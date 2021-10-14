package za.ac.cput.calender.group8.rentalbook.data;

import za.ac.cput.calender.bookings.lib.Person;
import za.ac.cput.calender.group8.rentalbook.business.Rentals;
import za.ac.cput.calender.group8.util.Utilities;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RentingFileLoader {


	public static List<Rentals> getListFromSequentialFile(String filename) {

		if (filename == null)
			throw new IllegalArgumentException("The file name cannot be null.");

		// To contain the booking objects
		List<Rentals> rentals = new ArrayList<Rentals>();
		Scanner inputFile = null;
		String recordStr = null;

		try {
			BufferedReader b = new BufferedReader(new InputStreamReader(
					new FileInputStream(filename)));
			inputFile = new Scanner(b);

			String[] fields = null;

			// To load the booking objects into the list
			while (inputFile.hasNext()) {
				recordStr = inputFile.nextLine();
				fields = recordStr.split("\\*");

				try {
					if (fields.length < 8)
						throw new IllegalArgumentException(
								"Invalid. Not enough fields");
					int year = Integer.parseInt(fields[0]);
					int month = Integer.parseInt(fields[1]);
					int day = Integer.parseInt(fields[2]);
					int hour = Integer.parseInt(fields[3]);
					int mins = Integer.parseInt(fields[4]);

					Person contact = new Person(fields[5], fields[6], fields[7]);

					if (fields.length == 9) {
						// Creates a new booking object with a reason.
						rentals.add(new Rentals(year, month, day,
								hour, mins, contact, fields[8]));
					} else if (fields.length == 8) {
						// Creates a new booking object without a reason.
						rentals.add(new Rentals(year, month, day,
								hour, mins, contact));
					} else
						throw new IllegalArgumentException(
								"Invalid. Too many fields");

				}// end of inner try
				catch (NumberFormatException nfe) {
					throw new IllegalArgumentException(
							"Illegal argument(s) in date and/or time in "
									+ recordStr);
				} catch (IllegalArgumentException iae) {
					throw new IllegalArgumentException("Error: "
							+ iae.getMessage() + " in " + recordStr);
				}
			}// end of while loop

			// Shrinks the array to contain only it's elements.
			((ArrayList<Rentals>) rentals).trimToSize();

		}// end of outer try

		catch (FileNotFoundException fnf) {
			throw new IllegalArgumentException("Error: " + filename
					+ " not found.");
		} finally {
			if (inputFile != null)
				inputFile.close();
		}
		return rentals;
	}


	@SuppressWarnings({ "unchecked" })
	public static List<Rentals> getListFromObjectFile(String filename)
			throws Exception {

		if (filename == null)
			throw new IllegalArgumentException("The file name cannot be null.");

		ObjectInputStream in = null;

		try {
			List<Rentals> rentals = (List<Rentals>) Utilities.deserializeObject(filename);
			return rentals;
		} catch (FileNotFoundException fnfe) {
			throw new IllegalArgumentException("Error: " + filename
					+ " not found.");
		} catch (Exception e) {
			throw new Exception("Error de-serializing object:  "
					+ e.getMessage());
		} finally {
			if (in != null)
				in.close();
		}

	}
}

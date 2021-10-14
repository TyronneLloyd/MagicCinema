package za.ac.cput.calender.group8.rentalbook.data;

import za.ac.cput.calender.bookings.lib.Person;
import za.ac.cput.calender.group8.rentalbook.business.Rentals;
import za.ac.cput.ui.calendar.ListUtilities;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;


public class SortMergeApp {

	@SuppressWarnings("rawtypes")
	public static void main(String[] args) {

		Comparable[] mergedList = new Rentals[0];

		// To hold the 11 bookings
		Rentals[][] apps = new Rentals[11][];

		try {
			// To load the booking objects in the array.
			for (int i = 0; i < 11; i++) {
				apps[i] = loadList("datafiles\\unsorted\\bookings"
						+ (i + 1) + ".txt");
				ListUtilities.sort(apps[i]);
			}

			// To save the booking objects to separate files.
			for (int i = 0; i < 11;) {
				ListUtilities.save(apps[i],
						"datafiles\\sorted\\sortedBookings" + (++i)
								+ ".txt", false);
			}

			String fileName = "datafiles\\sorted\\duplicateBookings.txt";

			// To merge the different Booking arrays in one array.
			for (int i = 0; i < 11; i++) {
				mergedList = ListUtilities.merge(mergedList, apps[i], fileName);
			}

			// To save the merged array in one file.
			ListUtilities.save(mergedList,
					"datafiles\\database\\bookings.txt", false);

		} catch (IllegalArgumentException iae) {
			System.out.println("An error occured: " + iae.getMessage());
		} catch (IOException ioe) {
			System.out.println("An error occured: " + ioe.getMessage());
		}
	}

	public static Rentals[] loadList(String filename) {
		Rentals[] rentals = new Rentals[10];
		Scanner inputFile = null;
		String recordStr = null;

		try {
			BufferedReader b = new BufferedReader(new InputStreamReader(
					new FileInputStream(filename)));
			inputFile = new Scanner(b);

			String[] fields = null;

			// i is keeping track of the number of objects in Booking[]
			int i = 0;
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
						rentals[i] = new Rentals(year, month, day,
								hour, mins, contact, fields[8]);
					} else if (fields.length == 8) {
						// Creates a new appointment object without a reason.
						rentals[i] = new Rentals(year, month, day,
								hour, mins, contact);
					} else
						throw new IllegalArgumentException(
								"Invalid. Too many fields");
					i++;

					// check if capacity has been surpassed
					// if true, grow list
					if (i >= rentals.length)
						rentals = Arrays.copyOf(rentals,
								(rentals.length + 1) * 2);
				}// end of inner try
				catch (NumberFormatException nfe) {
					throw new IllegalArgumentException(
							"Illegal argument(s) in date and/or time in "
									+ recordStr);
				} catch (IllegalArgumentException iae) {
					throw new IllegalArgumentException(iae.getMessage()
							+ " in " + recordStr);
				}
			}// end of while loop

			// Check if full to capacity, if false, shrink list
			if (i < rentals.length)
				rentals = Arrays.copyOf(rentals, i);

		}// end of outer try

		catch (FileNotFoundException fnf) {
			System.out.println("Error: " + filename + " not found.");
		} finally {
			if (inputFile != null)
				inputFile.close();
		}
		return rentals;
	}
}

package za.ac.cput.calender.group8.rentalbook.testclasses.RentedListDA;

import za.ac.cput.calender.group8.rentalbook.business.Rentals;
import za.ac.cput.calender.group8.rentalbook.data.RentingFileLoader;

import java.util.List;

import static java.lang.System.out;



public class LoadSequentialBookingFileTestApp {

	public static void main(String[] args) {
		
		List<Rentals> rentals = null;

		{
			out.println("Case 1 and 2:");
			String filename = "datafiles/testfiles/testBookings.txt";

			rentals = RentingFileLoader
					.getListFromSequentialFile(filename);

			for (Rentals app : rentals)
				System.out.println(app);
		}

		{
			// The directory or the file cannot be found
			try {
				out.println("\nCase 3:");
				String filename = "datafiles/testfiles/nonexistingfile.txt";
				rentals = RentingFileLoader
						.getListFromSequentialFile(filename);
			} catch (IllegalArgumentException iae) {
				out.println(iae.getMessage());
			}
		}

		{
			// The file is empty.
			try {
				out.println("\nCase 4:");
				String filename = "datafiles/testfiles/new.txt";
				rentals = RentingFileLoader
						.getListFromSequentialFile(filename);
				out.println("Size of list: " + rentals.size());
			} catch (IllegalArgumentException iae) {
				out.println(iae.getMessage());
			}
		}

		{
			// A record in the file does not have enough fields.
			try {
				out.println("\nCase 5:");
				String filename = "datafiles/testfiles/notEnoughFields.txt";
				rentals = RentingFileLoader
						.getListFromSequentialFile(filename);
			} catch (IllegalArgumentException iae) {
				out.println(iae.getMessage());
			}
		}

		{
			// A record in the file has too many fields
			try {
				out.println("\nCase 6:");
				String filename = "datafiles/testfiles/tooManyFields.txt";
				rentals = RentingFileLoader
						.getListFromSequentialFile(filename);
			} catch (IllegalArgumentException iae) {
				out.println(iae.getMessage());
			}
		}

		{
			// The date or time field in one of the records is an invalid
			// number.
			try {
				out.println("\nCase 7:");
				String filename = "datafiles/testfiles/errorInTime.txt";
				rentals = RentingFileLoader
						.getListFromSequentialFile(filename);

			} catch (IllegalArgumentException iae) {
				out.println(iae.getMessage());
			}
		}

		{
			// The date or time field in one of the records is not a number.
			try {
				out.println("\nCase 8:");
				String filename = "datafiles/testfiles/errorInTimeNotNum.txt";
				rentals = RentingFileLoader
						.getListFromSequentialFile(filename);

			} catch (IllegalArgumentException iae) {
				out.println(iae.getMessage());
			}
		}

		{
			// File name is null.
			try {
				out.println("\nCase 9:");
				rentals = RentingFileLoader
						.getListFromSequentialFile(null);
				out.println("Done.");
			} catch (IllegalArgumentException iae) {
				out.println(iae.getMessage());
			}
		}

	}
}

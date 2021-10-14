package za.ac.cput.calender.group8.rentalbook.testclasses.RentedListDA;

import za.ac.cput.calender.bookings.lib.FileType;
import za.ac.cput.calender.group8.rentalbook.data.RentListDA;

import java.io.IOException;
import java.util.Calendar;

import static java.lang.System.out;

public class IsAvailableTestApp {

	public static void main(String[] args) {

		String filename = "datafiles/testfiles/testBookings.ser";
		RentListDA apps = null;
		try {
			apps = new RentListDA(filename, FileType.SERIALIZED);
		} catch (IOException ioe) {
			out.print(ioe.getMessage());
		} catch (Exception e) {
			out.println(e.getMessage());
		}

		{// The date already exists.
			Calendar date = Calendar.getInstance();
			date.set(2011, 8, 11, 10, 30, 0);
			date.set(Calendar.MILLISECOND, 0);

			out.println("Case 1:");
			out.println(apps.isAvailable(date));
		}
		{// The date does not already exist.
			Calendar date = Calendar.getInstance();
			date.set(2012, 9, 22, 9, 0, 0);
			date.set(Calendar.MILLISECOND, 0);

			out.println("\nCase 2:");
			out.println(apps.isAvailable(date));
		}
		{// The date is null
			Calendar date = null;

			out.println("\nCase 3:");
			out.println(apps.isAvailable(date));
		}

	}

}

package za.ac.cput.calender.group8.rentalbook.testclasses.RentedListDA;

import za.ac.cput.calender.bookings.lib.FileType;
import za.ac.cput.calender.group8.rentalbook.business.Rentals;
import za.ac.cput.calender.group8.rentalbook.data.RentListDA;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import static java.lang.System.out;

public class GetDailyBookingsTest {

	public static void main(String[] args) {
		String filename = "datafiles/testfiles/testBookings.ser";
		RentListDA database = null;
		List<Rentals> apps = null;

		try {
			database = new RentListDA(filename, FileType.SERIALIZED);
		} catch (IOException ioe) {
			out.println(ioe.getMessage());
		} catch (Exception e) {
			out.println(e.getMessage());
		}
		{// Date is found
			out.println("Case 1:");
			Calendar date = Calendar.getInstance();
			date.setLenient(false);
			date.set(2011, 8, 11, 8, 30, 0);
			date.set(Calendar.MILLISECOND, 0);
			apps = database.getDailyBookings(date);
			out.println("Booking found:");
			for (Rentals app : apps)
				out.println(app);
		}
		{// Date is not found
			out.println("\nCase 2:");
			Calendar date = Calendar.getInstance();
			date.set(2011, 2, 9, 11, 30, 0);
			date.set(Calendar.MILLISECOND, 0);
			apps = database.getDailyBookings(date);
			out.println("Size of List of Bookings: " + apps.size());
		}
		{// Date is null
			out.println("\nCase 3:");
			apps = database.getDailyBookings(null);
			out.println("Size of List of Bookings: " + apps.size());
		}
	}

}

package za.ac.cput.calender.group8.rentalbook.testclasses.RentingBook;

import za.ac.cput.calender.bookings.lib.DailyConstraints;
import za.ac.cput.calender.bookings.lib.FileType;
import za.ac.cput.calender.group8.rentalbook.business.Rentals;
import za.ac.cput.calender.group8.rentalbook.business.EquipBook;
import za.ac.cput.calender.group8.rentalbook.data.RentListDA;

import java.util.Calendar;
import java.util.List;

import static java.lang.System.out;
import static java.util.Calendar.getInstance;

public class GetDailyBookingsTestApp {

	public static void main(String[] args) {
		try {
			EquipBook appBook = new EquipBook(
					new RentListDA(
							"datafiles/database/bookings.ser",
							FileType.SERIALIZED), new DailyConstraints());

			try {// Case 1
				out.println("Case 1:");
				appBook.getDailyBookings(null);
			} catch (IllegalArgumentException iae) {
				out.println(iae.getMessage());
			}

			{// Case 2
				out.println("\nCase 2:");
				Calendar date = getInstance();
				date.set(2011, 10, 28, 8, 30, 0);
				List<Rentals> apps = appBook.getDailyBookings(date);
				for (Rentals a : apps)
					out.println(a);
			}

			{// Case 3
				out.println("\nCase 3:");
				Calendar date = getInstance();
				date.set(2011, 10, 27, 8, 30, 0);
				List<Rentals> app = appBook
						.getDailyBookings(date);
				out.println(app);
			}

		} catch (Exception e) {
			out.println(e.getMessage() + " Outer catch");
		}
	}

}

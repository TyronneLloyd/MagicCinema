package za.ac.cput.calender.group8.rentalbook.testclasses;

import za.ac.cput.calender.bookings.lib.DailyConstraints;
import za.ac.cput.calender.bookings.lib.FileType;
import za.ac.cput.calender.group8.rentalbook.business.Rentals;
import za.ac.cput.calender.group8.rentalbook.business.EquipBook;
import za.ac.cput.calender.group8.rentalbook.data.RentListDA;

import java.util.Calendar;
import java.util.List;

public class RentBookTestApp {

	public static void main(String[] args) {
		try {
			EquipBook myEquipBook = new EquipBook(
					new RentListDA(
							"datafiles/database/bookings.ser",
							FileType.SERIALIZED),
					new DailyConstraints());
			try {
				Calendar c = Calendar.getInstance();
				c.setLenient(false);
				c.set(2011, 11, 5, 0, 0, 0);
				c.set(Calendar.MILLISECOND, 0);
				List<Rentals> dailyRentals = myEquipBook
						.getDailyBookings(c);

				System.out.printf("%s %2$tA, %2$tB %2$td, %2$tY\n",
						"Daily bookings on", c);
				for (Rentals a : dailyRentals)
					System.out.println("\t" + a);
			} catch (Exception e) {
				System.out.println("   " + e.getMessage());
			}

			myEquipBook.closeBook();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

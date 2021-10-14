package za.ac.cput.calender.group8.rentalbook.testclasses.RentingBook;

import za.ac.cput.calender.bookings.lib.DailyConstraints;
import za.ac.cput.calender.bookings.lib.FileType;
import za.ac.cput.calender.group8.rentalbook.business.Rentals;
import za.ac.cput.calender.group8.rentalbook.business.EquipBook;
import za.ac.cput.calender.group8.rentalbook.data.RentListDA;

import java.util.List;

import static java.lang.System.out;

public class GetRentalsForTestApp {

	public static void main(String[] args) {
		try {
			EquipBook appBook = new EquipBook(
					new RentListDA(
							"datafiles/database/bookings.ser",
							FileType.SERIALIZED), new DailyConstraints());

			try {// Case 1
				out.println("Case 1:");
				appBook.getBookingsFor(null);
			} catch (IllegalArgumentException iae) {
				out.println(iae.getMessage());
			}

			{// Case 2
				out.println("\nCase 2:");
				List<Rentals> app = appBook
						.getBookingsFor("(514)663-4211");
				out.println(app);
			}

			{// Case 3
				out.println("\nCase 3:");
				List<Rentals> app = appBook
						.getBookingsFor("(867)123-4567");
				out.println(app);
			}

		} catch (Exception e) {
			out.println(e.getMessage() + " Outer catch");
		}
	}

}

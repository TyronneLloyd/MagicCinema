package za.ac.cput.calender.group8.rentalbook.testclasses.RentingBook;

import za.ac.cput.calender.bookings.lib.DailyConstraints;
import za.ac.cput.calender.bookings.lib.FileType;
import za.ac.cput.calender.group8.rentalbook.business.EquipBook;
import za.ac.cput.calender.group8.rentalbook.data.RentListDA;

import static java.lang.System.out;

public class ConstructorRentedBookingsTestApp {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		try {
			out.println("Case 1");
			EquipBook appBook = new EquipBook(null,
					new DailyConstraints());
			out.println("Object created!");
		} catch (IllegalArgumentException iae) {
			out.println(iae.getMessage());
		}
		try {
			out.println("Case 2");
			EquipBook appBook2 = new EquipBook(
					new RentListDA(
							"datafiles/database/bookings.ser",
							FileType.SERIALIZED), new DailyConstraints());
			out.println("Object created!");
		} catch (IllegalArgumentException iae) {
			out.println(iae.getMessage());
		} catch (Exception e) {
			out.println(e.getMessage());
		}
	}
}

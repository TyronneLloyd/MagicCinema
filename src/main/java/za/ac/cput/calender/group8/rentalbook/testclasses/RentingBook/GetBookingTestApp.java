package za.ac.cput.calender.group8.rentalbook.testclasses.RentingBook;

import za.ac.cput.calender.bookings.rentalbookings.exceptions.NonExistingRentalException;
import za.ac.cput.calender.bookings.lib.DailyConstraints;
import za.ac.cput.calender.bookings.lib.FileType;
import za.ac.cput.calender.group8.rentalbook.business.Rentals;
import za.ac.cput.calender.group8.rentalbook.business.EquipBook;
import za.ac.cput.calender.group8.rentalbook.data.RentListDA;

import java.util.Calendar;

import static java.lang.System.out;

public class GetBookingTestApp {

	public static void main(String[] args) {
		try {
			EquipBook appBook = new EquipBook(
					new RentListDA(
							"datafiles/database/bookings.ser",
							FileType.SERIALIZED), new DailyConstraints());
			try {// Case 1
				out.println("Case 1:");
				appBook.getBooking(null);
			} catch (IllegalArgumentException iae) {
				out.println(iae.getMessage());
			}
			try {// Case 2
				out.println("\nCase 2:");
				Calendar date = Calendar.getInstance();
				date.set(2010, 2, 3, 10, 0, 0);
				Rentals a = appBook.getBooking(date);
				out.println(a);
			} catch (NonExistingRentalException iae) {
				out.println(iae.getMessage());
			}
			try {// Case 3
				out.println("\nCase 3:");
				Calendar date = Calendar.getInstance();
				date.set(2011, 11, 27, 14, 30);
				Rentals a = appBook.getBooking(date);
				out.println("Booking found!\n" + a);
			} catch (IllegalArgumentException iae) {
				out.println(iae.getMessage());
			}

		} catch (Exception e) {
			out.println(e.getMessage());
		}

	}

}

package za.ac.cput.calender.group8.rentalbook.testclasses.RentingBook;

import za.ac.cput.calender.bookings.rentalbookings.exceptions.DateNotAvailableException;
import za.ac.cput.calender.bookings.rentalbookings.exceptions.NonExistingRentalException;
import za.ac.cput.calender.bookings.lib.DailyConstraints;
import za.ac.cput.calender.bookings.lib.FileType;
import za.ac.cput.calender.group8.rentalbook.business.Rentals;
import za.ac.cput.calender.group8.rentalbook.business.EquipBook;
import za.ac.cput.calender.group8.rentalbook.data.RentListDA;

import java.util.Calendar;
import java.util.List;

import static java.lang.System.out;
import static java.util.Calendar.getInstance;

public class RescheduleRentalsTestApp {

	public static void main(String[] args) {
		try {
			EquipBook appBook = new EquipBook(
					new RentListDA(
							"datafiles/database/bookings.ser",
							FileType.SERIALIZED), new DailyConstraints());
			try {// Case 1
				out.println("Case 1:");
				appBook.rescheduleBooking(null, null);
			} catch (IllegalArgumentException iae) {
				out.println(iae.getMessage());
			}
			{// Case 2
				Calendar oldDate = getInstance();
				oldDate.set(2011, 11, 20, 10, 0);
				Calendar newDate = (Calendar) oldDate.clone();
				newDate.add(Calendar.MINUTE, 30);
				out.println("\nCase 2:");
				appBook.rescheduleBooking(oldDate, newDate);
				List<Rentals> apps = appBook.getDailyBookings(oldDate);
				for (Rentals a : apps)
					out.println(a);
			}
			try {// Case 3
				Calendar oldDate = getInstance();
				oldDate.set(2011, 11, 20, 10, 30);
				Calendar newDate = (Calendar) oldDate.clone();
				newDate.add(Calendar.MINUTE, 30);
				out.println("\nCase 3:");
				appBook.rescheduleBooking(oldDate, newDate);
			} catch (DateNotAvailableException dnae) {
				Calendar oldDate = getInstance();
				oldDate.set(2011, 11, 20, 10, 30);
				out.println(dnae.getMessage());
				List<Rentals> apps = appBook.getDailyBookings(oldDate);
				for (Rentals a : apps)
					out.println(a);
			}
			try {// Case 4
				Calendar oldDate = getInstance();
				oldDate.set(2011, 11, 20, 10, 00);
				Calendar newDate = (Calendar) oldDate.clone();
				newDate.add(Calendar.MINUTE, 30);
				out.println("\nCase 4:");
				appBook.rescheduleBooking(oldDate, newDate);
			} catch (NonExistingRentalException neae) {
				out.println(neae.getMessage());
			}
		} catch (Exception e) {
			out.println(e.getMessage() + e.getClass());
		}

	}

}

package za.ac.cput.calender.group8.rentalbook.testclasses.RentingBook;

import za.ac.cput.calender.bookings.rentalbookings.exceptions.NonExistingRentalException;
import za.ac.cput.calender.bookings.lib.DailyConstraints;
import za.ac.cput.calender.bookings.lib.FileType;
import za.ac.cput.calender.bookings.lib.Person;
import za.ac.cput.calender.group8.rentalbook.business.Rentals;
import za.ac.cput.calender.group8.rentalbook.business.EquipBook;
import za.ac.cput.calender.group8.rentalbook.data.RentListDA;

import java.util.Calendar;
import java.util.List;

import static java.lang.System.out;
import static java.util.Calendar.getInstance;

public class CancelRentedEquipTestApp {

	public static void main(String[] args) {

		try {
			EquipBook appBook = new EquipBook(
					new RentListDA(
							"datafiles/database/bookings.ser",
							FileType.SERIALIZED), new DailyConstraints());

			try {
				{// Case 1
					out.println("Case 1: ");
					appBook.cancelBooking(null);
					out.println("Booking cancelled!");
				}
			} catch (IllegalArgumentException iae) {
				out.println(iae.getMessage());
			}

			{// Case 2
				Calendar date = getInstance();
				date.set(2011, 10, 28, 8, 30, 0);
				out.println("\nCase 2: \nOriginal booking for 28/11/2011:");
				List<Rentals> apps = appBook.getDailyBookings(date);
				for (Rentals a : apps)
					out.println(a);
				Rentals dummyApp = new Rentals(2011, 10, 28, 8, 30,
						new Person("A", "Person"));
				appBook.cancelBooking(dummyApp);
				out.println("\nBooking cancelled at " + date.getTime());
				out.println("\nRemaining bookings for 28/11/2011:");
				apps = appBook.getDailyBookings(date);
				for (Rentals a : apps)
					out.println(a);
			}

			try {
				{// Case 3
					Calendar date = getInstance();
					date.set(2011, 10, 28, 8, 30, 0);
					out.println("\nCase 3: \nOriginal bookings for 28/11/2011:");
					List<Rentals> apps = appBook.getDailyBookings(date);
					for (Rentals a : apps)
						out.println(a);
					Rentals dummyApp = new Rentals(2011, 10, 28, 8, 30,
							new Person("A", "Person"));
					out.println("\nTrying to cancel bookings at " + date.getTime());
					appBook.cancelBooking(dummyApp);
				}
			} catch (NonExistingRentalException neae) {
				out.println(neae.getMessage());
			}
			
			try {
				{// Case 4
					Calendar date = getInstance();
					date.set(2010, 10, 28, 8, 30, 0);
					out.println("\nCase 4: \nOriginal bookings for 28/11/2010:");
					List<Rentals> apps = appBook.getDailyBookings(date);
					for (Rentals a : apps)
						out.println(a);
					Rentals dummyApp = new Rentals(2010, 10, 28, 8, 30,
							new Person("A", "Person"));
					out.println("\nTrying to cancel booking at " + date.getTime());
					appBook.cancelBooking(dummyApp);
				}
			} catch (IllegalArgumentException iae) {
				out.println(iae.getMessage());
			}

		} catch (Exception e) {
			out.println(e.getMessage() + e.getClass());
		}

	}

}

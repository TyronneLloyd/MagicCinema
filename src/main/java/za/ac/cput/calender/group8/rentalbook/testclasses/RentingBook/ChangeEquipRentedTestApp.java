package za.ac.cput.calender.group8.rentalbook.testclasses.RentingBook;

import za.ac.cput.calender.bookings.rentalbookings.exceptions.NonExistingRentalException;
import za.ac.cput.calender.bookings.lib.DailyConstraints;
import za.ac.cput.calender.bookings.lib.FileType;
import za.ac.cput.calender.bookings.lib.Person;
import za.ac.cput.calender.group8.rentalbook.business.Rentals;
import za.ac.cput.calender.group8.rentalbook.business.EquipBook;
import za.ac.cput.calender.group8.rentalbook.data.RentListDA;

import java.util.Calendar;

import static java.lang.System.out;
import static java.util.Calendar.getInstance;

public class ChangeEquipRentedTestApp {

	public static void main(String[] args) {

		try {
			EquipBook appBook = new EquipBook(
					new RentListDA(
							"datafiles/database/bookings.ser",
							FileType.SERIALIZED), new DailyConstraints());
			try {
				{// Case 1
					out.println("Case 1:");
					appBook.changeBookingDetails(null);
				}
			} catch (IllegalArgumentException iae) {
				out.println(iae.getMessage());
			}

			{// Case 2
				Calendar date = getInstance();
				date.set(2011, 10, 28, 8, 30, 0);
				out.println("\nCase 2: \nOriginal booking:");
				Rentals dummyApp = new Rentals(2011, 10, 28, 8, 30,
						new Person("NewFirstName", "NewLastName"),
						"This is a reason.");
				Rentals app = appBook.getBooking(date);
				out.println(app);
				appBook.changeBookingDetails(dummyApp);
				out.println("\nThe changed booking:");
				app = appBook.getBooking(date);
				out.println(app);
			}
			try {
				{// Case 3
					out.println("\nCase 3:");
					Rentals dummyApp = new Rentals(2011, 10, 27, 8, 30,
							new Person("NewFirstName", "NewLastName"),
							"This is a reason.");
					appBook.changeBookingDetails(dummyApp);
				}
			} catch (NonExistingRentalException iae) {
				out.println(iae.getMessage());
			}
			try {
				{// Case 4
					out.println("\nCase 4:");
					Rentals dummyApp = new Rentals(2010, 10, 27, 8, 30,
							new Person("NewFirstName", "NewLastName"),
							"This is a reason.");
					appBook.changeBookingDetails(dummyApp);
				}
			} catch (IllegalArgumentException iae) {
				out.println(iae.getMessage());
			}
		} catch (Exception e) {
			out.println(e.getMessage());
		}

	}
}

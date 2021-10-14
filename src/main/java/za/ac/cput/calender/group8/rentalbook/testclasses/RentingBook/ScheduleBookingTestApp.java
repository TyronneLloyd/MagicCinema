package za.ac.cput.calender.group8.rentalbook.testclasses.RentingBook;

import za.ac.cput.calender.bookings.rentalbookings.exceptions.DateNotAvailableException;
import za.ac.cput.calender.bookings.lib.DailyConstraints;
import za.ac.cput.calender.bookings.lib.FileType;
import za.ac.cput.calender.bookings.lib.Person;
import za.ac.cput.calender.group8.rentalbook.business.Rentals;
import za.ac.cput.calender.group8.rentalbook.business.EquipBook;
import za.ac.cput.calender.group8.rentalbook.data.RentListDA;

import static java.lang.System.out;

public class ScheduleBookingTestApp {

	public static void main(String[] args) {
		try {
			EquipBook appBook = new EquipBook(
					new RentListDA(
							"datafiles/database/bookings.ser",
							FileType.SERIALIZED), new DailyConstraints());

			DailyConstraints dCon = new DailyConstraints();
			dCon.setTimeInterval(60);
			EquipBook appBookTimeInt1h = new EquipBook(
					new RentListDA(
							"datafiles/database/bookings.ser",
							FileType.SERIALIZED), dCon);

			try {// Case 1
				out.println("Case 1:");
				appBook.scheduleBooking(null);
			} catch (IllegalArgumentException iae) {
				out.println(iae.getMessage());
			}
			try {// Case 2
				out.println("\nCase 2:");
				Rentals dummyApp = new Rentals(2011, 11, 16, 7, 30,
						new Person("A", "Person"));
				appBook.scheduleBooking(dummyApp);
			} catch (DateNotAvailableException dnae) {
				out.println(dnae.getMessage());
			}
			try {// Case 3
				out.println("\nCase 3:");
				Rentals dummyApp = new Rentals(2011, 11, 16, 12, 30,
						new Person("A", "Person"));
				appBook.scheduleBooking(dummyApp);
			} catch (DateNotAvailableException dnae) {
				out.println(dnae.getMessage());
			}
			try {// Case 4
				out.println("\nCase 4:");
				Rentals dummyApp = new Rentals(2011, 11, 16, 12, 00,
						new Person("A", "Person"));
				appBook.scheduleBooking(dummyApp);
			} catch (DateNotAvailableException dnae) {
				out.println(dnae.getMessage());
			}
			try {// Case 5
				out.println("\nCase 5:");
				Rentals dummyApp = new Rentals(2011, 11, 16, 11, 30,
						new Person("A", "Person"));
				appBookTimeInt1h.scheduleBooking(dummyApp);
			} catch (DateNotAvailableException dnae) {
				out.println(dnae.getMessage());
			}
			try {// Case 6
				out.println("\nCase 6:");
				Rentals dummyApp = new Rentals(2011, 11, 16, 20, 30,
						new Person("A", "Person"));
				appBook.scheduleBooking(dummyApp);
			} catch (DateNotAvailableException dnae) {
				out.println(dnae.getMessage());
			}
			try {// Case 7
				out.println("\nCase 7:");
				Rentals dummyApp = new Rentals(2011, 11, 17, 4, 30,
						new Person("A", "Person"));
				appBook.scheduleBooking(dummyApp);
			} catch (DateNotAvailableException dnae) {
				out.println(dnae.getMessage());
			}
			try {// Case 8
				out.println("\nCase 8:");
				Rentals dummyApp = new Rentals(2011, 11, 17, 16, 30,
						new Person("A", "Person"));
				appBook.scheduleBooking(dummyApp);
			} catch (DateNotAvailableException dnae) {
				out.println(dnae.getMessage());
			}
			try {// Case 9
				out.println("\nCase 9:");
				Rentals dummyApp = new Rentals(2011, 11, 19, 15, 00,
						new Person("A", "Person"));
				appBookTimeInt1h.scheduleBooking(dummyApp);
			} catch (DateNotAvailableException dnae) {
				out.println(dnae.getMessage());
			}
			try {// Case 10
				out.println("\nCase 10:");
				Rentals dummyApp = new Rentals(2011, 11, 19, 14, 00,
						new Person("A", "Person"));
				appBookTimeInt1h.scheduleBooking(dummyApp);
			} catch (DateNotAvailableException dnae) {
				out.println(dnae.getMessage());
			}
			try {// Case 11
				out.println("\nCase 11:");
				Rentals dummyApp = new Rentals(2011, 11, 19, 14, 30,
						new Person("A", "Person"));
				appBook.scheduleBooking(dummyApp);
			} catch (DateNotAvailableException dnae) {
				out.println(dnae.getMessage());
			}
			try {// Case 12
				out.println("\nCase 12:");
				Rentals dummyApp = new Rentals(2013, 10, 16, 12, 30,
						new Person("A", "Person"));
				appBook.scheduleBooking(dummyApp);
			} catch (DateNotAvailableException dnae) {
				out.println(dnae.getMessage());
			}
			try {// Case 13
				out.println("\nCase 13:");
				Rentals dummyApp = new Rentals(2010, 10, 16, 12, 30,
						new Person("A", "Person"));
				appBook.scheduleBooking(dummyApp);
			} catch (DateNotAvailableException dnae) {
				out.println(dnae.getMessage());
			}
			try {// Case 14
				out.println("\nCase 14:");
				Rentals dummyApp = new Rentals(2011, 11, 18, 12, 30,
						new Person("A", "Person"));
				appBook.scheduleBooking(dummyApp);
			} catch (DateNotAvailableException dnae) {
				out.println(dnae.getMessage());
			}
			{// Case 15
				out.println("\nCase 15:");
				Rentals dummyApp = new Rentals(2011, 11, 14, 13, 30,
						new Person("A", "Person"));
				appBook.scheduleBooking(dummyApp);
			}
			{// Case 16
				out.println("\nCase 16:");
				Rentals dummyApp = new Rentals(2011, 11, 15, 8, 00,
						new Person("A", "Person"));
				appBook.scheduleBooking(dummyApp);
			}
			{// Case 17
				out.println("\nCase 17:");
				Rentals dummyApp = new Rentals(2011, 11, 17, 8, 00,
						new Person("A", "Person"));
				appBook.scheduleBooking(dummyApp);
			}
		} catch (Exception e) {
			out.println(e.getMessage() + e.getClass());
		}

	}

}

package za.ac.cput.calender.group8.rentalbook.testclasses.RentedListDA;

import za.ac.cput.calender.bookings.rentalbookings.exceptions.NonExistingRentalException;
import za.ac.cput.calender.bookings.lib.FileType;
import za.ac.cput.calender.group8.rentalbook.business.Rentals;
import za.ac.cput.calender.group8.rentalbook.data.RentListDA;

import java.io.IOException;
import java.util.Calendar;

import static java.lang.System.out;

public class GetBookingTest {

	public static void main(String[] args) {

		String filename = "datafiles/testfiles/testBookings.ser";
		RentListDA apps = null;

		try {
			apps = new RentListDA(filename, FileType.SERIALIZED);
		} catch (IOException ioe) {
			out.println(ioe.getMessage());
		} catch (Exception e) {
			out.println(e.getMessage());
		}
		{// Date is found
			try {
				out.println("Case 1:");
				Calendar date = Calendar.getInstance();
				date.set(2011, 8, 11, 9, 30, 0);
				date.set(Calendar.MILLISECOND, 0);
				Rentals app = apps.getBooking(date);
				out.println("Booking found: " + app);
			} catch (NonExistingRentalException neae) {
				out.println(neae.getMessage());
			}
		}
		{// Date is not found
			try {
				out.println("\nCase 2:");
				Calendar date = Calendar.getInstance();
				date.set(2011, 2, 9, 11, 30, 0);
				date.set(Calendar.MILLISECOND, 0);
				Rentals app = apps.getBooking(date);
				out.println("Booking found: " + app);
			} catch (NonExistingRentalException neae) {
				out.println(neae.getMessage());
			}
		}

		{// Date is null
			try {
				out.println("\nCase 3:");
				Rentals app = apps.getBooking(null);
				out.println("Booking found: " + app);
			} catch (NonExistingRentalException neae) {
				out.println(neae.getMessage());
			}
		}
	}

}

package za.ac.cput.calender.group8.rentalbook.testclasses.RentedListDA;

import za.ac.cput.calender.bookings.rentalbookings.exceptions.DateNotAvailableException;
import za.ac.cput.calender.bookings.lib.FileType;
import za.ac.cput.calender.bookings.lib.Person;
import za.ac.cput.calender.group8.rentalbook.business.Rentals;
import za.ac.cput.calender.group8.rentalbook.data.RentListDA;

import java.io.IOException;

import static java.lang.System.out;

public class AddTest {

	public static void main(String[] args) {
		String filename = "datafiles/testfiles/testBookings.ser";
		RentListDA apps = null;
		Rentals app = null;

		try {
			apps = new RentListDA(filename, FileType.SERIALIZED);
		} catch (IOException ioe) {
			out.println(ioe.getMessage());
		} catch (Exception e) {
			out.println(e.getMessage());
		}

		out.println("Original database:\n" + apps);

		{// Date is not available.
			try {
				out.println("Case 1:");
				app = new Rentals(2011, 8, 11, 9, 30, new Person("Me",
						"You"));
				apps.add(app);
			} catch (DateNotAvailableException dnae) {
				out.println(dnae.getMessage());
			}
		}

		{// The date is available and is the earliest.
			try {
				out.println("\nCase 2 to 4:");
				app = new Rentals(2011, 8, 10, 9, 30, new Person("On",
						"Top"));
				apps.add(app);
			} catch (DateNotAvailableException dnae) {
				out.println(dnae.getMessage());
			}
		}
		{// The date is available in the middle.
			try {
				app = new Rentals(2011, 9, 26, 9, 30, new Person("In",
						"Middle"));
				apps.add(app);
			} catch (DateNotAvailableException dnae) {
				out.println(dnae.getMessage());
			}
		}
		{// The date is available and is the latest.
			try {
				app = new Rentals(2011, 11, 30, 9, 30, new Person("At",
						"Bottom"));
				apps.add(app);
			} catch (DateNotAvailableException dnae) {
				out.println(dnae.getMessage());
			}
		}

		out.println(apps);

		{// The booking is null.
			try {
				out.println("Case 5:");
				apps.add(null);
			} catch (DateNotAvailableException dnae) {
				out.println(dnae.getMessage());
			}
		}

	}
}

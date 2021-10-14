package za.ac.cput.calender.group8.rentalbook.testclasses.RentedListDA;

import za.ac.cput.calender.bookings.rentalbookings.exceptions.NonExistingRentalException;
import za.ac.cput.calender.bookings.lib.FileType;
import za.ac.cput.calender.bookings.lib.Person;
import za.ac.cput.calender.group8.rentalbook.business.Rentals;
import za.ac.cput.calender.group8.rentalbook.data.RentListDA;

import java.io.IOException;

import static java.lang.System.out;

public class RemoveTest {


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

		out.println("Original database:\n" + apps);

		{// The appointment exists.
			try {
				out.println("Case 1:");
				Rentals app = new Rentals(2011, 8, 11, 9, 30,
						new Person("Me", "You"));
				apps.remove(app);
				out.println(apps);
			} catch (NonExistingRentalException neae) {
				out.println(neae.getMessage());
			}
		}

		{// The booking does not exist.
			try {
				out.println("Case 2:");
				Rentals app = new Rentals(2011, 8, 10, 9, 30,
						new Person("First", "Last"));
				apps.remove(app);
			} catch (NonExistingRentalException neae) {
				out.println(neae.getMessage());
			}
		}
		
		{// The booking is null.
			try {
				out.println("\nCase 3:");
				apps.remove(null);
			} catch (NonExistingRentalException neae) {
				out.println(neae.getMessage());
			}
		}

	}

}

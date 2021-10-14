package za.ac.cput.calender.group8.rentalbook.testclasses.RentedListDA;

import za.ac.cput.calender.bookings.lib.FileType;
import za.ac.cput.calender.group8.rentalbook.business.Rentals;
import za.ac.cput.calender.group8.rentalbook.data.RentListDA;

import java.io.IOException;
import java.util.List;

import static java.lang.System.out;

public class GetBookingsForTest {

	public static void main(String[] args) {
		String filename = "datafiles/testfiles/testBookings.ser";
		RentListDA apps = null;
		List<Rentals> app = null;

		try {
			apps = new RentListDA(filename, FileType.SERIALIZED);
		} catch (IOException ioe) {
			out.println(ioe.getMessage());
		} catch (Exception e) {
			out.println(e.getMessage());
		}
		{// Telephone is found
			out.println("Case 1:");
			app = apps.getBookingsFor("(514)884-3642");
			out.println("Bookings found:");
			for (Rentals a : app)
				out.println(a);
		}
		{// Telephone is not found
			out.println("\nCase 2:");
			app = apps.getBookingsFor("(999)999-9999");
			out.println("Size of List of Bookings: " + app.size());
		}
		{// Telephone is null
			out.println("\nCase 3:");
			app = apps.getBookingsFor(null);
			out.println("Size of List of Bookings: " + app.size());
		}
	}

}

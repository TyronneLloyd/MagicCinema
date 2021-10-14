package za.ac.cput.calender.group8.rentalbook.testclasses.RentedListDA;

import za.ac.cput.calender.bookings.lib.FileType;
import za.ac.cput.calender.bookings.lib.Person;
import za.ac.cput.calender.group8.rentalbook.business.Rentals;
import za.ac.cput.calender.group8.rentalbook.data.RentListDA;

import java.io.IOException;

import static java.lang.System.out;

public class DisconnectTestApp {

	public static void main(String[] args) {

		String filename = "datafiles/testfiles/testBookingsDisconnect.txt";
		RentListDA apps = null;

		try {// Sequential file.
			out.println("Case 1");
			apps = new RentListDA(filename, FileType.TEXT_SEQUENTIAL);
			out.println(apps);
			apps.add(new Rentals(2011, 8, 11, 11, 30, new Person("New",
					"Booking"), "(514)856-4564"));
			apps.disconnect();
			out.println("Disconnected from " + filename + "\n");

			// Reconnects and displays
			apps = new RentListDA(filename, FileType.TEXT_SEQUENTIAL);
			out.println(apps);
		} catch (IOException ioe) {
			out.println(ioe.getMessage());
		} catch (Exception e) {
			out.println(e.getMessage());
		}

		try {// Serialized file.
			out.println("\nCase 2");
			filename = "datafiles/testfiles/testBookingsDisconnect.ser";
			apps = new RentListDA(filename, FileType.SERIALIZED);
			out.println(apps);
			apps.add(new Rentals(2011, 8, 11, 11, 30, new Person("New",
					"Booking"), "(514)856-4564"));
			apps.disconnect();
			out.println("Disconnected from " + filename + "\n");

			// Reconnects and displays
			apps = new RentListDA(filename, FileType.SERIALIZED);
			out.println(apps);
		} catch (IOException ioe) {
			out.println(ioe.getMessage());
		} catch (Exception e) {
			out.println(e.getMessage());
		}

	}
}

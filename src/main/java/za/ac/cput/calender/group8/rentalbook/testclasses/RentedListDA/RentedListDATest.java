package za.ac.cput.calender.group8.rentalbook.testclasses.RentedListDA;

import za.ac.cput.calender.bookings.lib.FileType;
import za.ac.cput.calender.group8.rentalbook.data.RentListDA;

import java.io.IOException;

import static java.lang.System.out;

public class RentedListDATest {

	public static void main(String[] args) {
		// Testing RentedListDA constructor and toString
		String filename = "datafiles/testfiles/testBookings.txt";
		RentListDA apps = null;

		try {// Sequential file.
			out.println("Case 1");
			apps = new RentListDA(filename, FileType.TEXT_SEQUENTIAL);
			out.println(apps);
		} catch (IOException ioe) {
			out.println(ioe.getMessage());
		} catch (Exception e) {
			out.println(e.getMessage());
		}

		try {// Serialized file.
			out.println("Case 2");
			filename = "datafiles/testfiles/testBookings.ser";
			apps = new RentListDA(filename, FileType.SERIALIZED);
			out.println(apps);
		} catch (IOException ioe) {
			out.println(ioe.getMessage());
		} catch (Exception e) {
			out.println(e.getMessage());
		}

		try {
			out.println("Case 3");
			filename = "datafiles/testfiles/thisfiledoesnotexist.txt";
			apps = new RentListDA(filename, FileType.TEXT_SEQUENTIAL);
			out.println(apps);
		} catch (IOException ioe) {
			out.println(ioe.getMessage());
		} catch (Exception e) {
			out.println(e.getMessage());
		}

		try {
			out.println("\nCase 4");
			filename = null;
			apps = new RentListDA(filename, FileType.TEXT_SEQUENTIAL);
			out.println(apps);
		} catch (IOException ioe) {
			out.println(ioe.getMessage());
		} catch (Exception e) {
			out.println(e.getMessage());
		}

	}

}

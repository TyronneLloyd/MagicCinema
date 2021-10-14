package za.ac.cput.calender.group8.rentalbook.testclasses.RentingBook;

import za.ac.cput.calender.bookings.lib.DailyConstraints;
import za.ac.cput.calender.bookings.lib.FileType;
import za.ac.cput.calender.group8.rentalbook.business.Rentals;
import za.ac.cput.calender.group8.rentalbook.business.EquipBook;
import za.ac.cput.calender.group8.rentalbook.data.RentingFileLoader;
import za.ac.cput.calender.group8.rentalbook.data.RentListDA;

import java.util.List;

import static java.lang.System.out;

public class CloseRentedBookingsTestApp {

	public static void main(String[] args) {

		{
			String filePath = "datafiles/testfiles/bookings.ser";
			EquipBook appBook;
			try {
				out.println("\nCase 1 (original run) Case 2 (second run):\nOriginal file:");

				List<Rentals> list = RentingFileLoader
						.getListFromObjectFile(filePath);
				out.println("Size: " + list.size());
				for (Rentals a : list)
					System.out.println(a);

				appBook = new EquipBook(new RentListDA(filePath,
						FileType.SERIALIZED), new DailyConstraints());
				out.println("Booking book created!");

				appBook.closeBook();
				out.println("Booking book closed!");

				out.println("New file:");

				List<Rentals> newList = RentingFileLoader
						.getListFromObjectFile(filePath);
				out.println("Size: " + newList.size());
				for (Rentals a : newList)
					System.out.println(a);

			} catch (IllegalArgumentException iae) {
				out.println(iae.getMessage());
			} catch (Exception e) {
				out.println(e.getMessage());
			}
		}

		{
			String filePath = "datafiles/testfiles/emptyFile.ser";
			EquipBook appBook;
			try {
				out.println("\nCase 3:\nOriginal file:");

				List<Rentals> list = RentingFileLoader
						.getListFromObjectFile(filePath);
				out.println("Size: " + list.size());
				for (Rentals a : list)
					System.out.println(a);

				appBook = new EquipBook(new RentListDA(filePath,
						FileType.SERIALIZED), new DailyConstraints());
				out.println("Booking book created!");

				appBook.closeBook();
				out.println("Booking book closed!");

				out.println("New file:");

				List<Rentals> newList = RentingFileLoader
						.getListFromObjectFile(filePath);
				out.println("Size: " + newList.size());
				for (Rentals a : newList)
					System.out.println(a);

			} catch (IllegalArgumentException iae) {
				out.println(iae.getMessage());
			} catch (Exception e) {
				out.println(e.getMessage() + e.getClass());
			}
		}
	}
}

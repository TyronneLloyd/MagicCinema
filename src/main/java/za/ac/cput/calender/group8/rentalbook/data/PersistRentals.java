package za.ac.cput.calender.group8.rentalbook.data;

import za.ac.cput.calender.group8.rentalbook.business.Rentals;
import za.ac.cput.calender.group8.util.Utilities;

import java.util.List;

public class PersistRentals {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		List<Rentals> rentals = null;
		try {
			rentals = RentingFileLoader
					.getListFromSequentialFile("datafiles/database/bookings.txt");
			Utilities.serializeObject(rentals,
					"datafiles/database/bookings.ser");
			rentals = (List<Rentals>) Utilities
					.deserializeObject("datafiles/database/bookings.ser");
			for (Rentals rented : rentals)
				System.out.println(rentals);
		} catch (Exception e) {
			System.out.println("Error - " + e.getMessage());
		}
	}
}

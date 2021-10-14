package za.ac.cput.calender.group8.rentalbook.application;

import za.ac.cput.calender.bookings.lib.DailyConstraints;
import za.ac.cput.calender.bookings.lib.FileType;
import za.ac.cput.calender.group8.rentalbook.business.EquipBook;
import za.ac.cput.calender.group8.rentalbook.data.RentListDA;
import za.ac.cput.calender.group8.rentalbook.ui.RentedBookTUI;


public class RentalBookingTUIApp {

	public static void main(String[] args) {		

		try 
		{
			EquipBook book = new EquipBook
					(new RentListDA("datafiles/database/bookings.ser",
							FileType.SERIALIZED),

							new DailyConstraints());
			new RentedBookTUI(book).activate();
		}
		catch (Exception e)
		{
			System.out.println("Error Connecting: " + e);
		}		

	}
}


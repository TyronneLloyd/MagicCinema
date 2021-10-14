package za.ac.cput.calender.group8.rentalbook.testclasses.RentingBook;

import za.ac.cput.calender.bookings.lib.DailyConstraints;
import za.ac.cput.calender.bookings.lib.FileType;
import za.ac.cput.calender.group8.rentalbook.business.EquipBook;
import za.ac.cput.calender.group8.rentalbook.data.RentListDA;

import java.util.Calendar;
import java.util.List;

import static java.lang.System.out;
import static java.util.Calendar.getInstance;

public class GetNextAvailableDatesStartingTestApp {

	public static void main(String[] args) {
		try {
			EquipBook appBook = new EquipBook(
					new RentListDA(
							"datafiles/database/bookings.ser",
							FileType.SERIALIZED), new DailyConstraints());

			{// Case 1
				out.println("Case 1:");

				try {
					appBook.getNextAvailableDatesStarting(null);
				} catch (IllegalArgumentException iae) {
					out.println(iae.getMessage());
				}
			}
			{// Case 2
				out.println("\nCase 2:");

				try {
					Calendar date = getInstance();
					date.add(Calendar.MONTH, -3);
					appBook.getNextAvailableDatesStarting(date);
				} catch (IllegalArgumentException iae) {
					out.println(iae.getMessage());
				}
			}
			{// Case 3
				out.println("\nCase 3:");

				try {
					Calendar date = getInstance();
					date.add(Calendar.MONTH, 4);
					appBook.getNextAvailableDatesStarting(date);
				} catch (IllegalArgumentException iae) {
					out.println(iae.getMessage());
				}
			}
			{// Case 4 and 8
				out.println("\nCase 4 and 8:");

				try {
					Calendar date = getInstance();
					date.set(2011, 11, 23, 9, 0, 0);
					date.set(Calendar.MILLISECOND, 0);
					List<Calendar> list = appBook
							.getNextAvailableDatesStarting(date);
					out.println("Size of list: " + list.size());
					for (Calendar d : list)
						out.println(d.getTime());
				} catch (IllegalArgumentException iae) {
					out.println(iae.getMessage());
				}
			}
			{// Case 5
				out.println("\nCase 5:");

				try {
					Calendar date = getInstance();
					date.set(2011, 11, 30, 12, 30, 0);
					date.set(Calendar.MILLISECOND, 0);
					List<Calendar> list = appBook
							.getNextAvailableDatesStarting(date);
					out.println("Size of list: " + list.size());
					for (Calendar d : list)
						out.println(d.getTime());
				} catch (IllegalArgumentException iae) {
					out.println(iae.getMessage());
				}
			}
			{// Case 6
				out.println("\nCase 6:");

				try {
					Calendar date = getInstance();
					date.add(Calendar.HOUR, -2);
					date.add(Calendar.MONTH, 3);
					date.set(Calendar.MILLISECOND, 0);
					List<Calendar> list = appBook
							.getNextAvailableDatesStarting(date);
					out.println("Size of list: " + list.size());
					for (Calendar d : list)
						out.println(d.getTime());
				} catch (IllegalArgumentException iae) {
					out.println(iae.getMessage());
				}
			}
			{// Case 7
				out.println("\nCase 7:");

				try {
					Calendar date = getInstance();
					date.set(2012, 1, 10, 9, 0, 0);
					date.set(Calendar.MILLISECOND, 0);
					List<Calendar> list = appBook
							.getNextAvailableDatesStarting(date);
					out.println("Size of list: " + list.size());
					for (Calendar d : list)
						out.println(d.getTime());
				} catch (IllegalArgumentException iae) {
					out.println(iae.getMessage());
				}
			}

		} catch (Exception e) {
			out.println(e.getMessage() + e.getClass());
		}

	}
}

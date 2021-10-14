package za.ac.cput.calender.bookings.rentalbookings.interfaces;

import za.ac.cput.calender.bookings.rentalbookings.exceptions.DateNotAvailableException;
import za.ac.cput.calender.bookings.rentalbookings.exceptions.NonExistingRentalException;

import java.util.Calendar;
import java.util.List;


public interface Schedulable<T extends Comparable<T>> {


	void cancelBooking(T entry) throws NonExistingRentalException, NonExistingRentalException;

	void changeBookingDetails(T entry)
			throws NonExistingRentalException;



	void closeBook() throws Exception;


	List<Calendar> getNextAvailableDatesStarting(Calendar startingDate);


	T getBooking(Calendar date) throws NonExistingRentalException;


	List<T> getBookingsFor(String telephoneNumber);


	List<T> getDailyBookings(Calendar date);

	boolean isAvailable(Calendar date);


	void scheduleBooking(T booking) throws DateNotAvailableException, DateNotAvailableException;


	void rescheduleBooking(Calendar currentDate, Calendar newDate)
			throws DateNotAvailableException, NonExistingRentalException;
}

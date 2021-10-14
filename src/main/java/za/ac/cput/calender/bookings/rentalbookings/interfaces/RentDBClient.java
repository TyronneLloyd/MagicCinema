package za.ac.cput.calender.bookings.rentalbookings.interfaces;


import za.ac.cput.calender.bookings.rentalbookings.exceptions.DateNotAvailableException;
import za.ac.cput.calender.bookings.rentalbookings.exceptions.NonExistingRentalException;

import java.util.Calendar;
import java.util.List;

public interface RentDBClient<T extends Comparable<T>> {

	void add(T booking) throws DateNotAvailableException;


	void disconnect() throws Exception;


	T getBooking(Calendar date) throws NonExistingRentalException;


	List<T> getBookingsFor(String telephoneNumber);


	List<T> getDailyBookings(Calendar date);


	boolean isAvailable(Calendar date);


	void remove(T booking) throws NonExistingRentalException;
	void update(T modifiedBooking) throws NonExistingRentalException;

}

package za.ac.cput.calender.group8.rentalbook.business;


import za.ac.cput.calender.bookings.rentalbookings.interfaces.Schedulable;
import za.ac.cput.calender.bookings.lib.TimeBlock;
import za.ac.cput.calender.bookings.rentalbookings.exceptions.DateNotAvailableException;
import za.ac.cput.calender.bookings.rentalbookings.exceptions.NonExistingRentalException;
import za.ac.cput.calender.bookings.rentalbookings.interfaces.RentDBClient;
import za.ac.cput.calender.bookings.lib.DailyConstraints;
import za.ac.cput.calender.bookings.lib.DailySchedule;
import za.ac.cput.calender.bookings.lib.Person;

import za.ac.cput.ui.calendar.ListUtilities;

import java.util.*;

import static java.util.Calendar.*;

public class EquipBook extends Observable implements
		Schedulable<Rentals> {

	private RentDBClient<Rentals> connection;
	private DailyConstraints dailyConstraints;
	private String errorMessage = "";

	public EquipBook(RentDBClient<Rentals> connection,
					 DailyConstraints dailyConstraints) {
		if (connection == null || dailyConstraints == null)
			throw new IllegalArgumentException(
					"The parameters must not be null.");
		this.connection = connection;
		this.dailyConstraints = dailyConstraints;
	}


	@Override
	public void cancelBooking(Rentals entry)
			throws NonExistingRentalException {
		if (entry == null)
			throw new IllegalArgumentException(
					"The booking cannot be null.");
		if (entry.getDate().before(getInstance())) {
			throw new IllegalArgumentException(
					"Cannot cancel booking that has already passed.");
		}
		connection.remove(entry);
		this.setChanged();
		this.notifyObservers(entry.getDate());
	}


	@Override
	public void changeBookingDetails(Rentals entry)
			throws NonExistingRentalException {
		if (entry == null)
			throw new IllegalArgumentException(
					"The booking cannot be null.");
		if (entry.getDate().before(getInstance())) {
			throw new IllegalArgumentException(
					"Cannot change booking that has already passed.");
		}
		connection.update(entry);
		this.setChanged();
		this.notifyObservers(entry.getDate());
	}

	@Override
	public void closeBook() throws Exception {

		// Before disconnecting, booking that have passed are removed.

		Calendar maxPreviousDate = getInstance();
		maxPreviousDate.add(MONTH, -dailyConstraints.getMaxMonthsInAdvance());

		Calendar today = getInstance();
		today.set(HOUR_OF_DAY, 0);
		today.set(MINUTE, 0);

		List<Rentals> listOfRentals;

		while (maxPreviousDate.before(today)) {
			listOfRentals = connection
					.getDailyBookings(maxPreviousDate);
			for (Rentals a : listOfRentals)
				connection.remove(a);
			maxPreviousDate.add(DATE, 1);
		}
		connection.disconnect();
	}


	@Override
	public List<Calendar> getNextAvailableDatesStarting(Calendar startingDate) {

		if (startingDate == null)
			throw new IllegalArgumentException("The date cannot be null.");

		if (startingDate.before(getInstance()))
			throw new IllegalArgumentException(
					"The starting date/time cannot be prior to now.");

		Calendar maxDate = getInstance();
		maxDate.add(MONTH, dailyConstraints.getMaxMonthsInAdvance());
		if (maxDate.before(startingDate))
			throw new IllegalArgumentException(
					"The starting date/time cannot be after "
							+ String.format("%1$tA, %1$tB %1td, %1$tY", maxDate)
							+ ".");

		int timeInterval = dailyConstraints.getTimeInterval();
		List<Calendar> availableDates = new ArrayList<Calendar>(5);
		Calendar date = (Calendar) startingDate.clone();

		int numOfDates = 0;
		while (numOfDates < 5) {
			if (validate(date)) {
				availableDates.add((Calendar) date.clone());
				numOfDates++;
			}
			date.add(MINUTE, timeInterval);
			if (maxDate.before(date))
				numOfDates = 5;
		}
		return availableDates;
	}


	@Override
	public Rentals getBooking(Calendar date)
			throws NonExistingRentalException {
		return connection.getBooking(date);
	}


	@Override
	public List<Rentals> getBookingsFor(String telephoneNumber) {
		return connection.getBookingsFor(telephoneNumber);
	}


	@Override
	public List<Rentals> getDailyBookings(Calendar date) {
		return connection.getDailyBookings(date);
	}


	@Override
	public boolean isAvailable(Calendar date) {

		errorMessage = "";

		if (date == null)
			throw new IllegalArgumentException("The date cannot be null.");

		if (date.before(getInstance())) {
			errorMessage = "Cannot schedule booking in the past. "
					+ String.format("%1$tA, %1$tB %1td, %1$tY", date);
			return false;
		}

		Calendar maxDate = getInstance();
		maxDate.add(MONTH, dailyConstraints.getMaxMonthsInAdvance());
		if (maxDate.before(date)) {
			errorMessage = "Cannot schedule booking after "
					+ String.format("%1$tA, %1$tB %1td, %1$tY", maxDate) + ".";
			return false;
		}

		return validate(date);
	}


	@Override
	public void scheduleBooking(Rentals booking)
			throws DateNotAvailableException {

		if (booking == null)
			throw new IllegalArgumentException(
					"The booking must not be null.");

		Calendar appDate = booking.getDate();

		if (isAvailable(appDate))
			connection.add(booking);
		else
			throw new DateNotAvailableException(errorMessage);
		this.setChanged();
		this.notifyObservers(booking.getDate());
	}

	@Override
	public void rescheduleBooking(Calendar currentDate, Calendar newDate)
			throws DateNotAvailableException, NonExistingRentalException {

		if (currentDate == null || newDate == null)
			throw new IllegalArgumentException(
					"The parameters must not be null.");

		// If the booking doesn't exist it will throw a
		// NonExistingAppointmentException.
		Rentals app = connection.getBooking(currentDate);

		connection.remove(app);

		// If true, it will add the new booking, if not it will put back the
		// old booking.
		if (isAvailable(newDate)) {
			Rentals newApp = new Rentals(newDate.get(YEAR),
					newDate.get(MONTH), newDate.get(DATE),
					newDate.get(HOUR_OF_DAY), newDate.get(MINUTE),
					app.getContact(), app.getReason());
			connection.add(newApp);
		} else {
			connection.add(app);
			throw new DateNotAvailableException(errorMessage);
		}
		this.setChanged();
		this.notifyObservers(new Calendar[]{currentDate,newDate});
	}

	private boolean validate(Calendar date) {

		// Time at which the booking starts.
		int day = date.get(DAY_OF_WEEK) - 1;

		// Constraints
		int timeInterval = dailyConstraints.getTimeInterval();
		DailySchedule[] constraints = dailyConstraints.getDayConstraints();
		TimeBlock timePeriod = constraints[day].getTimePeriod();
		TimeBlock lunchTime = constraints[day].getLunchTime();

		// Time at which the booking ends.
		Calendar endTime = (Calendar) date.clone();
		endTime.add(MINUTE, timeInterval - 1);

		// To check for conflicting bookings before
		Calendar conflictApp = (Calendar) date.clone();
		conflictApp.add(MINUTE, -(timeInterval - 30));

		// Creates two dummy bookings to check that there are no conflicting
		// bookings.
		Rentals dummyConflictApp = new Rentals(conflictApp.get(YEAR),
				conflictApp.get(MONTH), conflictApp.get(DATE),
				conflictApp.get(HOUR_OF_DAY), conflictApp.get(MINUTE),
				new Person("First", "Dummy"));
		Rentals dummyEndApp = new Rentals(endTime.get(YEAR),
				endTime.get(MONTH), endTime.get(DATE),
				endTime.get(HOUR_OF_DAY), endTime.get(MINUTE), new Person(
						"Second", "Dummy"));

		int startDayMins = timePeriod.getStartHours() * 60
				+ timePeriod.getStartMinutes();
		int endDayMins = timePeriod.getEndHours() * 60
				+ timePeriod.getEndMinutes();

		int startLunchMins = lunchTime.getStartHours() * 60
				+ lunchTime.getStartMinutes();
		int endLunchMins = lunchTime.getEndHours() * 60
				+ lunchTime.getEndMinutes();

		int startMins = date.get(HOUR_OF_DAY) * 60 + date.get(MINUTE);
		int endMins = endTime.get(HOUR_OF_DAY) * 60 + endTime.get(MINUTE);

		// Strings about the booking
		String dayName = "("
				+ date.getDisplayName(DAY_OF_WEEK, LONG, Locale.CANADA) + ")";
		String appTimes = "\nBooking from " + date.get(HOUR_OF_DAY) + ":"
				+ String.format("%02d", date.get(MINUTE)) + " to "
				+ endTime.get(HOUR_OF_DAY) + ":"
				+ String.format("%02d", endTime.get(MINUTE));

		// If there are bookings in between, it means that the booking
		// time is invalid.
		List<Rentals> dailyRentals = connection
				.getDailyBookings(date);

		if (ListUtilities.binarySearch(dailyRentals, dummyConflictApp) != ListUtilities
				.binarySearch(dailyRentals, dummyEndApp)) {
			errorMessage = "Conflicts with other bookings." + appTimes;
			return false;
		}

		// Error messages
		String lunchTimeError = "Cannot schedule bookings during lunch time "
				+ dayName
				+ " : "
				+ lunchTime.getStartHours()
				+ ":"
				+ String.format("%02d", lunchTime.getStartMinutes())
				+ " - "
				+ lunchTime.getEndHours()
				+ ":"
				+ String.format("%02d", lunchTime.getEndMinutes()) + appTimes;
		String startDayError = "Cannot schedule bookings before the start of the day "
				+ dayName
				+ " : "
				+ timePeriod.getStartHours()
				+ ":"
				+ String.format("%02d", timePeriod.getStartMinutes())
				+ appTimes;
		String endDayError = "Cannot schedule appointments after the end of the day "
				+ dayName
				+ " : "
				+ timePeriod.getEndHours()
				+ ":"
				+ String.format("%02d", timePeriod.getEndMinutes()) + appTimes;

		boolean isValid = false;

		switch (constraints[day]) {

		case FULL1: // Time Period(00, 00, 00, 00) Lunch Time(00, 00, 00, 00)
		case FULL2:
			if (startMins >= startDayMins) {
				if (startMins < startLunchMins) {
					if (endMins < startLunchMins)
						isValid = true;
					else
						errorMessage = lunchTimeError;
				} else if (startMins >= endLunchMins) {
					if (endMins < endDayMins)
						isValid = true;
					else
						errorMessage = endDayError;
				} else
					errorMessage = lunchTimeError;
			} else {
				errorMessage = startDayError;
			}
			break;

		case AM: // Time Block(00, 00, 00, 00)
		case PM:
			if (startMins >= startDayMins)
				if (endMins < endDayMins)
					isValid = true;
				else
					errorMessage = endDayError;
			else
				errorMessage = startDayError;
			break;

		case NONE: // No Time Block
			errorMessage = "Cannot schedule booking on "
					+ date.getDisplayName(DAY_OF_WEEK, LONG, Locale.CANADA)
					+ ".";
			break;
		}

		return isValid;
	}
}
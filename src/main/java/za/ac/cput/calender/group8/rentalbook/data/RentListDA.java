package za.ac.cput.calender.group8.rentalbook.data;

import za.ac.cput.calender.bookings.lib.FileType;
import za.ac.cput.calender.bookings.lib.Person;
import za.ac.cput.calender.bookings.rentalbookings.exceptions.DateNotAvailableException;
import za.ac.cput.calender.bookings.rentalbookings.exceptions.NonExistingRentalException;
import za.ac.cput.calender.bookings.rentalbookings.interfaces.RentDBClient;
import za.ac.cput.calender.group8.rentalbook.business.Rentals;
import za.ac.cput.calender.group8.util.ListUtilities;
import za.ac.cput.calender.group8.util.Utilities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class RentListDA implements RentDBClient<Rentals> {

	private List<Rentals> database = null;
	private String filename = null;
	private FileType medium;


	public RentListDA(String filename, FileType medium) throws Exception {

		this.medium = medium;
		this.filename = filename;

		if (this.medium == FileType.TEXT_SEQUENTIAL)
			database = RentingFileLoader
					.getListFromSequentialFile(filename);
		else if (this.medium == FileType.SERIALIZED) {
			database = RentingFileLoader.getListFromObjectFile(filename);
			if (database == null)
				database = new ArrayList<Rentals>();
		}
	}


	@Override
	public void add(Rentals booking) throws DateNotAvailableException {

		if (booking == null)
			throw new IllegalArgumentException(
					"The booking cannot be null.");

		int result = za.ac.cput.ui.calendar.ListUtilities.binarySearch(database, booking);
		if (result < 0) {
			result = -(result + 1);
			Rentals copyOfRentals = Utilities.copyOf(booking);
			database.add(result, copyOfRentals);
		} else
			throw new DateNotAvailableException();
	}


	@Override
	public void disconnect() throws Exception {

		if (medium == FileType.TEXT_SEQUENTIAL)
			ListUtilities.saveListToTextFile(database, filename);

		else if (medium == FileType.SERIALIZED)
			Utilities.serializeObject(database, filename);

		database = null;
	}


	@Override
	public Rentals getBooking(Calendar date)
			throws NonExistingRentalException {
		if (date == null)
			throw new IllegalArgumentException("The date cannot be null.");

		// Creates a dummy booking with the date sent in.
		Rentals app = new Rentals(date.get(Calendar.YEAR),
				date.get(Calendar.MONTH), date.get(Calendar.DATE),
				date.get(Calendar.HOUR_OF_DAY), date.get(Calendar.MINUTE),
				new Person("A", "Person"));

		// Checks if an booking has the same date
		int indexOfBooking = ListUtilities.binarySearch(database, app);
		if (indexOfBooking >= 0)
			return Utilities.copyOf(database.get(indexOfBooking));

		throw new NonExistingRentalException();
	}


	@Override
	public List<Rentals> getBookingsFor(String telephoneNumber) {
		List<Rentals> matchingApps = new ArrayList<Rentals>();

		if (telephoneNumber == null)
			throw new IllegalArgumentException(
					"The telephone number cannot be null.");

		for (Rentals app : database)
			if (app.getContact().getTelephoneNumber()
					.compareTo(telephoneNumber) == 0)
				matchingApps.add(Utilities.copyOf(app));

		((ArrayList<Rentals>) matchingApps).trimToSize();

		return matchingApps;
	}


	@Override
	public List<Rentals> getDailyBookings(Calendar date) {

		List<Rentals> rentals = new ArrayList<Rentals>();

		if (date == null)
			throw new IllegalArgumentException("The date cannot be null.");

		Calendar newDate = copyOfDateWithoutTime(date);

		// Creates a dummy booking with the newDate.
		Rentals app = new Rentals(newDate.get(Calendar.YEAR),
				newDate.get(Calendar.MONTH),
				newDate.get(Calendar.DAY_OF_MONTH), 0, 0, new Person("A",
						"Person"));

		// Finds the place where the booking on that day start, then looks
		// to find all the booking on that same day.
		int index = -(ListUtilities.binarySearch(database, app) + 1);
		while (index < database.size()) {
			Calendar appsDate = copyOfDateWithoutTime(database.get(index)
					.getDate());
			if (newDate.compareTo(appsDate) == 0)
				rentals.add(Utilities.copyOf(database.get(index)));
			else
				index = database.size();
			index++;
		}

		((ArrayList<Rentals>) rentals).trimToSize();

		return rentals;
	}


	@Override
	public boolean isAvailable(Calendar date) {
		if (date == null)
			throw new IllegalArgumentException("The date cannot be null.");

		// Create a dummy booking with the date sent in.
		Rentals app = new Rentals(date.get(Calendar.YEAR),
				date.get(Calendar.MONTH), date.get(Calendar.DATE),
				date.get(Calendar.HOUR_OF_DAY), date.get(Calendar.MINUTE),
				new Person("A", "Person"));

		if (ListUtilities.binarySearch(database, app) < 0)
			return true;

		return false;
	}


	@Override
	public void remove(Rentals booking)
			throws NonExistingRentalException {

		if (booking == null)
			throw new IllegalArgumentException(
					"The booking cannot be null.");

		// Looks for the booking
		int indexOfBooking = ListUtilities.binarySearch(database,
				booking);
		if (indexOfBooking < 0)
			throw new NonExistingRentalException();

		database.remove(indexOfBooking);
	}


	@Override
	public String toString() {
		String s = "database: Number of bookings in database: "
				+ database.size() + "\n";
		for (Rentals app : database)
			s += app + "\n";
		return s;
	}

	@Override
	public void update(Rentals modifiedBooking)
			throws NonExistingRentalException {

		if (modifiedBooking == null)
			throw new IllegalArgumentException(
					"The booking cannot be null.");

		// Looks for the booking
		int indexOfBooking = ListUtilities.binarySearch(database,
				modifiedBooking);

		if (indexOfBooking < 0)
			throw new NonExistingRentalException();

		database.set(indexOfBooking, Utilities.copyOf(modifiedBooking));
	}

	/*
	 * Makes a copy of a date and sets the time (hour, minute, second,
	 * millisecond) to zero.

	 */
	private Calendar copyOfDateWithoutTime(Calendar date) {

		Calendar appDate = Calendar.getInstance();
		appDate.set(date.get(Calendar.YEAR), date.get(Calendar.MONTH),
				date.get(Calendar.DAY_OF_MONTH), 0, 0, 0);
		appDate.set(Calendar.MILLISECOND, 0);

		return appDate;
	}

}

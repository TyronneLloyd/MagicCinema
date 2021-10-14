package za.ac.cput.calender.group8.rentalbook.business;

//import dw314.lib.*;

import za.ac.cput.calender.bookings.lib.Name;
import za.ac.cput.calender.bookings.lib.Person;

import java.io.Serializable;
import java.util.Calendar;


public class Rentals implements Comparable<Rentals>, Serializable {

	private Calendar date;
	private Person contact;
	private String reason;

	private static final long serialVersionUID = 4203146887L;


	public Rentals(int year, int month, int day, int hours, int minutes,
				   Person contact) {

		this(year, month, day, hours, minutes, contact, "");
	}


	public Rentals(int year, int month, int day, int hours, int minutes,
				   Person contact, String reason) {

		date = Calendar.getInstance();
		date.setLenient(false);
		date.set(year, month, day, hours, minutes, 0);
		date.set(Calendar.MILLISECOND, 0);

		// If the date is invalid, getTime() will throw an
		// IllegalArgumentException
		date.getTime();

		setContact(contact);
		setReason(reason);
	}


	public Person getContact() {
		Name copyName = contact.getName();
		Person copyContact = new Person(copyName.getFirstName(),
				copyName.getLastName(), contact.getTelephoneNumber(),
				contact.getAddress());
		return copyContact;
	}


	public Calendar getDate() {

		return (Calendar) date.clone();
	}


	public String getReason() {
		return reason;
	}


	public void setContact(Person contact) {
		if (contact == null)
			throw new IllegalArgumentException("The contact should not be null");
		this.contact = contact;
	}

	public void setReason(String reason) {
		if (reason == null)
			reason = "";
		this.reason = reason;
	}


	@Override
	public int compareTo(Rentals app) {

		if (this == app)
			return 0;

		return (date.compareTo(app.getDate()));
	}


	@Override
	public boolean equals(Object obj) {

		if (this == obj)
			return true;
		if (obj == null || obj.getClass() != this.getClass())
			return false;

		Rentals rentals = (Rentals) obj;

		return date.equals(rentals.date);
	}

	@Override
	public String toString() {

		String del = "*";

		Name name = contact.getName();
		String s = date.get(Calendar.YEAR) + del + date.get(Calendar.MONTH)
				+ del + date.get(Calendar.DAY_OF_MONTH) + del
				+ date.get(Calendar.HOUR_OF_DAY) + del
				+ date.get(Calendar.MINUTE) + del + name.toString() + del
				+ contact.getTelephoneNumber() + del + reason;
		return s;
	}
}
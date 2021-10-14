package za.ac.cput.calender.bookings.lib;

import java.io.Serializable;



public class Name implements Serializable{
	private String firstName = "";
	private String lastName = "";

	private static final long  serialVersionUID = 4203146887L;
	

	public Name() {
	}


	public Name(String firstName, String lastName) {
		setFirstName(firstName);
		setLastName(lastName);
	}

	public String getFirstName() {
		return firstName;
	}

	public String getFullName() {
		return (firstName + " " + lastName);
	}
	public String getLastName() {
		return lastName;
	}


	public void setFirstName(String firstName) {
		if (firstName == null)
			throw new IllegalArgumentException("Invalid first name");

		this.firstName = firstName;
	}


	public void setLastName(String lastName) {
		if (lastName == null)
			throw new IllegalArgumentException("Invalid last name");
		this.lastName = lastName;
	}


	@Override
	public String toString() {
		return (firstName + "*" + lastName);
	}
}

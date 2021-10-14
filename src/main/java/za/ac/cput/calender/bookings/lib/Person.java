package za.ac.cput.calender.bookings.lib;


import java.io.Serializable;


public class Person implements Serializable{

	private Name name;
	private Address address;
	private String telephoneNumber;

	private static final long  serialVersionUID = 4203146887L;
	

	public Person(String firstName, String lastName) {
		this(firstName, lastName, "", new Address());
	}


	public Person(String firstName, String lastName, String telephoneNumber) {
		this(firstName, lastName, telephoneNumber, new Address());
	}


	public Person(String firstName, String lastName, Address address) {
		this(firstName, lastName, "", address);
	}

	public Person(String firstName, String lastName, String telephoneNumber,
			Address address) {

		name = new Name();
		setName(firstName, lastName);
		this.address = new Address(address.getCivicNumber(),
				address.getStreetName(), address.getCity(),
				address.getProvince(), address.getPostalCode());
		this.telephoneNumber = telephoneNumber;
	}


	public Address getAddress() {
		Address address = new Address(this.address.getCivicNumber(),
				this.address.getStreetName(), this.address.getCity(),
				this.address.getProvince(), this.address.getPostalCode());
		return address;
	}


	public Name getName() {
		Name name = new Name(this.name.getFirstName(), this.name.getLastName());
		return name;
	}


	public String getTelephoneNumber() {
		return telephoneNumber;
	}


	public void setAddress(Address address) {

		this.address.setCity(address.getCity());
		this.address.setCivicNumber(address.getCivicNumber());
		this.address.setPostalCode(address.getPostalCode());
		this.address.setProvince(address.getProvince());
		this.address.setStreetName(address.getStreetName());
	}

	public void setName(String firstName, String lastName) {
		if (firstName.equals(""))
			throw new IllegalArgumentException("Invalid first name");
		if (lastName.equals(""))
			throw new IllegalArgumentException("Invalid last name");
		name.setFirstName(firstName);
		name.setLastName(lastName);
	}


	public void setTelephoneNumber(String telephoneNumber) {
		this.telephoneNumber = telephoneNumber;
	}


	@Override
	public String toString() {
		return (name.toString() + "*" + (address == null ? "" : address
				.toString()));
	}

}

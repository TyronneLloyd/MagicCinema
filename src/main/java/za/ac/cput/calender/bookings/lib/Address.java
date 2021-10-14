package za.ac.cput.calender.bookings.lib;

import java.io.Serializable;



public class Address implements Serializable {

	private String city;
	private String civicNumber;
	private String province;
	private String postalCode;
	private String streetName;

	private static final long serialVersionUID = 4203146887L;



	public Address(String... addressData) {

		if (addressData.length > 0)
			setCivicNumber(addressData[0]);
		else
			civicNumber = "";

		if (addressData.length > 1)
			setStreetName(addressData[1]);
		else
			streetName = "";

		if (addressData.length > 2)
			setCity(addressData[2]);
		else
			city = "";

		if (addressData.length > 3)
			setProvince(addressData[3]);
		else
			province = "";

		if (addressData.length > 4)
			setPostalCode(addressData[4]);
		else
			postalCode = "";

	}


	public String getAddress() {
		return (civicNumber
				+ (streetName.equals("") ? "" : (" " + streetName + "\n"))
				+ city + (province.equals("") ? "" : (", " + province)) + (postalCode
				.equals("") ? "" : ("\n" + postalCode)));
	}


	public String getCity() {
		return city;
	}


	public String getCivicNumber() {
		return civicNumber;
	}

	public String getProvince() {
		return province;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public String getStreetName() {
		return streetName;
	}


	public void setCity(String city) {
		if (city == null)
			throw new IllegalArgumentException("Invalid city.");
		else
			this.city = city;
	}


	public void setCivicNumber(String civicNumber) {
		if (civicNumber == null)
			throw new IllegalArgumentException("Invalid civic number.");
		else
			this.civicNumber = civicNumber;
	}

	public void setProvince(String province) {
		if (province == null)
			throw new IllegalArgumentException("Invalid province.");
		else
			this.province = province;
	}

	public void setPostalCode(String postalCode) {
		if (postalCode == null)
			throw new IllegalArgumentException("Invalid postal code.");
		else
			this.postalCode = postalCode;
	}


	public void setStreetName(String streetName) {
		if (streetName == null)
			throw new IllegalArgumentException("Invalid street name.");
		else
			this.streetName = streetName;
	}

	@Override
	public String toString() {
		return (civicNumber + "*" + streetName + "*" + city + "*" + province
				+ "*" + postalCode);
	}

}

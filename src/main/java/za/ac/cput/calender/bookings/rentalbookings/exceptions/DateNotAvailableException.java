package za.ac.cput.calender.bookings.rentalbookings.exceptions;


public class  DateNotAvailableException extends Exception {



	public DateNotAvailableException() {
		super("This Date is not available");
	}


	public DateNotAvailableException(String message) {
		super(message);
	}

}

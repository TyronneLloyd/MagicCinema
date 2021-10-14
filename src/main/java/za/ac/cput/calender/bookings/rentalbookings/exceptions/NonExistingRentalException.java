package za.ac.cput.calender.bookings.rentalbookings.exceptions;

public class NonExistingRentalException extends Exception{
	

	public NonExistingRentalException(){
		super("The booking does not exist.");
	}


	public NonExistingRentalException(String message) {
		super(message);
	}
}

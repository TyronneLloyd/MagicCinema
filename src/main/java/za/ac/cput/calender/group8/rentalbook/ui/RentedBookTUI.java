package za.ac.cput.calender.group8.rentalbook.ui;

import za.ac.cput.calender.group8.rentalbook.business.Rentals;
import za.ac.cput.calender.group8.rentalbook.business.EquipBook;
import za.ac.cput.calender.bookings.lib.Person;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import java.util.Observer;
import java.util.Observable;

public class RentedBookTUI implements Observer {

	private EquipBook model;

	public RentedBookTUI(EquipBook model) {

		this.model = model;
		model.addObserver(this);
		System.out.println("Today's scheduled bookings are:\n");
		update(model, Calendar.getInstance());

	}

	public void update(Observable model, Object obj) {
		displayFormattedBookings((java.util.Calendar) obj);
	}

	// EquipBook Text controller

	public void activate() {
		java.util.Scanner keyboard = new java.util.Scanner(System.in);
		String in;
		int menuChoice = 0;
		do {
			displayMenu();
			do {
				in = keyboard.nextLine();
				System.out.println();
			} while (in.length() == 0);

			if (Character.isDigit(in.charAt(0))) {
				menuChoice = Integer.parseInt(in);
				switch (menuChoice) {

				case 1:
					Calendar displayDate;
					try {
						displayDate = acceptDate();
						acceptTime(displayDate);

						model.cancelBooking(new Rentals(displayDate
								.get(Calendar.YEAR), displayDate
								.get(Calendar.MONTH), displayDate
								.get(Calendar.DATE), displayDate
								.get(Calendar.HOUR_OF_DAY), displayDate
								.get(Calendar.MINUTE), new Person("To",
								"Cancel"), "anything"));
					} catch (Exception e) {
						java.awt.Toolkit.getDefaultToolkit().beep();
						System.out.println("\nError: " + e.getMessage() + "\n");
					}
					break;
				case 2:
					try {
						displayDate = acceptDate();
						acceptTime(displayDate);
						Rentals rentals = model
								.getBooking(displayDate);

						System.out.println("Enter contact's first name "
								+ "(press enter if no change): ");
						String firstName = keyboard.nextLine();
						System.out.println("Enter contact's last name "
								+ "(press enter if no change): ");
						String lastName = keyboard.nextLine();
						System.out.println("Enter contact's telephone number "
								+ "(press enter if no change): ");
						String telephone = keyboard.nextLine();
						System.out.println("Enter reason for appointment "
								+ "(press enter if no change): ");
						String reason = keyboard.nextLine();
						if (firstName.equals(""))
							firstName = rentals.getContact().getName()
									.getFirstName();
						if (lastName.equals(""))
							lastName = rentals.getContact().getName()
									.getLastName();
						if (telephone.equals(""))
							telephone = rentals.getContact()
									.getTelephoneNumber();
						rentals.setContact(new Person(firstName, lastName,
								telephone));
						if (!reason.equals(""))
							rentals.setReason(reason);
						model.changeBookingDetails(rentals);
					} catch (Exception e) {
						java.awt.Toolkit.getDefaultToolkit().beep();
						System.out.println("\nError: " + e.getMessage() + "\n");
					}
					break;
				case 3:
					try {
						displayDate = acceptDate();
						acceptTime(displayDate);
						Rentals rentals = model
								.getBooking(displayDate);
						System.out
								.println("Details for booking scheduled on "
										+ displayDate.getTime());
						System.out.println("\n"
								+ rentals.getContact().getName()
										.getFirstName()
								+ " "
								+ rentals.getContact().getName()
										.getLastName() + " "
								+ rentals.getContact().getTelephoneNumber()
								+ " " + rentals.getReason() + "\n");
					} catch (Exception e) {
						java.awt.Toolkit.getDefaultToolkit().beep();
						System.out.println("\nError: " + e.getMessage() + "\n");
					}
					break;
				case 4:
					displayDate = acceptDate();
					displayFormattedBookings(displayDate);
					break;

				case 5:
					displayDate = acceptDate();
					acceptTime(displayDate);
					List<Calendar> dates = model
							.getNextAvailableDatesStarting(displayDate);
					System.out.println("Available dates: \n");
					for (Calendar d : dates)
						System.out.println(d.getTime());
					System.out.println("\n\n");
					break;
				case 6:
					System.out
							.println("Enter the telephone number to search for: ");
					String telephoneNumber = keyboard.nextLine();
					List<Rentals> rentals = model
							.getBookingsFor(telephoneNumber);
					if (rentals.size() == 0)
						System.out
								.println("No scheduled booking found for "
										+ telephoneNumber);
					else {
						System.out.println("Bookings found for "
								+ telephoneNumber + "\n");
						for (Rentals a : rentals)
							System.out.println(formatbyTelephoneBooking(a));
					}
					break;
				case 7:

					System.out.println("Enter contact's first name: ");
					String firstName = keyboard.nextLine();
					System.out.println("Enter contact's last name: ");
					String lastName = keyboard.nextLine();
					System.out.println("Enter contact's telephone number: ");
					String telephone = keyboard.nextLine();
					System.out.println("Enter reason for appointment: ");
					String reason = keyboard.nextLine();

					boolean scheduled = false;
					do {
						displayDate = acceptDate();
						acceptTime(displayDate);
						try {

							model.scheduleBooking(new Rentals(
									displayDate.get(Calendar.YEAR), displayDate
											.get(Calendar.MONTH), displayDate
											.get(Calendar.DATE), displayDate
											.get(Calendar.HOUR_OF_DAY),
									displayDate.get(Calendar.MINUTE),
									new Person(firstName, lastName, telephone),
									reason));
							scheduled = true;

						} catch (Exception e) {
							java.awt.Toolkit.getDefaultToolkit().beep();
							System.out.println("\nError: " + e.getMessage()
									+ "\n");
						}
					} while (!scheduled);
					break;

				case 8:
					boolean exist = false;
					boolean again = false;
					Calendar currentDate = null;
					do {
						try {
							System.out.println("Booking's current date");
							currentDate = acceptDate();
							acceptTime(currentDate);
							Rentals a = model.getBooking(currentDate);
							System.out.println("Booking details: " + a);
							exist = true;

						} catch (Exception e) {

							java.awt.Toolkit.getDefaultToolkit().beep();
							System.out.print("\nError: " + e.getMessage()
									+ "\n\n\tTry again? (Y/N) ");
							char response = keyboard.nextLine().charAt(0);
							again = false;
							if (response == 'Y' || response == 'y')
								again = true;
							exist = false;
						}
					} while (!exist && again);

					if (exist) {
						do {
							try {
								System.out.println("Booking's new date");
								Calendar newDate = acceptDate();
								acceptTime(newDate);
								model.rescheduleBooking(currentDate,
										newDate);
								exist = false;
								again = false;
							} catch (Exception e) {
								java.awt.Toolkit.getDefaultToolkit().beep();
								System.out.print("\nError: " + e.getMessage()
										+ "\n\n\tTry again? (Y/N) ");
								char response = keyboard.nextLine().charAt(0);
								again = false;
								if (response == 'Y' || response == 'y')
									again = true;
								exist = true;
							}
						} while (exist && again);
					}
					break;

				case 9:
					try {
						model.closeBook();
					} catch (Exception e) {
						System.out.println("Error closing book."
								+ e.getMessage());
					}

				}// end switch
			}// end if digit
			System.out.println("\n");
		} while (menuChoice != 9);

	}

	public static void displayMenu() {
		System.out.println("\n\n\t\tRental Book's System menu\n");
		System.out.println("1\tCancel an booking.");
		System.out.println("2\tChange an booking's details.");
		System.out.println("3\tDisplay booking details.");
		System.out.println("4\tDisplay daily bookings.");
		System.out.println("5\tDisplay the next five available dates.");
		System.out.println("6\tSearch by telephone number.");
		System.out.println("7\tSchedule an booking.");
		System.out.println("8\tReschedule an booking.");
		System.out.println("9\tExit.");

		System.out.print("\nSelect an option by entering the "
				+ "corresponding number: ");
	}

	// private methods

	private Calendar acceptDate() {
		Calendar date = null;
		java.util.Scanner keyboard = new java.util.Scanner(System.in);
		boolean valid = false;
		do {
			System.out.println("Enter the desired date as MM/DD/YYYY: ");
			String dateStr = keyboard.nextLine();
			// validate date
			String fields[] = dateStr.split("/");
			try {

				// parsing may throw Exception
				int month = Integer.parseInt(fields[0]) - 1;
				int day = Integer.parseInt(fields[1]);
				int year = Integer.parseInt(fields[2]);

				// if no exception convert to date
				date = Calendar.getInstance();
				date.set(year, month, day, 0, 0);
				date.set(Calendar.MILLISECOND, 0);
				valid = true;
			} catch (Exception e) {
				java.awt.Toolkit.getDefaultToolkit().beep();
				System.out.println("\nError: " + e.getMessage() + "\n");
			}
		} while (!valid);
		return date;
	}

	private void acceptTime(Calendar date) {

		java.util.Scanner keyboard = new java.util.Scanner(System.in);
		boolean valid = false;
		do {
			System.out.println("Enter time as "
					+ "HH:MM (e.g. 2:30PM would be entered as 14:30) :");
			String timeStr = keyboard.nextLine();
			String[] fields = timeStr.split(":");
			try {
				// validate time
				int hours = Integer.parseInt(fields[0]);
				int mins = Integer.parseInt(fields[1]);
//				System.out.println(hours);
				// set date
				date.set(Calendar.HOUR_OF_DAY, hours);
				date.set(Calendar.MINUTE, mins);
				date.set(Calendar.SECOND, 0);
				date.set(Calendar.MILLISECOND, 0);
				valid = true;
			} catch (Exception e) {
				java.awt.Toolkit.getDefaultToolkit().beep();
				System.out.println("\nError: " + e.getMessage() + "\n");
			}
		} while (!valid);

	}

	private void displayFormattedBookings(java.util.Calendar displayDate) {

		List<Rentals> rentals = null;
		String appointmentStr = "";

		// may throw exception
		appointmentStr = appointmentStr + getDayHeading(displayDate);
		rentals = this.model.getDailyBookings(displayDate);
		if (rentals.size() != 0) {

			for (Rentals a : rentals)
				appointmentStr = appointmentStr
						+ formatBooking((Rentals) a) + "\n";
		} else
			appointmentStr = appointmentStr + " No Bookings!";

		System.out.println("\n" + appointmentStr);

	}

	private String getDayHeading(Calendar date) {
		DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.FULL,
				Locale.CANADA);
		return "Bookings for " + dateFormatter.format(date.getTime())
				+ "\n";
	}

	private String formatBooking(Rentals a) {
		String fmt = "   %-20s @ %10s %-20s";
		DateFormat timeFormatter = DateFormat.getTimeInstance(DateFormat.SHORT,
				Locale.CANADA);

		return String.format(fmt, a.getContact().getName().getFullName(),
				timeFormatter.format(a.getDate().getTime()), a.getContact()
						.getTelephoneNumber() + "   " + a.getReason());
	}

	private String formatbyTelephoneBooking(Rentals a) {
		DateFormat dateFormatter = DateFormat.getDateInstance(DateFormat.FULL,
				Locale.CANADA);
		DateFormat timeFormatter = DateFormat.getTimeInstance(DateFormat.SHORT,
				Locale.CANADA);
		String fmt = "   %-20s on %-30s %-10s %-20s";
		return String.format(fmt, a.getContact().getName().getFullName(),
				dateFormatter.format(a.getDate().getTime()),
				timeFormatter.format(a.getDate().getTime()), a.getReason());
	}
}

package za.ac.cput.calender.group8.rentalbook.ui;

import za.ac.cput.calender.bookings.rentalbookings.exceptions.NonExistingRentalException;
import za.ac.cput.calender.bookings.lib.DailyConstraints;
import za.ac.cput.calender.bookings.lib.FileType;
import za.ac.cput.calender.bookings.lib.Person;
import za.ac.cput.calender.bookings.lib.ui.DateAndTimeDialog;
import za.ac.cput.calender.group8.rentalbook.business.Rentals;
import za.ac.cput.calender.group8.rentalbook.business.EquipBook;
import za.ac.cput.calender.group8.rentalbook.data.RentListDA;

import javax.swing.Timer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.DateFormat;
import java.util.List;
import java.util.*;

import static java.awt.BorderLayout.*;
import static java.util.Calendar.*;

@SuppressWarnings("serial")
public class RentalsBookGUI extends JFrame implements Observer {

	private Locale locale = Locale.CANADA;

	private EquipBook appBook;

	private ImageIcon[] icons = new ImageIcon[12];
	private JLabel imageLabel = new JLabel();
	private Calendar currentlySelectedDate = getInstance();
	private JLabel rightLabel = new JLabel();
	private JTextArea contentTextArea;
	private JButton todaysAppsButton;
	private CalendarPanel calendarPanel;


	public RentalsBookGUI() {
		try {
			appBook = new EquipBook(
					new RentListDA(
							"datafiles/database/bookings.ser",
							FileType.SERIALIZED), new DailyConstraints());
			appBook.addObserver(this);
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
		for (int i = 0; i < 12; i++) {
			icons[i] = new ImageIcon("images/month" + (i + 1) + ".gif");
		}
		add(getTitlePanel(), NORTH);
		add(getCalendarPanel(), WEST);
		add(getContentPanel(), CENTER);
		add(getNavigationPanel(), EAST);
		add(getSouthPanel(), SOUTH);
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Timer t = new Timer(1000, new TimerListener());
		t.setInitialDelay(0);
		t.start();

		// For when the window is closed
		// It will delete the past appointments
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				try {
					appBook.closeBook();
					JOptionPane.showMessageDialog(null,
							"Thank you for booking"
									+ "your equipment.");
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		});

		todaysAppsButton.doClick();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new RentalsBookGUI();
			}
		});
	}


	public EquipBook getModel() {
		return appBook;
	}


	public Locale getTheLocale() {
		return locale;
	}


	@Override
	public void update(Observable o, Object arg) {
		String allApps = "";

		// Checks if there is only one date sent in.
		if (arg instanceof Calendar) {
			Calendar date = (Calendar) arg;
			int newMonth = date.get(MONTH);
			if (newMonth != currentlySelectedDate.get(MONTH))
				imageLabel.setIcon(icons[newMonth]);
			currentlySelectedDate = (Calendar) date.clone();

			allApps = getFormattedBookingList(date,
					appBook.getDailyBookings(date));
		}
		// Checks if there is more than one date sent in.
		else if (arg instanceof Calendar[]) {
			Calendar[] dates = (Calendar[]) arg;
			allApps = getFormattedBookingList(dates[0],
					appBook.getDailyBookings(dates[0]));
			// If the date didn't change, it won't display again.
			if (dates[0].get(MONTH) != dates[1].get(MONTH)
					|| dates[0].get(DATE) != dates[1].get(DATE))
				allApps += "\n\n"
						+ getFormattedBookingList(dates[1],
								appBook.getDailyBookings(dates[1]));
		}
		if (allApps.length() != 0)
			contentTextArea.setText(allApps);
	}


	private JPanel getCalendarPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		calendarPanel = new CalendarPanel(locale, this);

		int i = Calendar.getInstance().get(MONTH);
		imageLabel.setIcon(icons[i]);

		panel.add(imageLabel, NORTH);
		panel.add(calendarPanel, SOUTH);

		JPanel wrapperPanel = new JPanel();
		wrapperPanel.add(panel, CENTER);
		return wrapperPanel;
	}

	private JPanel getContentPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		todaysAppsButton = new JButton("Today's Bookings");
		todaysAppsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				calendarPanel.setSelectedDate(getInstance());
			}
		});
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(todaysAppsButton);
		panel.add(buttonPanel, SOUTH);

		contentTextArea = new JTextArea(20, 95);
		contentTextArea.setEditable(false);
		contentTextArea.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createLineBorder(Color.GRAY, 1),
				BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		contentTextArea.setFont(new Font("Courier New", Font.PLAIN, 12));
		JScrollPane scrollPane = new JScrollPane(contentTextArea,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		panel.add(scrollPane, NORTH);
		panel.add(new JLabel(" "));
		JPanel wrapperPanel = new JPanel();
		wrapperPanel.add(panel);
		return wrapperPanel;
	}


	private JPanel getNavigationPanel() {
		JPanel panel = new JPanel(new GridLayout(4, 1, 10, 10));
		panel.setAlignmentX(CENTER_ALIGNMENT);
		panel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Options"),
				BorderFactory.createEmptyBorder(15, 40, 15, 40)));

		JButton displayDetailsButton = new JButton("Display Details");
		displayDetailsButton
				.addActionListener(new DisplayDetailsButtonListener());
		displayDetailsButton.setMnemonic('d');

		JButton getAvailableDatesButton = new JButton("Get Available Dates");
		getAvailableDatesButton
				.addActionListener(new GetAvailableDatesButtonListener());
		getAvailableDatesButton.setMnemonic('g');

		JButton scheduleBookingButton = new JButton("Schedule Booking");
		scheduleBookingButton
				.addActionListener(new ScheduleBookingButtonListener());
		scheduleBookingButton.setMnemonic('s');

		JButton searchByTelephoneButton = new JButton("Search by Telephone");
		searchByTelephoneButton
				.addActionListener(new SearchByTelephoneButtonListener());
		searchByTelephoneButton.setMnemonic('t');

		panel.add(displayDetailsButton);
		panel.add(getAvailableDatesButton);
		panel.add(scheduleBookingButton);
		panel.add(searchByTelephoneButton);

		return panel;
	}

	private JPanel getSouthPanel() {
		JPanel panel = new JPanel(new BorderLayout());
		JLabel leftLabel = new JLabel(
				"Equipment Rental Calender Booking");
		panel.add(leftLabel, WEST);
		panel.add(rightLabel, EAST);
		panel.setBorder(BorderFactory.createEmptyBorder(15, 20, 20, 20));
		return panel;
	}


	private JPanel getTitlePanel() {
		JPanel panel = new JPanel(new BorderLayout());
		Color colour = Color.BLUE;
		Font font = new Font("Arial", Font.BOLD, 18);

		panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		JLabel label = new JLabel("Equipment Rental Calender", SwingConstants.CENTER);
		label.setForeground(colour);
		label.setFont(font);
		JLabel label2 = new JLabel("Calender Booking System",
				SwingConstants.CENTER);
		label2.setForeground(colour);
		label2.setFont(font);

		label2.setBorder(BorderFactory.createEmptyBorder(8, 0, 0, 0));
		panel.add(label, NORTH);
		panel.add(label2, SOUTH);
		return panel;
	}


	private String getFormattedBookingList(Calendar displayDate,
										   List<Rentals> apps) {
		String formattedStr = "Scheduled booking for "
				+ DateFormat.getDateInstance(DateFormat.FULL, locale).format(
						displayDate.getTime()) + "\n";
		Calendar aDate;
		Person contact;
		String time;

		for (Rentals a : apps) {
			aDate = a.getDate();
			contact = a.getContact();
			time = DateFormat.getTimeInstance(DateFormat.SHORT, locale).format(
					aDate.getTime());
			formattedStr += String.format("%3s%-27s%3s%10s%14s%3s%s\n", "",
					contact.getName().getFullName(), " @ ", time,
					contact.getTelephoneNumber(), "", a.getReason());
		}
		// displaying appointments
		return formattedStr;
	}

	private class TimerListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			Calendar today = Calendar.getInstance();
			rightLabel.setText(DateFormat.getDateInstance(DateFormat.FULL,
					locale).format(today.getTime())
					+ "  "
					+ DateFormat.getTimeInstance(DateFormat.MEDIUM, locale)
							.format(today.getTime()));
		}
	}


	private class DisplayDetailsButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			Calendar date = DateAndTimeDialog.showDateAndTimeDialog(
					RentalsBookGUI.this, true, locale,
					currentlySelectedDate);
			try {
				Rentals app = appBook.getBooking(date);

				@SuppressWarnings("unused")
				SearchForm searchForm = new SearchForm(RentalsBookGUI.this,
						app);

			} catch (NonExistingRentalException neae) {
				JOptionPane.showMessageDialog(RentalsBookGUI.this,
						neae.getMessage());
			}
		}
	}

	private class GetAvailableDatesButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			try {
				Calendar startingDate = DateAndTimeDialog
						.showDateAndTimeDialog(RentalsBookGUI.this, true,
								locale);
				List<Calendar> dates = appBook
						.getNextAvailableDatesStarting(startingDate);
				String availableDates;

				if (dates.size() > 0) {

					availableDates = "Available times starting "
							+ DateFormat.getDateInstance(DateFormat.LONG,
									locale).format(startingDate.getTime())
							+ " "
							+ DateFormat.getTimeInstance(DateFormat.SHORT,
									locale).format(startingDate.getTime())
							+ "\n\n";

					for (Calendar date : dates)
						availableDates += String.format(
								"%3s%s%5s%8s\n",
								"",
								DateFormat.getDateInstance(DateFormat.LONG,
										locale).format(date.getTime()),
								"",
								DateFormat.getTimeInstance(DateFormat.SHORT,
										locale).format(date.getTime()));
				} else {
					availableDates = "There are no available dates starting\n\n"
							+ DateFormat.getDateInstance(DateFormat.FULL,
									locale).format(startingDate.getTime())
							+ "\n\n\nCheck the date to ensure that it is correct."
							+ "\n\nIf the date is correct, you are trying to schedule too far in"
							+ " advance. Try again tomorrow.";
				}
				contentTextArea.setText(availableDates);
			} catch (IllegalArgumentException iae) {
				JOptionPane.showMessageDialog(RentalsBookGUI.this,
						iae.getMessage());
			}
		}
	}// End GetAvailableDatesButtonListener

	/*
	 * This handles the Schedule Booking button when clicked.
	 */
	private class ScheduleBookingButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			@SuppressWarnings("unused")
			ScheduleForm scheduleForm = new ScheduleForm(
					RentalsBookGUI.this);
		}
	}

	/*
	 * This handles the Search by Telephone button when clicked.
	 */
	private class SearchByTelephoneButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			String telephoneNumber = JOptionPane.showInputDialog(null,
					"Enter the telephone number as (999)999-9999", "Input",
					JOptionPane.QUESTION_MESSAGE);
			if (telephoneNumber != null) {
				List<Rentals> apps = appBook
						.getBookingsFor(telephoneNumber);

				String formattedApps;
				if (apps.size() != 0) {

					formattedApps = "Scheduled bookings for telephone number "
							+ telephoneNumber + "\n\n";

					Calendar date;
					for (Rentals a : apps) {
						date = a.getDate();
						formattedApps += String.format(
								"%4s%-27s%-20s%s%s\n",
								"",
								a.getContact().getName().getFullName(),
								DateFormat.getDateInstance(DateFormat.LONG,
										locale).format(date.getTime()),
								"@ ",
								DateFormat.getTimeInstance(DateFormat.SHORT,
										locale).format(date.getTime()));
					}
				} else
					formattedApps = "There are no scheduled bookings for telephone number "
							+ telephoneNumber;
				contentTextArea.setText(formattedApps);
			}
		}
	}// End SearchByTelephoneNumber
}

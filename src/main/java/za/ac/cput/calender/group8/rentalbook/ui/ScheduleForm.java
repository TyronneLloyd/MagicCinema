package za.ac.cput.calender.group8.rentalbook.ui;

import za.ac.cput.calender.bookings.rentalbookings.interfaces.Schedulable;
import za.ac.cput.calender.bookings.lib.Person;
import za.ac.cput.calender.bookings.lib.ui.DatePanel;
import za.ac.cput.calender.bookings.lib.ui.PersonalDataPanel;
import za.ac.cput.calender.bookings.lib.ui.TimePanel;
import za.ac.cput.calender.group8.rentalbook.business.Rentals;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Calendar;

public class ScheduleForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private RentalsBookGUI mainGUI;
	private DatePanel dateSelector;
	private PersonalDataPanel personalData;
	private TimePanel timeSelector;

	public ScheduleForm(RentalsBookGUI mainGUI) {
		this.mainGUI = mainGUI;
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.addWindowListener(new Terminate());
		this.setTitle("Schedule Booking");
		Container container = getContentPane();
		((JPanel) container).setBorder(new EmptyBorder(10, 10, 10, 10));
		container.setLayout(new BorderLayout());
		container.add(getDateAndTimePanel(), BorderLayout.NORTH);
		personalData = new PersonalDataPanel();
		container.add(personalData, BorderLayout.CENTER);
		container.add(getBottomPanel(), BorderLayout.SOUTH);
		this.pack();
		this.setSize(400, 500);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

	private JPanel getBottomPanel() {
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(20, 10, 20, 20));
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBorder(BorderFactory.createEmptyBorder(10, 40, 10, 40));
		JButton scheduleButton = new JButton("Schedule");
		scheduleButton.setMnemonic('S');
		scheduleButton.addActionListener(new ScheduleButtonListener());
		buttonPanel.add(scheduleButton);
		panel.add(buttonPanel, scheduleButton);
		return panel;
	}

	private JPanel getDateAndTimePanel() {
		// date and time panel selection
		JPanel datePanel = new JPanel(new BorderLayout());
		datePanel.setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Booking Date And Time"),
				BorderFactory.createEmptyBorder(20, 20, 20, 20)));
		dateSelector = new DatePanel(mainGUI.getTheLocale());
		timeSelector = new TimePanel();
		datePanel.add(dateSelector, BorderLayout.WEST);
		datePanel.add(timeSelector, BorderLayout.EAST);
		return datePanel;
	}

	// private class

	private class ScheduleButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			try {

				// check if all required fields have been entered
				if (personalData.getClientID().equals("")
						|| personalData.getLastName().equals("")
						|| personalData.getTelephoneNumber().equals("")) {
					java.awt.Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(ScheduleForm.this,
							"You must enter the contact's first name,\n "
									+ "last name and telephone number.",
							"Invalid Data", JOptionPane.ERROR_MESSAGE);
				} else {
					Calendar date = dateSelector.getDate();
					date.set(Calendar.HOUR_OF_DAY, timeSelector.getHourOfDay());
					date.set(Calendar.MINUTE, timeSelector.getMinutes());
					((Schedulable<Rentals>) mainGUI.getModel())
							.scheduleBooking(new Rentals(date
									.get(Calendar.YEAR), date
									.get(Calendar.MONTH), date
									.get(Calendar.DATE), date
									.get(Calendar.HOUR_OF_DAY), date
									.get(Calendar.MINUTE), new Person(
									personalData.getClientID(), personalData
											.getLastName(), personalData
											.getTelephoneNumber()),
									personalData.getReason()));
					java.awt.Toolkit.getDefaultToolkit().beep();
					JOptionPane.showMessageDialog(ScheduleForm.this,
							"Booking has been scheduled.");
				}

			} catch (Exception e) {

				java.awt.Toolkit.getDefaultToolkit().beep();
				JOptionPane.showMessageDialog(ScheduleForm.this,
						e.getMessage(), "Invalid Data",
						JOptionPane.ERROR_MESSAGE);
			}
		}

	}

	private class Terminate extends WindowAdapter {
		public void windowClosing(WindowEvent we) {
			ScheduleForm.this.dispose();
		}
	}
}

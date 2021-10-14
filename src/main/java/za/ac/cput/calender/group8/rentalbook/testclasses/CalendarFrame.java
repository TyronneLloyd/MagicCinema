package za.ac.cput.calender.group8.rentalbook.testclasses;

import za.ac.cput.calender.group8.rentalbook.ui.CalendarPanel;

import javax.swing.*;
import java.util.Locale;

@SuppressWarnings("serial")
public class CalendarFrame extends JFrame {
	public CalendarFrame() {
		CalendarPanel panel = new CalendarPanel(Locale.CANADA);
		setTitle("Calendar EX4");
		add(panel);
		pack();
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	public static void main(String[] args) {
		new CalendarFrame();
	}
}

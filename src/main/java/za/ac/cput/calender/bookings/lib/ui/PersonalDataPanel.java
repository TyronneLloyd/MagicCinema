package za.ac.cput.calender.bookings.lib.ui;

import javax.swing.*;
import java.awt.*;

public class PersonalDataPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JTextField clientIDTextField;
	private JTextField lastNameTextField;
	private JTextField contactNumTextField;
	private JTextField reasonTextField;

	//clientID,name,surname,contactNumber, accountNumber;
	public PersonalDataPanel() {
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createTitledBorder("Personal Data"),
				BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		add(getLabelsPanel(), BorderLayout.WEST);
		add(getTextFieldPanel(), BorderLayout.CENTER);
	}

	public String getClientID() {
		return clientIDTextField.getText();
	}

	public String getLastName() {
		return lastNameTextField.getText();
	}

	public String getReason() {
		return reasonTextField.getText();
	}

	public String getTelephoneNumber() {
		if (isValidTelephone(contactNumTextField.getText()))
			return contactNumTextField.getText();
		else
			throw new RuntimeException("Invalid telephone number");
	}

	public void setClientIDTextField(String firstName) {
		clientIDTextField.setText(firstName);
		clientIDTextField.setFocusable(true);
		clientIDTextField.selectAll();
	}

	public void setLastNameTextField(String lastName) {
		lastNameTextField.setText(lastName);
	}

	public void setContactNumTextField(String telephone) {
		if (isValidTelephone(telephone))
			contactNumTextField.setText(telephone);
		else
			throw new RuntimeException("Invalid telephone number");
	}

	public void setReasonTextField(String reason) {
		reasonTextField.setText(reason);
	}

	// private methods

	private JPanel getLabelsPanel() {
		JPanel labelPanel = new JPanel(new GridLayout(4, 0, 5, 5));
		labelPanel.add(new JLabel("First Name"));
		labelPanel.add(new JLabel("Last Name"));
		labelPanel.add(new JLabel("Telephone # as (999)999-9999 "));
		labelPanel.add(new JLabel("Reason"));
		return labelPanel;
	}

	private JPanel getTextFieldPanel() {
		JPanel textFieldPanel = new JPanel(new GridLayout(4, 0, 5, 5));
		clientIDTextField = new JTextField();
		lastNameTextField = new JTextField();
		contactNumTextField = new JTextField();
		reasonTextField = new JTextField();
		textFieldPanel.add(clientIDTextField);
		textFieldPanel.add(lastNameTextField);
		textFieldPanel.add(contactNumTextField);
		textFieldPanel.add(reasonTextField);
		return textFieldPanel;
	}

	private boolean isValidTelephone(String phone) {
		boolean validPhone = true;
		if (!phone.matches("^\\((\\d{3})\\)(\\d{3})[-](\\d{4})$"))
			validPhone = false;
		return validPhone;
	}// end checkPhone method
}

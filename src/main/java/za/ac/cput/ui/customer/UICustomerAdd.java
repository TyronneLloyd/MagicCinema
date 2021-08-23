package za.ac.cput.ui.customer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class UICustomerAdd  extends JFrame implements ActionListener {
    Container container = getContentPane();

    //Labels for credentials on Reg form.
    JLabel userLabel = new JLabel("Username");
    JLabel passwordLabel = new JLabel("Password");
    JLabel fNameLabel = new JLabel("First Name");
    JLabel lNameLabel = new JLabel("Last Name");
    JLabel emailLabel = new JLabel("Email Address");
    JLabel mNumberLabel = new JLabel("Mobile Number");
    JLabel compNameLabel = new JLabel("Company Name");
    JLabel emPositionLabel = new JLabel("Position");


    //Textfields for credentials on Reg form.
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JTextField fNameTextField = new JTextField();
    JTextField lNameTextField = new JTextField();
    JTextField emailTextField = new JTextField();
    JTextField mNumberTextField = new JTextField();
    JTextField compNameTextField = new JTextField();
    JTextField emPositionTextField = new JTextField();


    //added by Sine
    JButton directToCamera = new JButton("Please verify your identity");

    //Submit, reset and login buttons on Reg form.
    JButton submitButton = new JButton("Submit");
    JButton resetButton = new JButton("Reset");
    JButton loginButton = new JButton("Login");
    JButton AdminLoginbutton = new JButton("Admin");

    UICustomerAdd() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {   //setBounds  = (x:,y:,width:,height:)
        //x: Keep it set to 50.
        //y: Increment the
        userLabel.setBounds(50, 50, 100, 30);
        passwordLabel.setBounds(50, 100, 100, 30);
        fNameLabel.setBounds(50, 150, 100, 30);
        lNameLabel.setBounds(50, 200, 100, 30);
        emailLabel.setBounds(50, 250, 100, 30);
        mNumberLabel.setBounds(50, 300, 100, 30);
        compNameLabel.setBounds(50, 350, 100, 30);
        emPositionLabel.setBounds(50, 400, 100, 30);


        //addded by Sine
        directToCamera.setBounds(100, 440, 250, 30);
        userTextField.setBounds(150, 50, 150, 30);
        passwordField.setBounds(150, 100, 150, 30);
        //passwordField.setBounds(50,150,100,30);
        fNameTextField.setBounds(150, 150, 150, 30);
        lNameTextField.setBounds(150, 200, 150, 30);
        emailTextField.setBounds(150, 250, 150, 30);
        mNumberTextField.setBounds(150, 300, 150, 30);
        compNameTextField.setBounds(150, 350, 150, 30);
        emPositionTextField.setBounds(150, 400, 150, 30);
        //showPassword.setBounds(150,250,150,30);
        submitButton.setBounds(100, 500, 100, 30);
        resetButton.setBounds(250, 500, 100, 30);
        loginButton.setBounds(100, 600, 250, 30);
        AdminLoginbutton.setBounds(250, 600, 250, 30);

        //registerButton.setBounds(50,360,250,30);
    }

    public void addComponentsToContainer() {
        //Adding labels to container
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(fNameLabel);
        container.add(lNameLabel);
        container.add(emailLabel);
        container.add(mNumberLabel);
        container.add(compNameLabel);
        container.add(emPositionLabel);

        //Adding Textfields to container
        container.add(userTextField);
        container.add(passwordField);
        container.add(fNameTextField);
        container.add(lNameTextField);
        container.add(emailTextField);
        container.add(mNumberTextField);
        container.add(compNameTextField);
        container.add(emPositionTextField);

        container.add(directToCamera);//added by Sine for camera

        //container.add(showPassword);
        //Adding buttons to container
        container.add(submitButton);
        container.add(resetButton);
        container.add(loginButton);


        container.add(AdminLoginbutton);

        //container.add(registerButton);
    }

    public void addActionEvent() {
        submitButton.addActionListener(this);
        resetButton.addActionListener(this);
        loginButton.addActionListener(this);

        //registerButton.addActionListener(this);

        directToCamera.addActionListener(this);//added by Sine

        AdminLoginbutton.addActionListener(this);
        //registerButton.addActionListener(this);

    }

    public void actionPerformed(ActionEvent e) {


        if (e.getSource() == submitButton) {
            String userText;
            String passwordText;
            String fNameText;
            String lNameText;
            String emailText;
            String mNumberText;
            String compNameText;
            String emPositionText;

            userText = userTextField.getText();
            passwordText = passwordField.getText();
            fNameText = fNameTextField.getText();
            lNameText = lNameTextField.getText();
            emailText = emailTextField.getText();
            mNumberText = mNumberTextField.getText();
            compNameText = compNameTextField.getText();
            emPositionText = emPositionTextField.getText();

            //<<<<<<<<User Verification goes here.>>>>>>>>>>>

            if (userText.equalsIgnoreCase("") && passwordText.equalsIgnoreCase(""))

                JOptionPane.showMessageDialog(this, "Please enter a username");
            else if (fNameText.equalsIgnoreCase("") && lNameText.equalsIgnoreCase("")) {

            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username/Password or User does not exist");
            }

        }
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
            fNameTextField.setText("");
            lNameTextField.setText("");
            emailTextField.setText("");
            mNumberTextField.setText("");
            compNameTextField.setText("");
            emPositionTextField.setText("");
        }
        if (e.getSource() == loginButton) {
            {

            }
        }
    }
}


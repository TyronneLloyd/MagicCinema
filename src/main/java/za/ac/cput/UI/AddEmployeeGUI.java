package za.ac.cput.UI;

import za.ac.cput.Database.EmployeeDB;
import za.ac.cput.Entity.Employee;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployeeGUI extends JFrame implements ActionListener {

    private Container cMainContainer;
    private JLabel lblTitle, lblFirstName, lblSurname, lblEmail, lblUserType, lblPassword, lblResults;
    private JTextField txtFirstName, txtSurname, txtEmail, txtPassword;
    private JTextArea txtOutput, txtResults;
    private JCheckBox cbTOS;
    private JComboBox cbUserType;
    private JButton btnAddEmployee, btnResetEmployee;
    private ImageIcon iconLogo;
    private Color main_color, sub_color, text_color;

    public AddEmployeeGUI() {
        super("CINEMA MAGIC");

        // Color

        main_color = new Color(0,0,0);
        sub_color = new Color(255, 255, 255);
        text_color = new Color(169,169,169);

        cMainContainer = getContentPane();
        cMainContainer.setLayout(null);

        // Image
        iconLogo = new ImageIcon("images/logo.png");
        lblTitle = new JLabel();
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setIcon(iconLogo);
        lblTitle.setSize(300, 60);
        lblTitle.setLocation(300, 30);
        cMainContainer.add(lblTitle);


        lblFirstName = new JLabel("First Name");
        lblFirstName.setFont(new Font("Arial", Font.PLAIN, 16));
        lblFirstName.setForeground(main_color);
        lblFirstName.setSize(100, 20);
        lblFirstName.setLocation(100, 100);
        cMainContainer.add(lblFirstName);

        txtFirstName = new JTextField();
        txtFirstName.setFont(new Font("Arial", Font.PLAIN, 16));
        txtFirstName.setBorder(new LineBorder(main_color, 1));
        txtFirstName.setBackground(sub_color);
        txtFirstName.setForeground(main_color);
        txtFirstName.setSize(190, 20);
        txtFirstName.setLocation(220, 100);
        cMainContainer.add(txtFirstName);

        lblSurname = new JLabel("Surname");
        lblSurname.setFont(new Font("Arial", Font.PLAIN, 16));
        lblSurname.setForeground(main_color);
        lblSurname.setSize(100, 20);
        lblSurname.setLocation(100, 150);
        cMainContainer.add(lblSurname);

        txtSurname = new JTextField();
        txtSurname.setFont(new Font("Arial", Font.PLAIN, 16));
        txtSurname.setBorder(new LineBorder(main_color, 1));
        txtSurname.setBackground(sub_color);
        txtSurname.setForeground(main_color);
        txtSurname.setSize(190, 20);
        txtSurname.setLocation(220, 150);
        cMainContainer.add(txtSurname);

        lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("Arial", Font.PLAIN, 16));
        lblPassword.setForeground(main_color);
        lblPassword.setSize(100, 20);
        lblPassword.setLocation(100, 200);
        cMainContainer.add(lblPassword);

        txtPassword = new JTextField();
        txtPassword.setFont(new Font("Arial", Font.PLAIN, 16));
        txtPassword.setBorder(new LineBorder(main_color, 1));
        txtPassword.setForeground(main_color);
        txtPassword.setBackground(sub_color);
        txtPassword.setSize(190, 20);
        txtPassword.setLocation(220, 200);
        cMainContainer.add(txtPassword);

        lblEmail = new JLabel("Email");
        lblEmail.setFont(new Font("Arial", Font.PLAIN, 16));
        lblEmail.setForeground(main_color);
        lblEmail.setSize(100, 20);
        lblEmail.setLocation(100, 250);
        cMainContainer.add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setFont(new Font("Arial", Font.PLAIN, 16));
        txtEmail.setBorder(new LineBorder(main_color, 1));
        txtEmail.setForeground(main_color);
        txtEmail.setBackground(sub_color);
        txtEmail.setSize(190, 20);
        txtEmail.setLocation(220, 250);
        cMainContainer.add(txtEmail);

        lblUserType = new JLabel("Access Level");
        lblUserType.setFont(new Font("Arial", Font.PLAIN, 16));
        lblUserType.setForeground(main_color);
        lblUserType.setSize(100, 20);
        lblUserType.setLocation(100, 300);
        cMainContainer.add(lblUserType);

        cbUserType = new JComboBox();
        cbUserType.addItem("Sales Person");
        cbUserType.addItem("Administrator");
        cbUserType.setBorder(new LineBorder(main_color, 1));
        cbUserType.setFont(new Font("Arial", Font.PLAIN, 16));
        cbUserType.setForeground(main_color);
        cbUserType.setBackground(sub_color);
        cbUserType.setSize(190, 20);
        cbUserType.setLocation(220, 300);
        cMainContainer.add(cbUserType);

        cbTOS = new JCheckBox("Accept Terms And Conditions.");
        cbTOS.setFont(new Font("Arial", Font.PLAIN, 15));
        cbTOS.setForeground(main_color);
        cbTOS.setBackground(sub_color);
        cbTOS.setSize(250, 20);
        cbTOS.setLocation(170, 450);
        cMainContainer.add(cbTOS);

        btnAddEmployee = new JButton("Add Employee");
        btnAddEmployee.setFont(new Font("Arial", Font.PLAIN, 15));
        btnAddEmployee.setBorder(new LineBorder(main_color, 1));
        btnAddEmployee.setBackground(main_color);
        btnAddEmployee.setForeground(sub_color);
        btnAddEmployee.setSize(130, 30);
        btnAddEmployee.setLocation(150, 500);
        btnAddEmployee.addActionListener(this);
        cMainContainer.add(btnAddEmployee);

        btnResetEmployee = new JButton("Reset");
        btnResetEmployee.setFont(new Font("Arial", Font.PLAIN, 15));
        btnResetEmployee.setBorder(new LineBorder(main_color, 1));
        btnResetEmployee.setBackground(main_color);
        btnResetEmployee.setForeground(sub_color);
        btnResetEmployee.setSize(130, 30);
        btnResetEmployee.setLocation(300, 500);
        btnResetEmployee.addActionListener(this);
        cMainContainer.add(btnResetEmployee);

        txtOutput = new JTextArea();
        txtOutput.setFont(new Font("Arial", Font.PLAIN, 15));
        txtOutput.setBorder(new LineBorder(main_color, 1));
        txtOutput.setBackground(sub_color);
        txtOutput.setForeground(main_color);
        txtOutput.setSize(300, 400);
        txtOutput.setLocation(500, 100);
        txtOutput.setLineWrap(true);
        txtOutput.setEditable(false);
        cMainContainer.add(txtOutput);

        lblResults = new JLabel("");
        lblResults.setFont(new Font("Arial", Font.PLAIN, 20));
        lblResults.setSize(500, 25);
        lblResults.setLocation(100, 500);
        cMainContainer.add(lblResults);

        txtResults = new JTextArea();
        txtResults.setFont(new Font("Arial", Font.PLAIN, 15));
        txtResults.setSize(200, 75);
        txtResults.setLocation(580, 175);
        txtResults.setLineWrap(true);
        cMainContainer.add(txtResults);

        setBounds(300, 90, 900, 600);
        setTitle("CINEMA MAGIC: ADD NEW EMPLOYEE ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cMainContainer.setBackground(sub_color);
        setResizable(false);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Add Employee")) {
            if(cbTOS.isSelected()) {
                if(txtFirstName.getText().isEmpty()) {

                }
                else if(txtSurname.getText().isEmpty()) {

                }
                else if(txtPassword.getText().isEmpty()) {

                }
                else if(txtEmail.getText().isEmpty()) {

                }
                else if(txtPassword.getText().isEmpty()) {

                }
                else {
                    String name = txtFirstName.getText();
                    String lName = txtSurname.getText();
                    String email = txtEmail.getText();
                    String password = txtPassword.getText();
                    String accountType = (String)cbUserType.getSelectedItem();
                    String output = "EMPLOYEE INFORMATION: \nEmployee Name: " + name + " "+ lName + "\nEmployee Email: " + email +
                            "\nEmployee Password: " + password + "\nAccess Level: " + accountType;
                    txtOutput.setText(output);

                    EmployeeDB employeeDB = new EmployeeDB();
                    employeeDB.addEmployee(name, lName, email, password, accountType);
                }
            }
        }
        else if(e.getActionCommand().equals("Reset")){
            txtFirstName.setText("");
            txtSurname.setText("");
            txtEmail.setText("");
            cbUserType.setSelectedIndex(1);
            txtPassword.setText("");
            txtOutput.setText("");
            cbTOS.setSelected(false);
        }

    }
}
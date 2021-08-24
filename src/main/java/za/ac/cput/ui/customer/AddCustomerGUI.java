package za.ac.cput.ui.customer;

/*
    @Description:AddCustomerGUI ->
    @Author: Cole Hanekom
    @Student Number: 217267556
    @Date: 20 August 2021
*/

import za.ac.cput.ui.dashboard.admin.UIAdminDashboard;
import za.ac.cput.util.GenericHelper;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddCustomerGUI extends JFrame implements ActionListener {
    private Container panelMain;
    private JLabel lblTitle, lblName, lblSurname, lblCustomerID, lblContactNumber, lblAccountNumber, lblResults,lblEmail,logo;
    private JTextField txtName, txtSurname, txtCustomerID, txtContactNumber, txtAccountNumber,txtEmail;
    private JTextArea txtOutput, txtResults;
    private JMenuBar mainMenu;
    private JButton btnAddCustomer, btnResetCustomer;
    private JLabel  lblCurrentUser;
    private JButton btnLogOut;
    private ImageIcon iconLogo;
    private Color main_color, sub_color, text_color,navColor;

    public AddCustomerGUI() {
       super("CINEMA MAGIC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Color navColor = new Color(186,39,94);
        Color headingText = new Color(230, 196, 96);
        Color textColor = Color.WHITE;


        mainMenu = new JMenuBar();
        mainMenu.setOpaque(true);
        mainMenu.setBackground(navColor);
        mainMenu.setPreferredSize(new Dimension(1000, 100));

        iconLogo = new ImageIcon("images/logo_white.png");
        lblTitle = new JLabel();
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setIcon(iconLogo);
        lblTitle.setSize(300, 60);

        mainMenu.add(lblTitle);

        mainMenu.add(Box.createHorizontalGlue());


        String userInfo = GenericHelper.getUserName();
        lblCurrentUser = new JLabel("Welcome, " + userInfo , SwingConstants.RIGHT);
        lblCurrentUser.setForeground(Color.WHITE);

        mainMenu.add(lblCurrentUser);
        btnLogOut = new JButton("Log Out ▼");
        btnLogOut.setBackground(navColor);
        btnLogOut.setForeground(Color.WHITE);
        btnLogOut.addActionListener(this);
        btnLogOut.setPreferredSize(new Dimension(100,50));
        mainMenu.add(btnLogOut);


        JPanel panelMain = new JPanel(new GridLayout(7, 0));
        panelMain.setSize(new Dimension(1000, 200));
       panelMain.setBorder(new EmptyBorder(10, 10, 10, 10));
        panelMain.setBackground(Color.WHITE);

        JPanel panelCenter = new JPanel();

        lblName = new JLabel("Name");
        lblName.setFont(new Font("Arial", Font.PLAIN, 15));
        lblName.setForeground(main_color);
        lblName.setSize(100, 20);
        lblName.setLocation(100, 100);
        //cMainContainer.add(lblName);
        panelMain.add(lblName);

        txtName = new JTextField();
        txtName.setFont(new Font("Arial", Font.PLAIN, 15));
        txtName.setBorder(new LineBorder(main_color, 1));
        txtName.setBackground(sub_color);
        txtName.setForeground(main_color);
        txtName.setSize(190, 20);
        txtName.setLocation(220, 100);
       // cMainContainer.add(txtName);
        panelMain.add(txtName);

        lblSurname = new JLabel("Surname");
        lblSurname.setFont(new Font("Arial", Font.PLAIN, 15));
        lblSurname.setForeground(main_color);
        lblSurname.setSize(100, 20);
        lblSurname.setLocation(100, 150);
        panelMain.add(lblSurname);

        txtSurname = new JTextField();
        txtSurname.setFont(new Font("Arial", Font.PLAIN, 15));
        txtSurname.setBorder(new LineBorder(main_color, 1));
        txtSurname.setBackground(sub_color);
        txtSurname.setForeground(main_color);
        txtSurname.setSize(190, 20);
        txtSurname.setLocation(220, 150);
        panelMain.add(txtSurname);

        lblAccountNumber = new JLabel("Account Number");
        lblAccountNumber.setFont(new Font("Arial", Font.PLAIN, 15));
        lblAccountNumber.setForeground(main_color);
        lblAccountNumber.setSize(100, 20);
        lblAccountNumber.setLocation(100, 200);
        panelMain.add(lblAccountNumber);

        txtAccountNumber = new JTextField();
        txtAccountNumber.setFont(new Font("Arial", Font.PLAIN, 15));
        txtAccountNumber.setBorder(new LineBorder(main_color, 1));
        txtAccountNumber.setForeground(main_color);
        txtAccountNumber.setBackground(sub_color);
        txtAccountNumber.setSize(190, 20);
        txtAccountNumber.setLocation(220, 200);
        panelMain.add(txtAccountNumber);

        lblCustomerID = new JLabel("Customer ID");
        lblCustomerID.setFont(new Font("Arial", Font.PLAIN, 15));
        lblCustomerID.setForeground(main_color);
        lblCustomerID.setSize(100, 20);
        lblCustomerID.setLocation(100, 250);
        panelMain.add(lblCustomerID);

        txtCustomerID = new JTextField();
        txtCustomerID.setFont(new Font("Arial", Font.PLAIN, 15));
        txtCustomerID.setBorder(new LineBorder(main_color, 1));
        txtCustomerID.setForeground(main_color);
        txtCustomerID.setBackground(sub_color);
        txtCustomerID.setSize(190, 20);
        txtCustomerID.setLocation(220, 250);
        panelMain.add(txtCustomerID);

        lblContactNumber = new JLabel("Contact Number");
        lblContactNumber.setFont(new Font("Arial", Font.PLAIN, 15));
        lblContactNumber.setForeground(main_color);
        lblContactNumber.setSize(100, 20);
        lblContactNumber.setLocation(100, 300);
        panelMain.add(lblContactNumber);

        txtContactNumber = new JTextField();
        txtContactNumber.setFont(new Font("Arial", Font.PLAIN, 15));
        txtContactNumber.setBorder(new LineBorder(main_color, 1));
        txtContactNumber.setForeground(main_color);
        txtContactNumber.setBackground(sub_color);
        txtContactNumber.setSize(190, 20);
        txtContactNumber.setLocation(220, 300);
        panelMain.add( txtContactNumber);

        lblEmail = new JLabel("Email");
        lblEmail.setFont(new Font("Arial", Font.PLAIN, 15));
        lblEmail.setForeground(main_color);
        lblEmail.setSize(100, 20);
        lblEmail.setLocation(100, 350);
        panelMain.add(lblEmail);

        txtEmail = new JTextField();
        txtEmail.setFont(new Font("Arial", Font.PLAIN, 15));
        txtEmail.setBorder(new LineBorder(main_color, 1));
        txtEmail.setForeground(main_color);
        txtEmail.setBackground(sub_color);
        txtEmail.setSize(190, 20);
        txtEmail.setLocation(220, 350);
        panelMain.add( txtEmail);

        btnAddCustomer = new JButton("Add Customer");
        btnAddCustomer.setFont(new Font("Arial", Font.PLAIN, 15));
        btnAddCustomer.setBorder(new LineBorder(navColor, 1));
        btnAddCustomer.setBackground(navColor);
        btnAddCustomer.setForeground(Color.white);
        btnAddCustomer.setSize(130, 30);
        btnAddCustomer.setLocation(150, 500);
        btnAddCustomer.addActionListener(this);
        panelMain.add(btnAddCustomer);

        btnResetCustomer = new JButton("Reset");
        btnResetCustomer.setFont(new Font("Arial", Font.PLAIN, 15));
        btnResetCustomer.setBorder(new LineBorder(navColor, 1));
        btnResetCustomer.setBackground(navColor);
       btnResetCustomer.setForeground(Color.WHITE);
        btnResetCustomer.setSize(130, 30);
        btnResetCustomer.setLocation(300, 500);
        btnResetCustomer.addActionListener(this);
        panelMain.add(btnResetCustomer);

        txtOutput = new JTextArea();
        txtOutput.setFont(new Font("Arial", Font.PLAIN, 15));
        txtOutput.setBorder(new LineBorder(main_color, 1));
        txtOutput.setBackground(sub_color);
        txtOutput.setForeground(main_color);
        txtOutput.setSize(300, 400);
        txtOutput.setLocation(500, 100);
        txtOutput.setLineWrap(true);
        txtOutput.setEditable(false);
        panelCenter.add(txtOutput);

//        lblResults = new JLabel("");
//        lblResults.setFont(new Font("Arial", Font.PLAIN, 20));
//        lblResults.setSize(500, 25);
//        lblResults.setLocation(100, 500);
//        panelMain.add(lblResults);
//
//        txtResults = new JTextArea();
//        txtResults.setFont(new Font("Arial", Font.PLAIN, 15));
//        txtResults.setSize(200, 75);
//        txtResults.setLocation(580, 175);
//        txtResults.setLineWrap(true);
//        panelCenter.add(txtResults);

        setJMenuBar(mainMenu);
         getContentPane().add(panelMain, BorderLayout.NORTH);
        getContentPane().add(panelCenter, BorderLayout.CENTER);

//        setSize(1000, 700);
//        pack();
//        setVisible(true);
        setBounds(300, 100, 900, 620);
        setTitle("CINEMA MAGIC: ADD NEW CUSTOMER ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //cMainContainer.setBackground(sub_color);
        panelMain.setBackground(sub_color);
        setResizable(false);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Add Customer")) {
                if(txtName.getText().isEmpty()) {

                }
                else if(txtSurname.getText().isEmpty()) {

                }
                else if(txtContactNumber.getText().isEmpty()) {

                }
                else if(txtCustomerID.getText().isEmpty()) {

                }
                else if(txtContactNumber.getText().isEmpty()) {

                }
                else if(txtEmail.getText().isEmpty()) {

                }
                else {
                    String name = txtName.getText();
                    String lName = txtSurname.getText();
                    String accountNumber = txtContactNumber.getText();
                    String customerID = txtCustomerID.getText();
                    String contactNumber = txtContactNumber.getText();
                    String email = txtEmail.getText();

                    String output = "CUSTOMER INFORMATION: \nCustomer Name: " + name + " "+ lName +"\nAccount Number: " + accountNumber+ "\nCustomer ID:"+ customerID  +
                            "\nContact Number: " + contactNumber+ "\nEmail: "+email;
                    txtOutput.setText(output);
                    txtName.setText("");
                    txtSurname.setText("");
                    txtAccountNumber.setText("");
                    txtCustomerID.setText("");
                    txtContactNumber.setText("");
                    txtEmail.setText("");
                }

        }
        else if(e.getActionCommand().equals("Reset")){
            txtName.setText("");
            txtSurname.setText("");
            txtCustomerID.setText("");
            txtContactNumber.setText("");
            txtEmail.setText("");
            txtOutput.setText("");
        }

    }
}
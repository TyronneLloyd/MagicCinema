package za.ac.cput.ui.admin;

import za.ac.cput.entity.Employee;
import za.ac.cput.factory.EmployeeFactory;
/*  @Subject: Project 3
    @Description: Employees Entity -> Employee.java
    @Author: Tyronne Lloyd Hendricks
    @Student Number: 215141210
    @Date: August 2021
  */
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class location extends JFrame implements ActionListener {
    private JLabel lblTitle;
    private JTextField txtFName, txtLName, txtEmail, txtPassword;
    private JComboBox cbAccountType;

    public location(int x, int y) {
        super("❣ Storage Location Add Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocation(x, y);


        //North Panel
        JPanel panelMain = new JPanel(new GridLayout(1, 0));
        panelMain.setSize(new Dimension(300, 60));
        panelMain.setBorder(new EmptyBorder(10, 10, 10, 10));
        panelMain.setBackground(Color.WHITE);

        lblTitle = new JLabel("ADD A NEW LOCATION", SwingConstants.LEFT);
        lblTitle.setForeground(Color.DARK_GRAY);
        lblTitle.setFont(new Font("Courier", Font.BOLD,16));
        lblTitle.setPreferredSize(new Dimension(300, 50));
        lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
        lblTitle.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.DARK_GRAY));

        panelMain.add(lblTitle);

        //Center Panel
        JPanel panelCenter = new JPanel(null);
        panelCenter.setPreferredSize(new Dimension(340, 150));
        panelCenter.setBackground(Color.WHITE);


        JLabel fName = new JLabel("ID:");
        fName.setBounds(10, 10, 80, 25);
        panelCenter.add(fName);
        txtFName = new JTextField();
        txtFName.setBounds(100, 10, 160, 25);
        panelCenter.add(txtFName);

        JLabel lName = new JLabel("Name:");
        lName.setBounds(10, 50, 80, 25);
        panelCenter.add(lName);
        txtLName = new JTextField();
        txtLName.setBounds(100, 50, 160, 25);
        panelCenter.add(txtLName);

        JButton btnSave = new JButton("SAVE");
        btnSave.addActionListener(this);
        btnSave.setBackground(Color.WHITE);
        btnSave.setBounds(50, 120, 80, 25);
        panelCenter.add(btnSave);

        JButton btnCancel = new JButton("CANCEL");
        btnCancel.addActionListener(this);
        btnCancel.setBackground(Color.WHITE);
        btnCancel.setBounds(150, 120, 80, 25);
        panelCenter.add(btnCancel);

        getContentPane().add(panelMain, BorderLayout.NORTH);
        getContentPane().add(panelCenter, BorderLayout.CENTER);

        //Display the window.
        setUndecorated(true);
        setSize(300, 700);
        pack();
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("SAVE")) {
            System.out.println("Adding information");
            String fName = txtFName.getText();
            String lName = txtLName.getText();
            String email = txtEmail.getText();
            int password = Integer.parseInt(txtPassword.getText());
            String accountType = String.valueOf(cbAccountType.getSelectedItem());

            //Create a new object
            Employee employee = EmployeeFactory.createEmployee(
                    fName,
                    lName,
                    email,
                    password,
                    accountType,
                    null);
            System.out.println(employee);
        }
        else if (e.getActionCommand().equals("CANCEL")) {
            dispose();
        }

    }
}

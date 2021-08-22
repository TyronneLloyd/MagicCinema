package za.ac.cput.ui.employee.employeeActions;

//import za.ac.cput.repository.employee.IEmployeeRepository;
import za.ac.cput.entity.Employee;
import za.ac.cput.factory.EmployeeFactory;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIEmployeeAdd extends JFrame implements ActionListener {
    private JLabel lblTitle;
    private JTextField txtFName, txtLName, txtEmail, txtPassword;
    private JComboBox cbAccountType;

    public UIEmployeeAdd(int x, int y) {
        super("❣ Employee Add Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLocation(x, y);

        //Title
        //North Panel
        JPanel panelMain = new JPanel(new GridLayout(1, 0));
        panelMain.setSize(new Dimension(500, 60));
        panelMain.setBorder(new EmptyBorder(10, 10, 10, 10));
        panelMain.setBackground(Color.WHITE);

        lblTitle = new JLabel("ADD NEW EMPLOYEES", SwingConstants.LEFT);
        lblTitle.setForeground(Color.DARK_GRAY);
        lblTitle.setFont(new Font("Courier", Font.BOLD,16));
        lblTitle.setPreferredSize(new Dimension(500, 50));
        lblTitle.setHorizontalAlignment(SwingConstants.LEFT);
        lblTitle.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.DARK_GRAY));

        panelMain.add(lblTitle);

        //Center Panel
        JPanel panelCenter = new JPanel(null);
        panelCenter.setPreferredSize(new Dimension(540, 150));
        panelCenter.setBackground(Color.WHITE);


        JLabel fName = new JLabel("First Name:");
        fName.setBounds(10, 10, 80, 25);
        panelCenter.add(fName);
        txtFName = new JTextField();
        txtFName.setBounds(100, 10, 160, 25);
        panelCenter.add(txtFName);

        JLabel lName = new JLabel("Surname:");
        lName.setBounds(280, 10, 80, 25);
        panelCenter.add(lName);
        txtLName = new JTextField();
        txtLName.setBounds(370, 10, 160, 25);
        panelCenter.add(txtLName);

        JLabel email = new JLabel("Email:");
        email.setBounds(10, 40, 80, 25);
        panelCenter.add(email);
        txtEmail = new JTextField();
        txtEmail.setBounds(100, 40, 430, 25);
        panelCenter.add(txtEmail);


        JLabel password = new JLabel("Password:");
        password.setBounds(10, 80, 80, 25);
        panelCenter.add(password);
        txtPassword = new JTextField();
        txtPassword.setBounds(100, 80, 160, 25);
        panelCenter.add(txtPassword);


        JLabel accountType = new JLabel("Account Type:");
        accountType.setBounds(280, 80, 80, 25);
        panelCenter.add(accountType);

        String[] accountTypes = { "Sales Person", "Administrator"};
        cbAccountType = new JComboBox(accountTypes);
        cbAccountType.setBounds(370, 80, 160, 25);
        panelCenter.add(cbAccountType);

        JButton btnSave = new JButton("SAVE");
        btnSave.addActionListener(this);
        btnSave.setBackground(Color.GREEN);
        btnSave.setBounds(200, 120, 80, 25);
        panelCenter.add(btnSave);

        JButton btnCancel = new JButton("CANCEL");
        btnCancel.addActionListener(this);
        btnCancel.setBackground(Color.BLACK);
        btnCancel.setBounds(290, 120, 80, 25);
        panelCenter.add(btnCancel);

        getContentPane().add(panelMain, BorderLayout.NORTH);
        getContentPane().add(panelCenter, BorderLayout.CENTER);

        //Display the window.
        setUndecorated(true);
        setSize(500, 700);
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

            //Call function to update
           /* new IEmployeeRepository.EmployeeRepository().add(employee);

            UIEmployee.refresh();
            dispose();*/
            //Close this window

        }
        else if (e.getActionCommand().equals("CANCEL")) {
            dispose();
        }

    }
}

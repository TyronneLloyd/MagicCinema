package za.ac.cput.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeAdminGUI extends JFrame implements ActionListener {
    private JPanel panelNorth, panelCenter, panelSouth;
    private JLabel lblHeading;
    private JButton btnAddEmployee, btnRemoveEmployee, btnBookItem, btnReturnItem, btnAddCustomer, btnRemoveCustomer ,btnAddProduct, btnRemoveProduct, btnLogout;
    private ImageIcon iconLogo, iconBookItem, iconReturnItem, iconAddCustomer, iconAddProduct, iconRemoveProduct, iconAddEmployee;
    private Color main_color, sub_color, text_color;

    public HomeAdminGUI() {
        super("Home Menu");

        // Color

        main_color = new Color(153,198,47);
        sub_color = new Color(20,24,27);
        text_color = new Color(169,169,169);

        // Image

        iconLogo = new ImageIcon("images/logo.png");
        lblHeading = new JLabel();
        lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
        lblHeading.setIcon(iconLogo);

        iconBookItem = new ImageIcon("images/bookItem.png");
        iconReturnItem = new ImageIcon("images/returnItem.png");
        iconAddCustomer = new ImageIcon("images/addCustomer.png");
        iconAddProduct = new ImageIcon("images/addProduct.png");
        iconRemoveProduct = new ImageIcon("images/removeProduct.png");
        iconAddEmployee = new ImageIcon("images/addEmployee.png");

        //Buttons

        btnAddEmployee = new JButton("Add new Employee");
        btnAddEmployee.setHorizontalTextPosition(SwingConstants.RIGHT);
        btnAddEmployee.setBackground(sub_color);
        btnAddEmployee.setForeground(Color.WHITE);
        btnAddEmployee.setBorder(BorderFactory.createLineBorder(main_color));

        btnRemoveEmployee = new JButton("Remove Employee");
        btnRemoveEmployee.setHorizontalTextPosition(SwingConstants.RIGHT);
        btnRemoveEmployee.setBackground(sub_color);
        btnRemoveEmployee.setForeground(Color.WHITE);
        btnRemoveEmployee.setBorder(BorderFactory.createLineBorder(main_color));

        btnRemoveCustomer = new JButton("Remove Customer");
        btnRemoveCustomer.setHorizontalTextPosition(SwingConstants.RIGHT);
        btnRemoveCustomer.setBackground(sub_color);
        btnRemoveCustomer.setForeground(Color.WHITE);
        btnRemoveCustomer.setBorder(BorderFactory.createLineBorder(main_color));

        btnAddProduct = new JButton("Add Product");
        btnAddProduct.setHorizontalTextPosition(SwingConstants.RIGHT);
        btnAddProduct.setBackground(sub_color);
        btnAddProduct.setForeground(Color.WHITE);
        btnAddProduct.setBorder(BorderFactory.createLineBorder(main_color));

        btnRemoveProduct = new JButton("Remove Product");
        btnRemoveProduct.setHorizontalTextPosition(SwingConstants.RIGHT);
        btnRemoveProduct.setBackground(sub_color);
        btnRemoveProduct.setForeground(Color.WHITE);
        btnRemoveProduct.setBorder(BorderFactory.createLineBorder(main_color));

        btnLogout = new JButton("Logout");
        btnLogout.setBackground(sub_color);
        btnLogout.setForeground(Color.WHITE);

        //ActionListener
        btnAddEmployee.addActionListener(this);
        btnRemoveEmployee.addActionListener(this);
        btnRemoveCustomer.addActionListener(this);
        btnRemoveProduct.addActionListener(this);
        btnAddProduct.addActionListener(this);
        btnLogout.addActionListener(this);

        getRootPane().setBorder(BorderFactory.createEmptyBorder(4,4,4,4));

        //Top Panel
        panelNorth = new JPanel();
        panelNorth.setBackground(sub_color);
        panelNorth.add(lblHeading);

        //Center Panel
        panelCenter = new JPanel(new GridLayout(0, 1));
        panelCenter.setBackground(sub_color);

        JLabel employeeCategory = new JLabel("EMPLOYEE INFORMATION:");
        employeeCategory.setForeground(main_color);
        JLabel customerCategory = new JLabel("CUSTOMER INFORMATION:");
        customerCategory.setForeground(main_color);
        JLabel productCategory = new JLabel("PRODUCT INFORMATION:");
        productCategory.setForeground(main_color);

        panelCenter.add(employeeCategory);
        panelCenter.add(btnAddEmployee);
        panelCenter.add(btnRemoveEmployee);

        panelCenter.add(customerCategory);
        panelCenter.add(btnRemoveCustomer);

        panelCenter.add(productCategory);
        panelCenter.add(btnAddProduct);
        panelCenter.add(btnRemoveProduct);


        //South Panel
        panelSouth = new JPanel();
        panelSouth.setLayout(new GridLayout(1,4));
        panelSouth.setBackground(sub_color);
        panelSouth.add(new JLabel());
        panelSouth.add(new JLabel());
        panelSouth.add(new JLabel());
        panelSouth.add(btnLogout);

        //ctrMain.add(calender);
        add(panelNorth, BorderLayout.NORTH);
        add(panelCenter, BorderLayout.CENTER);
        add(panelSouth, BorderLayout.SOUTH);

        setSize(500,500);
        setBackground(sub_color);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Add new Employee")) {
            System.out.println("GO TO ADD EMPLOYEE PAGE");
            AddEmployeeGUI addEmployeeGUI = new AddEmployeeGUI();
            this.dispose();
        }
        else if(e.getActionCommand().equals("Remove Employee")) {
            System.out.println("GO TO REMOVE EMPLOYEE PAGE");
        }
        else if(e.getActionCommand().equals("Add Customer")) {
            System.out.println("GO TO ADD CUSTOMER");
            //AddCustomerGUI addCustomerGUI = new AddCustomerGUI();
            this.dispose();
        }
        else if(e.getActionCommand().equals("Add Product")) {
            System.out.println("GO TO ADD PRODUCT");
        }
        else if(e.getActionCommand().equals("Remove Product")) {
            System.out.println("GO TO REMOVE PRODUCT");
        }
        else if(e.getActionCommand().equals("Logout")) {
            LoginGUI loginGUI = new LoginGUI();
            this.dispose();

        }
    }
}


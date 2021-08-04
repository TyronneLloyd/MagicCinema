package za.ac.cput.ui.admin;

//import za.ac.cput.repository.employee.IEmployeeRepository;
import za.ac.cput.util.GenericHelper;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIAdminDashboard extends JFrame implements ActionListener {

    private JMenuBar mainMenu;
    private Container cMainContainer;
    private JPanel panelMain;
    private ImageIcon iconLogo, iconCustomer, iconAll, iconAdd, iconRemove;
    private JLabel lblTitle, lblCurrentUser, lblHeading, lblStatCustomer, lblStatEmployee, lblStatProduct;
    private JButton btnLogOut, btnCustomer, btnEmployee, btnProduct;

    public UIAdminDashboard() {
        super("❣ Admin Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Menu Bar
        mainMenu = new JMenuBar();
        mainMenu.setOpaque(true);
        mainMenu.setBackground(Color.BLACK);
        mainMenu.setPreferredSize(new Dimension(1000, 100));

        iconLogo = new ImageIcon("images/logo_white.png");
        lblTitle = new JLabel();
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lblTitle.setIcon(iconLogo);
        lblTitle.setSize(300, 60);

        mainMenu.add(lblTitle);

        mainMenu.add(Box.createHorizontalGlue());

        lblCurrentUser = new JLabel("Welcome, " + GenericHelper.getUserName() +" ", SwingConstants.RIGHT);
        lblCurrentUser.setForeground(Color.WHITE);

        mainMenu.add(lblCurrentUser);

        btnLogOut = new JButton("Log Out ▼");
        btnLogOut.setBackground(Color.BLACK);
        btnLogOut.setForeground(Color.WHITE);
        btnLogOut.addActionListener(this);
        btnLogOut.setPreferredSize(new Dimension(100,50));

        mainMenu.add(btnLogOut);

        //North Panel
        JPanel panelMain = new JPanel(new GridLayout(0, 3));
        panelMain.setSize(new Dimension(1000, 60));
        panelMain.setBorder(new EmptyBorder(10, 10, 10, 10));
        panelMain.setBackground(Color.WHITE);

        lblHeading = new JLabel("Admin Dashboard", SwingConstants.LEFT);
        lblHeading.setForeground(Color.DARK_GRAY);
        lblHeading.setFont(new Font("Courier", Font.BOLD,16));
        lblHeading.setPreferredSize(new Dimension(100, 50));
        lblHeading.setHorizontalAlignment(SwingConstants.LEFT);
        lblHeading.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.DARK_GRAY));


        //lblCurrentUser.setBorder(new LineBorder(Color.WHITE));
        panelMain.add(lblHeading);

        GridLayout layout = new GridLayout(1,3);
        JPanel panelOptions = new JPanel(layout);
        panelOptions.setSize(new Dimension(1000, 500));
        panelOptions.setBackground(Color.WHITE);

        iconCustomer = new ImageIcon("images/addCustomer.png");
        btnCustomer = new JButton("CUSTOMER MANAGEMENT", iconCustomer);
        btnCustomer.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnCustomer.setHorizontalTextPosition(SwingConstants.CENTER);
        btnCustomer.setPreferredSize(new Dimension(170, 150));
        btnCustomer.setBackground(Color.WHITE);
        btnCustomer.setForeground(Color.BLACK);
        btnCustomer.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));

        iconAll = new ImageIcon("images/view.png");
        iconAdd = new ImageIcon("images/plus.png");
        iconRemove = new ImageIcon("images/minus.png");

        //Implementation of Button
        final JPopupMenu menuCustomer = new JPopupMenu("Menu");

        JMenuItem viewAllCustomers = new JMenuItem("View All Customer Information", iconAll);
        viewAllCustomers.addActionListener(this);
        menuCustomer.add(viewAllCustomers);

        JMenuItem addNewCustomers = new JMenuItem("Add A New Customer", iconAdd);
        addNewCustomers.addActionListener(this);
        menuCustomer.add(addNewCustomers);

        JMenuItem removeCustomer = new JMenuItem("Remove a Customer", iconRemove);
        removeCustomer.addActionListener(this);
        menuCustomer.add(removeCustomer);

        btnCustomer.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                menuCustomer.show(btnCustomer, btnCustomer.getWidth()/2, btnCustomer.getHeight()/2);
            }
        } );

        btnEmployee = new JButton("EMPLOYEE MANAGEMENT", iconCustomer);
        btnEmployee.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnEmployee.setHorizontalTextPosition(SwingConstants.CENTER);
        btnEmployee.setPreferredSize(new Dimension(170, 150));
        btnEmployee.setBackground(Color.WHITE);
        btnEmployee.setForeground(Color.BLACK);
        btnEmployee.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));

        //Implementation of Button
        final JPopupMenu menuEmployee = new JPopupMenu("Menu");

        JMenuItem viewAllEmployees = new JMenuItem("View All Employee Information", iconAll);
        viewAllEmployees.addActionListener(this);
        menuEmployee.add(viewAllEmployees);

        JMenuItem addNewEmployees = new JMenuItem("Add A New Employee", iconAdd);
        addNewEmployees.addActionListener(this);
        menuEmployee.add(addNewEmployees);

        JMenuItem removeEmployee = new JMenuItem("Remove a Employee", iconRemove);
        removeEmployee.addActionListener(this);
        menuEmployee.add(removeEmployee);

        btnEmployee.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                menuEmployee.show(btnEmployee, btnEmployee.getWidth()/2, btnEmployee.getHeight()/2);
            }
        } );

        btnProduct = new JButton("PRODUCT MANAGEMENT", iconCustomer);
        btnProduct.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnProduct.setHorizontalTextPosition(SwingConstants.CENTER);
        btnProduct.setPreferredSize(new Dimension(170, 150));
        btnProduct.setBackground(Color.WHITE);
        btnProduct.setForeground(Color.BLACK);
        btnProduct.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.BLACK));

        //Implementation of Button
        final JPopupMenu menuProduct = new JPopupMenu("Menu");

        JMenuItem viewAllProducts = new JMenuItem("View All Product Information", iconAll);
        viewAllProducts.addActionListener(this);
        menuProduct.add(viewAllProducts);

        JMenuItem addNewProduct = new JMenuItem("Add A New Product", iconAdd);
        addNewProduct.addActionListener(this);
        menuProduct.add(addNewProduct);

        JMenuItem removeProduct = new JMenuItem("Remove a Product", iconRemove);
        removeProduct.addActionListener(this);
        menuProduct.add(removeProduct);

        btnProduct.addActionListener( new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                menuProduct.show(btnProduct, btnProduct.getWidth()/2, btnProduct.getHeight()/2);
            }
        } );

        panelOptions.setBorder(new EmptyBorder(10, 10, 10, 10));
        layout.setHgap(25);

        panelOptions.add(btnCustomer);
        panelOptions.add(btnEmployee);
        panelOptions.add(btnProduct);

        //South Panel
        GridLayout statsLayout = new GridLayout(3, 3);
        JPanel panelStats = new JPanel(statsLayout);
        panelStats.setSize(new Dimension(500, 60));
        panelStats.setBorder(new EmptyBorder(20, 20, 20, 20));
        panelStats.setBackground(Color.WHITE);


        lblStatCustomer = new JLabel("<html>0<br>Number of Customers</html>");
        lblStatCustomer.setIcon(iconCustomer);
        lblStatCustomer.setVerticalTextPosition(SwingConstants.CENTER);
        lblStatCustomer.setHorizontalTextPosition(SwingConstants.RIGHT);
        lblStatCustomer.setPreferredSize(new Dimension(130, 80));
        lblStatCustomer.setBackground(Color.WHITE);
        lblStatCustomer.setForeground(Color.BLACK);
        lblStatCustomer.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));

        lblStatEmployee = new JLabel("<html>" /*+ new IEmployeeRepository.EmployeeRepository().getTotalRecords() */+ "<br>Number of Employees</html>");
        lblStatEmployee.setIcon(iconCustomer);
        lblStatEmployee.setVerticalTextPosition(SwingConstants.CENTER);
        lblStatEmployee.setHorizontalTextPosition(SwingConstants.RIGHT);
        lblStatEmployee.setPreferredSize(new Dimension(170, 80));
        lblStatEmployee.setBackground(Color.WHITE);
        lblStatEmployee.setForeground(Color.BLACK);
        lblStatEmployee.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));

        lblStatProduct = new JLabel("<html>0<br>Number of Products</html>");
        lblStatProduct.setIcon(iconCustomer);
        lblStatProduct.setVerticalTextPosition(SwingConstants.CENTER);
        lblStatProduct.setHorizontalTextPosition(SwingConstants.RIGHT);
        lblStatProduct.setPreferredSize(new Dimension(170, 80));
        lblStatProduct.setBackground(Color.WHITE);
        lblStatProduct.setForeground(Color.BLACK);
        lblStatProduct.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));

        statsLayout.setVgap(15);

        panelStats.add(new JLabel(""));
        panelStats.add(lblStatCustomer);
        panelStats.add(new JLabel(""));
        panelStats.add(lblStatEmployee);
        panelStats.add(new JLabel(""));
        panelStats.add(lblStatProduct);

        setJMenuBar(mainMenu);
        getContentPane().add(panelMain, BorderLayout.NORTH);
        getContentPane().add(panelOptions, BorderLayout.CENTER);
        getContentPane().add(panelStats, BorderLayout.SOUTH);

        //Display the window.
        setSize(1000, 700);
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("View All Customer Information")) {
            System.out.println("VIEW ALL CUSTOMERS SELECTED");
        }
        else if(e.getActionCommand().equals("Add A New Customer")) {
            System.out.println("ADD A NEW CUSTOMER SELECTED");
        }
        else if(e.getActionCommand().equals("Remove a Customer")) {
            System.out.println("REMOVE A CUSTOMER");
        }
        else if(e.getActionCommand().equals("View All Employee Information")) {
            System.out.println("VIEW ALL EMPLOYEE SELECTED");
        }
        else if(e.getActionCommand().equals("Add A New Employee")) {
            System.out.println("ADD A NEW EMPLOYEE SELECTED");
        }
        else if(e.getActionCommand().equals("Remove a Employee")) {
            System.out.println("REMOVE A EMPLOYEE");
        }
        else if(e.getActionCommand().equals("View All Product Information")) {
            System.out.println("VIEW ALL PRODUCT SELECTED");
        }
        else if(e.getActionCommand().equals("Add A New Product")) {
            System.out.println("ADD A NEW PRODUCT SELECTED");
        }
        else if(e.getActionCommand().equals("Remove a Product")) {
            System.out.println("REMOVE A PRODUCT");
        }
        else if (e.getActionCommand().equals("Log Out ▼")) {
            System.out.println("Logging out...");
        }


    }
}

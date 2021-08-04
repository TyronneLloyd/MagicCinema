package za.ac.cput.ui.employee;

//import za.ac.cput.repository.employee.IEmployeeRepository;
import za.ac.cput.util.GenericHelper;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIDashboard extends JFrame implements ActionListener {
    private JMenuBar mainMenu;
    private ImageIcon iconLogo, iconCustomer, iconAll, iconAdd, iconRemove, iconBookItem, iconReturnItem, iconAddCustomer, iconAddProduct, iconRemoveProduct;
    private JButton btnBookItem, btnReturnItem, btnAddCustomer;
    private JLabel lblTitle, lblCurrentUser, lblHeading, lblStatCustomer, lblStatEmployee, lblStatProduct;

    private JButton btnLogOut, btnCustomer, btnEmployee, btnProduct;

    public UIDashboard() {
        super("❣ Dashboard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Image

        iconBookItem = new ImageIcon("images/bookItem.png");
        iconReturnItem = new ImageIcon("images/returnItem.png");
        iconAddCustomer = new ImageIcon("images/addCustomer.png");
        iconAddProduct = new ImageIcon("images/addProduct.png");
        iconRemoveProduct = new ImageIcon("images/removeProduct.png");

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

        lblHeading = new JLabel("Today's Orders ♡", SwingConstants.RIGHT);
        lblHeading.setForeground(Color.DARK_GRAY);
        lblHeading.setFont(new Font("Courier", Font.BOLD,16));
        lblHeading.setPreferredSize(new Dimension(100, 50));
        lblHeading.setHorizontalAlignment(SwingConstants.RIGHT);
        lblHeading.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.DARK_GRAY));

        panelMain.add(new JLabel());
        panelMain.add(new JLabel());
        panelMain.add(lblHeading);

        //Buttons

        btnBookItem = new JButton("Book Item", iconBookItem);
        btnBookItem.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnBookItem.setHorizontalTextPosition(SwingConstants.CENTER);
        btnBookItem.setPreferredSize(new Dimension(130, 70));
        btnBookItem.setBackground(Color.WHITE);
        btnBookItem.setForeground(Color.BLACK);
        btnBookItem.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        btnReturnItem = new JButton("Return Item", iconReturnItem);
        btnReturnItem.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnReturnItem.setHorizontalTextPosition(SwingConstants.CENTER);
        btnReturnItem.setPreferredSize(new Dimension(130, 70));
        btnReturnItem.setBackground(Color.WHITE);
        btnReturnItem.setForeground(Color.BLACK);
        btnReturnItem.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        btnAddCustomer = new JButton("Add Customer", iconAddCustomer);
        btnAddCustomer.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnAddCustomer.setHorizontalTextPosition(SwingConstants.CENTER);
        btnAddCustomer.setPreferredSize(new Dimension(130, 70));
        btnAddCustomer.setBackground(Color.WHITE);
        btnAddCustomer.setForeground(Color.BLACK);
        btnAddCustomer.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        //ActionListener
        btnBookItem.addActionListener(this);
        btnReturnItem.addActionListener(this);
        btnAddCustomer.addActionListener(this);

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

        //West Panel
        JPanel panelWest = new JPanel(new GridLayout(5, 5));
        panelWest.setBorder(new EmptyBorder(10, 10, 10, 10));
        panelWest.setSize(new Dimension(200, 800));
        panelWest.setBackground(Color.WHITE);

        panelWest.add(btnAddCustomer);
        panelWest.add(btnBookItem);
        panelWest.add(btnReturnItem);

        //Center Panel
        JPanel panelCenter = new JPanel(new GridLayout(1, 1));
        panelCenter.setBorder(new EmptyBorder(10, 10, 10, 10));
        panelCenter.setSize(new Dimension(200, 800));
        panelCenter.setBackground(Color.WHITE);

        String[][] data = {
                { "1", "Info", "Info", "Info" },
                { "2", "Info", "Info", "Info" }
        };

        String[] columnNames = { "OrderId", "Insert Text", "Insert Text", "Insert Text" };

        JTable j = new JTable(data, columnNames);
        j.getTableHeader().setBackground(Color.BLACK);
        j.getTableHeader().setForeground(Color.WHITE);

        JScrollPane sp = new JScrollPane(j);
        sp.getViewport().setBackground(Color.WHITE);

        sp.setSize(800, 600);

        panelCenter.add(sp);

        //South Panel
        GridLayout statsLayout = new GridLayout(1, 1);
        JPanel panelStats = new JPanel(statsLayout);
        panelStats.setSize(new Dimension(500, 60));
        panelStats.setBorder(new EmptyBorder(20, 20, 20, 20));
        panelStats.setBackground(Color.WHITE);


        lblStatCustomer = new JLabel("<html>0<br>Number of Insert Text</html>");
        lblStatCustomer.setIcon(iconCustomer);
        lblStatCustomer.setVerticalTextPosition(SwingConstants.CENTER);
        lblStatCustomer.setHorizontalTextPosition(SwingConstants.RIGHT);
        lblStatCustomer.setPreferredSize(new Dimension(130, 80));
        lblStatCustomer.setBackground(Color.WHITE);
        lblStatCustomer.setForeground(Color.BLACK);
        lblStatCustomer.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));

//        lblStatEmployee = new JLabel("<html>" + new IEmployeeRepository.EmployeeRepository().getTotalRecords() + "<br>Number of Insert Text</html>");
        lblStatEmployee.setIcon(iconCustomer);
        lblStatEmployee.setVerticalTextPosition(SwingConstants.CENTER);
        lblStatEmployee.setHorizontalTextPosition(SwingConstants.RIGHT);
        lblStatEmployee.setPreferredSize(new Dimension(170, 80));
        lblStatEmployee.setBackground(Color.WHITE);
        lblStatEmployee.setForeground(Color.BLACK);
        lblStatEmployee.setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.LIGHT_GRAY));


        statsLayout.setVgap(15);

        panelStats.add(new JLabel(""));
        panelStats.add(new JLabel(""));
        panelStats.add(lblStatCustomer);
        panelStats.add(lblStatEmployee);

        setJMenuBar(mainMenu);
        getContentPane().add(panelMain, BorderLayout.NORTH);
        getContentPane().add(panelCenter, BorderLayout.CENTER);
        getContentPane().add(panelWest, BorderLayout.WEST);
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

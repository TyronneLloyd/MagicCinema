package za.ac.cput.ui.employee;

import za.ac.cput.ui.UILogin;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomeGUI extends JFrame implements ActionListener {
    private JPanel panelNorth, panelCenter, panelSouth;
    private JLabel lblHeading;
    private JButton btnBookItem, btnReturnItem, btnAddCustomer, btnLogout;
    private ImageIcon iconLogo, iconBookItem, iconReturnItem, iconAddCustomer, iconAddProduct, iconRemoveProduct;
    private Color main_color, sub_color, text_color;

    public HomeGUI() {
        super("Home Menu");

        // Color

        main_color = new Color(0,0,0);
        sub_color = new Color(255, 255, 255);
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

        //Buttons

        btnBookItem = new JButton("Book Item", iconBookItem);
        btnBookItem.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnBookItem.setHorizontalTextPosition(SwingConstants.CENTER);
        btnBookItem.setPreferredSize(new Dimension(130, 70));
        btnBookItem.setBackground(sub_color);
        btnBookItem.setForeground(Color.BLACK);
        btnBookItem.setBorder(BorderFactory.createLineBorder(main_color));

        btnReturnItem = new JButton("Return Item", iconReturnItem);
        btnReturnItem.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnReturnItem.setHorizontalTextPosition(SwingConstants.CENTER);
        btnReturnItem.setPreferredSize(new Dimension(130, 70));
        btnReturnItem.setBackground(sub_color);
        btnReturnItem.setForeground(Color.BLACK);
        btnReturnItem.setBorder(BorderFactory.createLineBorder(main_color));

        btnAddCustomer = new JButton("Add Customer", iconAddCustomer);
        btnAddCustomer.setVerticalTextPosition(SwingConstants.BOTTOM);
        btnAddCustomer.setHorizontalTextPosition(SwingConstants.CENTER);
        btnAddCustomer.setPreferredSize(new Dimension(130, 70));
        btnAddCustomer.setBackground(sub_color);
        btnAddCustomer.setForeground(Color.BLACK);
        btnAddCustomer.setBorder(BorderFactory.createLineBorder(main_color));


        btnLogout = new JButton("LOGOUT");
        btnLogout.setBackground(main_color);
        btnLogout.setForeground(Color.WHITE);

        //ActionListener
        btnBookItem.addActionListener(this);
        btnReturnItem.addActionListener(this);
        btnAddCustomer.addActionListener(this);
        btnLogout.addActionListener(this);

        Container ctrMain = this.getContentPane();
        ctrMain.setLayout(new BorderLayout(8,6));
        ctrMain.setBackground(sub_color);

        getRootPane().setBorder(BorderFactory.createEmptyBorder(4,4,4,4));

        //Top Panel
        panelNorth = new JPanel();
        panelNorth.setBackground(sub_color);
        panelNorth.add(lblHeading);

        //Center Panel
        panelCenter = new JPanel();
        panelCenter.setLayout(new FlowLayout(4,4,4));
        panelCenter.setBackground(sub_color);

        JLabel customerCategory = new JLabel("CUSTOMER INFORMATION:");
        customerCategory.setForeground(main_color);
        JLabel bookCategory = new JLabel("BOOKING PROCESS:");
        bookCategory.setForeground(main_color);
        JLabel productCategory = new JLabel("PRODUCT INFORMATION:");
        productCategory.setForeground(main_color);

        JPanel panelGrid = new JPanel();
        panelGrid.setLayout(new GridLayout(9,1,5,5));
        panelGrid.setBackground(sub_color);

        panelGrid.add(customerCategory);
        panelGrid.add(btnAddCustomer);

        panelGrid.add(bookCategory);
        panelGrid.add(btnBookItem);
        panelGrid.add(btnReturnItem);



        //Calender --> Add Calender System here
        JLabel calender = new JLabel("CALENDER PLACEHOLDER", SwingConstants.CENTER);
        calender.setOpaque(true);
        panelCenter.add(panelGrid);


        //South Panel
        panelSouth = new JPanel();
        panelSouth.setLayout(new GridLayout(1,4));
        panelSouth.setBackground(sub_color);
        panelSouth.add(new JLabel());
        panelSouth.add(new JLabel());
        panelSouth.add(new JLabel());
        panelSouth.add(btnLogout);

        ctrMain.add(calender);
        ctrMain.add(panelNorth, BorderLayout.NORTH);
        ctrMain.add(panelCenter, BorderLayout.WEST);
        ctrMain.add(panelSouth, BorderLayout.SOUTH);

        setSize(1000,850);
        setBackground(sub_color);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("Book Item")) {
            System.out.println("GO TO BOOKING PAGE");
        }
        else if(e.getActionCommand().equals("Return Item")) {
            System.out.println("GO TO RETURN PAGE");
        }
        else if(e.getActionCommand().equals("Add Customer")) {
            System.out.println("GO TO ADD CUSTOMER");
            //AddCustomerGUI addCustomerGUI = new AddCustomerGUI();
            //this.dispose();
        }
        else if(e.getActionCommand().equals("LOGOUT")) {
            UILogin loginGUI = new UILogin();
            this.dispose();

        }
    }
}

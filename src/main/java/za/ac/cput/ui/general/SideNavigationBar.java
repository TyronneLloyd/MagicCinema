package za.ac.cput.ui.general;

import za.ac.cput.ui.general.VerticalMenuBar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SideNavigationBar extends JPanel implements ActionListener {
    private JButton dashboard, addNewCustomer, rentEquipment, about;
    private JLabel logo, userData;
    private ImageIcon iconLogo, iconDashboard, iconCustomer, iconRental, iconAbout, iconCurrentUser, iconLogout;
    private JButton btnLogout;
    private Color background, buttonText, addictionColor;

    public SideNavigationBar(String currentUser, String currentUserAccess, String imagePath, String activeMenu) {
        background = new Color(186,39,94);
        buttonText = Color.WHITE;
        addictionColor = new Color(166, 23, 76);

        this.userData = new JLabel("<html>" + currentUser +"<br/>" + currentUserAccess + "</html>");
        this.userData.setForeground(buttonText);
        this.userData.setFont(new Font("SansSerif Bold", Font.BOLD, 12));
        this.iconCurrentUser= new ImageIcon(new ImageIcon(imagePath).getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));

        this.userData.setIcon(iconCurrentUser);


        this.setBackground(background);

        this.iconLogo = new ImageIcon("images/logo_white.png");
        this.logo = new JLabel();
        this.logo.setIcon(this.iconLogo);
        this.logo.setBackground(background);
        this.logo.setHorizontalAlignment(SwingConstants.CENTER);
        this.iconDashboard = new ImageIcon("images/nav-bar-icons/unselected/dashboard.png");
        this.iconCustomer = new ImageIcon("images/nav-bar-icons/unselected/customer.png");
        this.iconLogout = new ImageIcon("images/nav-bar-icons/logout.png");
        this.iconRental = new ImageIcon("images/nav-bar-icons/unselected/rental.png");
        this.iconAbout = new ImageIcon("images/nav-bar-icons/unselected/about.png");

        this.dashboard = new JButton("Dashboard");
        this.dashboard.addActionListener(this);
        this.dashboard.setOpaque(false);
        this.dashboard.setContentAreaFilled(false);
        this.dashboard.setBorderPainted(false);
        this.dashboard.setFocusPainted(false);
        this.dashboard.setHorizontalAlignment(SwingConstants.LEFT);
        this.dashboard.setForeground(buttonText);
        this.dashboard.setFont(new Font("SansSerif Bold", Font.BOLD, 15));
        this.dashboard.setIcon(iconDashboard);
        this.dashboard.setIconTextGap(10);

        this.addNewCustomer = new JButton("Add New Customer");
        this.addNewCustomer.addActionListener(this);
        this.addNewCustomer.setOpaque(false);
        this.addNewCustomer.setContentAreaFilled(false);
        this.addNewCustomer.setBorderPainted(false);
        this.addNewCustomer.setFocusPainted(false);
        this.addNewCustomer.setHorizontalAlignment(SwingConstants.LEFT);
        this.addNewCustomer.setForeground(buttonText);
        this.addNewCustomer.setFont(new Font("SansSerif Bold", Font.BOLD, 15));
        this.addNewCustomer.setIcon(iconCustomer);
        this.addNewCustomer.setIconTextGap(10);

        this.rentEquipment = new JButton("Rent Equipment");
        this.rentEquipment.addActionListener(this);
        this.rentEquipment.setOpaque(false);
        this.rentEquipment.setContentAreaFilled(false);
        this.rentEquipment.setBorderPainted(false);
        this.rentEquipment.setFocusPainted(false);
        this.rentEquipment.setHorizontalAlignment(SwingConstants.LEFT);
        this.rentEquipment.setForeground(buttonText);
        this.rentEquipment.setFont(new Font("SansSerif Bold", Font.BOLD, 15));
        this.rentEquipment.setIcon(iconRental);
        this.rentEquipment.setIconTextGap(10);

        this.about = new JButton("About");
        this.about.addActionListener(this);
        this.about.setOpaque(false);
        this.about.setContentAreaFilled(false);
        this.about.setBorderPainted(false);
        this.about.setFocusPainted(false);
        this.about.setHorizontalAlignment(SwingConstants.LEFT);
        this.about.setForeground(buttonText);
        this.about.setFont(new Font("SansSerif Bold", Font.BOLD, 15));
        this.about.setIcon(iconAbout);
        this.about.setIconTextGap(10);

        this.btnLogout = new JButton();
        this.btnLogout.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                System.out.println("---> This should leave to the login page");
            }
        });
        this.btnLogout.setIcon(iconLogout);
        this.btnLogout.setBackground(addictionColor);
        this.btnLogout.setSize(50, 50);

        setActiveButton(activeMenu);
        JMenuBar menuBar = new VerticalMenuBar();
        menuBar.setBackground(background);
        menuBar.add(new JLabel());
        menuBar.add(this.logo);
        menuBar.add(new JLabel());
        menuBar.add(this.dashboard);
        menuBar.add(this.addNewCustomer);
        menuBar.add(this.rentEquipment);
        menuBar.add(this.about);
        menuBar.add(new JLabel());
        menuBar.add(new JLabel());
        menuBar.add(new JLabel());
        menuBar.add(new JLabel());

        JPanel panelSouth = new JPanel(new BorderLayout());
        panelSouth.setBackground(addictionColor);
        panelSouth.add(userData, BorderLayout.CENTER);
        panelSouth.add(btnLogout, BorderLayout.EAST);


        JPanel container = new JPanel(new BorderLayout());
        container.add(menuBar, BorderLayout.CENTER);
        container.add(panelSouth, BorderLayout.SOUTH);

        this.add(container);

        setSize(new Dimension(500, 700));



    }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getActionCommand().equals("Dashboard")) {
            System.out.println("GO TO DASHBOARD");
        }
        else if(e.getActionCommand().equals("Add New Customer")) {
            System.out.println("Add New Customer");
        }
        else if(e.getActionCommand().equals("Rent Equipment")) {
            System.out.println("Rent Equipment");
        }
        else if(e.getActionCommand().equals("About")) {
            System.out.println("GO TO ABOUT");
        }

    }

    private void setActiveButton(String activeButton) {
        if(activeButton.equals("Dashboard")) {
            dashboard.setOpaque(true);
            dashboard.setBackground(buttonText);
            dashboard.setForeground(background);
            iconDashboard = new ImageIcon("images/nav-bar-icons/selected/dashboard.png");
            dashboard.setIcon(iconDashboard);
        }
        if(activeButton.equals("Add New Customer")) {
            addNewCustomer.setOpaque(true);
            addNewCustomer.setBackground(buttonText);
            addNewCustomer.setForeground(background);
            iconCustomer = new ImageIcon("images/nav-bar-icons/selected/customer.png");
            addNewCustomer.setIcon(iconCustomer);
        }
        if(activeButton.equals("Rent Equipment")) {
            rentEquipment.setOpaque(true);
            rentEquipment.setBackground(buttonText);
            rentEquipment.setForeground(background);
            iconRental = new ImageIcon("images/nav-bar-icons/selected/rental.png");
            rentEquipment.setIcon(iconRental);
        }
        if(activeButton.equals("About")) {
            about.setOpaque(true);
            about.setBackground(buttonText);
            about.setForeground(background);
            iconAbout = new ImageIcon("images/nav-bar-icons/selected/about.png");
            about.setIcon(iconAbout);
        }
    }
}


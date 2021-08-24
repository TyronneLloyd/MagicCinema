package za.ac.cput.ui.clientaccount.admin;

/*
   @Subject: Project 3
   @Description:UIAdminClientAccount.java
   @Author: Elrich Herman
   @Student Number: 218150040
   @Date: 22 August 2021
*/

import za.ac.cput.entity.ClientAccount;
import za.ac.cput.factory.ClientAccountFactory;
import za.ac.cput.ui.login.UILogin;
import za.ac.cput.util.GenericHelper;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIAdminClientAccount extends JFrame implements ActionListener {

    private JMenuBar mainMenu, buttonMenu;
    private ImageIcon iconLogo;
    private JLabel lblTitle, lblCurrentUser, lblHeading;
    private JButton btnLogOut;
    private static JTable table;
    private static DefaultTableModel model;
    private JScrollPane pane;

    public UIAdminClientAccount() {
        super("❣ Admin Client Accounts");
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


        JPanel panelMain = new JPanel(new GridLayout(2, 0));
        panelMain.setSize(new Dimension(1000, 60));
        panelMain.setBorder(new EmptyBorder(10, 10, 10, 10));
        panelMain.setBackground(Color.WHITE);

        buttonMenu = new JMenuBar();
        buttonMenu.setOpaque(true);
        buttonMenu.setBackground(Color.WHITE);
        buttonMenu.add(Box.createHorizontalGlue());

        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(this);
        btnUpdate.setBackground(navColor);
        btnUpdate.setForeground(textColor);
        JButton btnAdd = new JButton("Add");
        btnAdd.setBackground(navColor);
        btnAdd.setForeground(textColor);
        btnAdd.addActionListener(this);
        JButton btnDelete = new JButton("Delete");
        btnDelete.setBackground(navColor);
        btnDelete.setForeground(textColor);
        btnDelete.addActionListener(this);
        JButton btnReload = new JButton("Reload");
        btnReload.setBackground(navColor);
        btnReload.setForeground(textColor);

        buttonMenu.add(btnUpdate);
        buttonMenu.add(btnAdd);
        buttonMenu.add(btnDelete);
        buttonMenu.add(btnReload);

        lblHeading = new JLabel("Admin Client Account", SwingConstants.LEFT);
        lblHeading.setForeground(navColor);
        lblHeading.setFont(new Font("Courier", Font.BOLD,16));
        lblHeading.setPreferredSize(new Dimension(100, 50));
        lblHeading.setHorizontalAlignment(SwingConstants.LEFT);
        lblHeading.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.DARK_GRAY));

        panelMain.add(lblHeading);
        panelMain.add(buttonMenu);


        JPanel panelCenter = new JPanel();
        table = new JTable();
        model = new DefaultTableModel();
        Object[] columnName = new Object[6];
        columnName[0] = "Client ID";
        columnName[1] = "Client Name";
        columnName[2] = "Client Surname";
        columnName[3] = "Client Account Number";
        columnName[4] = "Contact Number";
        columnName[5] = "Number of items borrowed";
        model.setColumnIdentifiers(columnName);
        table.setModel(model);
        table.getTableHeader().setOpaque(false);
        table.getTableHeader().setBackground(navColor);
        table.getTableHeader().setForeground(Color.WHITE);
        pane = new JScrollPane(table);
        pane.setPreferredSize(new Dimension(1000, 400));
        panelCenter.add(pane);
        setJMenuBar(mainMenu);
        getContentPane().add(panelMain, BorderLayout.NORTH);
        getContentPane().add(panelCenter, BorderLayout.CENTER);

        setSize(1000, 700);
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

//
//        }
//        else if (e.getActionCommand().equals("CANCEL")) {
//            dispose();
//        }
//        else if (e.getActionCommand().equals("Log Out ▼")){
//            new UILogin();
//            dispose();
//        }
    }
}


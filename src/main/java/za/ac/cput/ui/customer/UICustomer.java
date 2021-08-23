package za.ac.cput.ui.customer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.table.DefaultTableModel;

public class UICustomer extends JFrame implements ActionListener {
    private JMenuBar mainMenu, buttonMenu;
    private ImageIcon iconLogo;
    private JLabel lblTitle, lblCurrentUser, lblHeading;
    private JButton btnLogOut;
    private static JTable table;
    private static DefaultTableModel model;
    private JScrollPane pane;

    public UICustomer() {
        super("❣ Customer Management");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Color navColor = new Color(186,39,94);

        //Menu Bar
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


        lblCurrentUser = new JLabel("Welcome, " , SwingConstants.RIGHT);
        lblCurrentUser.setForeground(Color.WHITE);

        mainMenu.add(lblCurrentUser);

        btnLogOut = new JButton("Log Out ▼");
        btnLogOut.setBackground(navColor);
        btnLogOut.setForeground(Color.WHITE);
        btnLogOut.addActionListener(this);
        btnLogOut.setPreferredSize(new Dimension(100,50));

        mainMenu.add(btnLogOut);

        //North Panel
        JPanel panelMain = new JPanel(new GridLayout(2, 0));
        panelMain.setSize(new Dimension(1000, 60));
        panelMain.setBorder(new EmptyBorder(10, 10, 10, 10));
        panelMain.setBackground(Color.WHITE);

        buttonMenu = new JMenuBar();
        buttonMenu.setOpaque(true);
        buttonMenu.setBackground(navColor);

        buttonMenu.add(Box.createHorizontalGlue());

        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(this);
        btnUpdate.setBackground(navColor);
        JButton btnAdd = new JButton("Add");
        btnAdd.setBackground(navColor);
        btnAdd.addActionListener(this);
        JButton btnDelete = new JButton("Delete");
        btnDelete.setBackground(navColor);
        btnDelete.addActionListener(this);
        JButton btnReload = new JButton("Reload");
        btnReload.setBackground(navColor);

        buttonMenu.add(btnUpdate);
        buttonMenu.add(btnAdd);
        buttonMenu.add(btnDelete);
        buttonMenu.add(btnReload);

        lblHeading = new JLabel("Customers Rented Equipment", SwingConstants.LEFT);
        lblHeading.setForeground(navColor);
        lblHeading.setFont(new Font("Courier", Font.BOLD,16));
        lblHeading.setPreferredSize(new Dimension(100, 50));
        lblHeading.setHorizontalAlignment(SwingConstants.LEFT);
        lblHeading.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.DARK_GRAY));

        panelMain.add(lblHeading);
        panelMain.add(buttonMenu);

        //Center Panel
        JPanel panelCenter = new JPanel();
        table = new JTable();
        model = new DefaultTableModel();

        Object[] columnsName = new Object[6];

        columnsName[0] = "First Name";
        columnsName[1] = "Last Name";
        columnsName[2] = "Email";
        columnsName[3] = "Password";
        columnsName[4] = "Access Level";
        columnsName[5] = "Date Created";

        model.setColumnIdentifiers(columnsName);

        Object[] rowData = new Object[6];


        table.setModel(model);
        table.getTableHeader().setOpaque(false);
        table.getTableHeader().setBackground(navColor);
        table.getTableHeader().setForeground(Color.white);

        pane = new JScrollPane(table);
        pane.setPreferredSize(new Dimension(1000, 400));

        panelCenter.add(pane);

        setJMenuBar(mainMenu);
        getContentPane().add(panelMain, BorderLayout.NORTH);
        getContentPane().add(panelCenter, BorderLayout.CENTER);

        //Display the window.
        setSize(1000, 700);
        pack();
        setVisible(true);

    }



    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Update")) {
            System.out.println("Updating information");
            int x = this.getSize().width / 2;
            int y = this.getSize().height / 2;


            int index = table.getSelectedRow();

            if (index == -1) {
                JOptionPane.showMessageDialog(null, "Select a Customer first.", "Alert", JOptionPane.WARNING_MESSAGE);
            } else {
                int n = JOptionPane.showConfirmDialog(
                        null,
                        "Are you sure you want to delete this record?",
                        "",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);
            }
        }
        else
   if(e.getActionCommand().equals("Add"))
      {
          new UICustomerAdd().addComponentsToContainer();
      }

        else if (e.getActionCommand().equals("CANCEL")) {
            dispose();
        }

    }


}

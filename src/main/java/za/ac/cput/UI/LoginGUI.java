package za.ac.cput.UI;

import za.ac.cput.Database.LoginVerificationDB;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame implements ActionListener {
    private JPanel panelNorth, panelCenter;
    private JLabel lblHeading, lblUserID, lblEmail, lblPassword, lblAccountType;
    private JTextField txtUsername, txtEmail;
    private JPasswordField txtPassword;
    private ImageIcon iconLogo;
    private JComboBox cbEmployeeType;
    private JButton btnSubmit;
    private Color main_color, sub_color, text_color;
    private String[] employeeType = {"Sales Person", "Administrator"};

    public LoginGUI() {
        super("CINEMA MAGIC");


        // Color

        main_color = new Color(153,198,47);
        sub_color = new Color(20,24,27);
        text_color = new Color(169,169,169);

        // Image

        iconLogo = new ImageIcon("images/logo.png");
        lblHeading = new JLabel();
        lblHeading.setHorizontalAlignment(SwingConstants.CENTER);
        lblHeading.setIcon(iconLogo);

        // User Label
        lblUserID = new JLabel();
        lblUserID.setHorizontalAlignment(SwingConstants.CENTER);
        lblUserID.setText("UsernameID");
        lblUserID.setForeground(main_color);
        txtUsername = new JTextField();
        txtUsername.setBackground(sub_color);
        txtUsername.setForeground(text_color);
        txtUsername.setBorder(new LineBorder(main_color, 1));

        // Email Label

        lblEmail = new JLabel();
        lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
        lblEmail.setText("Email");
        lblEmail.setForeground(main_color);
        txtEmail = new JTextField();
        txtEmail.setBackground(sub_color);
        txtEmail.setForeground(text_color);
        txtEmail.setBorder(new LineBorder(main_color, 1));

        // Password

        lblPassword = new JLabel();
        lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
        lblPassword.setText("Password");
        lblPassword.setForeground(main_color);
        txtPassword = new JPasswordField();
        txtPassword.setBackground(sub_color);
        txtPassword.setForeground(text_color);
        txtPassword.setBorder(new LineBorder(main_color, 1));

        //Account Type
        lblAccountType = new JLabel();
        lblAccountType.setHorizontalAlignment(SwingConstants.CENTER);
        lblAccountType.setText("Account Type");
        lblAccountType.setForeground(main_color);
        cbEmployeeType = new JComboBox(employeeType);
        cbEmployeeType.addActionListener(this);
        cbEmployeeType.setBackground(sub_color);
        cbEmployeeType.setForeground(text_color);
        cbEmployeeType.setBorder(new LineBorder(main_color, 1));

        // Submit

        btnSubmit = new JButton("SIGN IN");
        btnSubmit.setBorder(new LineBorder(main_color, 1));
        btnSubmit.setBackground(main_color);
        btnSubmit.setForeground(sub_color);
        btnSubmit.addActionListener(this);

        //North Panel

        panelNorth = new JPanel(new GridLayout(0, 1));
        panelNorth.setBorder(BorderFactory.createEmptyBorder(0, 90, 0, 90));
        panelNorth.setBackground(sub_color);

        panelNorth.add(lblHeading);

        //Center Panel

        panelCenter = new JPanel(new GridLayout(0, 1));
        panelCenter.setBorder(BorderFactory.createEmptyBorder(0, 90, 90, 90));
        panelCenter.setBackground(sub_color);

        panelCenter.add(lblUserID);
        panelCenter.add(txtUsername);
        panelCenter.add(lblEmail);
        panelCenter.add(txtEmail);
        panelCenter.add(lblPassword);
        panelCenter.add(txtPassword);
        panelCenter.add(lblAccountType);
        panelCenter.add(cbEmployeeType);
        panelCenter.add(new JLabel());
        panelCenter.add(btnSubmit);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(2, 1));
        add(panelNorth, BorderLayout.NORTH);
        add(panelCenter, BorderLayout.CENTER);
        setTitle("CINEMA MAGIC: SIGN IN ");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBackground(sub_color);
        setSize(500, 700);
        setResizable(false);
        setVisible(true);

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("SIGN IN")){
            //System.out.println("SIGNING IN");
            if(txtUsername.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Please enter a username.",
                        "CINEMA MAGIC: warning",
                        JOptionPane.WARNING_MESSAGE);
            }
            else if(txtEmail.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Please enter a email.",
                        "CINEMA MAGIC: warning",
                        JOptionPane.WARNING_MESSAGE);
            }
            else if(txtPassword.getPassword().length == 0) {
                JOptionPane.showMessageDialog(this,
                        "Please enter a valid password.",
                        "CINEMA MAGIC: warning",
                        JOptionPane.WARNING_MESSAGE);
            }
            else {
                //Notification
                JOptionPane.showMessageDialog(this,
                        "Verifying information...",
                        "CINEMA MAGIC",
                        JOptionPane.PLAIN_MESSAGE);

                String username = txtUsername.getText();
                String email = txtEmail.getText();
                String password = new String(txtPassword.getPassword());
                String accountType = (String)cbEmployeeType.getSelectedItem();

                LoginVerificationDB loginDB = new LoginVerificationDB();
                System.out.println(accountType);
                boolean result = loginDB.verifyUser(username, email, password, accountType);

                if(!result) {
                    JOptionPane.showMessageDialog(this,
                            "Validation Failed.",
                            "CINEMA MAGIC: warning",
                            JOptionPane.WARNING_MESSAGE);
                    txtUsername.setText("");
                    txtEmail.setText("");
                    txtPassword.setText("");
                }
                else {
                    if(cbEmployeeType.getSelectedItem() == "Administrator") {
                        HomeAdminGUI homeAdminGUI = new HomeAdminGUI();
                        this.dispose();
                    }
                    else {
                        HomeGUI homeGUI = new HomeGUI();
                        this.dispose();
                    }


                }
            }
        }
    }
}
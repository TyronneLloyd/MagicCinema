package za.ac.cput.ui.customer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;

public class UICustomerUpdate extends JFrame implements ActionListener {
    private JPanel panelSouth;
    private JPanel panelCenter;
    private JPanel  panelNorth;

    private JLabel lblHeader;
    private JLabel lblEmployeeID;
    private JTextField txtEmployeeID;
    private JLabel lblFirstName;
    private  JTextField txtFirstName;
    private JLabel lblLastName;
    private JTextField txtLastName;
    private  JLabel lblPhoneNumber;
    private JTextField txtPhoneNumber;
    private JLabel lblEmail;
    private JTextField txtEmail;
    private JLabel lblAddress;
    private JTextField txtAddress;
    private JButton btnUpdate,btnCancel;
    private Font font1,font2;

    public UICustomerUpdate(){
        super("Customer Management System");

        panelCenter = new JPanel();
        panelSouth = new JPanel();
        panelNorth = new JPanel();

        lblHeader = new JLabel("Update cu");

        lblEmployeeID = new JLabel("Employee ID: ",SwingConstants.RIGHT);
        txtEmployeeID = new JTextField();

        lblFirstName = new JLabel("First Name: ",SwingConstants.RIGHT);
        txtFirstName = new JTextField();

        lblLastName = new JLabel("Last Name: ",SwingConstants.RIGHT);
        txtLastName = new JTextField();

        lblPhoneNumber = new JLabel("Phone Number: ",SwingConstants.RIGHT);
        txtPhoneNumber = new JTextField();

        lblEmail = new JLabel("Email: ",SwingConstants.RIGHT);
        txtEmail = new JTextField();

        lblAddress = new JLabel("Address: ",SwingConstants.RIGHT);
        txtAddress = new JTextField();

        btnUpdate = new JButton("Update");
        btnCancel = new JButton("Cancel");

        font1 = new Font("Ariel",Font.PLAIN,20);
        font2 = new Font("Ariel",Font.PLAIN,15);
    }

    public void setGUI(){
        panelCenter.setLayout(new GridLayout(8,2));
        panelSouth.setLayout(new GridLayout(1,2));

        lblHeader.setFont(font1);
        panelNorth.add(lblHeader);


        lblEmployeeID.setFont(font2);
        txtEmployeeID.setFont(font2);
        panelCenter.add(lblEmployeeID);
        panelCenter.add(txtEmployeeID);

        lblFirstName.setFont(font2);
        txtFirstName.setFont(font2);
        panelCenter.add(lblFirstName);
        panelCenter.add(txtFirstName);

        lblLastName.setFont(font2);
        txtLastName.setFont(font2);
        panelCenter.add(lblLastName);
        panelCenter.add(txtLastName);

        lblPhoneNumber.setFont(font2);
        txtPhoneNumber.setFont(font2);
        panelCenter.add(lblPhoneNumber);
        panelCenter.add(txtPhoneNumber);

        lblEmail.setFont(font2);
        txtEmail.setFont(font2);
        panelCenter.add(lblEmail);
        panelCenter.add(txtEmail);

        lblAddress.setFont(font2);
        txtAddress.setFont(font2);
        panelCenter.add(lblAddress);
        panelCenter.add(txtAddress);

        btnUpdate.setFont(font2);
        panelSouth.add(btnUpdate);
        btnCancel.setFont(font2);
        panelSouth.add(btnCancel);

        this.add(panelNorth, BorderLayout.NORTH);
        this.add(panelCenter, BorderLayout.CENTER);
        this.add(panelSouth,BorderLayout.SOUTH);

        btnUpdate.addActionListener(this);
        btnCancel.addActionListener(this);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setVisible(true);
    }
    public void actionPerformed(ActionEvent e){
        if (e.getActionCommand().equals("Update")){


        }else{
            if (e.getActionCommand().equals("Cancel")){
                System.exit(0);
            }
        }
    }
}

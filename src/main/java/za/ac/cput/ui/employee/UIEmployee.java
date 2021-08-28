package za.ac.cput.ui.employee;

//import za.ac.cput.repository.employee.IEmployeeRepository;
import za.ac.cput.entity.Employee;
import za.ac.cput.factory.EmployeeFactory;
import za.ac.cput.ui.employee.employeeActions.UIEmployeeAdd;
import za.ac.cput.ui.employee.employeeActions.UIEmployeeUpdate;
import za.ac.cput.util.GenericHelper;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UIEmployee extends JFrame implements ActionListener {

    private JMenuBar mainMenu, buttonMenu;
    private ImageIcon iconLogo;
    private JLabel lblTitle, lblCurrentUser, lblHeading;
    private JButton btnLogOut;
    private static JTable table;
    private static DefaultTableModel model;
    private JScrollPane pane;

    public UIEmployee() {
        super("❣ Employee Management");
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


        String userInfo = GenericHelper.getUserName();
        lblCurrentUser = new JLabel("Welcome, " + userInfo , SwingConstants.RIGHT);
        lblCurrentUser.setForeground(Color.WHITE);

        mainMenu.add(lblCurrentUser);

        btnLogOut = new JButton("Log Out ▼");
        btnLogOut.setBackground(Color.BLACK);
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
        buttonMenu.setBackground(Color.WHITE);

        buttonMenu.add(Box.createHorizontalGlue());

        JButton btnUpdate = new JButton("Update");
        btnUpdate.addActionListener(this);
        btnUpdate.setBackground(Color.BLACK);
        JButton btnAdd = new JButton("Add");
        btnAdd.setBackground(Color.BLACK);
        btnAdd.addActionListener(this);
        JButton btnDelete = new JButton("Delete");
        btnDelete.setBackground(Color.BLACK);
        btnDelete.addActionListener(this);
        JButton btnReload = new JButton("Reload");
        btnReload.setBackground(Color.BLACK);

        buttonMenu.add(btnUpdate);
        buttonMenu.add(btnAdd);
        buttonMenu.add(btnDelete);
        buttonMenu.add(btnReload);

        lblHeading = new JLabel("EMPLOYEES", SwingConstants.LEFT);
        lblHeading.setForeground(Color.DARK_GRAY);
        lblHeading.setFont(new Font("Courier", Font.BOLD,16));
        lblHeading.setPreferredSize(new Dimension(100, 50));
        lblHeading.setHorizontalAlignment(SwingConstants.LEFT);
        lblHeading.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.DARK_GRAY));

        panelMain.add(lblHeading);
        panelMain.add(buttonMenu);

        //Center Panel
        JPanel panelCenter = new JPanel();
        //List<Employee> employeeList = new IEmployeeRepository.EmployeeRepository().getAll();

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

      /*  for(int i = 0; i < employeeList.size(); i++) {

            rowData[0] = employeeList.get(i).getName();
            rowData[1] = employeeList.get(i).getSurname();
            rowData[2] = employeeList.get(i).getEmail();
            rowData[3] = employeeList.get(i).getPassword();
            rowData[4] = employeeList.get(i).getUserType();
            rowData[5] = employeeList.get(i).getDateCreated();

            model.addRow(rowData);
        }*/
        table.setModel(model);
        table.getTableHeader().setOpaque(false);
        table.getTableHeader().setBackground(Color.BLACK);
        table.getTableHeader().setForeground(Color.WHITE);

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

    /*public static void refresh() {
        model.setRowCount(0);
        List<Employee> employeeList = new IEmployeeRepository.EmployeeRepository().getAll();
        Object[] rowData = new Object[6];

        for(int i = 0; i < employeeList.size(); i++) {

            rowData[0] = employeeList.get(i).getName();
            rowData[1] = employeeList.get(i).getSurname();
            rowData[2] = employeeList.get(i).getEmail();
            rowData[3] = employeeList.get(i).getPassword();
            rowData[4] = employeeList.get(i).getUserType();
            rowData[5] = employeeList.get(i).getDateCreated();

            model.addRow(rowData);
        }
    }
*/

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Update")) {
            System.out.println("Updating information");
            int x = this.getSize().width / 2;
            int y = this.getSize().height / 2;

            int index = table.getSelectedRow();

            if(index == -1) {
                JOptionPane.showMessageDialog(null,"Select an employee first.","Alert",JOptionPane.WARNING_MESSAGE);
            }
            else {
                /*
                Employee employee = EmployeeFactory.createEmployee(
                        String.valueOf(table.getValueAt(index, 0)),
                        String.valueOf(table.getValueAt(index, 1)),
                        String.valueOf(table.getValueAt(index, 2)),
                        (int)table.getValueAt(index, 3),
                        String.valueOf(table.getValueAt(index, 4)),
                        null);


                new UIEmployeeUpdate(index, employee, x, y);


                 */

            }
            System.out.println(index);

        }
        else if(e.getActionCommand().equals("Add")) {
            System.out.println("Updating information");
            int x = this.getSize().width / 2;
            int y = this.getSize().height / 2;
            new UIEmployeeAdd(x, y);
        }
        else if(e.getActionCommand().equals("Delete")) {
            System.out.println("Deleting information");

            //Change this to a different class later

            int index = table.getSelectedRow();

            if(index == -1) {
                JOptionPane.showMessageDialog(null,"Select an employee first.","Alert",JOptionPane.WARNING_MESSAGE);
            }
            else {
                int n = JOptionPane.showConfirmDialog(
                        null,
                        "Are you sure you want to delete this record?",
                        "Cinema Magic",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.WARNING_MESSAGE);

                /*if(n == 0) {
                    //Delete the record
                    new IEmployeeRepository.EmployeeRepository().remove(index);
                    refresh();

                }*/
            }

        }
        else if (e.getActionCommand().equals("CANCEL")) {
            dispose();
        }

    }


}

package za.ac.cput.services.employee.features.commands;

import za.ac.cput.entity.Employee;

import javax.swing.*;
import java.sql.*;

public class AddNewEmployeeRecord {

    static final String DATABASE_URL = "jdbc:mysql://localhost/magiccinema";
    private Employee employee;
    private Connection dbConn;

    public AddNewEmployeeRecord(Employee _employee) throws SQLException {
        employee = _employee;
        dbConn = DriverManager.getConnection(DATABASE_URL, "root", "");
    }
    public void AddRecord() throws SQLException {
        if(!checkId(employee.getPassword())) {
            AddEmployeeInformation();
        }
    }


    //Check if record already exists
    private boolean checkId(int employeeId) throws SQLException {
        int employeeID =  employee.getPassword();
        String sql = "Select 1 from employee where UsernameID = ?";

        PreparedStatement ps = dbConn.prepareStatement(sql);
        ps.setInt(1, employeeID);
        ResultSet rs = ps.executeQuery();

        return rs.next();
    }

    //If record is not found add record to the database
    private void AddEmployeeInformation() {
        Connection connection;
        PreparedStatement ps;

        try {
            connection = DriverManager.getConnection(DATABASE_URL, "root", "");
            ps = connection.prepareStatement(
                    "INSERT INTO employee(FirstName, LastName, Email, Password, AccountType) " +
                            "VALUES(?,?,?,?,?)");
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getSurname());
            ps.setString(3, employee.getSurname().toLowerCase() + employee.getName().toLowerCase().charAt(0) + "@mcinema.co.za");
            ps.setInt(4, employee.getPassword());
            ps.setString(5, employee.getUserType());

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record has been added.");
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}



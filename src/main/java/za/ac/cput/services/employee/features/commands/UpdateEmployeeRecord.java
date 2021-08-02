package za.ac.cput.services.employee.features.commands;

import za.ac.cput.entity.Employee;

import java.sql.*;

public class UpdateEmployeeRecord {

    static final String DATABASE_URL = "jdbc:mysql://localhost/magiccinema";
    private Employee employee;
    private Connection dbConn;
    private int employeeId;

    public UpdateEmployeeRecord(int empId, Employee _employee) {
        employee = _employee;
        employeeId = empId;
        try{
            dbConn = DriverManager.getConnection(DATABASE_URL, "root", "");
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
    public void updateEmployeeInformation() {
        Connection connection;
        PreparedStatement statement;

        try {
            connection = DriverManager.getConnection(DATABASE_URL, "root", "");


            String sql = "UPDATE employee SET FirstName=?, LastName=?, Email=?, Password=?, AccountType=? WHERE UsernameID=?";
            statement = connection.prepareStatement(sql);
            statement.setString(1, employee.getName());
            statement.setString(2, employee.getSurname());
            statement.setString(3, employee.getEmail());
            statement.setInt(4, employee.getPassword());
            statement.setString(5, employee.getUserType());
            statement.setInt(6, employeeId);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                System.out.println("An existing user was updated successfully!");
            }
            connection.close();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

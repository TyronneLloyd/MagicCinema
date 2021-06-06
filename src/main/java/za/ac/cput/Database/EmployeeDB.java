package za.ac.cput.Database;

import javax.swing.*;
import java.sql.*;

public class EmployeeDB {

    static final String DATABASE_URL = "jdbc:mysql://localhost/magiccinema";

    public void addEmployee(String firstName, String lastName, String email, String password, String accountType) {

        Connection connection;
        PreparedStatement ps;
        ResultSet resultSet;

        try {
            connection = DriverManager.getConnection(DATABASE_URL, "root", "");
            ps = connection.prepareStatement(
                    "INSERT INTO employee(FirstName, LastName, Email, Password, AccountType) " +
                    "VALUES(?,?,?,?,?)");
            ps.setString(1, firstName);
            ps.setString(2, lastName);
            ps.setString(3, email);
            ps.setString(4, password);
            ps.setString(5, accountType);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record has been added.");
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}

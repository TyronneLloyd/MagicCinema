package za.ac.cput.Database;

import za.ac.cput.Entity.Employee;
import za.ac.cput.Factory.EmployeeFactory;

import javax.swing.*;
import java.sql.*;

public class LoginVerificationDB {

    static final String DATABASE_URL = "jdbc:mysql://localhost/magiccinema";

    public Employee verifyUser(String accessCode) {
        Connection connection;
        PreparedStatement ps;
        ResultSet resultSet;
        Employee e = null;
        String username = null;
        String firstName = null;
        String lastName = null;
        String email = null;
        String password = null;
        String accountType = null;

        try {
            connection = DriverManager.getConnection(DATABASE_URL, "root", "");
            //ps = connection.prepareStatement(output);

            ps = connection.prepareStatement("SELECT * FROM `employee` " +
                                                "WHERE `Password` = ?");
            ps.setString(1, accessCode);

            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                username = resultSet.getString("UsernameID");
                firstName = resultSet.getString("FirstName");
                lastName = resultSet.getString("LastName");
                email = resultSet.getString("Email");
                password = resultSet.getString("Password");
                accountType = resultSet.getString("AccountType");
            }
            e = EmployeeFactory.createEmployee(firstName, lastName, accountType, password);
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println(e);
        return e;
    }


}

package za.ac.cput.services.login.features.queries;

import za.ac.cput.entity.Employee;
import za.ac.cput.factory.EmployeeFactory;
import za.ac.cput.util.GenericHelper;

import java.sql.*;

public class GetLoginInformation {
    static final String DATABASE_URL = "jdbc:mysql://localhost/magiccinema";

    public Employee verifyUser(String accessCode) {
        Connection connection;
        PreparedStatement ps;
        ResultSet resultSet;
        Employee e = null;
        String username, firstName = null, lastName = null, email = null, accountType = null, dateCreated = null;
        int password = 0;

        try {
            connection = DriverManager.getConnection(DATABASE_URL, "root", "");

            ps = connection.prepareStatement("SELECT * FROM `employee` " +
                    "WHERE `Password` = ?");
            ps.setString(1, accessCode);

            resultSet = ps.executeQuery();

            while (resultSet.next()) {
                username = resultSet.getString("UsernameID");
                firstName = resultSet.getString("FirstName");
                lastName = resultSet.getString("LastName");
                email = resultSet.getString("Email");
                password = resultSet.getInt("Password");
                accountType = resultSet.getString("AccountType");
                dateCreated = resultSet.getString("DateCreated");
            }
            if(password != 0) {
                e = EmployeeFactory.createEmployee(
                        firstName,
                        lastName,
                        email,
                        password,
                        accountType,
                        dateCreated
                );

                GenericHelper.createUserTracker(firstName+ " " + lastName);

                return e;
            }

        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println(e);
        return null;
    }
}

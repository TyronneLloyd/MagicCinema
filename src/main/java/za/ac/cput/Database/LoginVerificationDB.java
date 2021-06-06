package za.ac.cput.Database;

import javax.swing.*;
import java.sql.*;

public class LoginVerificationDB {

    static final String DATABASE_URL = "jdbc:mysql://localhost/magiccinema";

    public boolean verifyUser(String username, String email, String password, String accountType) {
        Connection connection;
        PreparedStatement ps;
        ResultSet resultSet;
        boolean result = false;

        try {
            connection = DriverManager.getConnection(DATABASE_URL, "root", "");
            //ps = connection.prepareStatement(output);

            ps = connection.prepareStatement("SELECT `UsernameID`, `Email`, `Password`, `AccountType` FROM `employee` " +
                    "WHERE `UsernameID` = ? AND `Email` = ? AND `Password` = ? AND `AccountType` = ?");
            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, password);
            ps.setString(4, accountType);

            resultSet = ps.executeQuery();

            if(resultSet.next()) {
                JOptionPane.showMessageDialog(null, "Login Success.");
                result = true;
            }
            else {
                result = false;
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return result;
    }

}

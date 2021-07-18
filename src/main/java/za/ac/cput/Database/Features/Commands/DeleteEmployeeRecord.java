package za.ac.cput.Database.Features.Commands;

import javax.swing.*;
import java.sql.*;

public class DeleteEmployeeRecord {

    static final String DATABASE_URL = "jdbc:mysql://localhost/magiccinema";
    private Connection dbConn;
    private PreparedStatement ps;
    private Statement statement;
    private int index;

    public DeleteEmployeeRecord(int _index) {
        index = _index;

    }

    public void deleteRecord() {
        try {
            dbConn = DriverManager.getConnection(DATABASE_URL, "root", "");
            ps = dbConn.prepareStatement(
                    "DELETE FROM employee WHERE UsernameID = ?");
            ps.setInt(1, index);

            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Record has been removed.");
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        }

}

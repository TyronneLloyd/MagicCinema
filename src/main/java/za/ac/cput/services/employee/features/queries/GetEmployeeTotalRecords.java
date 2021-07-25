package za.ac.cput.services.employee.features.queries;

import java.sql.*;

public class GetEmployeeTotalRecords {
    static final String DATABASE_URL = "jdbc:mysql://localhost/magiccinema";
    private Connection dbConn;
    private int count = 0;

    public int getEmployeeTotal() {

        try {
            dbConn = DriverManager.getConnection(DATABASE_URL, "root", "");
            String query = "select count(*) from employee";
            Statement st = dbConn.createStatement();
            ResultSet rs = st.executeQuery(query);

            rs.next();
            count = rs.getInt(1);
            System.out.println("Number of records in the employee table: "+count);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return count;
    }
}

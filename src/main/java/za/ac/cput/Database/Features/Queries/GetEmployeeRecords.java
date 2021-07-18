package za.ac.cput.Database.Features.Queries;

import za.ac.cput.Entity.Employee;
import za.ac.cput.Factory.EmployeeFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GetEmployeeRecords {
    static final String DATABASE_URL = "jdbc:mysql://localhost/magiccinema";
    private Connection dbConn;
    private String employeeId;

    public List<Employee> employeeList() {
        List<Employee> data = new ArrayList<>();

        try{
            dbConn = DriverManager.getConnection(DATABASE_URL, "root", "");
            String query = "SELECT * FROM employee";
            Statement st = dbConn.createStatement();
            ResultSet rs = st.executeQuery(query);

            Employee employee;
            while(rs.next()) {
                employee = new EmployeeFactory().createEmployee(
                        rs.getString("FirstName"),
                        rs.getString("LastName"),
                        rs.getString("Email"),
                        rs.getInt("Password"),
                        rs.getString("AccountType"),
                        rs.getString("DateCreated")

                );
                data.add(employee);
            }
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return data;
    }

}

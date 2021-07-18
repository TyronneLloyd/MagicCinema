package za.ac.cput.Database.Repository;

import za.ac.cput.Database.Features.Commands.AddNewEmployeeRecord;
import za.ac.cput.Database.Features.Commands.DeleteEmployeeRecord;
import za.ac.cput.Database.Features.Commands.UpdateEmployeeRecord;
import za.ac.cput.Database.Features.Queries.GetEmployeeRecords;
import za.ac.cput.Entity.Employee;

import java.sql.SQLException;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository{

    @Override
    public Employee get(String employeePin) {
        return null;
    }

    @Override
    public List<Employee> getAll() {
        return new GetEmployeeRecords().employeeList();
    }

    @Override
    public void add(Employee employee) {
        try {
            new AddNewEmployeeRecord(employee).AddRecord();
        }
        catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void update(int employeeId, Employee employee) {
        new UpdateEmployeeRecord(employeeId, employee).updateEmployeeInformation();

    }

    @Override
    public void remove(int employeeId) {
        new DeleteEmployeeRecord(employeeId).deleteRecord();

    }
}

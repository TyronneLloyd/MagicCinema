package za.ac.cput.repository.impl;
import za.ac.cput.entity.Employee;
import za.ac.cput.repository.IEmployeeRepository;
import za.ac.cput.services.employee.features.commands.AddNewEmployeeRecord;
import za.ac.cput.services.employee.features.commands.DeleteEmployeeRecord;
import za.ac.cput.services.employee.features.commands.UpdateEmployeeRecord;
import za.ac.cput.services.employee.features.queries.GetEmployeeRecords;
import za.ac.cput.services.employee.features.queries.GetEmployeeTotalRecords;
import za.ac.cput.services.login.features.queries.GetLoginInformation;

import java.sql.SQLException;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository {

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

    @Override
    public Employee login(String accessCode) {
        Employee e = new GetLoginInformation().verifyUser(accessCode);

        if(e != null) {
            return e;
        }
        else {
            throw null;
        }
    }

    @Override
    public int getTotalRecords() {
        return new GetEmployeeTotalRecords().getEmployeeTotal();
    }
}

package za.ac.cput.Database.Repository;

import za.ac.cput.Entity.Employee;

import java.util.List;


public interface IEmployeeRepository {

    /**
     * This function gets the employee object from the database.
     */
    Employee get(String employeePin);

    /**
     * This function returns all employees in the table
     */
    List<Employee> getAll();

    /**
     * This function add a new employee to the database.
     */
    void add(Employee employee);

    /**
     * This function allows the information from the database to be changed.
     */
    void update(int employeeId, Employee employee);

    /**
     * This function removes a record from the database.
     */
    void remove(int employeeId);
}

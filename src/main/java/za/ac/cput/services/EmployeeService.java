package za.ac.cput.services;

import za.ac.cput.entity.Employee;
import za.ac.cput.repository.employee.EmployeeRepository;
import za.ac.cput.services.employee.IEmployeeService;

import java.util.Set;

public class EmployeeService implements IEmployeeService {
    private static EmployeeService service = null;
    private EmployeeRepository repository = null;

    private EmployeeService() {
        this.repository = EmployeeRepository.getRepository();
    }

    public static EmployeeService getService() {
        if(service == null) {
            service = new EmployeeService();
        }
        return service;
    }

    @Override
    public Employee create(Employee employee) {
        return this.repository.create(employee);
    }

    @Override
    public Employee read(String employeeId) {
        return this.repository.read(employeeId);
    }

    @Override
    public Employee update(Employee employeeId) {
        return this.repository.update(employeeId);
    }

    @Override
    public boolean delete(String employeeId) {
        return this.repository.delete(employeeId);
    }

    @Override
    public Set<Employee> getAll() {
        return this.repository.getAll();
    }
}

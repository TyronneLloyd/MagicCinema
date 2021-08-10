package za.ac.cput.repository.employee;

import za.ac.cput.entity.Employee;
import za.ac.cput.repository.employee.IEmployeeRepository;
import za.ac.cput.repository.equipmentStorage.EquipmentStorageRepository;

import java.util.HashSet;
import java.util.Set;

public class EmployeeRepository implements IEmployeeRepository {
    private static EmployeeRepository repository = null;
    private Set<Employee> employeeDB = null;

    private EmployeeRepository() {
        employeeDB = new HashSet<Employee>();
    }

    public static EmployeeRepository getRepository() {
        if (repository == null) {
            repository = new EmployeeRepository();
        }
        return repository;

    }
    @Override
    public Employee read(String employeeId) {
        for(Employee employee : employeeDB) {
            if(employee.getEmployeeNumber().equals(employeeId)) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public Employee create(Employee employee) {
        boolean success = employeeDB.add(employee);
        if(!success)
            return null;
        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        Employee request = read(employee.getEmployeeNumber());
        if(request != null) {
            employeeDB.remove(request);
            employeeDB.add(employee);
            return employee;
        }
        return null;
    }

    @Override
    public boolean delete(String employeeId) {
        Employee request = read(employeeId);
        if(request == null) {
            return false;
        }
        employeeDB.remove(request);
        return true;
    }

    @Override
    public Set<Employee> getAll() {
        return employeeDB;
    }
}
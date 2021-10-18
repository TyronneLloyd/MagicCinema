package za.ac.cput.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Employee;
import za.ac.cput.repository.employee.EmployeeRepository;
import za.ac.cput.services.employee.IEmployeeService;
import javax.persistence.EntityNotFoundException;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeService implements IEmployeeService {

    private final EmployeeRepository repository;

    @Autowired
    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Employee create(Employee employee) {
        return this.repository.save(employee);
    }

    @Override
    public Employee read(String employeeId) {
        return this.repository.findById(employeeId).orElseThrow(() -> new EntityNotFoundException("Employee with id " + employeeId + " was not found" ));
    }

    @Override
    public Employee update(Employee employee) {
        if(this.repository.existsById(employee.getEmployeeNumber()))
            return this.repository.save(employee);
        return null;
    }

    @Override
    public boolean delete(String employeeId) {
        this.repository.deleteById(employeeId);
        if(this.repository.existsById(employeeId))
            return false;
        else
            return true;
    }

    @Override
    public boolean Login(String username, int password) {
        Set<Employee> employees = getAll();
        for(Employee employee : employees){
            if(employee.getUsername().equals(username) && employee.getPassword()==password) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Set<Employee> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }

    @Override
    public Employee readByPassword(int password) {
        Set<Employee> employees = getAll();
        for(Employee employee : employees) {
            if(employee.getPassword() == password) {
                return employee;
            }
        }
        return null;
    }
}
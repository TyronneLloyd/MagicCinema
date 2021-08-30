package za.ac.cput.repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.entity.Employee;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface EmployeeRepository extends JpaRepository<Employee, String> {
}

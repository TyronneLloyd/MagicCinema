package za.ac.cput.Repository.employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

}

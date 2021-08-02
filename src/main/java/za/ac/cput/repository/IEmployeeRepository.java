package za.ac.cput.repository;

import za.ac.cput.entity.Employee;

import java.util.List;


public interface IEmployeeRepository extends IRepository<Employee, String>{

    Employee login(String accessCode);
    int getTotalRecords();
}

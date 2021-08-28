package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Employee;
import za.ac.cput.factory.EmployeeFactory;
import za.ac.cput.services.EmployeeService;

import java.util.Set;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping(value = "/create")
    public ResponseEntity<Employee> create(@RequestBody Employee employee){
        Employee newEmployee = service.create(EmployeeFactory.
                        createEmployee(
                            employee.getName(),
                            employee.getSurname(),
                            employee.getEmail(),
                            employee.getPassword(),
                            employee.getRole()));
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @GetMapping(value = "/read/{employeeId}")
    public ResponseEntity<Employee> read(@PathVariable String employeeId){
        Employee readEmployee = service.read(employeeId);
        return new ResponseEntity<>(readEmployee, HttpStatus.OK);
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Employee> update(@RequestBody Employee employee){
        Employee newEmployee = new Employee.Builder().copy(employee)
                .setName(employee.getName())
                .setEmail(employee.getEmail())
                .setPassword(employee.getPassword())
                .setSurname(employee.getSurname())
                .setRole(employee.getRole())
                .setDateCreated(employee.getDateCreated())
                .setImagePath(employee.getImagePath())
                .build();
        Employee updateEmployee = service.update(newEmployee);

        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);

    }

    @DeleteMapping(value = "/delete/{employeeId}")
    public ResponseEntity<?> delete(@RequestBody String employeeId){
        service.delete(employeeId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public ResponseEntity<Set<Employee>> getAll(){
        Set<Employee> roles = service.getAll();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }
}

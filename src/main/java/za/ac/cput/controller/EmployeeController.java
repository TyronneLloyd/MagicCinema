package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Client;
import za.ac.cput.entity.Employee;
import za.ac.cput.entity.EquipmentStorage;
import za.ac.cput.entity.catalog.Equipment;
import za.ac.cput.factory.ClientFactory;
import za.ac.cput.factory.EmployeeFactory;
import za.ac.cput.services.EmployeeService;

import java.util.Set;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("/login/{username}/{password}")
    public ResponseEntity<Boolean> login(@PathVariable String username, @PathVariable int password){
        System.out.println("Button Clicked");
        boolean result = service.Login(username, password);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Employee> create(@RequestBody Employee employee){
        Employee newEmployee = service.create(EmployeeFactory.
                        createEmployee(
                                employee.getUsername(),
                                employee.getName(),
                                employee.getSurname(),
                                employee.getEmail(),
                                employee.getPassword(),
                                employee.getRole()));
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @GetMapping(value = "/read/{employeeNumber}")
    public ResponseEntity<Employee> read(@PathVariable String employeeNumber){
        Employee readEmployee = service.read(employeeNumber);
        return new ResponseEntity<>(readEmployee, HttpStatus.OK);
    }

    @GetMapping("/readpassword/{password}")
    public Employee readUserByPassword (@PathVariable int password)
    {
        return service.readByPassword(password);
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

    @DeleteMapping("/delete/{employeeNumber}")
    public ResponseEntity<String> delete(@PathVariable String employeeNumber) {
        System.out.println(employeeNumber);
        service.delete(employeeNumber);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public ResponseEntity<Set<Employee>> getAll(){
        Set<Employee> roles = service.getAll();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }
}

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
        boolean result = service.Login(username, password);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PostMapping(value = "/create")
    public Employee create(@RequestBody Employee employee){
        return service.create(employee);
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
    public Employee update(@RequestBody Employee employee){
        return service.update(employee);

    }

    @DeleteMapping("/delete/{employeeNumber}")
    public ResponseEntity<String> delete(@PathVariable String employeeNumber) {
        service.delete(employeeNumber);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @RequestMapping(value = "/getall", method = RequestMethod.GET)
    public ResponseEntity<Set<Employee>> getAll(){
        Set<Employee> roles = service.getAll();
        return new ResponseEntity<>(roles, HttpStatus.OK);
    }
}

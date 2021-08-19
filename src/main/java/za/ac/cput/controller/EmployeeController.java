/*

package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import za.ac.cput.entity.Employee;
import za.ac.cput.factory.EmployeeFactory;
import za.ac.cput.services.EmployeeService;

import java.util.Set;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Employee create(@RequestBody Employee employee){
        Employee newEmployee = EmployeeFactory.
                createEmployee(
                        employee.getName(),
                        employee.getSurname(),
                        employee.getEmployeeNumber(),
                        employee.getPassword(),
                        employee.getUserType(),employee.getDateCreated());
        return employeeService.create(newEmployee);
    }

    @RequestMapping(value = "/read", method = RequestMethod.GET)
    public Employee read(@RequestBody Employee employeeId){
        return employeeService.read(employeeId.getEmployeeNumber());
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    public Employee update(@RequestBody Employee employee){
        Employee newEmployee = new Employee.Builder().copy(employee)
                .setName(employee.getName())
                .setSurname(employee.getSurname())
                .setPassword(employee.getPassword()).setUserType(employee.getUserType()).build();
        return employeeService.update(newEmployee);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public boolean delete(@RequestBody Employee employeeId){
        if(employeeService.delete(employeeId.getEmployeeNumber()))
            return true;
        else {
            return false;
        }
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public Set<Employee> getAll(){
        return employeeService.getAll();
    }
}

*/

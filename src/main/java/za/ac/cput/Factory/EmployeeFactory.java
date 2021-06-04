package za.ac.cput.Factory;
/*
    @Description:Employees Entity ->
    @Author: Tyronne Lloyd Hendricks
    @Student Number: 215141210
    @Date: 4 June 2021
 */
import za.ac.cput.Entity.Employee;
import za.ac.cput.Util.GenericHelper;

public class EmployeeFactory {
    public static Employee createEmployee(String name, String surname,String userType, String username,String password){
        String employeeNumber = GenericHelper.generateId();

        Employee employee = new Employee.Builder()
                .setEmployeeNumber(employeeNumber)
                .setName(name)
                .setSurname(surname)
                .setUserType(userType)
                .setUsername(username)
                .setPassword(password)
                .build();

        return employee;
    }

}

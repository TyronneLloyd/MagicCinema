package za.ac.cput.factory;
/*  @Subject: Project 3
    @Description: Employees Factory -> EmployeeFactory.java
    @Author: Tyronne Lloyd Hendricks
    @Student Number: 215141210
    @Date: 3rd June 2021
  */
import za.ac.cput.entity.Employee;
import za.ac.cput.util.GenericHelper;

public class EmployeeFactory {
    public static Employee createEmployee(String name, String surname,String email, int password, String userType, String dateCreated){
        String employeeNumber = GenericHelper.generateId();

        Employee employee = new Employee.Builder()
                .setEmployeeNumber(employeeNumber)
                .setName(name)
                .setSurname(surname)
                .setEmail(email)
                .setPassword(password)
                .setUserType(userType)
                .setDateCreated(dateCreated)
                .build();

        return employee;
    }

}

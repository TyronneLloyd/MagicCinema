package za.ac.cput.Factory;

import za.ac.cput.Entity.Employee;

public class EmployeeFactory {
    public static Employee createEmployee(String employeeNumber, String name, String surname,String userType, String username,String password){

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

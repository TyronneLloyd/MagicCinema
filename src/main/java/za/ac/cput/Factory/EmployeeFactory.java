package za.ac.cput.Factory;

import za.ac.cput.Entity.Employee;
import za.ac.cput.Util.GenericHelper;

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

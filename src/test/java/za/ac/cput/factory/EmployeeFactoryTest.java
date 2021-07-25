package za.ac.cput.factory;
/*
    @Description:Employees Entity ->
    @Author: Tyronne Lloyd Hendricks
    @Student Number: 215141210
    @Date: 4 June 2021
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Employee;

class EmployeeFactoryTest {

    @Test
    public void createEmployee(){
        Employee employee = EmployeeFactory.createEmployee("Ty","Lloyd", "Ty@gmail.com",215141210, "Administrator", null);
        assertNotNull(employee);
        System.out.println(employee);

    }

}//class
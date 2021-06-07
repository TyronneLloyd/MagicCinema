package za.ac.cput.Factory;
/*
    @Description:Employees Entity ->
    @Author: Tyronne Lloyd Hendricks
    @Student Number: 215141210
    @Date: 4 June 2021
 */

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import za.ac.cput.Entity.Employee;

class EmployeeFactoryTest {

    @Test
    public void createEmployee(){
        Employee employee = EmployeeFactory.createEmployee("Ty","Lloyd", "admin","215141210");
        assertNotNull(employee);
        System.out.println(employee);

    }

}//class
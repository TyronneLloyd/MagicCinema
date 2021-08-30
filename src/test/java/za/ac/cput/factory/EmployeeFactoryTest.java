package za.ac.cput.factory;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Employee;

class EmployeeFactoryTest {

    @Test
    public void createEmployee(){
        Employee employee = EmployeeFactory
                .createEmployee("Ty","Lloyd", "Ty@gmail.com",215141210, "1");
        assertNotNull(employee);
        System.out.println(employee);

    }

}
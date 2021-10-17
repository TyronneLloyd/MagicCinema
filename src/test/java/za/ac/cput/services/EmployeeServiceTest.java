
package za.ac.cput.services;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Employee;
import za.ac.cput.factory.EmployeeFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class EmployeeServiceTest {
    @Autowired
    private  EmployeeService service;
    private static Employee employee = EmployeeFactory.createEmployee(

            "TyTy",
            "Ty",
            "Lloyd",
            "Ty@gmail.com",
            215141210,
            "1");

    @Test
    void a_create() {
        Employee create = service.create(employee);
        assertEquals(create.getEmployeeNumber(), employee.getEmployeeNumber());
        System.out.println("Created: " + create);
    }

    @Test
    void b_read() {
        Employee read = service.read(employee.getEmployeeNumber());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Employee update = new Employee.Builder().copy(employee).setName("Jeff").build();
        assertNotNull(service.update(update));
        System.out.println("Updated: " + update);
    }

    @Test
    void d_getAll() {
        System.out.println("Display All:");
        System.out.println(service.getAll());
    }

    @Test
    void e_delete() {
        boolean success = service.delete(employee.getEmployeeNumber());
        assertTrue(success);
        System.out.println("Delete: " + success);
    }

}


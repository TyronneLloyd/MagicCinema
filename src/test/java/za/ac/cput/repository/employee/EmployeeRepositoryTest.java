
package za.ac.cput.repository.employee;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Employee;
import za.ac.cput.factory.EmployeeFactory;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class EmployeeRepositoryTest {
    private static EmployeeRepository repository = EmployeeRepository.getRepository();
    private static Employee employee = EmployeeFactory.createEmployee(
            "Ty",
            "Lloyd",
            "Ty@gmail.com",
            215141210,
            "Administrator",
            null);

    @Test
    void a_create() {
        Employee create = repository.create(employee);
        assertEquals(create.getEmployeeNumber(), employee.getEmployeeNumber());
        System.out.println("Created: " + create);
    }

    @Test
    void b_read() {
        Employee read = repository.read(employee.getEmployeeNumber());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Employee update = new Employee.Builder().copy(employee).setEmail("LTy@email.com").setDateCreated("08-06-2021").build();
        assertNotNull(repository.update(update));
        System.out.println("Updated: " + update);
    }

    @Test
    void d_getAll() {
        System.out.println("Display All: "  + repository.getAll());
    }

    @Test
    void e_delete() {
        boolean success = repository.delete(employee.getEmployeeNumber());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

}

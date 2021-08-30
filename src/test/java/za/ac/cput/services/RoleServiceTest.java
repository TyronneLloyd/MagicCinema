package za.ac.cput.services;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.Role;
import za.ac.cput.factory.RoleFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest
class RoleServiceTest {

    @Autowired
    private  RoleService service;
    private static Role role = RoleFactory.createRole(
            "Dev", "Responsible for implementing features"
    );

    @Test
    void a_create() {
        Role create = service.create(role);
        assertEquals(create.getId(), role.getId());
        System.out.println("Created: " + create);
    }

    @Test
    void b_read() {
        Role read = service.read(role.getId());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Role update = new Role.Builder().copy(role).setTitle("Developer").build();
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
        boolean success = service.delete(role.getId());
        assertTrue(success);
        System.out.println("Delete: " + success);
    }

}
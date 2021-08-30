package za.ac.cput.factory;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.Role;

import static org.junit.jupiter.api.Assertions.*;

class RoleFactoryTest {

    @Test
    void createRole() {
        Role role = RoleFactory.createRole(
                "Dev", "Responsible for implementing features"
        );
        assertNotNull(role);
        System.out.println(role);
    }


}
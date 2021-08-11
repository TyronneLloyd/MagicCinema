package za.ac.cput.services;

/*
   @Subject: Project 3
   @Description:LoginServiceTest.java
   @Author: Elrich Herman
   @Student Number: 218150040
   @Date: 8 June 2021
*/

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Login;
import za.ac.cput.factory.LoginFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class LoginServiceTest {
    private static LoginService service  = LoginService.getService();
    private static Login login = LoginFactory.createLogin("HG548ZHkd");

    @Test
    @Order(1)
    void create() {
        Login create = service.create(login);
        assertEquals(create.getPassword(),login.getPassword());
        System.out.println("Created: " + create);
    }

    @Test
    @Order(2)
    void read() {
        Login read = service.read(login.getPassword());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    @Order(3)
    void update() {
        Login update = new Login.Builder().copy(login).setPassword("HG548ZHkd6").build();
        assertNotNull(service.update(update));
        System.out.println("Updated: " + update);
    }

    @Test
    @Order(4)
    void delete() {
        boolean delete = service.delete(login.getPassword());
        assertTrue(delete);
        System.out.println("Deleted: " + delete);
    }

    @Test
    @Order(5)
    void getAll() {
        System.out.println("Display All: ");
        System.out.println(service.getAll());
    }
}
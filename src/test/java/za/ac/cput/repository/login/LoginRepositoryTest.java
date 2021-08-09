package za.ac.cput.repository.login;

/*
   @Subject: Project 3
   @Description:LoginRepositoryTest.java
   @Author: Elrich Herman
   @Student Number: 218150040
   @Date: 07 August 2021
*/

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Login;
import za.ac.cput.factory.LoginFactory;
import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)


public class LoginRepositoryTest {

    private static LoginRepository repository = LoginRepository.getRepository();
    private static Login login = LoginFactory.createLogin("H56464FH554");

    @Test
    @Order(1)
    void create() {
        Login create = repository.create(login);
        assertEquals(create.getPassword(), login.getPassword());
        System.out.println("Create: " + create);
    }

    @Test
    @Order(2)
    void read() {
        Login read = repository.read(login.getPassword());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    @Order(3)
    void update() {
        Login updated = new Login.Builder().copy(login).Password("H56464FH5541").build();
        assertNotNull(repository.update(updated));
        System.out.println("Update: " + updated);
    }

    @Test
    @Order(4)
    void getAll() {
        System.out.println("Display All: "  + repository.getAll());
    }

    @Test
    @Order(5)
    void delete() {
        boolean success = repository.delete(login.getPassword());
        assertTrue(success);
        System.out.println("Delete: " + success);
    }
}


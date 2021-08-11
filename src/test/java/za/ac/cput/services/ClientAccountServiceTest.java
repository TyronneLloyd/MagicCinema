package za.ac.cput.services;

/*
   @Subject: Project 3
   @Description:ClientAccountServiceTest.java
   @Author: Elrich Herman
   @Student Number: 218150040
   @Date: 8 June 2021
*/

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.ClientAccount;
import za.ac.cput.factory.ClientAccountFactory;
import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

public class ClientAccountServiceTest {
    private static ClientAccountService service  = ClientAccountService.getService();
    private static ClientAccount clientAccount = ClientAccountFactory.createClientAccount("558963458", "558");

    @Test
    @Order(1)
    void create() {
        ClientAccount create = service.create(clientAccount);
        assertEquals(create.getAccountNumber(),clientAccount.getAccountNumber());
        System.out.println("Created: " + create);
    }

    @Test
    @Order(2)
    void read() {
        ClientAccount read = service.read(clientAccount.getAccountNumber());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    @Order(3)
    void update() {
        ClientAccount update = new ClientAccount.Builder().copy(clientAccount).setAccountNumber("5588955874").build();
        assertNotNull(service.update(update));
        System.out.println("Updated: " + update);
    }

    @Test
    @Order(4)
    void delete() {
        boolean delete = service.delete(clientAccount.getAccountNumber());
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
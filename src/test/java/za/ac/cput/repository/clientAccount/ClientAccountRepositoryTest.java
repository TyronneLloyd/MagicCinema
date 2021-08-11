package za.ac.cput.repository.clientAccount;

/*
   @Subject: Project 3
   @Description:ClientAccountRepositoryTest.java
   @Author: Elrich Herman
   @Student Number: 218150040
   @Date: 08 August 2021
*/

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.ClientAccount;
import za.ac.cput.factory.ClientAccountFactory;
import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)

class ClientAccountRepositoryTest
{

    private static ClientAccountRepository repository = ClientAccountRepository.getRepository();
    private static ClientAccount clientAccount = ClientAccountFactory.createClientAccount("9955448", "11");

    @Test
    @Order(1)
    void create() {
        ClientAccount create = repository.create(clientAccount);
        assertEquals(create.getAccountNumber(), clientAccount.getAccountNumber());
        System.out.println("Create: " + create);
    }

    @Test
    @Order(2)
    void read() {
        ClientAccount read = repository.read(clientAccount.getAccountNumber());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    @Order(3)
    void update() {
        ClientAccount updated = new ClientAccount.Builder().copy(clientAccount).NumberBorrowed("11").build();
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
        boolean success = repository.delete(clientAccount.getAccountNumber());
        assertTrue(success);
        System.out.println("Delete: " + success);
    }
}



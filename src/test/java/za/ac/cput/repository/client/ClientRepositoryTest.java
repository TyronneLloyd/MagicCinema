package za.ac.cput.repository.client;

/*
    @Description:ClientRepositoryTest ->
    @Author: Cole Hanekom
    @Student Number: 217267556
    @Date: 04 August 2021
*/

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Client;
import za.ac.cput.factory.ClientFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ClientRepositoryTest {
    private static ClientRepository repository = ClientRepository.getRepository();
    private static Client client = ClientFactory.createClient("Steve", "Silva", "0722224560", "100000000009");

    @Test
    @Order(1)
    void create() {
        Client create = repository.create(client);
        assertEquals(create.getClientID(), client.getClientID());
        System.out.println("Created: " + create);
    }

    @Test
    @Order(2)
    void read() {
        Client read = repository.read(client.getClientID());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    @Order(3)
    void update() {
        Client updated = new Client.Builder().copy(client).setSurname("Jobs").build();
        assertNotNull(repository.update(updated));
        System.out.println("Update: " + updated);
    }

    @Test
    @Order(5)
    void delete() {
        boolean success = repository.delete(client.getClientID());
        assertTrue(success);
        System.out.println("Delete: " + success);
    }

    @Test
    @Order(4)
    void getAll() {
        System.out.println("Show All:");
        System.out.println(repository.getAll());
    }
}
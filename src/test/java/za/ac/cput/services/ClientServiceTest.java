package za.ac.cput.services;

/*
    @Description:ClientServiceTest ->
    @Author: Cole Hanekom
    @Student Number: 217267556
    @Date: 04 August 2021
*/

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.Client;
import za.ac.cput.factory.ClientFactory;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
class ClientServiceTest {
    private static ClientService service;
    private static Client client = ClientFactory.createClient("Erling", "Haaland", "0722114560");

    @Test
    void a_create() {
        Client created = service.create(client);
        assertEquals(created.getClientID(), client.getClientID());
        System.out.println("Created: " + created);
    }

    @Test
    void b_read() {
        Client read = service.read(client.getClientID());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Test
    void c_update() {
        Client updated = new Client.Builder().copy(client).setAccountNumber("100000000010").build();
        assertNotNull(service.update(updated));
        System.out.println("Updated: " + updated);
    }

    @Test
    void e_delete() {
        boolean success = service.delete(client.getClientID());
        assertTrue(success);
        System.out.println("Deleted: " + success);
    }

    @Test
    void d_getAll() {
        System.out.println("Show All:");
        System.out.println(service.getAll());
    }
}
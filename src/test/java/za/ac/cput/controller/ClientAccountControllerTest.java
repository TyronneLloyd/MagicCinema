package za.ac.cput.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.ClientAccount;
import za.ac.cput.factory.ClientAccountFactory;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ClientAccountControllerTest {

    private static ClientAccount clientAccount = ClientAccountFactory.createClientAccount("55689954", "25");

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/clientaccount";

    @Test
    @Order(1)
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<ClientAccount> postResponse = restTemplate.postForEntity(url, clientAccount , ClientAccount.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        clientAccount = postResponse.getBody();
        System.out.println("Saved data: " + clientAccount);
        assertEquals(clientAccount.getAccountNumber(), postResponse.getBody().getAccountNumber());
    }

    @Test
    @Order(2)
    void b_read() {
        String url = baseURL + "/read/" + clientAccount.getAccountNumber();
        System.out.println("URL: " + url);
        ResponseEntity<ClientAccount> response = restTemplate.getForEntity(url, ClientAccount.class);
        assertEquals(clientAccount.getAccountNumber(), response.getBody().getAccountNumber());
    }

    @Test
    @Order(3)
    void c_update() {
        ClientAccount updated = new ClientAccount.Builder().copy(clientAccount).setAccountNumber("55687955").build();
        String url = baseURL + "/update";
        System.out.println("Post data: " + updated);
        ResponseEntity<ClientAccount> response = restTemplate.postForEntity(url, updated, ClientAccount.class);
        assertNotNull(response.getBody());
    }

    @Test
    @Order(5)
    void e_delete() {
        String url = baseURL + "/delete/" + clientAccount.getAccountNumber();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    @Order(4)
    void d_getAll()
    {
        String url = baseURL + "/getall/";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show All: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}
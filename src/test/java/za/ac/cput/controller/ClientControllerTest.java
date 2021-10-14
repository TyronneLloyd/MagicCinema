package za.ac.cput.controller;

/*
    @Description:ClientControllerTest ->
    @Author: Cole Hanekom
    @Student Number: 217267556
    @Date: 17 August 2021
*/

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.entity.Client;
import za.ac.cput.factory.ClientFactory;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ClientControllerTest {
    private static Client client = ClientFactory.createClient("Erling", "Haaland", "0722114560");
    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL =  "http://localhost:8080/client";

    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<Client> postResponse = restTemplate.postForEntity(url,client,Client.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        client= postResponse.getBody();
        System.out.println("Saved data: " + client);
        assertEquals(client.getClientID(),postResponse.getBody().getClientID());
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + client.getClientID();
        System.out.println("URL: " + url);
        ResponseEntity<Client> response = restTemplate.getForEntity(url, Client.class);
        assertEquals(client.getClientID(),response.getBody().getClientID());


    }

    @Test
    void c_update() {
        Client updated = new Client.Builder().copy(client).setAccountNumber("100000000010").build();
        String url = baseURL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
        ResponseEntity<Client> response = restTemplate.postForEntity(url,updated,Client.class);
        assertNotNull(response.getBody());
    }

    @Test
    void e_delete() {
        String url = baseURL + "/delete/" + client.getClientID();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
    void d_getAll() {
        String url = baseURL + "/getall";
        HttpHeaders headers = new  HttpHeaders();
        HttpEntity<String> entity  = new HttpEntity<>(null,headers);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show all: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}
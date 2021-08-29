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
import za.ac.cput.entity.Login;
import za.ac.cput.factory.LoginFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LoginControllerTest {

    private static Login login = LoginFactory.createLogin("H80094jjd&*");

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/login";

    @Test
    @Order(1)
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<Login> postResponse = restTemplate.postForEntity(url, login , Login.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        login = postResponse.getBody();
        System.out.println("Saved data: " + login);
        assertEquals(login.getPassword(), postResponse.getBody().getPassword());
    }

    @Test
    @Order(2)
    void b_read() {
        String url = baseURL + "/read/" + login.getPassword();
        System.out.println("URL: " + url);
        ResponseEntity<Login> response = restTemplate.getForEntity(url, Login.class);
        assertEquals(login.getPassword(), response.getBody().getPassword());
    }

    @Test
    @Order(3)
    void c_update() {
        Login updated = new Login.Builder().copy(login).setPassword("Hjdldkfh6890h@").build();
        String url = baseURL + "/update";
        System.out.println("Post data: " + updated);
        ResponseEntity<Login> response = restTemplate.postForEntity(url, updated, Login.class);
        assertNotNull(response.getBody());
    }

    @Test
    @Order(5)
    void e_delete() {
        String url = baseURL + "/delete/" + login.getPassword();
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
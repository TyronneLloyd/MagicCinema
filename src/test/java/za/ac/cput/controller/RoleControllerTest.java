package za.ac.cput.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.Role;
import za.ac.cput.factory.RoleFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RoleControllerTest {

    private static Role role = RoleFactory.createRole(
            "Dev", "Responsible for implementing features"
    );
    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/role";

    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<Role> postResponse = restTemplate.postForEntity(url, role , Role.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        role = postResponse.getBody();
        System.out.println("Saved data: " + role);
        assertEquals(role.getId(), postResponse.getBody().getId());
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + role.getId();
        System.out.println("URL: " + url);
        ResponseEntity<Role> response = restTemplate.getForEntity(url, Role.class);
        assertEquals(role.getId(), response.getBody().getId());
    }

    @Test
    void c_update() {
        Role updated = new Role.Builder().copy(role).setTitle("Developer").build();
        String url = baseURL + "/update";
        System.out.println("Post data: " + updated);
        ResponseEntity<Role> response = restTemplate.postForEntity(url, updated, Role.class);
        assertNotNull(response.getBody());
    }

    @Test
    void e_delete() {
        String url = baseURL + "/delete/" + role.getId();
        System.out.println("URL: " + url);
        restTemplate.delete(url);
    }

    @Test
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
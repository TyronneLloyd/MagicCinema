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
import za.ac.cput.entity.EquipmentStorage;
import za.ac.cput.factory.EquipmentStorageFactory;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EquipmentStorageControllerTest {

    private static EquipmentStorage equipmentStorage = EquipmentStorageFactory.createStorageFactory("21", "11001");

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/equipmentstorage";

    @Test
    @Order(1)
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<EquipmentStorage> postResponse = restTemplate.postForEntity(url, equipmentStorage , EquipmentStorage.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        equipmentStorage = postResponse.getBody();
        System.out.println("Saved data: " + equipmentStorage);
        assertEquals(equipmentStorage.getEquipmentID(), postResponse.getBody().getEquipmentID());
    }

    @Test
    @Order(2)
    void b_read() {
        String url = baseURL + "/read/" + equipmentStorage.getEquipmentID();
        System.out.println("URL: " + url);
        ResponseEntity<EquipmentStorage> response = restTemplate.getForEntity(url, EquipmentStorage.class);
        assertEquals(equipmentStorage.getEquipmentID(), response.getBody().getEquipmentID());
    }

    @Test
    @Order(3)
    void c_update() {
        EquipmentStorage updated = new EquipmentStorage.Builder().copy(equipmentStorage).ShelfSpace("50").build();
        String url = baseURL + "/update";
        System.out.println("Post data: " + updated);
        ResponseEntity<EquipmentStorage> response = restTemplate.postForEntity(url, updated, EquipmentStorage.class);
        assertNotNull(response.getBody());
    }

    @Test
    @Order(5)
    void e_delete() {
        String url = baseURL + "/delete/" + equipmentStorage.getEquipmentID();
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
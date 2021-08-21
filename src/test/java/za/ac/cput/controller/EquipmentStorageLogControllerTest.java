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
import za.ac.cput.entity.EquipmentStorageLog;
import za.ac.cput.factory.EquipmentStorageLogFactory;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EquipmentStorageLogControllerTest {

    private static EquipmentStorageLog storageLog = EquipmentStorageLogFactory.createEquipmentStorageLog(
            "Camera", "4321"
    );

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/equipmentstoragelog";

    @Test
    void a_create() {
        String url = baseURL + "/create";
        ResponseEntity<EquipmentStorageLog> postResponse = restTemplate.postForEntity(url, storageLog , EquipmentStorageLog.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        storageLog = postResponse.getBody();
        System.out.println("Saved data: " + storageLog);
        assertEquals(storageLog.getEquipmentStorageLogId(), postResponse.getBody().getEquipmentStorageLogId());
    }

    @Test
    void b_read() {
        String url = baseURL + "/read/" + storageLog.getEquipmentStorageLogId();
        System.out.println("URL: " + url);
        ResponseEntity<EquipmentStorageLog> response = restTemplate.getForEntity(url, EquipmentStorageLog.class);
        assertEquals(storageLog.getEquipmentStorageLogId(), response.getBody().getEquipmentStorageLogId());
    }

    @Test
    void c_update() {
        EquipmentStorageLog updated = new EquipmentStorageLog.Builder().copy(storageLog).setEquipmentStorageLocation("23415").build();
        String url = baseURL + "/update";
        System.out.println("Post data: " + updated);
        ResponseEntity<EquipmentStorageLog> response = restTemplate.postForEntity(url, updated, EquipmentStorageLog.class);
        assertNotNull(response.getBody());
    }

    @Test
    void e_delete() {
        String url = baseURL + "/delete/" + storageLog.getEquipmentStorageLogId();
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
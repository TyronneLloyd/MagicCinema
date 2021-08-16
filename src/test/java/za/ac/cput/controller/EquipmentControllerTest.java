package za.ac.cput.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.entity.ClientAccount;
import za.ac.cput.entity.Equipment;
import za.ac.cput.factory.EquipmentFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EquipmentControllerTest {
    private static Equipment equipment = EquipmentFactory.createEquipment("","",
            "","","",459.90,true);

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http:";
    @Test
    @Order(1)
    void create() {
        String url = baseURL +"/create";
        ResponseEntity<Equipment> postResponse = restTemplate.postForEntity
                (url,equipment,Equipment.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
       equipment = postResponse.getBody();
        System.out.println("Save data:" + equipment);
        assertEquals(equipment.getEquipmentID(), postResponse.getBody().getEquipmentID());

    }

    @Test
    @Order(2)
    void read() {

        String url = baseURL+"/read/" + equipment.getEquipmentID();
        System.out.println("URL read" + url);
        ResponseEntity<Equipment> responseEntity = restTemplate.getForEntity(url,Equipment.class);
        assertEquals(equipment.getEquipmentID(),responseEntity.getBody().getEquipmentID());

    }

    @Test
    @Order(3)
    void update() {
        Equipment update = new Equipment.Builder().copy(equipment).setGearCategory("Generator").build();
        String url = baseURL+"/update";
        System.out.println("URL read" + url);
        System.out.println("Updated data" + update);
        ResponseEntity<Equipment> response = restTemplate.postForEntity(url,update,Equipment.class);
        assertNotNull(response.getBody());
    }

    @Test
    @Order(4)
    void delete() {
        String url = baseURL+"/delete/" + equipment.getEquipmentID();
        System.out.println("URL deleted: " + url);
        restTemplate.delete(url);
    }

    @Test
    @Order(5)
    void getAll() {
        String url = baseURL+"/getAll/";
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null,headers);
        ResponseEntity<String> responseEntity = restTemplate.exchange
                (url, HttpMethod.GET,entity,String.class);
        System.out.println("Show All the data stored");
        System.out.println(responseEntity);
        System.out.println(responseEntity.getBody());

    }
}
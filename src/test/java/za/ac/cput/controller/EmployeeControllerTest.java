package za.ac.cput.controller;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.entity.Client;
import za.ac.cput.entity.Employee;
import za.ac.cput.factory.EmployeeFactory;

import static org.junit.jupiter.api.Assertions.*;
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeControllerTest {
    private static Employee employee = EmployeeFactory.createEmployee(
                    "Ty",
                    "Lloyd",
                    "Ty@gmail.com",
                    "215141210",
                    1,
                    "1");
    @Autowired
    private TestRestTemplate testRestTemplate;
    private final String baseURL =  "http://localhost:8080/employee";
    @Test
    void create() {
        String url = baseURL + "/create";
        ResponseEntity<Employee> postResponse = testRestTemplate.postForEntity(url, employee, Employee.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);
        employee = postResponse.getBody();
        System.out.println("Saved: " + employee);
        assertEquals(employee.getEmployeeNumber(),postResponse.getBody().getEmployeeNumber());
    }
    @Test
    void read() {
        String url = baseURL + "/read/" + employee.getEmployeeNumber();
        System.out.println("URL: " + url);
        ResponseEntity<Employee> response = testRestTemplate.getForEntity(url, Employee.class);
        assertEquals(employee.getEmployeeNumber(),response.getBody().getEmployeeNumber());
    }
    @Test
    void update() {
        Employee updated = new Employee.Builder().copy(employee).setName("Tyronne").build();
        String url = baseURL + "/update";
        System.out.println("URL: " + url);
        System.out.println("Post data: " + updated);
    }
    @Test
    void delete() {
        String url = baseURL + "/delete/" + employee.getEmployeeNumber();
        System.out.println("URL: " + url);
        testRestTemplate.delete(url);
    }
    @Test
    void getAll() {
        String url = baseURL + "/getAll";
        HttpHeaders headers = new  HttpHeaders();
        HttpEntity<String> entity  = new HttpEntity<>(null,headers);
        ResponseEntity<String> response = testRestTemplate.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("Show all: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}
package za.ac.cput.controller.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Author: Robyn White (218034555)
 * EmployeeControllerTest.java
 */


import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import za.ac.cput.entity.user.Employee;
import za.ac.cput.factory.user.EmployeeFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class EmployeeControllerTest {
    private static Employee employee = EmployeeFactory.build("Jeff","beezos","885154",50.00);

    @Autowired
    private TestRestTemplate restTemp;
    private final String BASE_URL= "http://localhost:8080/employee";




    @Test
    void A_create() {
        String url = BASE_URL + "/create";
        ResponseEntity<Employee> response = restTemp.postForEntity(url, employee, Employee.class);
        assertNotNull(response);
        assertNotNull(response.getBody());
        employee = response.getBody();
        System.out.println("Employee created: " + employee);
        assertEquals(employee.getEmployeeID(), response.getBody().getEmployeeID());
    }


    @Test
    void B_read() {
        String url = BASE_URL + "/read/" + employee.getEmployeeID();
        System.out.println("URL: " + url);
        ResponseEntity<Employee> response = restTemp.getForEntity(url, Employee.class);
        assertEquals(employee.getEmployeeID(), response.getBody().getEmployeeID());
    }


    @Test

    void C_update() {
        Employee updated = new Employee.Builder().copy(employee).setFirstName("Martha").build();
        String url = BASE_URL + "/update";
        System.out.println("Updated Employee Info: " + updated);
        ResponseEntity<Employee> response = restTemp.postForEntity(url, employee, Employee.class);
        assertNotNull(response.getBody());
    }


    @Order(5)
    @Test
    void E_delete() {
        String url = BASE_URL + "/delete/" + employee.getEmployeeID();
        restTemp.delete(url);
    }


    @Order(4)
    @Test
    void D_getAllTest() {
        String url = BASE_URL + "/getall";
        HttpHeaders header = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, header);
        ResponseEntity<String> response = restTemp.exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println("All Employees: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}
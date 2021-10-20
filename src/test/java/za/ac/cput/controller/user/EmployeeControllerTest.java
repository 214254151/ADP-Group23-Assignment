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


    @Autowired
    private TestRestTemplate restTemp;
    private final String BASE_URL= "http://localhost:8080/employee";
    private String Username = "user";
    private String Password = "password";
    private static Employee employee = EmployeeFactory.build("Jeff","beezos","885154",50.00);



    @Test
    void A_create() {
        String url = BASE_URL + "/create";
        HttpHeaders head = new HttpHeaders();
        head.setBasicAuth(Username, Password);
        ResponseEntity<Employee> response;
        HttpEntity<Employee> request = new HttpEntity<>(employee, head);
        response = restTemp.exchange(url,HttpMethod.POST, request, Employee.class);
        assertEquals(employee.getFirstName(), response.getBody().getFirstName());
        System.out.println("Employee created: " + employee);

    }


    @Test
    void B_read() {
        String url = BASE_URL + "/read/" + employee.getEmployeeID();
        HttpHeaders head = new HttpHeaders();
        head.setBasicAuth(Username, Password);
        HttpEntity<Employee> request = new HttpEntity<>(employee, head);
        ResponseEntity<Employee> response  = restTemp.exchange(url,HttpMethod.GET, request, Employee.class);
        System.out.println("URL: " + url);
        assertEquals(employee.getEmployeeID(), response.getBody().getEmployeeID());
        System.out.println(response);
    }


    @Test
    void C_update() {
        Employee updated = new Employee.Builder().copy(employee).setFirstName("Martha").build();
        String url = BASE_URL + "/update";
        HttpHeaders head = new HttpHeaders();
        head.setBasicAuth(Username, Password);
        HttpEntity<Employee> request = new HttpEntity<>(updated, head);
        ResponseEntity<Employee> response  = restTemp.exchange(url,HttpMethod.POST, request, Employee.class);
        System.out.println("Updated Employee Info: " + updated);
        assertEquals(employee.getEmployeeID(), response.getBody().getEmployeeID());
    }


    @Order(5)
    @Test
    void E_delete() {
        String url = BASE_URL + "/delete/" + employee.getEmployeeID();
        HttpHeaders head = new HttpHeaders();
        head.setBasicAuth(Username, Password);
        HttpEntity<String> entity = new HttpEntity<>(null, head);
        ResponseEntity<String> response = restTemp.exchange(url, HttpMethod.DELETE, entity, String.class);

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
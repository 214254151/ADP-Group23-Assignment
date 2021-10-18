package za.ac.cput.controller.user;

/*
 *  Name: Tye Walker
 *  Student Number: 218338562
 *  Group: 23
 *
 *  Customer Controller Test
 */

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
import za.ac.cput.entity.user.Customer;
import za.ac.cput.factory.user.CustomerFactory;

import javax.swing.*;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT) // Defined port so it uses to 8080
class CustomerControllerTest {

    private static Customer customer = CustomerFactory.build("testfirstname", "testlastname", "0821234567", "first@test.com");
    private static Customer customerTwo = CustomerFactory.build("Jane", "Hey", "0827654321", "JaneHey@gmail.com");

    private String securityUsername = "user";
    private String securityPassword = "password";

    private final String baseURL = "http://localhost:8080/customer";

    @Autowired
    private TestRestTemplate restTemplate;

    // Create Test
    @Order(1)
    @Test
    void create() {
        String url = baseURL + "/create";

        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(securityUsername, securityPassword);
        ResponseEntity<Customer> response;
        HttpEntity<Customer> request = new HttpEntity<>(customer, header);
        response = restTemplate.exchange(url, HttpMethod.POST, request, Customer.class);
        assertEquals(customer.getCustomerID(), response.getBody().getCustomerID());
        System.out.println(response.getBody());
        }

    // Read Test
    @Order(2)
    @Test
    void read() {
        String url = baseURL + "/read/" + customer.getCustomerID();
        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(securityUsername, securityPassword);
        System.out.println("URL: " + url);
        HttpEntity<Customer> request = new HttpEntity<>(null, header);
        ResponseEntity<Customer> response = restTemplate.exchange(url, HttpMethod.GET, request, Customer.class);

        assertEquals(customer.getCustomerID(), response.getBody().getCustomerID());
        System.out.println(response);
    }

    // Update Test
    @Order(3)
    @Test
    void update() {
        Customer customerUpdated = new Customer.Builder().copy(customer).lastName("Dig").builder();
        String url = baseURL + "/update";
        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(securityUsername, securityPassword);

        System.out.println("Updated Customer: " + customerUpdated);
        HttpEntity<Customer> request = new HttpEntity<>(customerUpdated, header);
        ResponseEntity<Customer> response = restTemplate.exchange(url, HttpMethod.POST, request, Customer.class);
        assertNotNull(response.getBody());
        System.out.println(response);
    }

    // Get All Test
    @Order(4)
    @Test
    void getAllTest1() {
        String url = baseURL + "/getall";
        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(securityUsername, securityPassword);
        HttpEntity<String> httpEntity = new HttpEntity<>(null, header);
        ResponseEntity<String> responseGetAll = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        System.out.println("Get All Test (Customers): ");
        System.out.println(responseGetAll);
        System.out.println(responseGetAll.getBody());
    }

    // Delete Test
    @Order(5)
    @Test
    void delete() {
        String url = baseURL + "/delete/" + customer.getCustomerID();

        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(securityUsername, securityPassword);
        HttpEntity<String> request = new HttpEntity<>(null, header);
        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.DELETE, request, String.class);
        System.out.println(response);
        System.out.println("Deleted Customer: " + customer);
        assertEquals(200, response.getStatusCodeValue());
    }

    // Get All Test
    @Order(6)
    @Test
    void getAllTest2() {
        String url = baseURL + "/getall";
        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(securityUsername, securityPassword);
        HttpEntity<String> httpEntity = new HttpEntity<>(null, header);
        ResponseEntity<String> responseGetAll = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        System.out.println("Get All Test (Customers): ");
        System.out.println(responseGetAll);
        System.out.println(responseGetAll.getBody());
    }

}















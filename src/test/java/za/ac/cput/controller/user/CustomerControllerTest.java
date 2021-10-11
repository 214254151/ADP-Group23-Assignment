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

    private static Customer customer = CustomerFactory.build("John", "Doe", "0821234567", "johndoe@gmail.com");
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
//        ResponseEntity<Customer> postResponse = restTemplate.postForEntity(url, customer, Customer.class);
//        assertNotNull(postResponse);
//        assertNotNull(postResponse.getBody());
//        customer = postResponse.getBody();
//        System.out.println("Customer Saved: " + customer);
//        assertEquals(customer.getCustomerID(), postResponse.getBody().getCustomerID());

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
        System.out.println(request.getHeaders());
        System.out.println("11111111111111");
        System.out.println(response);
        System.out.println("22222222222222");
        System.out.println(response.getStatusCode());
        System.out.println("33333333333333");
        System.out.println(response.getBody());


        assertEquals(customer.getCustomerID(), response.getBody().getCustomerID());
    }

    // Update Test
    @Order(3)
    @Test
    void update() {
        Customer customerUpdated = new Customer.Builder().copy(customer).lastName("Dig").builder();
        String url = baseURL + "/update";
        System.out.println("Updated Customer: " + customerUpdated);
        ResponseEntity<Customer> response = restTemplate.postForEntity(url, customerUpdated, Customer.class);
        assertNotNull(response.getBody());
    }

    // Delete Test
    @Order(4)
    @Test
    void delete() {
        String url = baseURL + "/delete/" + customer.getCustomerID();
        restTemplate.delete(url);
    }

    // Get All Test
    @Order(5)
    @Test
    void getAllTest() {
        String url = baseURL + "/getall";
        HttpHeaders header = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<>(null, header);
        ResponseEntity<String> responseGetAll = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        System.out.println("Get All Test (Customers): ");
        System.out.println(responseGetAll);
        System.out.println(responseGetAll.getBody());
    }

}















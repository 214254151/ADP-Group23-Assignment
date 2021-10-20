/**
 * Author: Tauriq-Allie Wilkinson (219071330)
 * Group 23
 * Supplier Controller Test
 * SupplierControllerTest.java
 */
package za.ac.cput.controller.product;

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
import za.ac.cput.entity.product.Supplier;
import za.ac.cput.factory.product.SupplierFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class SupplierControllerTest {

    private static Supplier supplier = SupplierFactory.build("Checkers", "CheckersHQ@yahoo.com", "021456891");
    private static Supplier supplierV2 = SupplierFactory.build("Aneesa's Organics", "AOrganics@gmail.com", "021 455 56874");

    private String securityUsername = "user";
    private String securityPassword = "password";

    private final String baseURL = "http://localhost:8080/supplier";

    @Autowired
    private TestRestTemplate rTemplate;


    @Order(1)
    @Test
    void create() {
        String url = baseURL + "/create";
        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(securityUsername, securityPassword);
        ResponseEntity<Supplier> postResponse;
        HttpEntity<Supplier> request = new HttpEntity<>(supplier, header);
        postResponse = rTemplate.exchange(url, HttpMethod.POST, request, Supplier.class);
        assertEquals(supplier.getSupplierID(), postResponse.getBody().getSupplierID());
        System.out.println(postResponse.getBody());
    }

    @Order(2)
    @Test
    void read() {
        String url = baseURL + "/read/" + supplier.getSupplierID();
        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(securityUsername, securityPassword);
        System.out.println("URL: " + url);
        HttpEntity<Supplier> request = new HttpEntity<>(null, header);
        ResponseEntity<Supplier> postResponse = rTemplate.exchange(url, HttpMethod.GET, request, Supplier.class);

        assertEquals(supplier.getSupplierID(), postResponse.getBody().getSupplierID());
        System.out.println(postResponse);
    }

    @Order(3)
    @Test
    void update() {
        Supplier supplierChange = new Supplier.Builder().copy(supplier).setSupplierEmail("IchangedEmail.com").build();
        String url = baseURL + "/update";
        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(securityUsername, securityPassword);

        System.out.println("Updated Supplier: " + supplierChange);
        HttpEntity<Supplier> request = new HttpEntity<>(supplierChange, header);
        ResponseEntity<Supplier> postResponse = rTemplate.exchange(url, HttpMethod.POST, request, Supplier.class);
        assertNotNull(postResponse.getBody());
        System.out.println(postResponse);
    }

    @Order(4)
    @Test
    void delete() {
        String url = baseURL + "/getAll";
        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(securityUsername, securityPassword);
        HttpEntity<String> httpE = new HttpEntity<>(null, header);
        ResponseEntity<String> postResponseGetAll = rTemplate.exchange(url, HttpMethod.GET, httpE, String.class);
        System.out.println("Get All: (Suppliers)");
        System.out.println(postResponseGetAll);
        System.out.println(postResponseGetAll.getBody());
    }

}
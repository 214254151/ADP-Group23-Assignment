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

    private static Supplier supplier = SupplierFactory.build("Checkers", "CheckersHQ@yahoo.com", "021 456 7891");
    private static Supplier supplierV2 = SupplierFactory.build("Aneesa's Organics", "AOrganics@gmail.com", "021 455 56874");
    @Autowired
    private TestRestTemplate rTemplate;
    private final String baseURL = "http://localhost:8080/supplier";

    @Order(1)
    @Test
    void create() {
        String url = baseURL + "/create";
        ResponseEntity<Supplier> postResponse = rTemplate.postForEntity(url, supplier, Supplier.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        supplier = postResponse.getBody();
        System.out.println("Supplier Saved: " + supplier);
        assertEquals(supplier.getSupplierID(), postResponse);
    }

    @Order(2)
    @Test
    void createSecond() {
        String url = baseURL + "/create";
        ResponseEntity<Supplier> postResponse = rTemplate.postForEntity(url, supplierV2, Supplier.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        supplierV2 = postResponse.getBody();
        System.out.println("Supplier Saved: " + supplierV2);
        assertEquals(supplier.getSupplierID(), postResponse);
    }

    @Order(3)
    @Test
    void read() {
        String url = baseURL + "/read/" + supplier.getSupplierID();
        System.out.println("URL: " + url);
        ResponseEntity<Supplier> response = rTemplate.getForEntity(url, Supplier.class);
        assertEquals(supplierV2.getSupplierID(), response.getBody().getSupplierID());
    }

    @Order(4)
    @Test
    void update() {
        Supplier update = new Supplier.Builder().copy(supplier).setSupplierEmail("Checkers@gmail.com").build();
        String url = baseURL + "/update";
        System.out.println("Updated Supplier: " + supplier);
        ResponseEntity<Supplier> response = rTemplate.postForEntity(url, update, Supplier.class);
        assertNotNull(response.getBody());
    }

    @Order(5)
    @Test
    void delete() {
        String url = baseURL + "/getAll";
        HttpHeaders header = new HttpHeaders();
        HttpEntity<String> httpE = new HttpEntity<>(null, header);
        ResponseEntity<String> responseGetAll = rTemplate.exchange(url, HttpMethod.GET, httpE, String.class);
        System.out.println("Get All: ");
        System.out.println(responseGetAll);
        System.out.println(responseGetAll.getBody());
    }

}
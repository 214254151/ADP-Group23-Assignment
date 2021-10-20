//BillControllerTest.java
//Test for BillController
//Author: Cameron van Wyk(219088470)

package za.ac.cput.controller.product;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import za.ac.cput.entity.product.Bill;
import za.ac.cput.factory.product.BillFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class BillControllerTest
{
    private static Bill bill = BillFactory.build(100, 15, 115);

    private String username = "user";
    private String password = "password";

    private final String baseURL = "http://localhost:8080/bill";

    @Autowired
    private TestRestTemplate restTemplate;

    @Order(1)
    @Test
    void create()
    {
        String url = baseURL + "/create";
        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(username, password);
        HttpEntity<Bill> entity = new HttpEntity<>(bill, header);
        ResponseEntity<Bill> postResponse = restTemplate.exchange(url, HttpMethod.POST, entity, Bill.class);

        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        assertEquals(postResponse.getStatusCode(), HttpStatus.OK);

        bill = postResponse.getBody();

        System.out.println("Saved Data: " + bill);
        assertEquals(bill.getBillID(), postResponse.getBody().getBillID());
    }

    @Order(2)
    @Test
    void read()
    {
        String url = baseURL + "/read/" + bill.getBillID();
        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(username, password);
        HttpEntity<Bill> entity = new HttpEntity<>(null, header);

        System.out.println("Url: " + url);
        ResponseEntity<Bill> response = restTemplate.exchange(url, HttpMethod.GET, entity, Bill.class);
        assertEquals(bill.getBillID(), response.getBody().getBillID());
    }

    @Order(3)
    @Test
    void update()
    {
        Bill update = new Bill.Builder().copy(bill).setBillID("69").build();

        String url = baseURL + "/update";
        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(username, password);
        HttpEntity<Bill> entity = new HttpEntity<>(update, header);

        System.out.println("Url: " + url);
        System.out.println("Post data: " + update);

        ResponseEntity<Bill> response = restTemplate.exchange(url, HttpMethod.POST, entity, Bill.class);
        assertNotNull(response.getBody());
    }

    @Order(4)
    @Test
    void delete()
    {
        String url = baseURL + "/delete/" + bill.getBillID();
        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(username, password);
        HttpEntity<Bill> entity = new HttpEntity<>(null, header);

        System.out.println("Url: " + url);
        restTemplate.exchange(url, HttpMethod.DELETE, entity, String.class);
    }

    @Order(5)
    @Test
    void getAll()
    {
        String url = baseURL + "/getAll";

        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(username, password);
        HttpEntity<Bill> entity = new HttpEntity<>(null, header);
        ResponseEntity<Bill> response = restTemplate.exchange(url, HttpMethod.GET, entity, Bill.class);

        System.out.println("Get all: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}
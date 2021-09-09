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
import org.springframework.test.util.AssertionErrors;
import za.ac.cput.entity.product.Bill;
import za.ac.cput.factory.product.BillFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class BillControllerTest
{
    private static Bill bill = BillFactory.build(100, 15, 115);

    @Autowired
    private TestRestTemplate restTemplate;
    private final String baseURL = "http://localhost:8080/bill";

    @Order(1)
    @Test
    void create()
    {
        String url = baseURL + "/create";
        ResponseEntity<Bill> postResponse = restTemplate.postForEntity(url, bill, Bill.class);

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

        System.out.println("Url: " + url);
        ResponseEntity<Bill> response = restTemplate.getForEntity(url, Bill.class);
        assertEquals(bill.getBillID(), response.getBody().getBillID());
    }

    @Order(3)
    @Test
    void update()
    {
        Bill update = new Bill.Builder().copy(bill).setBillID("69").build();

        String url = baseURL + "/update";
        System.out.println("Url: " + url);
        System.out.println("Post data: " + update);

        ResponseEntity<Bill> response = restTemplate.postForEntity(url, update, Bill.class);
        assertNotNull(response.getBody());
    }

    @Order(4)
    @Test
    void delete()
    {
        String url = baseURL + "/delete/" + bill.getBillID();
        System.out.println("Url: " + url);
        restTemplate.delete(url);
    }

    @Test
    void getAll()
    {
        String url = baseURL + "/getAll";

        HttpHeaders header = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<>(null, header);
        ResponseEntity<Bill> response = restTemplate.exchange(url, HttpMethod.GET, httpEntity, Bill.class);

        System.out.println("Gett all: ");
        System.out.println(response);
        System.out.println(response.getBody());
    }
}
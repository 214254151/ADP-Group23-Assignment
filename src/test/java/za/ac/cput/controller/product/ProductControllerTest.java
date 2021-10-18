package za.ac.cput.controller.product;

/**  Name: Antin Williams
 *  Student Number: 219212058
 *  Group: 23
 *
 *  Test Class for Product Controller
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
import za.ac.cput.entity.product.Product;
import za.ac.cput.entity.user.Customer;
import za.ac.cput.factory.product.ProductFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class ProductControllerTest {

    private static Product product =    ProductFactory.buildProduct("123", "456", "name1", "100");
    private static Product productTwo = ProductFactory.buildProduct("1234", "567", "name2", "1010");

    private String securityUsername = "user";
    private String securityPassword = "password";
    private final String baseURL = "http://localhost:8080/product";

    @Autowired
    private TestRestTemplate restTemplate;

    // Create Test
    @Order(1)
    @Test
    void create() {
        String url = baseURL + "/create";
        ResponseEntity<Product> postResponse = restTemplate.postForEntity(url, product, Product.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        product = postResponse.getBody();
        System.out.println("Product Saved: " + product);
        assertEquals(product.getProductId(), postResponse.getBody().getProductId());
    }

    // Create Test 2
    @Order(2)
    @Test
    void createTwo() {
        String url = baseURL + "/create";
        HttpHeaders header = new HttpHeaders();
        header.setBasicAuth(securityUsername, securityPassword);
        ResponseEntity<Product> response;
        HttpEntity<Product> request = new HttpEntity<>(product, header);
        response = restTemplate.exchange(url, HttpMethod.POST, request, Product.class);
        assertEquals(product.getProductId(), response.getBody().getProductId());
        System.out.println(response.getBody());
    }

    // Read Test
    @Order(3)
    @Test
    void read() {
        String url = baseURL + "/read/" + product.getProductId();
        System.out.println("URL: " + url);
        ResponseEntity<Product> response = restTemplate.getForEntity(url, Product.class);
        assertEquals(product.getProductId(), response.getBody().getProductId());
    }

    // Update Test
    @Order(4)
    @Test
    void update() {
        Product productUpdated = new Product.Builder().copy(product).setName("newName").Build();
        String url = baseURL + "/update";
        System.out.println("Updated Product: " + productUpdated);
        ResponseEntity<Product> response = restTemplate.postForEntity(url, productUpdated, Product.class);
        assertNotNull(response.getBody());
    }

    // Delete Test
    @Order(5)
    @Test
    void delete() {
        String url = baseURL + "/delete/" + product.getProductId();
        restTemplate.delete(url);
    }

    // Get All Test
    @Order(6)
    @Test
    void getAllTest() {
        String url = baseURL + "/getall";
        HttpHeaders header = new HttpHeaders();
        HttpEntity<String> httpEntity = new HttpEntity<>(null, header);
        ResponseEntity<String> responseGetAll = restTemplate.exchange(url, HttpMethod.GET, httpEntity, String.class);
        System.out.println("Get All Test (Products): ");
        System.out.println(responseGetAll);
        System.out.println(responseGetAll.getBody());
    }

}

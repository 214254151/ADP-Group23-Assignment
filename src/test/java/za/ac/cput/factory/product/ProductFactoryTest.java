package za.ac.cput.factory.product;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.product.Product;

import static org.junit.jupiter.api.Assertions.*;

class ProductFactoryTest {

    Product product;

    @BeforeEach
    void setUp() {
        product = ProductFactory.buildProduct("123","  123456","name", "50");
    }
    @Test
    void buildUser(){
        assertNotNull(product);
        System.out.println(product);
    }
}

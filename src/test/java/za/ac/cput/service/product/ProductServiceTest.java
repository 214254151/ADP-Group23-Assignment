/*
package za.ac.cput.service.product;
*/
/**  Name: Antin Williams
 *  Student Number: 219212058
 *  Group: 23
 *
 *  Tests for ProductService
 *//*

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.product.Product;
import za.ac.cput.factory.product.ProductFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BillServiceTest
{
    private static ProductService productService = ProductService.getProductService();
    private static Product product = ProductFactory.buildProduct("null","null","null", 115);

    @Order(1)
    @Test
    void create()
    {
        Product create = productService.create(product);
        assertEquals(create.getProductId(), product.getProductId());
        System.out.println("Created: " + create);
    }

    @Order(2)
    @Test
    void read()
    {
        Product read = productService.read(product.getProductId());
        System.out.println("Read: " + read);
    }

    @Order(3)
    @Test
    void update()
    {
        Product update = new Product.Builder().copy(product).setProductId("123").Build();
        System.out.println("Updated: " + update);
    }

    @Order(4)
    @Test
    void delete()
    {
        productService.delete(product.getProductId());
        System.out.println("Deleted: " + product.getProductId());
    }
}
*/

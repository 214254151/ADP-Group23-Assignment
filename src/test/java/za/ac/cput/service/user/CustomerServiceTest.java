package za.ac.cput.service.user;

/*
 *  Name: Tye Walker
 *  Student Number: 218338562
 *  Group: 23
 *
 *  CustomerServiceTest
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.user.Customer;
import za.ac.cput.factory.user.CustomerFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerServiceTest {
    private static CustomerService service = CustomerService.getCustomerService();
    private static Customer customer = CustomerFactory.build("John", "Wayne", "0829110073", "johnwayne@gmail.com");

    // Create test:
    @Order(1)
    @Test
    void createTest() {
        Customer created = service.create(customer);
        assertEquals(created.getCustomerID(), customer.getCustomerID());
        System.out.println("Created: " + created);
    }

    // Read Test:
    @Order(2)
    @Test
    void readTest() {
        Customer read = service.read(customer.getCustomerID());
        assertEquals(read.getCustomerID(), customer.getCustomerID());
        System.out.println("Read: " + read);
    }

    // Update Test: Email Changes
    @Order(3)
    @Test
    void updateTest() {
        Customer updateCustomer = new Customer.Builder().copy(customer).email("johnwayne73@yahoo.com").builder();
        assertNotNull(service.update(updateCustomer));
        System.out.println("Update: " + updateCustomer);
    }

    // Delete Test:
    @Order(4)
    @Test
    void deleteTest() {
        service.delete(customer.getCustomerID());
        assertNotNull(service);
    }

}















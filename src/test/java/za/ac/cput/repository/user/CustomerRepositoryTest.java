package za.ac.cput.repository.user;

/*
 *  Name: Tye Walker
 *  Student Number: 218338562
 *  Group: 23
 *
 *  Tests for CustomerRepository
 */

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.user.Customer;
import za.ac.cput.factory.user.CustomerFactory;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class CustomerRepositoryTest {
    private static CustomerRepository repository = CustomerRepository.getRepository();
    private static Customer customer = CustomerFactory.build("Tye", "Walker", "0827232556", "218338562@mycput.ac.za");

    // Create test:
    @Order(1)
    @Test
    void createTest() {
        Customer created = repository.create(customer);
        assertEquals(created.getCustomerID(), customer.getCustomerID());
        System.out.println("Created: " + created);
    }

    // Read test:
    @Order(2)
    @Test
    void readTest() {
        Customer read = repository.read(customer.getCustomerID());
        // assertEquals(read.getCustomerID(), customer.getCustomerID());
        System.out.println("Read: " + read);
    }

    // Update test: Update surname
    @Order(3)
    @Test
    void updateTest() {
        Customer updateCustomer = new Customer.Builder().copy(customer).lastName("Jones").builder();
        assertEquals(updateCustomer.getCustomerID(), customer.getCustomerID());
        System.out.println("Updated Customer: " + updateCustomer);
    }

    @Order(4)
    @Test
    void deleteTest() {
        repository.delete(customer.getCustomerID());
        assertNotNull(repository);
    }

    @Order(5)
    @Test
    void getAllTest() {
        System.out.println("Customers: \n" + repository.getAll());
    }

}


















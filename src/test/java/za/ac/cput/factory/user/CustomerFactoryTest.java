package za.ac.cput.factory.user;

/*
 *  Name: Tye Walker
 *  Student Number: 218338562
 *  Group: 23
 *
 *  CustomerFactoryTest class
 */

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.entity.user.Customer;

import static org.junit.jupiter.api.Assertions.*;

class CustomerFactoryTest {

    private CustomerFactory customerOne;
    private CustomerFactory customerTwo;
    private CustomerFactory customerThree;

    @BeforeEach
    void setUp() {
        customerOne = new CustomerFactory();
        customerTwo = new CustomerFactory();
        customerThree = customerOne;
    }

    /*
     * Object Equality:
     * This test checks if the two objects are the same
     */
    @Test
    void testEquality() {
        assertEquals(customerOne, customerThree);
    }

    /*
     * Object Identity:
     * This test checks if the two objects are the same
     * This test will pass:
     */
    @Test
    void testIdentity() {
        assertSame(customerOne, customerThree);
    }

    //This test will fail:
    @Test
    void testIdentityFail() {
        assertSame(customerOne, customerTwo);
    }

    /*
     * Timeout Test:
     * This test will fail after 5 seconds
     */
    //This test will pass:
    @Test
    @Timeout(5)
    void testTimeout() throws InterruptedException {
        Thread.sleep(4000);                         //Waits 5 seconds (5000 milliseconds)
        System.out.println("Passed!");
    }

    //This test will fail:
    @Test
    @Timeout(5)
    void testTimeoutFail() throws InterruptedException {
        Thread.sleep(6000);                         //Waits 5 seconds (5000 milliseconds)
        System.out.println("Passed!");
    }

    /*
     * Disabling test:
     * This test is disabled and will not run.
     */
    @Test
    @Disabled
    void DisabledTest() {
        assertEquals(10, 5+2+6);
    }

    //Test for CustomerFactory.build
    //This test is to check if the values are valid.
    //This test will pass
    @Test
    void validTest() {
        Customer c = CustomerFactory.build("Tye", "Walker", "0827777777", "218338562@mycput.ac.za");
        System.out.println(c);
        assertNotNull(c);
    }

    // This test WILL failed because the email is invalid.
    @Test
    void validTestFail() {
        Customer c = CustomerFactory.build("John","Doe","0123456789","John``Doe@gmail.com");
        System.out.println(c);
        assertNotNull(c);
    }




}
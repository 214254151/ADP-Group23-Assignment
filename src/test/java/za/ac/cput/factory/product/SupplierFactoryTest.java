package za.ac.cput.factory.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.entity.product.Supplier;
import za.ac.cput.entity.user.Customer;
import za.ac.cput.factory.user.CustomerFactory;

import static org.junit.jupiter.api.Assertions.*;

class SupplierFactoryTest {

    private SupplierFactory shampooSupplier, dyeSupplier, newShampSupplier;


    @BeforeEach
    void setUp() {
        shampooSupplier = new SupplierFactory();
        dyeSupplier = new SupplierFactory();
        newShampSupplier = shampooSupplier;
    }

    @Test
    void equalTest() {
        assertEquals(newShampSupplier,shampooSupplier );
    }

    @Test
    void identityTest() {
        assertSame(newShampSupplier, shampooSupplier);
    }

    @Test
    void idFailTest() {
        assertNotSame(newShampSupplier, shampooSupplier);
    }

    @Test
    @Timeout(5)
    void timeoutTest()throws InterruptedException {
        Thread.sleep(4000);
        System.out.println("Approved");

    }

    @Test
    @Disabled
    void disableTest() {
        assertNotSame(shampooSupplier, dyeSupplier);

    }

    @Test
    void createValidTest() {
        Supplier s = SupplierFactory.build("Checkers", "Checkers@yahoo.hotmail", "0214558792");
        System.out.println(s);
        assertNotNull(s);
    }

    @Test
    void createValidFailTest() {
        Supplier s = SupplierFactory.build("Anessa Brands", "Anessa458$$@yahoo.hotmail", "0214558792");
        System.out.println(s);
        assertNotNull(s);
    }
}
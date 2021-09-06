package za.ac.cput.factory.product;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import za.ac.cput.entity.product.Bill;

import static org.junit.jupiter.api.Assertions.*;

class BillFactoryTest
{
    private Bill billA, billB, billC;

    @BeforeEach
    void setUp()
    {
        billA = null;
        billB = null;
        billC = billA;
    }

    @Test
    void testIdentity()
    {
        assertSame(billA, billB);
    }

    @Test
    void testEquality()
    {
        assertEquals(billA, billC);
    }

    @Test
    @Disabled
    void DisabledTest()
    {
        assertNotNull(billC);
    }

    @Test
    void validTest()
    {
        Bill bill = BillFactory.build(100, 15, 155);
        System.out.println(bill);
        assertNotNull(bill);
    }
}
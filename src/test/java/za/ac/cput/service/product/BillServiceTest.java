//BillServiceTest.java
//Test for BillService
//Author: Cameron van Wyk(219088470)

package za.ac.cput.service.product;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.product.Bill;
import za.ac.cput.factory.product.BillFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BillServiceTest
{
    private static BillService service = BillService.getBillService();
    private static Bill bill = BillFactory.build(100, 15, 115);

    @Order(1)
    @Test
    void create()
    {
        Bill create = service.create(bill);
        assertEquals(create.getBillID(), bill.getBillID());
        System.out.println("Created: " + create);
    }

    @Order(2)
    @Test
    void read()
    {
        Bill read = service.read(bill.getBillID());
        System.out.println("Read: " + read);
    }

    @Order(3)
    @Test
    void update()
    {
        Bill update = new Bill.Builder().copy(bill).setBillID("1738").build();
        System.out.println("Updated: " + update);
    }

    @Order(4)
    @Test
    void delete()
    {
        service.delete(bill.getBillID());
        System.out.println("Deleted: " + bill.getBillID());
    }
}
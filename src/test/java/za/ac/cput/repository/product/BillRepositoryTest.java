package za.ac.cput.repository.product;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import za.ac.cput.entity.product.Bill;
import za.ac.cput.factory.product.BillFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BillRepositoryTest
{
    private static BillRepository repository = BillRepository.getRepository();
    private static Bill bill = BillFactory.build(100, 15, 115);

    @Order(1)
    @Test
    void create()
    {
        Bill create = repository.create(bill);
        System.out.println("Created: " + create);
    }

    @Order(2)
    @Test
    void read()
    {
        Bill read = repository.read(bill.getBillID());
        System.out.println("Read: " + read);
    }

    @Order(3)
    @Test
    void update()
    {
        Bill update = new Bill.Builder().copy(bill).setBillID("21").build();
        System.out.println("Updated: " + update);
    }

    @Order(4)
    @Test
    void delete()
    {
        repository.delete(bill.getBillID());
        System.out.println("Deleted: " + bill.getBillID() + " ");
    }

    @Order(5)
    @Test
    void getAll()
    {
        System.out.println("Bills: \n" + repository.getAll());
    }
}
package za.ac.cput.service.product;

import za.ac.cput.entity.product.Bill;
import za.ac.cput.repository.product.BillRepository;

import java.util.Set;

public class BillService implements IBillService
{
    private static BillService billService;
    private BillRepository billRepository;

    private BillService()
    {
        this.billRepository = BillRepository.getRepository();
    }

    public static BillService getBillService()
    {
        if (billService == null)
        {
            billService = new BillService();
        }

        return billService;
    }

    @Override
    public Bill create(Bill bill)
    {
        return this.billRepository.create(bill);
    }

    @Override
    public Bill read(String s)
    {
        return this.billRepository.read(s);
    }

    @Override
    public Bill update(Bill bill)
    {
        return this.billRepository.update(bill);
    }

    @Override
    public void delete(String s)
    {
        this.billRepository.delete(s);
    }

    @Override
    public Set<Bill> getAll() {
        return this.billRepository.getAll();
    }
}

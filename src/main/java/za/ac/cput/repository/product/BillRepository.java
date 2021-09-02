package za.ac.cput.repository.product;

import za.ac.cput.entity.product.Bill;

import java.util.HashSet;
import java.util.Set;

public class BillRepository implements IBillRepository
{
    private static BillRepository repository = null;
    private Set<Bill> billDB;

    private BillRepository()
    {
        this.billDB = new HashSet<>();
    }

    public static BillRepository getRepository()
    {
        if (repository == null)
        {
            repository = new BillRepository();
        }

        return repository;
    }

    @Override
    public Bill create(Bill bill)
    {
        this.billDB.add(bill);
        return bill;
    }

    @Override
    public Bill read(String billID)
    {
        for (Bill b: billDB)
        {
            if (b.getBillID().equals(billID))
                return b;
        }
        return null;
    }

    @Override
    public Bill update(Bill bill)
    {
        Bill oldBill = read(bill.getBillID());
        if (oldBill != null)
        {
            billDB.remove(oldBill);
            billDB.add(bill);
            return bill;
        }
        return null;
    }

    @Override
    public void delete(String billID)
    {
        Bill deleteBill = read(billID);
        if (deleteBill == null)
        {
            System.out.println("Bill is null.");
        }
        else
        {
            billDB.remove(deleteBill);
            System.out.println("Bill removed.");
        }
    }

    @Override
    public Set<Bill> getAll()
    {
        return billDB;
    }
}

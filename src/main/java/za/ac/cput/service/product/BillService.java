//BillService.java
//Class for Bill Service
//Author: Cameron van Wyk(219088470)

package za.ac.cput.service.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.product.Bill;
import za.ac.cput.repository.product.BillRepository;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class BillService implements IBillService
{
   @Autowired
    private BillRepository repository;

   @Override
    public Bill create(Bill bill)
   {
       return this.repository.save(bill);
   }

   @Override
    public Bill read(String billID)
   {
       return this.repository.findById(billID).orElse(null);
   }

   @Override
    public Bill update(Bill bill)
   {
       if (this.repository.existsById(bill.getBillID()))
           return this.repository.save(bill);
       else return null;
   }

   @Override
    public void delete(String billID)
   {
       this.repository.deleteById(billID);
   }

   @Override
    public Set<Bill> getAll()
   {
       return this.repository.findAll().stream().collect(Collectors.toSet());
   }
}

package za.ac.cput.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.product.Bill;
import za.ac.cput.factory.product.BillFactory;
import za.ac.cput.service.product.BillService;

import java.util.Set;

@RestController
@RequestMapping("/bill")
public class BillController
{
    @Autowired
    private BillService billService;

    @PostMapping("/create")
    public Bill create(@RequestBody Bill bill)
    {
        Bill newBill = BillFactory.build(bill.getSubTotal(), bill.getTax(), bill.getTotal());
        return billService.create(newBill);
    }

    @GetMapping("/read/{id}")
    public Bill read(@PathVariable String id)
    {
        return billService.read(id);
    }

    @PostMapping("/update")
    public Bill update(@RequestBody Bill bill)
    {
        return billService.update(bill);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id)
    {
        billService.delete(id);
    }

    @GetMapping("/getAll")
    public Set<Bill> getAll()
    {
        return billService.getAll();
    }
}

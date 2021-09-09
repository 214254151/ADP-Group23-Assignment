
/**
 * Author: Tauriq-Allie Wilkinson (219071330)
 * Group 23
 * Supplier Controller
 * SupplierController.java
 */

package za.ac.cput.controller.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.product.Supplier;
import za.ac.cput.factory.product.SupplierFactory;
import za.ac.cput.service.product.SupplierService;

import java.util.Set;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    @Autowired
    private SupplierService supplierService;

    @PostMapping("/create")
    public Supplier create(@RequestBody Supplier supplier)
    {
        Supplier newSupplier = SupplierFactory.build(supplier.getSupplierName(), supplier.getSupplierEmail(), supplier.getSupplierContact());
        return supplierService.create(newSupplier);
    }

    @GetMapping("/read/{id}")
    public Supplier read(@PathVariable String id) {
        return supplierService.read(id);
    }

    @PostMapping("/update")
    public Supplier update(@RequestBody Supplier supplier) {
        return supplierService.update(supplier);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        supplierService.delete(id);
    }

    @GetMapping("/getall")
    public Set<Supplier> getAll() {
        return supplierService.getAll();
    }

}

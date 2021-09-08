
/**
 * Author: Tauriq-Allie Wilkinson (219071330)
 * Group 23
 * Supplier Service
 * SupplierService.java
 */

package za.ac.cput.service.product;


import org.springframework.stereotype.Service;
import za.ac.cput.entity.product.Supplier;
import za.ac.cput.repository.product.SupplierRepository;

import java.util.Set;

@Service
public class SupplierService implements ISupplierService {

    private static SupplierService supplierService;
    private SupplierRepository supplierRepository;

    private SupplierService(){
        this.supplierRepository = SupplierRepository.getRepository();

    }

    public static SupplierService getSupplierService(){
        if(supplierService ==null){
            supplierService = new SupplierService();
        }
        return supplierService;
    }


    @Override
    public Supplier create(Supplier supplier) {
        return this.supplierRepository.create(supplier);
    }

    @Override
    public Supplier read(String supplierID) {
        return this.supplierRepository.read(supplierID);
    }

    @Override
    public Supplier update(Supplier supplier) {
        return this.supplierRepository.update(supplier);
    }

    @Override
    public void delete(String supplierID) {
        this.supplierRepository.delete(supplierID);

    }

    @Override
    public Set<Supplier> getAll() {
        return this.supplierRepository.getAll();
    }
}

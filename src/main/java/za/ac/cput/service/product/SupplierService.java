
/**
 * Author: Tauriq-Allie Wilkinson (219071330)
 * Group 23
 * Supplier Service
 * SupplierService.java
 */

package za.ac.cput.service.product;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.product.Supplier;
import za.ac.cput.repository.product.SupplierRepository;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class SupplierService implements ISupplierService {

    private static SupplierService supplierService = null;

    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public Supplier create(Supplier supplier) {
        return this.supplierRepository.save(supplier);
    }

    @Override
    public Supplier read(String supplierID) {
        return this.supplierRepository.findById(supplierID).orElse(null);
    }

    @Override
    public Supplier update(Supplier supplier) {
        if( this.supplierRepository.existsById(supplier.getSupplierID())) {
            return this.supplierRepository.save(supplier);
        }
        return null;
    }

    @Override
    public void delete(String supplierID) {
        this.supplierRepository.deleteById(supplierID);
        if( this.supplierRepository.existsById(supplierID)){
            System.out.println("Deleted");
        }else{
            System.out.println("Not Found");
        }

    }

    @Override
    public Set<Supplier> getAll() {
        return this.supplierRepository.findAll().stream().collect(Collectors.toSet());
    }

    public Set<Supplier> searchName(String searchValue) {
        Set<Supplier> getAllSuppliers = getAll();
        Set<Supplier> resultSet = new HashSet<>();
        for (Supplier s : getAllSuppliers) {
            String lowercaseC = s.getSupplierName().toLowerCase();
            String lowerCaseS = searchValue.toLowerCase();

            if (lowercaseC.contains(lowerCaseS)) {
                resultSet.add(s);
            }
        }
        return resultSet;
    }


    public Set<Supplier> searchEmail(String searchValue) {
        Set<Supplier> getAllSuppliers = getAll();
        Set<Supplier> resultSet = new HashSet<>();
        System.out.println(searchValue);
        for (Supplier s : getAllSuppliers) {
            String lowercaseC = s.getSupplierEmail().toLowerCase();
            String lowerCaseS = searchValue.toLowerCase();

            if (lowercaseC.contains(lowerCaseS)) {
                resultSet.add(s);
            }
        }
        return resultSet;
    }




    public Set<Supplier> searchContact(String searchValue) {
        Set<Supplier> getAllSuppliers = getAll();
        Set<Supplier> resultSet = new HashSet<>();
        System.out.println(searchValue);
        for (Supplier s : getAllSuppliers) {
            String lowercaseC = s.getSupplierContact().toLowerCase();
            String lowerCaseS = searchValue.toLowerCase();

            if (lowercaseC.contains(lowerCaseS)) {
                resultSet.add(s);
            }
        }
        return resultSet;
    }

}

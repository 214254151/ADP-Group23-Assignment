/**
 * Author: Tauriq-Allie Wilkinson (219071330)
 * Group 23
 * Supplier Repository
 * SupplierRepository.java
 */


package za.ac.cput.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.product.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier,String> {

}

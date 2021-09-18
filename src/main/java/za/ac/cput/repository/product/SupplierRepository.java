package za.ac.cput.repository.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.product.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier,String> {

}

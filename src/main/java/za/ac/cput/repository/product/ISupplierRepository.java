package za.ac.cput.repository.product;

import za.ac.cput.entity.product.Supplier;
import za.ac.cput.repository.IRepository;


import java.util.Set;

public interface ISupplierRepository extends IRepository<Supplier, String> {


    public Set<Supplier> getAll();
}

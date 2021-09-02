package za.ac.cput.repository.product;

import za.ac.cput.entity.product.Bill;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IBillRepository extends IRepository
{
    Set<Bill> getAll();
}

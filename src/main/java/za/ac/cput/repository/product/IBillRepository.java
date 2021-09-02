//IBillRepository.java
//Interface for Bill Repository
//Author: Cameron van Wyk(219088470)

package za.ac.cput.repository.product;

import za.ac.cput.entity.product.Bill;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IBillRepository extends IRepository<Bill, String>
{
    Set<Bill> getAll();
}

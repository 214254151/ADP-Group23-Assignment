//IBillService.java
//Interface for Bill Service
//Author: Cameron van Wyk(219088470)

package za.ac.cput.service.product;

import za.ac.cput.entity.product.Bill;
import za.ac.cput.service.IService;

import java.util.Set;

public interface IBillService extends IService<Bill, String>
{
    Set<Bill> getAll();
}

/**
 * Author: Tauriq-Allie Wilkinson (219071330)
 * Group 23
 * Supplier Service Interface
 * ISupplierService.java
 */

package za.ac.cput.service.product;

import za.ac.cput.entity.product.Supplier;
import za.ac.cput.service.IService;

import java.util.Set;

public interface ISupplierService extends IService<Supplier, String> {
     Set<Supplier> getAll();
}

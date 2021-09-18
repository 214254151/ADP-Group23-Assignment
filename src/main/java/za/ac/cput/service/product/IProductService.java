package za.ac.cput.service.product;

import za.ac.cput.entity.product.Product;
import za.ac.cput.service.IService;

import java.util.Set;

public interface IProductService extends IService<Product, String> {
    Set<Product> getAll();
}

package za.ac.cput.controller.product;

/**  Name: Antin Williams
 *  Student Number: 219212058
 *  Group: 23
 *
 *  Class for Product Controller
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.product.Product;
import za.ac.cput.factory.product.ProductFactory;
import za.ac.cput.service.product.ProductService;

import java.util.Set;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/create")
    public Product create(@RequestBody Product product) {
        Product newProduct = ProductFactory.buildProduct(product.getProductId(), product.getSupplierId(), product.getName(), product.getPrice());
        return productService.create(newProduct);
    }

    @GetMapping("/read/{id}")
    public Product read(@PathVariable String id) {
        return productService.read(id);
    }

    @PostMapping("/update")
    public Product update(@RequestBody Product product) {
        return productService.update(product);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        productService.delete(id);
    }

    @GetMapping("/getall")
    public Set<Product> getAll() {
        return productService.getAll();
    }
}

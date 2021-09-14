package za.ac.cput.repository.product;

/**  Name: Antin Williams
 *  Student Number: 219212058
 *  Group: 23
 *
 *  Interface for ProductRepository
 */
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.product.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

}

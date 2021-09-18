package za.ac.cput.factory.product;

import za.ac.cput.entity.product.Product;

public class ProductFactory {
    public static Product buildProduct (
            String productId,
            String supplierId,
            String name,
            double price
    ) {
        return new Product.Builder()
                .setProductId(productId)
                .setSupplierId(supplierId)
                .setName(name)
                .setPrice(price)
                .Build();
    }
}

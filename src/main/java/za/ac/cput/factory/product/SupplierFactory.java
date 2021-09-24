/**
 * Author: Tauriq-Allie Wilkinson (219071330)
 * Group 23
 * Supplier Factory
 * SupplierFactory.java
 */

package za.ac.cput.factory.product;

import za.ac.cput.entity.product.Supplier;
import za.ac.cput.util.GenericHelper;

public class SupplierFactory {

    public static Supplier build( String supplierName, String supplierEmail, String supplierContact){

        String supplierID = GenericHelper.generateID();

        if (!GenericHelper.validateEmail(supplierEmail)) {
            System.out.println("Please Insert a Valid Email");
            return null;
        }
        if (supplierName.isEmpty() || supplierContact.isEmpty() || supplierEmail.isEmpty()) {
            System.out.println("Please Enter All Information");
            return null;
        }

        Supplier supplier = new Supplier.Builder().setSupplierID(supplierID).setSupplierName(supplierName)
                .setSupplierEmail(supplierEmail).setSupplierContact(supplierContact).build();

        return new Supplier.Builder().setSupplierID(supplierID).setSupplierName(supplierName)
                .setSupplierEmail(supplierEmail).setSupplierContact(supplierContact).build();
    }
}

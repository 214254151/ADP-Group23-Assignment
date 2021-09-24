
///**
// * Author: Tauriq-Allie Wilkinson (219071330)
// * Group 23
// * Supplier Service Test
// * SupplierServiceTest.java
// */
//package za.ac.cput.service.product;
//
//import org.junit.jupiter.api.MethodOrderer;
//import org.junit.jupiter.api.Order;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import za.ac.cput.entity.product.Supplier;
//import za.ac.cput.factory.product.SupplierFactory;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
//class SupplierServiceTest {
//    private static  SupplierService supServ = SupplierService.getRepository();
//   private static Supplier supplier = SupplierFactory.build("Aneesa's Organics", "AOrganics@gmail.com","021 455 56874");
//
//   @Order(1)
//   @Test
//   void create(){
//       Supplier c = supServ.create(supplier);
//       assertEquals(c.getSupplierID(), supplier.getSupplierID());
//       System.out.println("Existing: " + c);
//
//   }
//
//   @Order(2)
//   @Test
//   void read(){
//
//       Supplier r = supServ.read(supplier.getSupplierID());
//       assertEquals(r.getSupplierID(), supplier.getSupplierID());
//       System.out.println("Read: " + r);
//   }
//
//    @Order(3)
//    @Test
//    void update(){
//
//        Supplier u = new Supplier.Builder().copy(supplier).setSupplierContact("021 242 5671").build();
//        assertEquals(u.getSupplierContact(), supplier.getSupplierContact());
//        System.out.println("Update: " + u);
//    }
//
//    @Order(4)
//    @Test
//    void delete(){
//
//        supServ.delete(supplier.getSupplierID());
//        System.out.println("Deleted: " + supplier.getSupplierID());
//    }
//
//
//}
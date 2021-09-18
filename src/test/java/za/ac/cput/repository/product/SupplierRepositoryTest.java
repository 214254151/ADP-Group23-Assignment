///**
// * Author: Tauriq-Allie Wilkinson (219071330)
// * Group 23
// * Supplier Repository Test
// * SupplierRepositoryTest.java
// */
//
// package za.ac.cput.repository.product;
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
//class SupplierRepositoryTest {
//
//   private static  SupplierRepository supRepo = SupplierRepository.getRepository();
//   private static Supplier supplier = SupplierFactory.build("Aneesa's Organics", "AOrganics@gmail.com","021 455 56874");
//
//   @Order(1)
//   @Test
//   void createTest(){
//       Supplier c = supRepo.create(supplier);
//       assertEquals(c.getSupplierID(), supplier.getSupplierID());
//       System.out.println("Existing: " + c);
//
//   }
//
//   @Order(2)
//   @Test
//   void readTest(){
//
//       Supplier r = supRepo.read(supplier.getSupplierID());
//       assertEquals(r.getSupplierID(), supplier.getSupplierID());
//       System.out.println("Read: " + r);
//   }
//
//    @Order(3)
//    @Test
//    void updateTest(){
//
//        Supplier u = new Supplier.Builder().copy(supplier).setSupplierContact("021 242 5671").build();
//        assertEquals(u.getSupplierContact(), supplier.getSupplierContact());
//        System.out.println("Update: " + u);
//    }
//
//    @Order(4)
//    @Test
//    void deleteTest(){
//
//        supRepo.deleteById(supplier.getSupplierID());
//        assertEquals(r.getSupplierID(), supplier.getSupplierID());
//        System.out.println("Read: " + r);
//    }
//
//    @Order(5)
//    @Test
//    void getTest(){
//
//        System.out.println("Supplier: \n"  + supRepo.getAll());
//    }
//
//}
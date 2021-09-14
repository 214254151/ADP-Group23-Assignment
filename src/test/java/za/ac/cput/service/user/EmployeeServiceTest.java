package za.ac.cput.service.user; /**
 * Author: Robyn White (218034555)
 * EmployeeServiceTest.java
 */


import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import za.ac.cput.entity.user.Employee;
import za.ac.cput.factory.user.EmployeeFactory;



import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest
class EmployeeServiceTest {

    @Autowired
    private EmployeeService service;
    private static Employee employee = EmployeeFactory.build("Jesi","Lingard","021785468", 15.00);

    @Order(1)
    @Test
    void create() {
        Employee created = service.create(employee);
        assertEquals(created.getEmployeeID(),employee.getEmployeeID());
        System.out.println("Create: " + created);
    }
    @Order(2)
    @Test
    void read() {
        Employee  read = service.read(employee.getEmployeeID());
        assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Order(3)
    @Test
    void update() {
        Employee old = service.read("b1df9796-385a-4054-beae-5fe7fa667ecd");
        Employee updated = new Employee.Builder().copy(employee).setFirstName("Jesse").build();
        assertNotNull(service.update(updated));
        System.out.println("Update: " + updated);
    }

    @Order(5)
    @Test
    void delete() {
        service.delete(employee.getEmployeeID());
        assertNotNull(service);
    }

    @Order(4)
    @Test
    void getAll(){
        System.out.println("All Employees: ");
        System.out.println(service.getAll());

    }
}
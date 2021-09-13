package za.ac.cput.factory.user;

import org.junit.jupiter.api.Test;
import za.ac.cput.entity.user.Employee;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeFactoryTest {

    @Test
    void testCorrectData(){
        Employee e = EmployeeFactory.build("Luke","Shaw","0216549132",45.00);
        System.out.println(e);
        assertNotNull(e);
    }

    @Test
    void testIncorrectData(){
        Employee e = EmployeeFactory.build("Victor","Lindelof","0215855105", 55.00);
        System.out.println(e);
        assertNotNull(e);
    }

    @Test
    void testEquality(){

        Employee e = EmployeeFactory.build("Harry","Maguire","0216549132", 20.00);
        assertEquals(e,e);
    }

    @Test
    void testIdentity(){
        Employee e = EmployeeFactory.build("Bruno","Fernandes","0216549132", 20.00);
        assertSame(e,e);
    }
}
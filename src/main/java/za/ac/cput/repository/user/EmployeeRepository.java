/**
 * Author: Robyn White (218034555)
 * EmployeeRepository.java
 */
package za.ac.cput.repository.user;

import za.ac.cput.entity.user.Employee;

import java.util.HashSet;
import java.util.Set;

public class EmployeeRepository implements IEmployeeRepository{
    private static EmployeeRepository repository = null;
    private Set<Employee> employeeDB;

    private EmployeeRepository() {
        employeeDB = new HashSet<>();
    }

    public static EmployeeRepository getRepository() {
        if(repository == null)
        {
            repository = new EmployeeRepository();
        }
        return repository;
    }


    @Override
    public Employee create(Employee supplier) {
        this.employeeDB.add(supplier);
        return supplier;
    }



    @Override
    public Employee read(String employeeID) {
        for (Employee e: employeeDB)
            if (e.getEmployeeID().equals(employeeID))
            {
                return e;
            }
        return null;
    }


    @Override
    public Employee update(Employee supplier) {
        Employee firstEmployee = read(supplier.getEmployeeID());
        if (firstEmployee != null) {
            employeeDB.remove(firstEmployee);
            employeeDB.add(supplier);
            return supplier;
        }
        return null;
    }


    @Override
    public void delete(String employeeID) {
        Employee delete = read(employeeID);
        if (delete == null)
            System.out.println("Employee does not exist");

        employeeDB.remove(delete);
        System.out.println("Employee has been deleted");
    }

    public Set<Employee> getAll() {
        return employeeDB;
    }
}

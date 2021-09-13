/**
 * Author: Robyn White (218034555)
 * EmployeeService.java
 */
package za.ac.cput.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.user.Employee;
import za.ac.cput.repository.user.EmployeeRepository;


import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeService implements IEmployeeService {
    @Autowired
    private EmployeeRepository repository;


    @Override
    public Employee create(Employee employee) {
        return this.repository.save(employee);
    }

    @Override
    public Employee read(String employeeID) {
        return this.repository.findById(employeeID).orElse(null);
    }

    @Override
    public Employee update(Employee employee) {
        if(this.repository.existsById(employee.getEmployeeID()))
            return this.repository.save(employee);
        return null;
    }

    @Override
    public void delete(String employeeID) {
        this.repository.deleteById(employeeID);
        if (this.repository.existsById(employeeID)) {
            System.out.println("Deleted");
        } else {
            System.out.println("Not found.");
        }
    }

    @Override
    public Set<Employee> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }



}

/**
 * Author: Robyn White (218034555)
 * IEmployeeRepository.java
 */
package za.ac.cput.repository.user;

import za.ac.cput.entity.user.Employee;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IEmployeeRepository extends IRepository<Employee, String> {
    public Set<Employee> getAll();
}

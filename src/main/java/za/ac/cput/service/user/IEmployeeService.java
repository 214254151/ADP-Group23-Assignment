/**
 * Author: Robyn White (218034555)
 * IEmployeeService.java
 */
package za.ac.cput.service.user;

import za.ac.cput.entity.user.Employee;
import za.ac.cput.service.IService;

import java.util.Set;

public interface IEmployeeService extends IService<Employee, String> {
    public Set<Employee> getAll() ;
}

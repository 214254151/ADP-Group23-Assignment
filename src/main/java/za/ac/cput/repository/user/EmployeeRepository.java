/**
 * Author: Robyn White (218034555)
 * EmployeeRepository.java
 */
package za.ac.cput.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.user.Employee;

import java.util.HashSet;
import java.util.Set;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

}

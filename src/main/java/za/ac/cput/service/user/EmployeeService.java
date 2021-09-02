/**
 * Author: Robyn White (218034555)
 * EmployeeService.java
 */
package za.ac.cput.service.user;

import za.ac.cput.entity.user.Employee;
import za.ac.cput.repository.user.EmployeeRepository;


import java.util.Set;

public class EmployeeService implements IEmployeeService {
    private static EmployeeService service;
    private EmployeeRepository repository;

    private EmployeeService()
    {
        this.repository = EmployeeRepository.getRepository();
    }

    public static EmployeeService getService()
    {
        if(service == null)
        {
            service = new EmployeeService();
        }
        return service;
    }

    @Override
    public Employee create(Employee employee) {
        return this.repository.create(employee);
    }

    @Override
    public Employee read(String e) {
        return this.repository.read(e);
    }


    @Override
    public Employee update(Employee employee) {
        return this.repository.update(employee);
    }


    @Override
    public void delete(String e) {
        this.repository.delete(e);
    }


    @Override
    public Set<Employee> getAll() {
        return this.repository.getAll();
    }

}

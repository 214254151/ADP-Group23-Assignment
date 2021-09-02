/**
 * Author: Robyn White (218034555)
 * EmployeeController.java
 */
package za.ac.cput.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.user.Employee;
import za.ac.cput.factory.user.EmployeeFactory;
import za.ac.cput.service.user.EmployeeService;

import java.util.Set;

public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;


    @PostMapping("/create")
    public Employee create(@RequestBody Employee employee)
    {
        Employee newEmployee =  EmployeeFactory.build(employee.getFirstName(),employee.getLastName(),
                employee.getPhoneNumber(),employee.getEmployeeRate());
        return employeeService.create(newEmployee);
    }


    @GetMapping("/read/{id}")
    public Employee read(@PathVariable String id) {
        return employeeService.read(id);
    }


    @PostMapping("/update")
    public Employee update(@RequestBody Employee employee) {
        return employeeService.update(employee);
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        employeeService.delete(id);
    }



    @GetMapping("/getall")
    public Set<Employee> getAll() {
        return employeeService.getAll();
    }

}

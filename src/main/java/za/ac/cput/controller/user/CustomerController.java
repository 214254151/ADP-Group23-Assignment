package za.ac.cput.controller.user;

/*
 *  Name: Tye Walker
 *  Student Number: 218338562
 *  Group: 23
 *
 *  CustomerService
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.user.Customer;
import za.ac.cput.factory.user.CustomerFactory;
import za.ac.cput.service.user.CustomerService;

import java.util.Set;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/create")
    public Customer create(@RequestBody Customer customer) {
        Customer newCustomer = CustomerFactory.build(customer.getFirstName(), customer.getLastName(), customer.getContactNumber(), customer.getEmail());
        return customerService.create(newCustomer);
    }

    @GetMapping("/read/{id}")
    public Customer read(@PathVariable String id) {
        return customerService.read(id);
    }

    @PostMapping("/update")
    public Customer update(@RequestBody Customer customer) {
        return customerService.update(customer);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable String id) {
        customerService.delete(id);
    }

    @GetMapping("/getall")
    public Set<Customer> getAll() {
        return customerService.getAll();
    }

    @GetMapping("/search/firstname/{searchTerm}")
    public Set<Customer> searchByFirstName(@PathVariable String searchTerm) {
        return customerService.searchFirstName(searchTerm);
    }

    @GetMapping("/search/lastname/{searchTerm}")
    public Set<Customer> searchByLastName(@PathVariable String searchTerm) {
        return customerService.searchLastName(searchTerm);
    }

    @GetMapping("/search/contactnumber/{searchTerm}")
    public Set<Customer> searchByContactNumber(@PathVariable String searchTerm) {
        return customerService.searchContactNumber(searchTerm);
    }

    @GetMapping("/search/email/{searchTerm}")
    public Set<Customer> searchByEmail(@PathVariable String searchTerm) {
        return customerService.searchEmail(searchTerm);
    }



}

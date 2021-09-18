package za.ac.cput.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.user.Customer;
import za.ac.cput.repository.user.CustomerRepository;

import java.util.Set;
import java.util.stream.Collectors;

/*
 *  Name: Tye Walker
 *  Student Number: 218338562
 *  Group: 23
 *
 *  CustomerService
 */

@Service
public class CustomerService implements ICustomerService {
    private static CustomerService service = null;

    @Autowired
    private CustomerRepository repository;

    @Override
    public Customer create(Customer customer) {
        return this.repository.save(customer);
    }

    @Override
    public Customer read(String customerID) {
        return this.repository.findById(customerID).orElse(null);
    }

    @Override
    public Customer update(Customer customer) {
        if (this.repository.existsById(customer.getCustomerID())) {
            return this.repository.save(customer);
        }
        return null;
    }

    @Override
    public void delete(String customerID) {
        this.repository.deleteById(customerID);
        if (this.repository.existsById(customerID)) {
            System.out.println("Deleted");
        } else {
            System.out.println("Not found.");
        }
    }

    @Override
    public Set<Customer> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}

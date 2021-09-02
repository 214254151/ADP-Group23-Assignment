package za.ac.cput.service.user;

import org.springframework.stereotype.Service;
import za.ac.cput.entity.user.Customer;
import za.ac.cput.repository.user.CustomerRepository;

import java.util.Set;

/*
 *  Name: Tye Walker
 *  Student Number: 218338562
 *  Group: 23
 *
 *  CustomerService
 */

@Service
public class CustomerService implements ICustomerService {

    private static CustomerService customerService;
    private CustomerRepository customerRepository;

    private CustomerService() {
        this.customerRepository = CustomerRepository.getRepository();
    }

    public static CustomerService getCustomerService() {
        if (customerService == null) {
            customerService = new CustomerService();
        }
        return customerService;
    }

    @Override
    public Customer create(Customer customer) {
        return this.customerRepository.create(customer);
    }

    @Override
    public Customer read(String customerID) {
        return this.customerRepository.read(customerID);
    }

    @Override
    public Customer update(Customer customer) {
        return this.customerRepository.update(customer);
    }

    @Override
    public void delete(String customerID) {
        this.customerRepository.delete(customerID);
    }

    @Override
    public Set<Customer> getAll() {
        return this.customerRepository.getAll();
    }
}

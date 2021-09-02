package za.ac.cput.repository.user;

import za.ac.cput.entity.user.Customer;

import java.util.HashSet;
import java.util.Set;

/*
 *  Name: Tye Walker
 *  Student Number: 218338562
 *  Group: 23
 *
 *  CustomerService
 */

public class CustomerRepository  implements ICustomerRepository {
    private static CustomerRepository repository = null;
    private Set<Customer> customerDB;

    private CustomerRepository() {
        this.customerDB = new HashSet<>();
    }

    public static CustomerRepository getRepository() {
        if (repository == null) {
            repository = new CustomerRepository();
        }
        return repository;
    }

    @Override
    public Customer create(Customer customer) {
        this.customerDB.add(customer);
        return customer;
    }

    @Override
    public Customer read(String customerID) {
        for (Customer c : customerDB) {
            if (c.getCustomerID().equals(customerID)) {
                return c;
            }
        }
        return null;
    }

    @Override
    public Customer update(Customer customer) {
        Customer firstCustomer = read(customer.getCustomerID());
        if (firstCustomer != null) {
            customerDB.remove(firstCustomer);
            customerDB.add(customer);
            return customer;
        }
        return null;
    }

    @Override
    public void delete(String customerID) {
        Customer deleteCustomer = read(customerID);
        if (deleteCustomer == null) {
            System.out.println("Customer is null.");
        }
        customerDB.remove(deleteCustomer);
        System.out.println("Customer removed.");
    }

    @Override
    public Set<Customer> getAll() {
        return customerDB;
    }
}

package za.ac.cput.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.user.Customer;
import za.ac.cput.repository.user.CustomerRepository;

import java.util.HashSet;
import java.util.Locale;
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
            System.out.println("Found");
            return this.repository.save(customer);
        } else {
            System.out.println("Not Found");
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

    public Set<Customer> searchFirstName(String searchValue) {
        Set<Customer> getAllCustomers = getAll();
        Set<Customer> resultSet = new HashSet<>();
        for (Customer c : getAllCustomers) {
            String lowercaseC = c.getFirstName().toLowerCase();
            String lowerCaseS = searchValue.toLowerCase();

            if (lowercaseC.contains(lowerCaseS)) {
                resultSet.add(c);
            }
        }
        return resultSet;
    }

    public Set<Customer> searchLastName(String searchValue) {
        Set<Customer> getAllCustomers = getAll();
        Set<Customer> resultSet = new HashSet<>();
        System.out.println(searchValue);
        for (Customer c : getAllCustomers) {
            String lowercaseC = c.getLastName().toLowerCase();
            String lowerCaseS = searchValue.toLowerCase();

            if (lowercaseC.contains(lowerCaseS)) {
                resultSet.add(c);
            }
        }
        return resultSet;
    }

    public Set<Customer> searchContactNumber(String searchValue) {
        Set<Customer> getAllCustomers = getAll();
        Set<Customer> resultSet = new HashSet<>();
        System.out.println(searchValue);
        for (Customer c : getAllCustomers) {
            String lowercaseC = c.getContactNumber().toLowerCase();
            String lowerCaseS = searchValue.toLowerCase();

            if (lowercaseC.contains(lowerCaseS)) {
                resultSet.add(c);
            }
        }
        return resultSet;
    }

    public Set<Customer> searchEmail(String searchValue) {
        Set<Customer> getAllCustomers = getAll();
        Set<Customer> resultSet = new HashSet<>();
        System.out.println(searchValue);
        for (Customer c : getAllCustomers) {
            String lowercaseC = c.getEmail().toLowerCase();
            String lowerCaseS = searchValue.toLowerCase();

            if (lowercaseC.contains(lowerCaseS)) {
                resultSet.add(c);
            }
        }
        return resultSet;
    }

}

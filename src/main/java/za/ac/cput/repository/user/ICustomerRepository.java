package za.ac.cput.repository.user;

import za.ac.cput.entity.user.Customer;
import za.ac.cput.repository.IRepository;

import java.util.Set;

/*
 *  Name: Tye Walker
 *  Student Number: 218338562
 *  Group: 23
 *
 *  CustomerService
 */

public interface ICustomerRepository extends IRepository<Customer, String> {

    // Set is used because each customer is unique.
    public Set<Customer> getAll();

}

package za.ac.cput.service.user;

import za.ac.cput.entity.user.Customer;
import za.ac.cput.service.IService;

import java.util.Set;

/*
 *  Name: Tye Walker
 *  Student Number: 218338562
 *  Group: 23
 *
 *  CustomerService
 */

public interface ICustomerService extends IService<Customer, String> {

    public Set<Customer> getAll();

}

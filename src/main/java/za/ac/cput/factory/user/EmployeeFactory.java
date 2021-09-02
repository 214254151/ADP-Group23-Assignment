/**
 * Author: Robyn White (218034555)
 * EmployeeFactory.java
 */

package za.ac.cput.factory.user;

import za.ac.cput.entity.user.Employee;

import java.util.UUID;

public class EmployeeFactory {
    public static Employee build(String firstName, String lastName, String phoneNumber, Double employeeRate) {

        String employeeID = UUID.randomUUID().toString();
        if (firstName.isEmpty() || lastName.isEmpty() || phoneNumber.isEmpty() || employeeRate.equals(null))
            return null;

        return new Employee.Builder()
                .setEmployeeID(employeeID)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setPhoneNumber(phoneNumber)
                .setEmployeeRate(employeeRate)
                .build();
    }
}

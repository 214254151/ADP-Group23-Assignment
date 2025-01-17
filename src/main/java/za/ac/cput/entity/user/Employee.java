/**
 * Author: Robyn White (218034555)
 * Employee.java
 */
package za.ac.cput.entity.user;

public class Employee {
    private String employeeID, firstName, lastName, phoneNumber;
    private Double employeeRate;

    public Employee(String employeeID, String firstName , String lastName, String phoneNumber, Double employeeRate) {
        this.employeeID = employeeID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.employeeRate = employeeRate;
    }

    private Employee(Builder builder)
    {
        this.employeeID = builder.employeeID;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.phoneNumber = builder.phoneNumber;
        this.employeeRate = builder.employeeRate;

    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Double getEmployeeRate() {
        return employeeRate;
    }

    public static class Builder {

        private String employeeID, firstName, lastName, phoneNumber;
        private Double employeeRate;


        public Builder setEmployeeID(String employeeID) {
            this.employeeID = employeeID;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
            return this;
        }

        public Builder setEmployeeRate(Double employeeRate) {
            this.employeeRate = employeeRate;
            return this;
        }


        public Employee build(){

            return new Employee(this);
        }

        public Builder copy(Employee e){
            this.employeeID = e.employeeID;
            this.firstName = e.firstName;
            this.lastName = e.lastName;
            this.phoneNumber = e.phoneNumber;
            this.employeeRate = e.employeeRate;
            return this;
        }

        @Override
        public String toString() {
            return "Builder{" +
                    "employeeID='" + employeeID + '\'' +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    ", phoneNumber='" + phoneNumber + '\'' +
                    ", employeeRate=" + employeeRate +
                    '}';
        }
    }

}

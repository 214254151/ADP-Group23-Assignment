/*
 *  Name: Abongile Tshopi
 *  Student Number: 214254151
 *  Group: 23
 *
 */

package za.ac.cput.entity.user;

public class Appointment {

    private String appointmentID, customerID, employeeID, appointmentType, startTime, endTime;
    private Double employeeRate;

    //private Appointment() {}

    private Appointment (Builder builder) {
        this.appointmentID=builder.appointmentID;
        this.customerID =builder.customerID;
        this.employeeID = builder.employeeID;
        this.appointmentType = builder.appointmentType;
        this.employeeRate = builder.employeeRate;
        this.startTime = builder.startTime;
        this.endTime = builder.endTime;
    }

    public String getAppointmentID() {
        return appointmentID;
    }
    public String getCustomerID() {
        return customerID;
    }
    public String getEmployeeID() {
        return employeeID;
    }
    public String getAppointmentType() {
        return appointmentType;
    }
    public Double getEmployeeRate() {return employeeRate; }
    public String getStartTime() {
        return startTime;
    }
    public String getEndTime() {
        return endTime;
    }

    public static class Builder {
        private String appointmentID, customerID, employeeID, appointmentType, startTime, endTime;
        private Double employeeRate;

        public Builder setAppointmentID(String appointmentID) {
            this.appointmentID = appointmentID;
            return this;
        }

        public Builder setCustomerID(String customerID) {
            this.customerID = customerID;
            return this;
        }

        public Builder setEmployeeID(String employeeID) {
            this.employeeID = employeeID;
            return this;
        }

        public Builder setAppointmentType(String appointmentType) {
            this.appointmentType = appointmentType;
            return this;
        }

        public Builder setStartTime(String startTime) {
            this.startTime = startTime;
            return this;
        }

        public Builder setEndTime(String endTime) {
            this.endTime = endTime;
            return this;
        }

        public Builder setEmployeeRate(Double employeeRate) {
            this.employeeRate = employeeRate;
            return this;
        }

        public Appointment build() {
            return new Appointment(this);
        }

        public Builder copy(Appointment appointment) {
            this.appointmentID = appointment.appointmentID;
            this.customerID = appointment.customerID;
            this.employeeID = appointment.employeeID;
            this.appointmentType = appointment.appointmentType;
            this.employeeRate = appointment.employeeRate;
            this.startTime = appointment.startTime;
            this.endTime = appointment.endTime;
            return this;
        }
    }

        @Override
        public String toString() {
            return "Builder{" +
                    "appointmentID='" + appointmentID + '\'' +
                    ", customerID='" + customerID + '\'' +
                    ", employeeID='" + employeeID + '\'' +
                    ", appointmentType='" + appointmentType + '\'' +
                    ", startTime='" + startTime + '\'' +
                    ", endTime='" + endTime + '\'' +
                    ", employeeRate=" + employeeRate +
                    '}';
        }
    }


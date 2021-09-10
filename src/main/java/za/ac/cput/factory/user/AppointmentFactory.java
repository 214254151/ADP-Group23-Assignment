/*
 *  Name: Abongile Tshopi
 *  Student Number: 214254151
 *  Group: 23
 *
 */

package za.ac.cput.factory.user;

import za.ac.cput.entity.user.Appointment;
import za.ac.cput.util.GenericHelper;

public class AppointmentFactory {
    public static Appointment createAppointment(String customerID, String employeeID, String appointmentType,
                                    String startTime, String endTime, Double employeeRate) {

        String appointmentID = GenericHelper.generateID();
        Appointment appointment = new Appointment.Builder()

        //return new Appointment.Builder().appointmentID(appointmentID)
                .setAppointmentID(appointmentID)
                .setCustomerID(customerID)
                .setEmployeeID(employeeID)
                .setAppointmentType(appointmentType)
                .setStartTime(startTime)
                .setEndTime(endTime)
                .setEmployeeRate(employeeRate)
                .build();

//        if (startTime.isEmpty() || endTime.isEmpty() || appointmentType.isEmpty()) {
//            System.out.println("Missing values..");
//            return null;
//        }

        return appointment;
    }
}

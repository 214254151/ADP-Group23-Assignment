/*
 *  Name: Abongile Tshopi
 *  Student Number: 214254151
 *  Group: 23
 */
package za.ac.cput.repository.user;

import java.util.HashSet;
import java.util.Set;
import za.ac.cput.entity.user.Appointment;

public class AppointmentRepository implements IAppointmentRepository{

    private static AppointmentRepository repository = null;
    private Set<Appointment> appointmentDB;

    private AppointmentRepository(){
        this.appointmentDB = new HashSet<>();
    }

    public static AppointmentRepository getRepository() {
        if (repository == null) {
            repository = new AppointmentRepository();
        }
        return repository;
    }

    @Override
    public Appointment create(Appointment appointment) {
        this.appointmentDB.add(appointment);
        return appointment;
    }

    @Override
    public Appointment read(String appointmentID) {
        for (Appointment ap : appointmentDB){
            if (ap.getAppointmentID().equals(appointmentID)){
                return ap;
            }
        }
        return null;
    }

    @Override
    public Appointment update(Appointment appointment) {
        Appointment apo1 = read(appointment.getAppointmentID());
        if (apo1 != null){
            appointmentDB.remove(apo1);
            appointmentDB.add(appointment);
            return appointment;
        }
        return null;
    }

    @Override
    public void delete(String appointmentID) {
        Appointment deleteAppointment = read((appointmentID));
        if (deleteAppointment == null)
            System.out.println("Appointment is null");

            appointmentDB.remove(deleteAppointment);
            System.out.println("Appointment is removed");

    }

    @Override
    public Set<Appointment> getAll() {
        return appointmentDB;
    }
}

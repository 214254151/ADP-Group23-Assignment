package za.ac.cput.service.user;

import za.ac.cput.entity.user.Appointment;
import za.ac.cput.service.IService;

import java.util.Set;

public interface IAppointmentService  extends IService <Appointment, String> {

    Set<Appointment> getAll();
}

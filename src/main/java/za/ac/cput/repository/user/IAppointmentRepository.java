/*
 *  Name: Abongile Tshopi
 *  Student Number: 214254151
 *  Group: 23
 */

package za.ac.cput.repository.user;

import za.ac.cput.entity.user.Appointment;
import za.ac.cput.repository.IRepository;

import java.util.Set;

public interface IAppointmentRepository extends IRepository<Appointment, String> {
    public Set<Appointment> getAll();
}

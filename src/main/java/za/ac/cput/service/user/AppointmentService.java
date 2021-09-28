package za.ac.cput.service.user;

import za.ac.cput.entity.user.Appointment;
import za.ac.cput.repository.user.AppointmentRepository;

import java.util.Set;

public class AppointmentService implements IAppointmentService{
    private static AppointmentService appointmentService= null;
    private AppointmentRepository appointmentRepository;

    private AppointmentService(){
        this.appointmentRepository = AppointmentRepository.getRepository();
    }

    public static IAppointmentService getAppointmentService(){
        if(appointmentService == null){
            appointmentService = new AppointmentService();
        }
        return appointmentService;
    }

    @Override
    public Appointment create(Appointment appointment){
        return this.appointmentRepository.create(appointment);
    }

    @Override
    public Appointment read(String appointmentID){
        return this.appointmentRepository.read(appointmentID);
    }

    @Override
    public Appointment update(Appointment appointment){
        return this.appointmentRepository.update(appointment);
    }

    @Override
    public void delete(String appointmentID){
        this.appointmentRepository.delete(appointmentID);
    }

    @Override
    public Set<Appointment> getAll(){
        return this.appointmentRepository.getAll();
    }
}


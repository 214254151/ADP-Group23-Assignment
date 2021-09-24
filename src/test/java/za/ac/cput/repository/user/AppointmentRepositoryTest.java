package za.ac.cput.repository.user;

import org.junit.jupiter.api.*;
import za.ac.cput.entity.user.Appointment;
import za.ac.cput.factory.user.AppointmentFactory;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AppointmentRepositoryTest {
    private static AppointmentRepository repository = AppointmentRepository.getRepository();
    private static Appointment appointment = AppointmentFactory.createAppointment("Customer101010",
            "Employee202020", "Day", "10:00PM", "1:00PM", 5.0);


    @Order(1)
    @Test
    void createTest() {
        Appointment created = repository.create(appointment);
        assertEquals(created.getAppointmentID(), appointment.getAppointmentID());
        System.out.println("Appointment Created: " + created);

    }

    @Order(2)
    @Test
    void readTest() {
        Appointment read = repository.read(appointment.getAppointmentID());
        //assertEquals(read.getAppointmentID(), appointment.getAppointmentID());
        //assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Order(3)
    @Test
    void updateTest() {
        Appointment updateAppointment = new Appointment.Builder().copy(appointment).setAppointmentType("Night").build();
        assertEquals(updateAppointment.getAppointmentID(), appointment.getAppointmentID());
        System.out.println("Appointment Updated : " + updateAppointment);
    }

    @Order(5)
    @Test
    void getAllTest() {
        System.out.println("Appointment: \n" + repository.getAll());
    }

    @Order(4)
    @Test
    void deleteTest() {
        repository.delete(appointment.getAppointmentID());
        assertNotNull(repository);
    }


}
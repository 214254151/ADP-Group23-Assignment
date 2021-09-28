package za.ac.cput.service.user;

import org.junit.jupiter.api.*;
import org.springframework.core.annotation.Order;
import za.ac.cput.entity.user.Appointment;
import za.ac.cput.factory.user.AppointmentFactory;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class AppointmentServiceTest {
    private  static AppointmentService service = (AppointmentService) AppointmentService.getAppointmentService();
    private static Appointment appointment = AppointmentFactory.build("Cus10000000", "Emp10101010",
            "Night","8:00PM", "10:00PM", 7.3);

    @Order(1)
    @Test
    public  void createTest(){
        Appointment created = service.create(appointment) ;
        assertNotNull(created.getAppointmentID(), appointment.getAppointmentID());
        System.out.println("Created: " + created);
    }

    @Order(2)
    @Test
    public void readTest() {
        Appointment read = service.read(appointment.getAppointmentID());
       // assertNotNull(read);
        System.out.println("Read: " + read);
    }

    @Order(3)
    @Test
    void updateTest() {
        Appointment updateAppo = new Appointment.Builder().copy(appointment).setStartTime("8:30PM").build();
       // assertNotNull(service.update(updateAppo));
        System.out.println("Update: " + updateAppo);
    }

    @Order(5)
    @Test
    void deleteTest() {
        service.delete(appointment.getAppointmentID());
        assertNotNull(service);
    }

    @Order(4)
    @Test
    void getAll(){
        System.out.println("Appointments available: ");
        System.out.println(service.getAll());

    }
}

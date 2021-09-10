package za.ac.cput.factory.user;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import za.ac.cput.entity.user.Appointment;
import static org.junit.jupiter.api.Assertions.*;

public class AppointmentFactoryTest {

    //The test passes as the method assertNotNull is true, the appointment object is created successfully
    @Test
    public void createAppointment0(){
        Appointment appointment = AppointmentFactory.createAppointment("C10111", "E10111",
                "Day","10:00AM", "01:00PM", 6.1);

        System.out.println(appointment);
        assertNotNull(appointment);

    }
    @Test
    public void disabling(){
        System.out.println("Temporal technical issues");
        disabling();

    }

    @Test
    public void failTest(){
        try{
            fail("Test is failing");
        } catch (Exception e) {
            e.printStackTrace();
            assertTrue(true);
        }
    }

    //Time testing will pass as the time limit is 1 sec to generate the order that take 700 milli seconds
    @Test
    @Timeout(1)
    public void testTime() throws InterruptedException{

        Appointment apo = AppointmentFactory.createAppointment("C10111", "E10111", "Day",
                "10:00AM", "01:00PM",  6.2 );
        Thread.sleep(700);
        System.out.println(apo);


    }

    Appointment appo0 = AppointmentFactory.createAppointment("C10111", "E10111", "Day",
            "10:00AM", "01:00PM",  6.2 );

    Appointment appo1 = AppointmentFactory.createAppointment("C10111", "E10111", "Night",
            "11:00AM", "02:00PM",  7.2 );

    //The test will fail since object appo0 and appo1 are not identical, each order have a unique oderID/s
    @Test
    public void testIdentity()
    {
        System.out.println(appo0);
        System.out.println(appo1);

        assertSame(appo0, appo1 );
    }

    //Object appo1 and appo0 are not equal, the test will fail
    @Test
    public void testingEquality(){
        System.out.println(appo0);
        System.out.println(appo1);

        assertEquals(appo0, appo1);
    }
}

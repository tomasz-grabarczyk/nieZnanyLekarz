package nieZnanyLekarz.patientPackage;

import nieZnanyLekarz.generalPackage.CalendarScreen;
import nieZnanyLekarz.generalPackage.HoursScreen;
import nieZnanyLekarz.interfacePackage.DrawFrame;

import javax.swing.*;

class ShowPatientAppointments
        implements DrawFrame {

    void showPatientAppointments() {
        // TODO: code to show patient appointments
        JFrame frame_patientAppoinments = new JFrame("Patient appointments");

        JLabel labelPatientAppointment = new JLabel();
        labelPatientAppointment.setText("<html>"+ "Specialization: " + SelectSpecialization.getDoctorSpecialization() + "<br/>Doctor: " + SelectDoctorName.getSelectedDoctorName() + "<br/>Date: " + CalendarScreen.getDateSelected() + "<br/>Hour: " + HoursScreen.getHourSelected() +"</html>");

        JLabel labelPatientAppointment2 = new JLabel();
        labelPatientAppointment2.setText("<html>"+ "Specialization: " + SelectSpecialization.getDoctorSpecialization() + "<br/>Doctor: " + SelectDoctorName.getSelectedDoctorName() + "<br/>Date: " + CalendarScreen.getDateSelected() + "<br/>Hour: " + HoursScreen.getHourSelected() +"</html>");

        frame_patientAppoinments.add(labelPatientAppointment);
        frame_patientAppoinments.add(labelPatientAppointment2);
        showFrame(frame_patientAppoinments, 5, 1, 200, 80);
    }
}

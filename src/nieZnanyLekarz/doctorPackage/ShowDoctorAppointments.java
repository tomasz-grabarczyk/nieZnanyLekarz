package nieZnanyLekarz.doctorPackage;

import nieZnanyLekarz.generalPackage.CalendarScreen;
import nieZnanyLekarz.generalPackage.HoursScreen;
import nieZnanyLekarz.interfacePackage.DrawFrame;

import javax.swing.*;

class ShowDoctorAppointments
        implements DrawFrame {

    void showDoctorAppointments() {
        // TODO: code to show doctor appointments
        JFrame frame_doctorAppoinments = new JFrame("Doctor appointments"); // stwórz ramkę tworzenia wizyt dla doktora

        JLabel labelDoctorAppointment = new JLabel(); // stwórz label dla pokazywania wizyty
        labelDoctorAppointment.setText("<html>" + "Date: " + CalendarScreen.getDateSelected() + "<br/>Hour: " + HoursScreen.getHourSelected() +"</html>");

        JLabel labelDoctorAppointment2 = new JLabel();
        labelDoctorAppointment2.setText("<html>" + "Date: " + CalendarScreen.getDateSelected() + "<br/>Hour: " + HoursScreen.getHourSelected() +"</html>");

        frame_doctorAppoinments.add(labelDoctorAppointment);
        frame_doctorAppoinments.add(labelDoctorAppointment2);
        showFrame(frame_doctorAppoinments, 5, 1, 150, 50);
    }
}

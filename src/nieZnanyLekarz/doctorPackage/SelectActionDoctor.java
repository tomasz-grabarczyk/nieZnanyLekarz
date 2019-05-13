package nieZnanyLekarz.doctorPackage;



import nieZnanyLekarz.interfacePackage.DrawButtons;
import nieZnanyLekarz.interfacePackage.DrawFrame;

import javax.swing.*;

public class SelectActionDoctor
        implements DrawButtons, DrawFrame {

    public void drawButtonsSelectAction() {
        JFrame frame_selectActionDoctor = new JFrame("Doctor - select action:");
        JButton button_newAppointment = new JButton("Add new appointment");
        JButton button_showAllAppointments = new JButton("Show all appointments");

        showFrame(frame_selectActionDoctor, 2, 1, 300, 70);

        drawButtons(button_newAppointment, frame_selectActionDoctor);
        button_newAppointment.addActionListener(e -> {
            frame_selectActionDoctor.dispose();
            AddNewAppointment doctor_addNewAppointment = new AddNewAppointment();
            doctor_addNewAppointment.addNewAppointment();
        });

        drawButtons(button_showAllAppointments, frame_selectActionDoctor);
        button_showAllAppointments.addActionListener(e -> {
            frame_selectActionDoctor.dispose();
            ShowAllAppointments doctor_showAllAppointments = new ShowAllAppointments();
            doctor_showAllAppointments.showDoctorAppointments();
        });


    }
}

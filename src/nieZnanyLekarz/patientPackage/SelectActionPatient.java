package nieZnanyLekarz.patientPackage;

import nieZnanyLekarz.interfacePackage.DrawButtons;
import nieZnanyLekarz.interfacePackage.DrawFrame;

import javax.swing.*;

public class SelectActionPatient
        implements DrawButtons, DrawFrame {

    public void drawButtonsSelectAction() {
        JFrame frame_selectActionPatient = new JFrame("Patient - select action:");
        JButton button_showMyAppointments = new JButton("Show my appointments");
        JButton button_bookNewAppointment = new JButton("Book new appointment");

        drawButtons(button_showMyAppointments, frame_selectActionPatient);
        button_showMyAppointments.addActionListener(e -> {
            frame_selectActionPatient.dispose();
            ShowAllAppointments showAllAppointments = new ShowAllAppointments();
            showAllAppointments.showPatientAppointments();
        });

        drawButtons(button_bookNewAppointment, frame_selectActionPatient);
        button_bookNewAppointment.addActionListener(e -> {
            frame_selectActionPatient.dispose();
            SelectSpecialization selectSpecialization = new SelectSpecialization();
            selectSpecialization.selectSpecialization();
        });

        showFrame(frame_selectActionPatient, 2, 1, 300, 70);
    }
}

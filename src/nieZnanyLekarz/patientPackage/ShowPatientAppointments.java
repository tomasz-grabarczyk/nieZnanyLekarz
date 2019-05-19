package nieZnanyLekarz.patientPackage;

import nieZnanyLekarz.interfacePackage.DrawFrame;
import nieZnanyLekarz.interfacePackage.SelectionScreen;
import nieZnanyLekarz.interfacePackage.ShowAppointments;

import javax.swing.*;

import java.io.IOException;

class ShowPatientAppointments
        implements DrawFrame, SelectionScreen, ShowAppointments {

    private JFrame frame_patientAppointments = new JFrame("Patient appointments");

    void showPatientAppointments() throws IOException {
        String filePath = "/home/zayl/IdeaProjects/nieZnanyLekarz/src/patientAppointment.txt"; // TODO: if needed change path to file
        showAppointments(frame_patientAppointments, filePath, false, 80, 220, ""); // pokaż ramkę z wizytami
    }
}

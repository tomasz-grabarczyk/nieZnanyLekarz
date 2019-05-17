package nieZnanyLekarz.patientPackage;

import nieZnanyLekarz.interfacePackage.DrawFrame;
import nieZnanyLekarz.interfacePackage.SelectionScreen;
import nieZnanyLekarz.interfacePackage.ShowAppointments;

import javax.swing.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import static nieZnanyLekarz.generalPackage.CalendarScreen.getDateSelected;
import static nieZnanyLekarz.generalPackage.HoursScreen.getHourSelected;
import static nieZnanyLekarz.patientPackage.SelectDoctorName.getSelectedDoctorName;
import static nieZnanyLekarz.patientPackage.SelectSpecialization.getDoctorSpecialization;

class ShowPatientAppointments
        implements DrawFrame, SelectionScreen, ShowAppointments {

    private JFrame frame_patientAppointments = new JFrame("Patient appointments");
    private String filePath = "/home/zayl/IdeaProjects/nieZnanyLekarz/src/patientAppointment.txt";

    void showPatientAppointments() throws IOException {
        showAppointments(frame_patientAppointments, filePath, false, 80, "");
    }

    void insertNewRecordToFile() throws IOException {
        // TODO: zmiana sposobu wprowadzania informacji do pliku, tutaj tylko testowo zrobione

        String patientAppointmentInfo = "  " + getDoctorSpecialization() + ";" + getSelectedDoctorName() + ";" + getDateSelected() + ";" + getHourSelected();

        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
        writer.append(patientAppointmentInfo);
        writer.close();
    }


}

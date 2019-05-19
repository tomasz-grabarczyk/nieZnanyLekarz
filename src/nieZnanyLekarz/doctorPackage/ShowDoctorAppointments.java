package nieZnanyLekarz.doctorPackage;

import nieZnanyLekarz.interfacePackage.DrawFrame;
import nieZnanyLekarz.interfacePackage.ReadDataFromFile;
import nieZnanyLekarz.interfacePackage.ShowAppointments;
import nieZnanyLekarz.patientPackage.SelectDoctorName;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

class ShowDoctorAppointments
        implements DrawFrame, ShowAppointments, ReadDataFromFile {

    private JFrame frame_doctorAppointments = new JFrame("Doctor appointments");

    void showDoctorAppointments() throws IOException {
        // TODO: if needed change path to file
        String filePath = "/home/zayl/IdeaProjects/nieZnanyLekarz/src/patientAppointment.txt";
        String doctorNamesPath = "/home/zayl/IdeaProjects/nieZnanyLekarz/src/doctorNames.txt";

        List<String> list_doctorNames = readDataFromFile(doctorNamesPath, "; "); // rozdziel string na kawałki po "; "

        String doctorName = "";

        for (int i = 0; i < list_doctorNames.size(); i += 2) {
            if (SelectDoctorName.getSelectedDoctorName().equals(list_doctorNames.get(i))) // jeśli login zgadza się z takim z pliku
                doctorName = list_doctorNames.get(i + 1); // to ustaw imię i nazwisko przypisane do loginu
        }

        showAppointments(frame_doctorAppointments, filePath, true, 50, 150, doctorName); // pokaż ramkę z wizytami i ustal jej właściwości
    }
}

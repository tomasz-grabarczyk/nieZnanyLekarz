package nieZnanyLekarz.patientPackage;

import nieZnanyLekarz.interfacePackage.DrawFrame;
import nieZnanyLekarz.interfacePackage.SelectionScreen;

import javax.swing.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static nieZnanyLekarz.generalPackage.CalendarScreen.getDateSelected;
import static nieZnanyLekarz.generalPackage.HoursScreen.getHourSelected;
import static nieZnanyLekarz.patientPackage.SelectDoctorName.getSelectedDoctorName;
import static nieZnanyLekarz.patientPackage.SelectSpecialization.getDoctorSpecialization;

class ShowPatientAppointments
        implements DrawFrame, SelectionScreen {

    private JFrame frame_patientAppointments = new JFrame("Patient appointments");
    private String filePath = "C:\\Users\\A702387\\Desktop\\nieZnanyLekarz\\src\\patientAppointment.txt";

    void showPatientAppointments() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get(filePath)); // załaduj dane z pliku do tablicy jako jeden rekord
        String patientAppointmentInfo = lines.get(0); // wrzuć dane z listy do stringa

        int numberOfIndividualRecord = 4; // ilość poszczególnych informacji (specjalizacja, imię i nazwisko, data, godzina)

        String[] stringArray_numberOfPatientAppointments = patientAppointmentInfo.split(" {2}"); // rozdziel string na podstawie dwóch spacji "  "
        List<String> numberOfPatientAppointments = new ArrayList<>(Arrays.asList(stringArray_numberOfPatientAppointments)); // wrzuć dane z tablicy do listy

        JLabel[] labelPatientAppointment = new JLabel[numberOfPatientAppointments.size() * numberOfIndividualRecord]; // stwórz odpowiednią ilość labeli

        for (String numberOfPatientAppointment : numberOfPatientAppointments) {
            String[] appointmentInfoSeparated = numberOfPatientAppointment.split(";"); // rozdzielenie stringa z pliku na poszczególne kawałki bazując na średniku ";"
            for (int i = 0; i < appointmentInfoSeparated.length / numberOfIndividualRecord; i++) {
                labelPatientAppointment[i] = new JLabel(); // stwórz nowego labela
                labelPatientAppointment[i].setText("<html>" + "Specialization: " + appointmentInfoSeparated[i] + "<br/>Doctor: " + appointmentInfoSeparated[i + 1] + "<br/>Date: " + appointmentInfoSeparated[i + 2] + "<br/>Hour: " + appointmentInfoSeparated[i + 3] + "</html>"); // ustaw tekst z poszczególnymi danymi w nowych liniach

                frame_patientAppointments.add(labelPatientAppointment[i]); // dodaj label do ramki
            }
        }

        showFrame(frame_patientAppointments, numberOfPatientAppointments.size(), 1, 300, 80); // pokaż ramkę i ustal jej właściwości
    }

    void insertNewRecordToFile() throws IOException {
        // TODO: zmiana sposobu wprowadzania inforacji do pliku, tutaj tylko testowo zrobione

        String patientAppointmentInfo = "  " + getDoctorSpecialization() + ";" + getSelectedDoctorName() + ";" + getDateSelected() + ";" + getHourSelected();

        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true));
        writer.append(patientAppointmentInfo);
        writer.close();
    }


}

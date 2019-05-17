package nieZnanyLekarz.patientPackage;

import nieZnanyLekarz.interfacePackage.*;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SelectSpecialization
        implements DrawButtons, DrawFrame, SelectionScreen, SelectDoctors {

    private static String doctorSpecialization;
    static String getDoctorSpecialization() {
        return doctorSpecialization;
    }
    private static void setDoctorSpecialization(String doctorSpecialization) {
        SelectSpecialization.doctorSpecialization = doctorSpecialization;
    }

    void selectSpecialization() throws IOException {
        // TODO: zmienić sztywne dane w tablicy na takie pobierane z pliku
        String[] stringArray_doctorSpecialization = {"Internist", "Oncologist", "Cardiologist"};
        List<String> stringList_doctorSpecialization = new ArrayList<>(Arrays.asList(stringArray_doctorSpecialization));

        JFrame frame_selectSpecialization = new JFrame("Select specialization"); // stwórz ramkę dla specjalizacji doktora
        JButton[] button_doctorSpecialization = new JButton[stringList_doctorSpecialization.size()]; // stwórz przyciski dla specjalizacji doktora w ilości elementów tablicy


        for (int i = 0; i < stringList_doctorSpecialization.size(); i++) { // iteruje bazując na ilości elementów tablicy
            button_doctorSpecialization[i] = new JButton(stringList_doctorSpecialization.get(i)); // stwórz nowy przycisk i ustal jego wartość na element z tablicy
            drawButtons(button_doctorSpecialization[i], frame_selectSpecialization); // stwórz przyciski i dodaj je do ramki

            int finalI = i;
            button_doctorSpecialization[i].addActionListener(e -> { // dodaj akcję po kliknięciu
                frame_selectSpecialization.dispose(); // ukryj ramkę specjalizacji
                SelectSpecialization.setDoctorSpecialization(button_doctorSpecialization[finalI].getText()); // ustal wartość zmiennej na tekst z przycisku

                SelectDoctorName selectDoctorName = new SelectDoctorName();
                selectDoctorName.selectDoctorName(); // pokaż ramkę związaną z wyborem imienia lekarza
            });
        }

        showFrame(frame_selectSpecialization, stringList_doctorSpecialization.size(), 1, 200, 100); // pokaż ramkę wyboru specjalizacji i ustal jej właściwości
    }
}

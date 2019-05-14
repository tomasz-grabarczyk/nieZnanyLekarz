package nieZnanyLekarz.interfacePackage;

import nieZnanyLekarz.patientPackage.SelectDate;
import nieZnanyLekarz.patientPackage.SelectSpecialization;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public interface SelectDoctors extends DrawButtons, DrawFrame {

    default void selectDoctorInterface(String[] doctorNames) {
        List<String> stringList_doctorNames = new ArrayList<>(Arrays.asList(doctorNames)); // dodaj dane z tablicy do listy

        JFrame frame_selectDoctor = new JFrame("Select doctor"); // stwórz nową ramkę
        JButton[] button_doctorName = new JButton[stringList_doctorNames.size()]; // stwórz przyciski dla doktorów w ilości elementów z tablicy

        for (int i = 0; i < stringList_doctorNames.size(); i++) { // iteruje bazując na ilości elementów z listy
            button_doctorName[i] = new JButton(stringList_doctorNames.get(i)); // stwórz nowy przycisk
            drawButtons(button_doctorName[i], frame_selectDoctor); // dodaj przycisk do ramki

            int finalI = i;
            button_doctorName[i].addActionListener(e -> { // dodaj akcję po kliknięciu w przycisk
                frame_selectDoctor.dispose(); // ukryj ramkę
                SelectDate selectDate = new SelectDate();
                selectDate.selectDate(); // przejdź do wyboru daty
                SelectSpecialization.setSelectedDoctorName(button_doctorName[finalI].getText()); // ustaw imię i nazwisko doktora bazując na tym, co pokazuje przycisk
            });

        }

        showFrame(frame_selectDoctor, stringList_doctorNames.size(), 1, 200, 100); // pokaż ramkę i ustal jej wlaściwości
    }
}

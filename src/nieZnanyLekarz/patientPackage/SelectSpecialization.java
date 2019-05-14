package nieZnanyLekarz.patientPackage;

import nieZnanyLekarz.interfacePackage.*;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectSpecialization
        implements DrawButtons, DrawFrame, SelectActionScreenLoop, SelectDoctors {

    private static String doctorSpecialization;
    public static String getDoctorSpecialization() {
        return doctorSpecialization;
    }
    private static void setDoctorSpecialization(String doctorSpecialization) {
        SelectSpecialization.doctorSpecialization = doctorSpecialization;
    }

    private static String selectedDoctorName;
    public static String getSelectedDoctorName() {
        return selectedDoctorName;
    }
    public static void setSelectedDoctorName(String selectedDoctorName) {
        SelectSpecialization.selectedDoctorName = selectedDoctorName;
    }

    void selectSpecialization() {
        // TODO: zmienić sztywne dane w tablicy na takie pobierane z pliku
        String[] stringArray_doctorSpecialization = {"Internist", "Oncologist", "Cardiologist"};
        List<String> stringList_doctorSpecialization = new ArrayList<>(Arrays.asList(stringArray_doctorSpecialization));

        JFrame frame_selectSpecialization = new JFrame("Select specialization");
        JButton[] button_doctorSpecialization = new JButton[stringList_doctorSpecialization.size()];

        for (int i = 0; i < stringList_doctorSpecialization.size(); i++) {
            button_doctorSpecialization[i] = new JButton(stringList_doctorSpecialization.get(i));
            drawButtons(button_doctorSpecialization[i], frame_selectSpecialization);

            int finalI = i;
            button_doctorSpecialization[i].addActionListener(e -> {
                frame_selectSpecialization.dispose();
                SelectSpecialization.setDoctorSpecialization(button_doctorSpecialization[finalI].getText());

                switch (SelectSpecialization.getDoctorSpecialization()) {
                    case "Internist":
                        // TODO: zmienić sztywne dane w tablicy na takie pobierane z pliku
                        String[] stringArray_doctorNamesInternist = {"Jan Kowalski", "Tomasz Grabarczyk", "Krolik Bugs"};
                        selectDoctorInterface(stringArray_doctorNamesInternist);
                        break;
                    case "Oncologist":
                        // TODO: zmienić sztywne dane w tablicy na takie pobierane z pliku
                        String[] stringArray_doctorNamesOncologist = {"Maria Wanda", "Myszka Miki", "Karol Hipopotam"}; // stwórz listę z imionami doktorów
                        selectDoctorInterface(stringArray_doctorNamesOncologist);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "There is no doctor with specialization: " + SelectSpecialization.getDoctorSpecialization(), "Add new appointment ", JOptionPane.INFORMATION_MESSAGE);
                        goBackToSelectionScreen();
                        break;
                }
            });
        }

        showFrame(frame_selectSpecialization, stringList_doctorSpecialization.size(), 1, 200, 100);
    }
}

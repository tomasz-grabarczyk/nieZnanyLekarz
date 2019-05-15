package nieZnanyLekarz.patientPackage;

import nieZnanyLekarz.interfacePackage.SelectDoctors;

import javax.swing.*;

public class SelectDoctorName
        implements SelectDoctors {

    private static String selectedDoctorName;
    static String getSelectedDoctorName() {
        return selectedDoctorName;
    }
    public static void setSelectedDoctorName(String selectedDoctorName) {
        SelectDoctorName.selectedDoctorName = selectedDoctorName;
    }

    void selectDoctorName() {
        switch (SelectSpecialization.getDoctorSpecialization()) {
            case "Internist":
                // TODO: zmienić sztywne dane w tablicy na takie pobierane z pliku
                String[] stringArray_doctorNamesInternist = {"Jan Kowalski", "Tomasz Grabarczyk", "Krolik Bugs"}; // stwórz tablicę z imionami doktorów
                selectDoctorInterface(stringArray_doctorNamesInternist);
                break;
            case "Oncologist":
                // TODO: zmienić sztywne dane w tablicy na takie pobierane z pliku
                String[] stringArray_doctorNamesOncologist = {"Maria Wanda", "Myszka Miki", "Karol Hipopotam"}; // stwórz tablicę z imionami doktorów
                selectDoctorInterface(stringArray_doctorNamesOncologist);
                break;
            default:
                JOptionPane.showMessageDialog(null, "There are no doctors with specialization: " + SelectSpecialization.getDoctorSpecialization(), "Add new appointment ", JOptionPane.INFORMATION_MESSAGE);
                selectionScreen(); // pokaż wiadomość, jeśli nie ma żadnego doktora
                break;
        }
    }
}

package nieZnanyLekarz.generalPackage;

import nieZnanyLekarz.interfacePackage.*;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static nieZnanyLekarz.generalPackage.CalendarScreen.getDateSelected;
import static nieZnanyLekarz.patientPackage.SelectDoctorName.getSelectedDoctorName;
import static nieZnanyLekarz.patientPackage.SelectSpecialization.getDoctorSpecialization;

class HoursScreen
        implements DrawButtons, DrawFrame, SelectionScreen, WriteDataToFile {

    private static String string_hourSelected;
    private static String getHourSelected() {
        return string_hourSelected;
    }
    private boolean boolean_dateAndHourAddedToFile = false;
    private String filePath = "/home/zayl/IdeaProjects/nieZnanyLekarz/src/patientAppointment.txt"; // TODO: if needed change path to file
    private String doctorAppointmentFilePath = "/home/zayl/IdeaProjects/nieZnanyLekarz/src/doctorAppointments.txt";

    void drawHoursButtons() {
        // TODO: zmienić sztywne dane w tablicy na takie pobierane z pliku
        String[] stringArray_hours = {"8:00", "8:30", "9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30"};
        List<String> stringList_hours = new ArrayList<>(Arrays.asList(stringArray_hours));

        JFrame frame_hours = new JFrame("Hours"); // stwórz ramkę dla godzin
        JButton[] button_hours = new JButton[stringList_hours.size()]; // stwórz przyciski dla godzin w ilości elementów listy

        LoginScreen loginScreen = new LoginScreen();

        for (int i = 0; i < stringList_hours.size(); i++) { // iteruje do ilości elementów listy
            button_hours[i] = new JButton(stringList_hours.get(i)); // powiąż element listy z przyciskiem
            frame_hours.add(button_hours[i]); // dodaj przycisk do ramki godzin

            int finalI = i;
            button_hours[i].addActionListener(e -> { // dodaj akcję po kliknięciu
                frame_hours.dispose(); // ukryj ramkę godzin
                string_hourSelected = button_hours[finalI].getText(); // ustaw wartość zmiennej na tekst z przycisku

                // TODO: sprawdzenie, czy data (getDateSelected()) i godzina (string_hourSelected) została poprawnie dodana do pliku
                boolean_dateAndHourAddedToFile = true;

                if (boolean_dateAndHourAddedToFile) {
                    JOptionPane.showMessageDialog(null, "Successfully added new appointment!", "Add new appointment", JOptionPane.INFORMATION_MESSAGE);
                    if (loginScreen.getFlagLoggedIn().equals("P")) { // jeśli loguje się pacjent
                        if (getDoctorSpecialization() != null && getSelectedDoctorName() != null && getDateSelected() != null && getHourSelected() != null) { // zrobione aby uniknąć wrzucania wartości NULL w zmienne przy uruchomieniu apki
                            try {
                                String patientAppointmentInfo = "  " + getDoctorSpecialization() + ";" + getSelectedDoctorName() + ";" + getDateSelected() + ";" + getHourSelected();
                                writeDataToFile(filePath, patientAppointmentInfo);
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        }
                    } else if (loginScreen.getFlagLoggedIn().equals("D")) { // jeśli loguje się doktor
                        if (getDateSelected() != null && getHourSelected() != null) { // zrobione aby uniknąć wrzucania wartości NULL w zmienne przy uruchomieniu apki
                            try {
                                String doctorAppointmentInfo = "  " + getSelectedDoctorName() + getDateSelected() + ";" + getHourSelected();
                                writeDataToFile(doctorAppointmentFilePath, doctorAppointmentInfo);
                            } catch (IOException ex) {
                                ex.printStackTrace();
                            }
                        }
                    }
                    selectionScreen();
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to add new appointment!\nPlease try again!", "Add new appointment ", JOptionPane.INFORMATION_MESSAGE);
                    selectionScreen();
                }
            });
        }

        showFrame(frame_hours, 8, 2, 300, 70); // pokaż ramkę godzin i ustal jej właściwości
    }
}

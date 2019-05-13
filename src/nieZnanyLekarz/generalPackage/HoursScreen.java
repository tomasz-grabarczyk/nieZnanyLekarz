package nieZnanyLekarz.generalPackage;

import nieZnanyLekarz.interfacePackage.DrawButtons;
import nieZnanyLekarz.interfacePackage.DrawFrame;
import nieZnanyLekarz.interfacePackage.SelectActionScreenLoop;
import nieZnanyLekarz.patientPackage.SelectDoctor;
import nieZnanyLekarz.patientPackage.SelectSpecialization;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HoursScreen
        implements DrawButtons, DrawFrame, SelectActionScreenLoop {

    private String string_hourSelected;

    private boolean boolean_dateAndHourAddedToFile = false;

    void drawHoursButtons() {
        JFrame frame_hours = new JFrame("Hours");

        String[] stringArray_hours = {"8:00", "8:30", "9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30"};
        List<String> stringList_hours = new ArrayList<>(Arrays.asList(stringArray_hours));
        JButton[] button_hours = new JButton[stringList_hours.size()];

        showFrame(frame_hours, 8, 2, 300, 70);

        for (int i = 0; i < stringList_hours.size(); i++) {
            button_hours[i] = new JButton(stringList_hours.get(i));
            frame_hours.add(button_hours[i]);

            int finalI = i;
            button_hours[i].addActionListener(e -> {
                frame_hours.dispose();
                string_hourSelected = button_hours[finalI].getText();

                // TODO: sprawdzenie, czy data (getDateSelected()) i godzina (string_hourSelected) została poprawnie dodana do pliku
                boolean_dateAndHourAddedToFile = true;

                if (boolean_dateAndHourAddedToFile) {
                    JOptionPane.showMessageDialog(null, "Added new appointment:\n\nSpecialization: " + SelectSpecialization.getDoctorSpecialization() + "\nDoctor: " + SelectDoctor.getSelectedDoctorName() + "\nDate: " + CalendarScreen.getDateSelected() + "\nHour: " + string_hourSelected, "Add new appointment ", JOptionPane.INFORMATION_MESSAGE);
                    goBackToSelectionScreen();
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to add new appointment!\nPlease try again!", "Add new appointment ", JOptionPane.INFORMATION_MESSAGE);
                    goBackToSelectionScreen();
                }
            });
        }
    }
}

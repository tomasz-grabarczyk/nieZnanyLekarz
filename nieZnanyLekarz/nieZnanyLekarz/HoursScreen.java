package nieZnanyLekarz;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class HoursScreen implements DrawButtons, DrawFrame, SelectActionScreen {
    private static String dateSelected;
    private String getDateSelected() {
        return dateSelected;
    }
    static void setDateSelected(String dateSelected) {
        HoursScreen.dateSelected = dateSelected;
    }

    private String hourSelected;

    private boolean dateAndHourAddedToFile = false;

    void drawHoursButtons() {
        JFrame hoursFrame = new JFrame("Hours");

        String[] arrayOfHours = {"8:00", "8:30", "9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30"};
        List<String> listOfHours = new ArrayList<>(Arrays.asList(arrayOfHours));
        JButton[] hoursButton = new JButton[listOfHours.size()];

        showFrame(hoursFrame, 8, 2);

        for (int i = 0; i < listOfHours.size(); i++) {
            hoursButton[i] = new JButton();
            hoursButton[i].setText(listOfHours.get(i));
            hoursFrame.add(hoursButton[i]);

            int finalI = i;
            hoursButton[i].addActionListener(e -> {
                hoursFrame.dispose();
                hourSelected = hoursButton[finalI].getText();

                // TODO: sprawdzenie, czy data (getDateSelected()) i godzina (hourSelected) została poprawnie dodana do pliku
                dateAndHourAddedToFile = true;

                if (dateAndHourAddedToFile) {
                    JOptionPane.showMessageDialog(null, "Added new appointment!\nDate: " + getDateSelected() + "\nHour: " + hourSelected, "Add new appointment ", JOptionPane.INFORMATION_MESSAGE);
                    goBackToSelectionScreen();
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to add new appointment!\nPlease try again!", "Add new appointment ", JOptionPane.INFORMATION_MESSAGE);
                    goBackToSelectionScreen();
                }
            });
        }
    }
}

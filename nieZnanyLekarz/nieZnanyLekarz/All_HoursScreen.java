package nieZnanyLekarz;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class All_HoursScreen
        implements All_DrawButtonsInterface, All_DrawFrameInterface, All_SelectActionScreenLoopInterface {

    private static String string_dateSelected;
    private String getDateSelected() {
        return string_dateSelected;
    }
    static void setString_dateSelected(String string_dateSelected) {
        All_HoursScreen.string_dateSelected = string_dateSelected;
    }

    private String string_hourSelected;

    private boolean boolean_dateAndHourAddedToFile = false;

    void drawHoursButtons() {
        JFrame frame_hours = new JFrame("Hours");

        String[] stringArray_hours = {"8:00", "8:30", "9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30"};
        List<String> stringList_hours = new ArrayList<>(Arrays.asList(stringArray_hours));
        JButton[] button_hours = new JButton[stringList_hours.size()];

        showFrame(frame_hours, 8, 2, 300, 70);

        for (int i = 0; i < stringList_hours.size(); i++) {
            button_hours[i] = new JButton();
            button_hours[i].setText(stringList_hours.get(i));
            frame_hours.add(button_hours[i]);

            int finalI = i;
            button_hours[i].addActionListener(e -> {
                frame_hours.dispose();
                string_hourSelected = button_hours[finalI].getText();

                // TODO: sprawdzenie, czy data (getDateSelected()) i godzina (string_hourSelected) została poprawnie dodana do pliku
                boolean_dateAndHourAddedToFile = true;

                if (boolean_dateAndHourAddedToFile) {
                    JOptionPane.showMessageDialog(null, "Added new appointment!\nDate: " + getDateSelected() + "\nHour: " + string_hourSelected, "Add new appointment ", JOptionPane.INFORMATION_MESSAGE);
                    goBackToSelectionScreen();
                } else {
                    JOptionPane.showMessageDialog(null, "Failed to add new appointment!\nPlease try again!", "Add new appointment ", JOptionPane.INFORMATION_MESSAGE);
                    goBackToSelectionScreen();
                }
            });
        }
    }
}

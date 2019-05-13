package nieZnanyLekarz.generalPackage;



import nieZnanyLekarz.interfacePackage.DrawButtons;
import nieZnanyLekarz.interfacePackage.DrawFrame;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalendarScreen
        implements DrawButtons, DrawFrame {

    private static String string_dateSelected;
    static String getDateSelected() {
        return string_dateSelected;
    }
    private static void setString_dateSelected(String string_dateSelected) {
        CalendarScreen.string_dateSelected = string_dateSelected;
    }

    public void selectDate() {
        JFrame frame_calendarScreen = new JFrame("Calendar");
        String[] stringArray_dates = {"13.05.2019", "14.05.2019", "15.05.2019", "16.05.2019", "17.05.2019"};

        List<String> stringList_dates = new ArrayList<>(Arrays.asList(stringArray_dates));
        JButton[] button_dates = new JButton[stringList_dates.size()];

        showFrame(frame_calendarScreen, stringList_dates.size(), 1, 300,70);

        for (int i = 0; i < stringList_dates.size(); i++) {
            button_dates[i] = new JButton();
            button_dates[i].setText(stringList_dates.get(i));
            drawButtons(button_dates[i], frame_calendarScreen);

            int finalI = i;
            button_dates[i].addActionListener(e -> {
                frame_calendarScreen.dispose();
                setString_dateSelected(button_dates[finalI].getText());
                HoursScreen hoursScreen = new HoursScreen();
                hoursScreen.drawHoursButtons();
            });
        }
    }
}

package nieZnanyLekarz;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static nieZnanyLekarz.HoursScreen.setDateSelected;

class CalendarScreen implements DrawButtons, DrawFrame {

    void selectDate() {
        JFrame calendarScreenFrame = new JFrame("Calendar");
        String[] datesArray = {"13.05.2019", "14.05.2019", "15.05.2019", "16.05.2019", "17.05.2019"};

        List<String> datesList = new ArrayList<>(Arrays.asList(datesArray));
        JButton[] buttonsDates = new JButton[datesList.size()];

        showFrame(calendarScreenFrame, datesList.size(), 1);

        for (int i = 0; i < datesList.size(); i++) {
            buttonsDates[i] = new JButton();
            buttonsDates[i].setText(datesList.get(i));
            drawButtons(buttonsDates[i], calendarScreenFrame);

            int finalI = i;
            buttonsDates[i].addActionListener(e -> {
                calendarScreenFrame.dispose();
                setDateSelected(buttonsDates[finalI].getText());
                HoursScreen hoursScreen = new HoursScreen();
                hoursScreen.drawHoursButtons();
            });
        }
    }
}

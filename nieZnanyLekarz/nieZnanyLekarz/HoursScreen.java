package nieZnanyLekarz;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HoursScreen {

    private String selectedHour;
    public String getSelectedHour() {
        return selectedHour;
    }
    private void setSelectedHour(String selectedHour) {
        this.selectedHour = selectedHour;
    }

    void drawHoursButtons() {
        JFrame hoursFrame = new JFrame("Hours");

        String[] arrayOfHours = {"8:00", "8:30", "9:00", "9:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30"};
        List<String> listOfHours = new ArrayList<>(Arrays.asList(arrayOfHours));
        JButton[] hoursButton = new JButton[listOfHours.size()];

        for (int i = 0; i < listOfHours.size(); i++) {
            hoursButton[i] = new JButton();
            hoursButton[i].setText(listOfHours.get(i));
            hoursFrame.add(hoursButton[i]);

            int finalI = i;
            hoursButton[i].addActionListener(e -> {
                setSelectedHour(hoursButton[finalI].getText());
                hoursFrame.dispose();
            });
        }

        hoursFrame.setLayout(new GridLayout(8, 2));
        hoursFrame.setSize(400, listOfHours.size() * 50);
        hoursFrame.setResizable(false);
        hoursFrame.setLocationRelativeTo(null);
        hoursFrame.setVisible(true);
    }
}

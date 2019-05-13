package nieZnanyLekarz.patientPackage;

import nieZnanyLekarz.interfacePackage.DrawButtons;
import nieZnanyLekarz.interfacePackage.DrawFrame;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectDoctor
        implements DrawButtons, DrawFrame {

    private static String selectedDoctorName;
    public static String getSelectedDoctorName() {
        return selectedDoctorName;
    }
    public static void setSelectedDoctorName(String selectedDoctorName) {
        SelectDoctor.selectedDoctorName = selectedDoctorName;
    }

    void selectDoctor() {
        String[] stringArray_doctorNames = {"Jan Kowalski", "Tomasz Grabarczyk", "Krolik Bugs"};
        List<String> stringList_doctorNames = new ArrayList<>(Arrays.asList(stringArray_doctorNames));

        JFrame frame_selectDoctor = new JFrame("Select doctor");
        JButton[] button_doctorName = new JButton[stringList_doctorNames.size()];

        for (int i = 0; i < stringList_doctorNames.size(); i++) {
            button_doctorName[i] = new JButton(stringList_doctorNames.get(i));
            drawButtons(button_doctorName[i], frame_selectDoctor);

            int finalI = i;
            button_doctorName[i].addActionListener(e -> {
                frame_selectDoctor.dispose();
                BookNewAppointment bookNewAppointment = new BookNewAppointment();
                bookNewAppointment.bookNewAppointment();
                setSelectedDoctorName(button_doctorName[finalI].getText());
            });

        }

        showFrame(frame_selectDoctor, stringList_doctorNames.size(), 1, 200, 100);


        // TODO: frame and buttons for doctors

    }
}

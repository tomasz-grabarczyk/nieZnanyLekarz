package nieZnanyLekarz.patientPackage;

import nieZnanyLekarz.interfacePackage.DrawButtons;
import nieZnanyLekarz.interfacePackage.DrawFrame;
import nieZnanyLekarz.interfacePackage.SelectActionScreenLoop;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SelectSpecialization
        implements DrawButtons, DrawFrame, SelectActionScreenLoop {

    private static String doctorSpecialization;
    public static String getDoctorSpecialization() {
        return doctorSpecialization;
    }
    private static void setDoctorSpecialization(String doctorSpecialization) {
        SelectSpecialization.doctorSpecialization = doctorSpecialization;
    }

    void selectSpecialization() {
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
                setDoctorSpecialization(button_doctorSpecialization[finalI].getText());

                if (getDoctorSpecialization().equals("Internist")) {
                    SelectDoctor selectDoctor = new SelectDoctor();
                    selectDoctor.selectDoctor();
                } else {
                    JOptionPane.showMessageDialog(null, "There is no doctor with specialization: " + getDoctorSpecialization(), "Add new appointment ", JOptionPane.INFORMATION_MESSAGE);
                    goBackToSelectionScreen();
                }

            });

        }

        showFrame(frame_selectSpecialization, stringList_doctorSpecialization.size(), 1, 200, 100);

    }

}

package nieZnanyLekarz;

import javax.swing.*;

class Patient_SelectAction
        implements All_DrawButtonsInterface, All_DrawFrameInterface {

    void drawButtonsSelectActionPatient() {
        JFrame frame_selectActionPatient = new JFrame("Patient - select action:");
        JButton button_showMyAppointments = new JButton("Show my appointments");
        JButton button_bookNewAppointment = new JButton("Book new appointment");

        drawButtons(button_showMyAppointments, frame_selectActionPatient);
        button_showMyAppointments.addActionListener(e -> {
            frame_selectActionPatient.dispose();
            Patient_ShowAllAppointments patient_showAllAppointments = new Patient_ShowAllAppointments();
            patient_showAllAppointments.showPatientAppointments();
        });

        drawButtons(button_bookNewAppointment, frame_selectActionPatient);
        button_bookNewAppointment.addActionListener(e -> {
            frame_selectActionPatient.dispose();
            Patient_BookNewAppointment patient_bookNewAppointment = new Patient_BookNewAppointment();
            patient_bookNewAppointment.patientNewAppointment();
        });

        showFrame(frame_selectActionPatient, 2, 1, 300, 70);
    }
}

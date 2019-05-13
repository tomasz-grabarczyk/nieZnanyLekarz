package nieZnanyLekarz;

import javax.swing.*;

class Doctor_SelectAction
        implements All_DrawButtonsInterface, All_DrawFrameInterface {

    void drawButtonsSelectActionDoctor() {
        JFrame frame_selectActionDoctor = new JFrame("Doctor - select action:");
        JButton button_newAppointment = new JButton("Add new appointment");
        JButton button_showAllAppointments = new JButton("Show all appointments");

        showFrame(frame_selectActionDoctor, 2, 1, 300, 70);

        drawButtons(button_newAppointment, frame_selectActionDoctor);
        button_newAppointment.addActionListener(e -> {
            frame_selectActionDoctor.dispose();
            Doctor_AddNewAppointment doctor_addNewAppointment = new Doctor_AddNewAppointment();
            doctor_addNewAppointment.doctorAddNewAppointment();
        });

        drawButtons(button_showAllAppointments, frame_selectActionDoctor);
        button_showAllAppointments.addActionListener(e -> {
            frame_selectActionDoctor.dispose();
            Doctor_ShowAllAppointments doctor_showAllAppointments = new Doctor_ShowAllAppointments();
            doctor_showAllAppointments.showDoctorAppointments();
        });


    }
}

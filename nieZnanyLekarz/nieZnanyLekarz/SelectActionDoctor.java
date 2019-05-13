package nieZnanyLekarz;

import javax.swing.*;

class SelectActionDoctor implements DrawButtons, DrawFrame {

    void drawButtonsSelectActionDoctor() {
        JFrame selectActionDoctorFrame = new JFrame("Doctor - select action:");
        JButton addNewAppointmentButton = new JButton("Add new appointment");
        JButton showAllAppointmentsButton = new JButton("Show all appointments");

        showFrame(selectActionDoctorFrame, 2, 1);

        drawButtons(addNewAppointmentButton, selectActionDoctorFrame);
        addNewAppointmentButton.addActionListener(e -> {
            selectActionDoctorFrame.dispose();
            CalendarScreen calendarScreen = new CalendarScreen();
            calendarScreen.selectDate();
        });

        drawButtons(showAllAppointmentsButton, selectActionDoctorFrame);
        showAllAppointmentsButton.addActionListener(e -> {
            selectActionDoctorFrame.dispose();
            System.out.println("Show all appointments");
        });


    }
}

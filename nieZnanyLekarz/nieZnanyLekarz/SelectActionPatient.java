package nieZnanyLekarz;

import javax.swing.*;

class SelectActionPatient implements DrawButtons, DrawFrame {

    void drawButtonsSelectActionPatient() {
        JFrame selectActionPatientFrame = new JFrame("Patient - select action:");
        JButton addShowMyAppointmentsButton = new JButton("Show my appointments");
        JButton bookNewAppointmentButton = new JButton("Book new appointment");

        drawButtons(addShowMyAppointmentsButton, selectActionPatientFrame);
        addShowMyAppointmentsButton.addActionListener(e -> {
            selectActionPatientFrame.dispose();
            System.out.println("Show my appointments");
        });

        drawButtons(bookNewAppointmentButton, selectActionPatientFrame);
        bookNewAppointmentButton.addActionListener(e -> {
            selectActionPatientFrame.dispose();
            CalendarScreen calendarScreen = new CalendarScreen();
            calendarScreen.selectDate();
            System.out.println("Book new appointment");
        });

        showFrame(selectActionPatientFrame, 2, 1);
    }
}

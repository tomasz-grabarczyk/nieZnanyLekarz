package nieZnanyLekarz.doctorPackage;

import nieZnanyLekarz.generalPackage.CalendarScreen;
import nieZnanyLekarz.interfacePackage.DrawButtons;
import nieZnanyLekarz.interfacePackage.DrawFrame;

import javax.swing.*;
import java.io.IOException;

public class SelectActionDoctor
        implements DrawButtons, DrawFrame {

    public void selectActionDoctor() {
        JFrame frame_selectActionDoctor = new JFrame("Doctor - select action:"); // stwórz nową ramkę dla wyboru akcji doktora
        JButton button_showAllAppointments = new JButton("Show all appointments"); // stwórz przycisk dla pokazywania wizyt
        JButton button_newAppointment = new JButton("Add new appointment"); // stwórz przycisk dla tworzenia wizyt

        drawButtons(button_showAllAppointments, frame_selectActionDoctor); // stwórz przycisk do pokazania wizyt doktora i dodaj go do ramki
        button_showAllAppointments.addActionListener(e -> { // dodaj akcję po kliknięciu w przycisk
            frame_selectActionDoctor.dispose(); // zamknij ramkę z przyciskami
            ShowDoctorAppointments showDoctorAppointments = new ShowDoctorAppointments();
            try {
                showDoctorAppointments.showDoctorAppointments(); // dodaj ramkę z pokazywaniem wizyt doktora
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        drawButtons(button_newAppointment, frame_selectActionDoctor);
        button_newAppointment.addActionListener(e -> { // dodaj akcję po kliknięciu w przycisk
            frame_selectActionDoctor.dispose(); // zamknij ramkę z przyciskami
            CalendarScreen calendarScreen = new CalendarScreen();
            calendarScreen.selectDate(); // pokaż kalendarz
        });

        showFrame(frame_selectActionDoctor, 2, 1, 300, 70); // pokaż ramkę wyboru akcji doktora i nadaj jej właściwości
        closeFrame(frame_selectActionDoctor); // nadpisanie metody z Interface'u Draw Frame, żeby zamykał okno
    }
}

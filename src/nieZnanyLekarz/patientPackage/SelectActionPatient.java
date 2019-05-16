package nieZnanyLekarz.patientPackage;

import nieZnanyLekarz.interfacePackage.DrawButtons;
import nieZnanyLekarz.interfacePackage.DrawFrame;

import javax.swing.*;
import java.io.IOException;

import static nieZnanyLekarz.generalPackage.CalendarScreen.getDateSelected;
import static nieZnanyLekarz.generalPackage.HoursScreen.getHourSelected;
import static nieZnanyLekarz.patientPackage.SelectDoctorName.getSelectedDoctorName;
import static nieZnanyLekarz.patientPackage.SelectSpecialization.getDoctorSpecialization;


public class SelectActionPatient
        implements DrawButtons, DrawFrame {



    public void selectActionPatient () {
        JFrame frame_selectActionPatient = new JFrame("Patient - select action:"); // stwórz nową ramkę dla wyboru akcji pacjenta
        JButton button_showMyAppointments = new JButton("Show my appointments"); // stwórz przycisk dla pokazywania wizyt
        JButton button_bookNewAppointment = new JButton("Book new appointment"); // stwórz przycisk dla rezerwacji wizyty


        drawButtons(button_showMyAppointments, frame_selectActionPatient); // stwórz przycisk do pokazania wizyt pacjenta i dodaj go do ramki
        button_showMyAppointments.addActionListener(e -> { // dodaj akcję po kliknięciu w przycisk
            frame_selectActionPatient.dispose(); // zamknij ramkę z przyciskami
            ShowPatientAppointments showPatientAppointments = new ShowPatientAppointments();
            try {
                showPatientAppointments.showPatientAppointments(); // pokaż ramkę z wszystkimi wizytami pacjenta
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });

        drawButtons(button_bookNewAppointment, frame_selectActionPatient); // dodaj przycisk do ramki
        button_bookNewAppointment.addActionListener(e -> { // dodaj akcję po kliknięciu w przycisk
            frame_selectActionPatient.dispose(); // zamknij ramkę z przyciskami
            SelectSpecialization selectSpecialization = new SelectSpecialization();
            try {
                // dodaj nowy rekord do pliku
                if (getDoctorSpecialization() != null && getSelectedDoctorName() != null && getDateSelected() != null && getHourSelected() != null) { // zrobione aby uniknąć wrzucania wartości NULL w zmienne przy uruchomieniu apki
                    ShowPatientAppointments showPatientAppointments = new ShowPatientAppointments();
                    showPatientAppointments.insertNewRecordToFile();
                }
                selectSpecialization.selectSpecialization(); // pokaż ramkę z wyborem specjalizacji doktora
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        showFrame(frame_selectActionPatient, 2, 1, 300, 70); // pokaż ramkę i nadaj jej odpowiednie właściwości
        closeFrame(frame_selectActionPatient); // zamknij okno i wyłącz aplikację
    }


}

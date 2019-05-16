package nieZnanyLekarz.generalPackage;

import nieZnanyLekarz.doctorPackage.SelectActionDoctor;
import nieZnanyLekarz.interfacePackage.DrawFrame;
import nieZnanyLekarz.interfacePackage.DrawButtons;
import nieZnanyLekarz.patientPackage.SelectActionPatient;
import nieZnanyLekarz.patientPackage.SelectDoctorName;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class LoginScreen
        implements DrawButtons, DrawFrame {

    private static String string_flagDoctors;
    public String getFlagDoctor() {
        return string_flagDoctors;
    }
    public static void setFlagDoctor(String flagDoctor) {
        string_flagDoctors = flagDoctor;
    }

    private JFrame frame_loginScreen = new JFrame("Logging screen"); // stwórz ramkę logowania
    private JButton button_submit = new JButton("Log in"); // stwórz przycisk do logowania
    private JTextField textField_login = new JTextField("admin"); // stwórz wiersz do wpisania loginu

    private AtomicBoolean atomicBoolean_loginAndPasswordValidated = new AtomicBoolean(false); // ustal wartość walidacji loginy na false

    public void drawLoginFrame() {
        JPasswordField textField_password = new JPasswordField("123"); // stwórz wiersz do wpisania hasła (hashowany)

        frame_loginScreen.add(textField_login); // dodaj przycisk do ramki
        frame_loginScreen.add(textField_password); // dodaj przycisk do ramki
        frame_loginScreen.add(button_submit); // dodaj przycisk do ramki

        button_submit.addActionListener(e -> { // dodaj akcję po kliknięciu
            // TODO: sprawdzenie, czy login i hasło znajdują się w pliku, tutaj porównywane do sztywnych wartości
            if (textField_login.getText().equals("admin") && textField_password.getText().equals("123")) {
                atomicBoolean_loginAndPasswordValidated.set(true);
                proceedAfterSuccessfulLogin();
            } else if (textField_login.getText().equals("Tomasz") && textField_password.getText().equals("123")) {
                atomicBoolean_loginAndPasswordValidated.set(true);
                proceedAfterSuccessfulLogin();
            } else
                JOptionPane.showMessageDialog(null, "Login and/or password is incorrect!\nPlease try again.", "Log in", JOptionPane.INFORMATION_MESSAGE); // pokaż wiadomość po nieudanym logowaniu
        });

        showFrame(frame_loginScreen, 3, 1, 300,70); // pokaż okno logowania i ustal jego właściwości
        closeFrame(frame_loginScreen); // // nadpisanie metody z Interface'u Draw Frame, tak, aby zamykał okno
    }

    private void proceedAfterSuccessfulLogin() {
        if (getFlagDoctor().equals("D") && atomicBoolean_loginAndPasswordValidated.get()) {
            SelectDoctorName.setSelectedDoctorName(textField_login.getText());
            frame_loginScreen.dispose();
            SelectActionDoctor selectActionDoctor = new SelectActionDoctor();
            selectActionDoctor.selectActionDoctor(); // pokaż ramkę z wyborem akcji dla doktora
        } else if (getFlagDoctor().equals("P") && atomicBoolean_loginAndPasswordValidated.get()) {
            frame_loginScreen.dispose();
            SelectActionPatient selectActionPatient = new SelectActionPatient();
            selectActionPatient.selectActionPatient(); // pokaż ramkę z wyborem akcji dla pacjenta
        }
    }
}
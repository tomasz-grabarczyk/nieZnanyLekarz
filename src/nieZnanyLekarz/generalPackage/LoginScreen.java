package nieZnanyLekarz.generalPackage;

import nieZnanyLekarz.doctorPackage.SelectActionDoctor;
import nieZnanyLekarz.interfacePackage.DrawFrame;
import nieZnanyLekarz.interfacePackage.DrawButtons;
import nieZnanyLekarz.patientPackage.SelectActionPatient;
import nieZnanyLekarz.patientPackage.SelectSpecialization;

import javax.swing.*;
import java.awt.*;
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

    private JFrame frame_loginScreen = new JFrame("Logging screen");
    private JButton button_submit = new JButton("Log in");
    private JTextField textField_login = new JTextField("admin");

    private AtomicBoolean atomicBoolean_loginAndPasswordValidated = new AtomicBoolean(false);

    public void drawLoginFrame() {
        frame_loginScreen.setLayout(new GridLayout(3,1));

        JPasswordField textField_password = new JPasswordField("123");

        frame_loginScreen.add(textField_login);
        frame_loginScreen.add(textField_password);
        frame_loginScreen.add(button_submit);

        button_submit.addActionListener(e -> {
            // TODO: sprawdzenie, czy login i hasło znajdują się w pliku, tutaj porównywane do sztywnych wartości
            if (textField_login.getText().equals("admin") && textField_password.getText().equals("123")) {
                atomicBoolean_loginAndPasswordValidated.set(true);
                proceedAfterSuccessfulLogin();
            } else if (textField_login.getText().equals("Tomasz") && textField_password.getText().equals("123")) {
                atomicBoolean_loginAndPasswordValidated.set(true);
                proceedAfterSuccessfulLogin();
            } else
                System.out.println("Login lub hasło nieprawidłowe!");
        });

        showFrame(frame_loginScreen, 3, 1, 300,70);
        closeFrame(frame_loginScreen); // // nadpisanie metody z Interface'u Draw Frame, tak, aby zamykał okno
    }

    private void proceedAfterSuccessfulLogin() {
        if (getFlagDoctor().equals("D") && atomicBoolean_loginAndPasswordValidated.get()) {
            SelectSpecialization.setSelectedDoctorName(textField_login.getText());
            frame_loginScreen.dispose();
            SelectActionDoctor selectActionDoctor = new SelectActionDoctor();
            selectActionDoctor.drawButtonsSelectActionDoctor();
        } else if (getFlagDoctor().equals("P") && atomicBoolean_loginAndPasswordValidated.get()) {
            frame_loginScreen.dispose();
            SelectActionPatient selectActionPatient = new SelectActionPatient();
            selectActionPatient.drawButtonsSelectActionPatient();
        }
    }
}
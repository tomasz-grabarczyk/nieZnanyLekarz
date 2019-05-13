package nieZnanyLekarz;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicBoolean;

class All_LoginScreen
        implements All_DrawButtonsInterface, All_DrawFrameInterface {

    private static String string_flagDoctors;
    String getFlagDoctor() {
        return string_flagDoctors;
    }
    static void setFlagDoctor(String flagDoctor) {
        string_flagDoctors = flagDoctor;
    }

    private JFrame frame_loginScreen = new JFrame("Logging screen");
    private JButton button_submit = new JButton("Log in");

    private AtomicBoolean atomicBoolean_loginAndPasswordValidated = new AtomicBoolean(false);

    void drawLoginFrame() {
        frame_loginScreen.setLayout(new GridLayout(3,1));

        JTextField textField_login = new JTextField("admin");
        JPasswordField textField_password = new JPasswordField("123");

        frame_loginScreen.add(textField_login);
        frame_loginScreen.add(textField_password);
        frame_loginScreen.add(button_submit);

        showFrame(frame_loginScreen, 3, 1, 300,70);

        button_submit.addActionListener(e -> {
            // TODO: sprawdzenie, czy login i hasło znajdują się w pliku, tutaj porównywane do sztywnych wartości
            if (textField_login.getText().equals("admin") && textField_password.getText().equals("123")) {
                atomicBoolean_loginAndPasswordValidated.set(true);
                proceedAfterSuccessfulLogin();
            } else
                System.out.println("Login lub hasło nieprawidłowe!");
        });
    }

    private void proceedAfterSuccessfulLogin() {
        if (getFlagDoctor().equals("D") && atomicBoolean_loginAndPasswordValidated.get()) {
            frame_loginScreen.dispose();
            Doctor_SelectAction doctor_selectAction = new Doctor_SelectAction();
            doctor_selectAction.drawButtonsSelectActionDoctor();
        } else if (getFlagDoctor().equals("P") && atomicBoolean_loginAndPasswordValidated.get()) {
            frame_loginScreen.dispose();
            Patient_SelectAction patient_selectAction = new Patient_SelectAction();
            patient_selectAction.drawButtonsSelectActionPatient();
        }
    }


}
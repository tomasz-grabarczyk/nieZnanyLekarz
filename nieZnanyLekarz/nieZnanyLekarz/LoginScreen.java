package nieZnanyLekarz;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicBoolean;

class LoginScreen implements DrawButtons, DrawFrame {
    private static String flagDoctors;
    String getFlagDoctor() {
        return flagDoctors;
    }
    static void setFlagDoctor(String flagDoctor) {
        flagDoctors = flagDoctor;
    }

    private JFrame loginScreenFrame = new JFrame("Logging screen");
    private JButton submitButton = new JButton("Log in");

    private AtomicBoolean loginAndPasswordValidated = new AtomicBoolean(false);

    void drawLoginFrame() {
        loginScreenFrame.setLayout(new GridLayout(3,1));

        JTextField loginTextField = new JTextField("admin");
        JPasswordField passwordTextField = new JPasswordField("123");

        loginScreenFrame.add(loginTextField);
        loginScreenFrame.add(passwordTextField);
        loginScreenFrame.add(submitButton);

        showFrame(loginScreenFrame, 3, 1);

        submitButton.addActionListener(e -> {
            // TODO: sprawdzenie, czy login i hasło znajdują się w pliku, tutaj porównywane do sztywnych wartości
            if (loginTextField.getText().equals("admin") && passwordTextField.getText().equals("123")) {
                loginAndPasswordValidated.set(true);
                proceedAfterSuccessfulLogin();
            } else
                System.out.println("Login lub hasło nieprawidłowe!");
        });
    }

    private void proceedAfterSuccessfulLogin() {
        if (getFlagDoctor().equals("D") && loginAndPasswordValidated.get()) {
            loginScreenFrame.dispose();
            SelectActionDoctor selectActionDoctor = new SelectActionDoctor();
            selectActionDoctor.drawButtonsSelectActionDoctor();
            System.out.println("Doctor loogen in!"); // Do sprawdzenia czy działa, można wywalić w finalnym kodzie
        } else if (getFlagDoctor().equals("P") && loginAndPasswordValidated.get()) {
            loginScreenFrame.dispose();
            SelectActionPatient selectActionPatient = new SelectActionPatient();
            selectActionPatient.drawButtonsSelectActionPatient();
            System.out.println("Patient logged in!"); // Do sprawdzenia czy działa, można wywalić w finalnym kodzie
        }
    }
}
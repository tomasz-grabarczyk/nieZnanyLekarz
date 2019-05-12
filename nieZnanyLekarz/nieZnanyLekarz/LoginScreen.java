package nieZnanyLekarz;

import javax.swing.*;
import java.awt.*;
import java.util.concurrent.atomic.AtomicBoolean;

class LoginScreen {
    // Ustaw flagę dla doktora albo pacjenta
    private static String flagDoctors;
    private String getFlagDoctor() {
        return flagDoctors;
    }
    static void setFlagDoctor(String flagDoctor) {
        flagDoctors = flagDoctor;
    }

    private JFrame loginFrame = new JFrame();
    private JButton submit = new JButton("Log in");

    private AtomicBoolean loginAndPasswordValidated = new AtomicBoolean(false);

    void drawLoginFrame() {
        loginFrame.setLayout(new GridLayout(3,1));

        JTextField loginTextField = new JTextField("admin");
        JPasswordField passwordTextField = new JPasswordField("123");

        loginFrame.add(loginTextField);
        loginFrame.add(passwordTextField);
        loginFrame.add(submit);

        loginFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        loginFrame.setSize(300, 200);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setResizable(false);
        loginFrame.setVisible(true);

        submit.addActionListener(e -> {
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
            loginFrame.dispose();
            HoursScreen hoursScreen = new HoursScreen();
            hoursScreen.drawHoursButtons();
            System.out.println("Doctor loogen in!"); // Do sprawdzenia czy działa, można wywalić w finalnym kodzie
        } else if (getFlagDoctor().equals("P") && loginAndPasswordValidated.get()) {
            loginFrame.dispose();
            System.out.println("Patient logged in!"); // Do sprawdzenia czy działa, można wywalić w finalnym kodzie
        }
    }
}
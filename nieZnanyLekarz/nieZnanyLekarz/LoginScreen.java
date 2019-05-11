package nieZnanyLekarz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class LoginScreen extends JDatePanelWrapper {

    private String[] array_userAndPassword          = {
            "admin", "123",
            "tgrabarczyk@nzl.pl", "tgpass",
            "mjazdzewska@nzl.pl", "mjpass",
            "kturski@nzl.pl", "ktpass"
    };
    List<String> list_userAndPassword = new ArrayList<>(Arrays.asList(array_userAndPassword));

    void aaa() {
        selectDate();


        System.out.println(pickedDate);
    }
    /*
    void setGeneralLayout(JFrame frame, int width, int height, int noOfRows) {
        frame.setLayout(new GridLayout(noOfRows,1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    void setDateLayout(JFrame frame, int width, int height, int numberOfRows) {
        frame.setLayout(new GridLayout(numberOfRows,1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    void drawLoginScreen() throws IOException {
        launchReader();

        frame_loginScreen.add(textField_username);
        frame_loginScreen.add(textField_password);
        frame_loginScreen.add(button_submit);
        button_submit.setFocusPainted(false);

        setGeneralLayout(frame_loginScreen, 300, 180, 3);
    }

     */
}

package nieZnanyLekarz;

import static nieZnanyLekarz.LoginScreen.setFlagDoctor;

public class MainDoctor {
    public static void main(String[] args) {
        setFlagDoctor("D");

        LoginScreen loginScreen = new LoginScreen();
        loginScreen.drawLoginFrame();
    }
}

package nieZnanyLekarz;

import nieZnanyLekarz.generalPackage.LoginScreen;

import static nieZnanyLekarz.generalPackage.LoginScreen.setFlagDoctor;

public class MainDoctor {

    public static void main(String[] args) {
        setFlagDoctor("D");

        LoginScreen loginScreen = new LoginScreen();
        loginScreen.drawLoginFrame();
    }
}

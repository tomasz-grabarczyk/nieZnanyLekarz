package nieZnanyLekarz;

import nieZnanyLekarz.generalPackage.LoginScreen;

import static nieZnanyLekarz.generalPackage.LoginScreen.setFlagLoggedIn;

public class MainDoctor {

    public static void main(String[] args) {

        setFlagLoggedIn("D"); // ustal flagę na doktora

        LoginScreen loginScreen = new LoginScreen();
        loginScreen.drawLoginFrame(); // pokaż ramkę logowania
    }
}

package nieZnanyLekarz;

import nieZnanyLekarz.generalPackage.LoginScreen;

import java.util.ArrayList;

import static nieZnanyLekarz.generalPackage.LoginScreen.setFlagDoctor;

class MainPatient {

    public static void main(String[] args) {

        setFlagDoctor("P"); // ustal flagę na pacjenta

        LoginScreen loginScreen = new LoginScreen();
        loginScreen.drawLoginFrame(); // pokaż ekran logowania
        }
}

package nieZnanyLekarz;

import nieZnanyLekarz.generalPackage.LoginScreen;

import static nieZnanyLekarz.generalPackage.LoginScreen.setFlagLoggedIn;

class MainPatient {

    public static void main(String[] args) {

        setFlagLoggedIn("P"); // ustal flagę na pacjenta

        LoginScreen loginScreen = new LoginScreen();
        loginScreen.drawLoginFrame(); // pokaż ekran logowania
        }
}

package nieZnanyLekarz;

import nieZnanyLekarz.generalPackage.LoginScreen;

import static nieZnanyLekarz.generalPackage.LoginScreen.setFlagDoctor;

class MainPatient {

    public static void main(String[] args) {
        setFlagDoctor("P");

        LoginScreen loginScreen = new LoginScreen();
        loginScreen.drawLoginFrame();
        }
}

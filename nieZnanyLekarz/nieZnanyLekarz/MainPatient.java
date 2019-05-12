package nieZnanyLekarz;

import static nieZnanyLekarz.LoginScreen.setFlagDoctor;

class MainPatient {
    public static void main(String[] args) {
        setFlagDoctor("P");

        LoginScreen loginScreen = new LoginScreen();
        loginScreen.drawLoginFrame();
        }
}

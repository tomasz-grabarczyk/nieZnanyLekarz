package nieZnanyLekarz;

import static nieZnanyLekarz.All_LoginScreen.setFlagDoctor;

class Patient_Main {

    public static void main(String[] args) {
        setFlagDoctor("P");

        All_LoginScreen all_loginScreen = new All_LoginScreen();
        all_loginScreen.drawLoginFrame();
        }
}

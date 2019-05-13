package nieZnanyLekarz;

import static nieZnanyLekarz.All_LoginScreen.setFlagDoctor;

public class Doctor_Main {

    public static void main(String[] args) {
        setFlagDoctor("D");

        All_LoginScreen all_loginScreen = new All_LoginScreen();
        all_loginScreen.drawLoginFrame();
    }
}

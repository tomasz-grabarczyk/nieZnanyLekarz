package nieZnanyLekarz.interfacePackage;

import nieZnanyLekarz.doctorPackage.SelectActionDoctor;
import nieZnanyLekarz.generalPackage.LoginScreen;
import nieZnanyLekarz.patientPackage.SelectActionPatient;

public interface SelectActionScreenLoop {

    default void goBackToSelectionScreen() {
        LoginScreen loginScreen = new LoginScreen();

        if (loginScreen.getFlagDoctor().equals("D")) {
            SelectActionDoctor selectActionDoctor = new SelectActionDoctor();
            selectActionDoctor.drawButtonsSelectActionDoctor(); // wróc do wyboru akcji dla lekarza
        } else if (loginScreen.getFlagDoctor().equals("P")) {
            SelectActionPatient selectActionPatient = new SelectActionPatient();
            selectActionPatient.drawButtonsSelectActionPatient(); // wróc do wyboru akcji dla pacjenta
        }
    }
}

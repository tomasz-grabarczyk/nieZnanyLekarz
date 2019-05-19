package nieZnanyLekarz.interfacePackage;

import nieZnanyLekarz.doctorPackage.SelectActionDoctor;
import nieZnanyLekarz.generalPackage.LoginScreen;
import nieZnanyLekarz.patientPackage.SelectActionPatient;

public interface SelectionScreen {

    default void selectionScreen() {
        LoginScreen loginScreen = new LoginScreen();

        if (loginScreen.getFlagLoggedIn().equals("D")) {
            SelectActionDoctor selectActionDoctor = new SelectActionDoctor();
            selectActionDoctor.selectActionDoctor(); // wróc do wyboru akcji dla lekarza
        } else if (loginScreen.getFlagLoggedIn().equals("P")) {
            SelectActionPatient selectActionPatient = new SelectActionPatient();
            selectActionPatient.selectActionPatient(); // wróc do wyboru akcji dla pacjenta
        }
    }
}

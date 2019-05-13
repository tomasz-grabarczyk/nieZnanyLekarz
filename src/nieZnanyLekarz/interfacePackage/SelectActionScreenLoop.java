package nieZnanyLekarz.interfacePackage;

import nieZnanyLekarz.doctorPackage.SelectActionDoctor;
import nieZnanyLekarz.generalPackage.LoginScreen;
import nieZnanyLekarz.patientPackage.SelectActionPatient;

public interface SelectActionScreenLoop {

    default void goBackToSelectionScreen() {
        LoginScreen loginScreen = new LoginScreen();

        if (loginScreen.getFlagDoctor().equals("D")) {
            SelectActionDoctor doctor_selectAction = new SelectActionDoctor();
            doctor_selectAction.drawButtonsSelectAction();
        } else if (loginScreen.getFlagDoctor().equals("P")) {
            SelectActionPatient patient_selectAction = new SelectActionPatient();
            patient_selectAction.drawButtonsSelectAction();
        }
    }
}

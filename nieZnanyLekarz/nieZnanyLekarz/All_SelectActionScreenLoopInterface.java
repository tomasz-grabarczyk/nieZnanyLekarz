package nieZnanyLekarz;

interface All_SelectActionScreenLoopInterface {

    default void goBackToSelectionScreen() {
        All_LoginScreen loginScreen = new All_LoginScreen();

        if (loginScreen.getFlagDoctor().equals("D")) {
            Doctor_SelectAction doctor_selectAction = new Doctor_SelectAction();
            doctor_selectAction.drawButtonsSelectActionDoctor();
        } else if (loginScreen.getFlagDoctor().equals("P")) {
            Patient_SelectAction patient_selectAction = new Patient_SelectAction();
            patient_selectAction.drawButtonsSelectActionPatient();
        }
    }
}

package nieZnanyLekarz;

interface SelectActionScreen {

    default void goBackToSelectionScreen() {
        LoginScreen loginScreen = new LoginScreen();

        if (loginScreen.getFlagDoctor().equals("D")) {
            SelectActionDoctor selectActionDoctor = new SelectActionDoctor();
            selectActionDoctor.drawButtonsSelectActionDoctor();
        } else if (loginScreen.getFlagDoctor().equals("P")) {
            SelectActionPatient selectActionPatient = new SelectActionPatient();
            selectActionPatient.drawButtonsSelectActionPatient();
        }
    }
}

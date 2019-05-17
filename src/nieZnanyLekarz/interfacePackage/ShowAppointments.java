package nieZnanyLekarz.interfacePackage;

import javax.swing.*;
import java.io.IOException;

public interface ShowAppointments extends DrawFrame, ReadDataFromFile {

    default void showAppointments(JFrame frameName, String filePath, boolean isDoctor, int heightMultiplierValue, String doctorName) throws IOException {

        int numberOfRows = 0;

        for (String numberOfPatientAppointment : readDataFromFile(filePath, "  ")) {
            String[] appointmentInfoSeparated = numberOfPatientAppointment.split(";"); // rozdzielenie stringa z pliku na poszczególne kawałki bazując na średniku ";"
            if (appointmentInfoSeparated[1].equals(doctorName) && isDoctor) {
                numberOfRows += 1;
                JLabel labelPatientAppointment = new JLabel();
                labelPatientAppointment.setText("<html>" + "Date: " + appointmentInfoSeparated[2] + "<br/>Hour: " + appointmentInfoSeparated[3] + "</html>");
                frameName.add(labelPatientAppointment);
            } else if (!isDoctor){
                numberOfRows += 1;
                JLabel labelPatientAppointment = new JLabel();
                labelPatientAppointment.setText("<html>" + "Specialization: " + appointmentInfoSeparated[0] + "<br/>Doctor: " + appointmentInfoSeparated[1] + "<br/>Date: " + appointmentInfoSeparated[2] + "<br/>Hour: " + appointmentInfoSeparated[3] + "</html>");
                frameName.add(labelPatientAppointment);
            }
        }

        showFrame(frameName, numberOfRows, 1, 300, heightMultiplierValue); // pokaż ramkę i ustal jej właściwości
    }
}

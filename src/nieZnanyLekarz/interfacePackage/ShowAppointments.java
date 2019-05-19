package nieZnanyLekarz.interfacePackage;

import javax.swing.*;
import java.io.IOException;

public interface ShowAppointments extends DrawFrame, ReadDataFromFile {

    default void showAppointments(JFrame frameName, String filePath, boolean isDoctor, int heightMultiplierValue, int width, String doctorName) throws IOException {

        int numberOfRows = 0,
            numberOfColumns = 0,
            oddNuber = 1;

        for (String numberOfPatientAppointment : readDataFromFile(filePath, "  ")) { // rozdzielenie stringa z pliku na podstawie "  "
            String[] appointmentInfoSeparated = numberOfPatientAppointment.split(";"); // rozdzielenie stringa z pliku na podstawie ";"
            if (appointmentInfoSeparated[1].equals(doctorName) && isDoctor) { // jeśli loguje się doktor i jeśli jest jakieś imię i nazwisko pasujące do umówionej wizyty to wylistuj te wizyty
                numberOfRows += 1; // dodaj wiersz dla każdego rekordu
                JLabel labelPatientAppointment = new JLabel(); // stwórz labela
                labelPatientAppointment.setText("<html>" + "Date: " + appointmentInfoSeparated[2] + "<br/>Hour: " + appointmentInfoSeparated[3] + "</html>"); // ustaw tekst labela
                frameName.add(labelPatientAppointment); // dodaj labela do ramki
            } else if (!isDoctor) { // jeśli loguje się pacjent to pokaż wszystkie wizyty na podstawie tego co w pliku
                numberOfRows += 1; // dodaj wiersz dla każdego rekordu
                JLabel labelPatientAppointment = new JLabel();
                labelPatientAppointment.setText("<html>" + "Specialization: " + appointmentInfoSeparated[0] + "<br/>Doctor: " + appointmentInfoSeparated[1] + "<br/>Date: " + appointmentInfoSeparated[2] + "<br/>Hour: " + appointmentInfoSeparated[3] + "</html>"); // ustaw tekst labela
                frameName.add(labelPatientAppointment); // dodaj labela do ramki
            }
        }

        for (int i = 0; i <= 100; i += 10) { // pokaż informacje dla maksymalnie 100 wizyt
            if (i == 0)
                oddNuber = 0; // jeśli wizyt jest poniżej 10 to nie dodawaj kolejnego nadmiarowego wiersza
            if (numberOfRows > i && numberOfRows <= i + 10)
                numberOfColumns = (i + 10) / 10; // ustaw liczbę kolumn na podstawie liczby rekordów
        }

        if (numberOfRows % 2 == 1)
            showFrame(frameName, (numberOfRows / numberOfColumns) + oddNuber, numberOfColumns, width * numberOfColumns, heightMultiplierValue); // jeśli liczba wierzy jest nieparzysta to dodaj jeden wiersz oraz pokaż ramkę i ustal jej właściwości
        else
            showFrame(frameName, numberOfRows / numberOfColumns, numberOfColumns, width * numberOfColumns, heightMultiplierValue); // pokaż ramkę i ustal jej właściwości



    }
}

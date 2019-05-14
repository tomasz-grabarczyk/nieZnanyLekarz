package nieZnanyLekarz.interfacePackage;

import javax.swing.*;

public interface DrawButtons {

    default void drawButtons(JButton buttonName, JFrame frameName) {
        buttonName.setSize(200, 100); // ustaw rozmiar przyciski
        buttonName.setFocusPainted(false); // nie pokazuj wykropkowanej ramki po kliknięciu przycisku
        frameName.add(buttonName); // dodaj przycisk do ramki
    }
}

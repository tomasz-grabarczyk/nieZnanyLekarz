package nieZnanyLekarz.interfacePackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public interface DrawFrame extends SelectionScreen {

    default void showFrame(JFrame frameName, int numerOfRows, int numerOfColumns, int width, int heightMultiplierValue) {
        frameName.setLayout(new GridLayout(numerOfRows,numerOfColumns)); // stwórz GridLayout
        frameName.setSize(width,heightMultiplierValue * numerOfRows); // ustaw wielkość
        frameName.setLocationRelativeTo(null); // pokaż ramkę na środku ekranu
        frameName.setResizable(false); // zablokuj możliwość zmiany rozmiaru ramki
        frameName.setVisible(true); // pokaż ramkę

        frameName.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent event) {
                selectionScreen(); // po naciśnięciu "X" wraca do ramki wyboru akcji
            }
        });
    }

    default void closeFrame (JFrame frame) {
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // po naciśnieciu "X" zamknij ramkę i wyłącz aplikację
    }
}

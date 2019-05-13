package nieZnanyLekarz.interfacePackage;

import javax.swing.*;
import java.awt.*;

public interface DrawFrame {

    default void showFrame(JFrame frameName, int numerOfRows, int numerOfColumns, int width, int heightValue) {
        frameName.setLayout(new GridLayout(numerOfRows,numerOfColumns));
        frameName.setSize(width,heightValue * numerOfRows);
        frameName.setLocationRelativeTo(null);
        frameName.setResizable(false);
        frameName.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameName.setVisible(true);
    }
}

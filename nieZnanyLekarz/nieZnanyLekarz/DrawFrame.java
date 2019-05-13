package nieZnanyLekarz;

import javax.swing.*;
import java.awt.*;

interface DrawFrame {

    default void showFrame(JFrame frameName, int numerOfRows, int numerOfColumns) {
        frameName.setLayout(new GridLayout(numerOfRows,numerOfColumns));
        frameName.setSize(300,70 * numerOfRows);
        frameName.setLocationRelativeTo(null);
        frameName.setResizable(false);
        frameName.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frameName.setVisible(true);
    }
}

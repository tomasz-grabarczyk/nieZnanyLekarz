package nieZnanyLekarz;

import javax.swing.*;

interface DrawButtons {

    default void drawButtons(JButton buttonName, JFrame frameName) {
        buttonName.setSize(200, 100);
        buttonName.setFocusPainted(false);
        frameName.add(buttonName);
    }
}

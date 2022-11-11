package javas.views.components;


import javas.constants.ViewConstants;

import javax.swing.*;
import java.awt.*;



public class Input extends JFormattedTextField {

    public Input() {
        init();
    }

    private void init() {
        this.setBorder(BorderFactory.createLineBorder(ViewConstants.BORDER_COLOR));
        this.setPreferredSize(new Dimension(500, 45));
        setFont(new Font("Fira Sans", Font.PLAIN, 16));
    }
}

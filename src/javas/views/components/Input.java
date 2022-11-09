package javas.views.components;

import javas.constants.ViewConstants;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;



public class Input extends JTextField {
    private Border border;

    public Input() {
        init();
    }

    private void init() {
        this.border = BorderFactory.createLineBorder(ViewConstants.BORDER_COLOR, 0);
        setBorder(border);
        setFont(new Font("Fira Sans", Font.PLAIN, 16));
    }
}

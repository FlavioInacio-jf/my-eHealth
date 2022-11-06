package javas.view.components;

import javas.AppContants;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;



public class Input extends JTextField {
    private Border border;

    public Input() {
        init();
    }

    private void init() {
        this.border = BorderFactory.createLineBorder(AppContants.BORDER_COLOR, 0);
        setBorder(border);
        setFont(new Font("Fira Sans", Font.PLAIN, 16));
    }
}
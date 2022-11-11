package javas.views.components;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;



public class Input extends JFormattedTextField {
    private Border border;

    public Input() {
        init();
    }

    private void init() {
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setPreferredSize(new Dimension(500, 45));
        setFont(new Font("Fira Sans", Font.PLAIN, 16));
    }
}

package javas.view.components;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Input extends JTextField {
    private Border border;

    public Input() {
        init();
    }

    private void init() {
        this.border = BorderFactory.createLineBorder(new Color(229, 229, 229), 1);
        setBorder(border);
        setFont(new Font("Fira Sans", Font.PLAIN, 16));
        setSize(100, 10);
    }
}

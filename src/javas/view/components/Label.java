package javas.view.components;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Label extends JLabel {
    public Label (String title) {
        super(title);
        this.init();
    }

    public void init() {
        setFont(new Font("Fira Sans", Font.BOLD, 12));
        setBackground(Color.WHITE);
        setAlignmentX(0);
    }
}

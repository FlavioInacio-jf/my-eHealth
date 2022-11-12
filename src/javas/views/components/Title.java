package javas.views.components;

import javax.swing.*;
import java.awt.*;

public class Title extends JLabel {
    public Title(String text, int align) {
        super(text, align);
        this.init();
    }

    private void init() {
        this.setFont(new Font("Fira Sans", Font.BOLD, 24));
    }
}

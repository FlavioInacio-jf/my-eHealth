package javas.views.components;

import javax.swing.*;
import java.awt.*;

public class ButtonWithIcon extends JButton {
    public ButtonWithIcon(String title) {
        super(title);

        this.setPreferredSize(new Dimension(120, 80));
        this.setHorizontalAlignment(SwingConstants.CENTER);
        this.setVerticalTextPosition(SwingConstants.BOTTOM);
        this.setHorizontalTextPosition(SwingConstants.CENTER);
        this.setFocusPainted(false);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.setBorder(null);
        this.setOpaque(true);
        this.setBackground(Color.WHITE);
    }
}

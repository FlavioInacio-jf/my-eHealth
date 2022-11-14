package javas.views.components;

import javas.constants.ViewConstants;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class Button extends JButton {
    public Button(String title) {
        init(title);
    }

    private void init(String title) {
        this.setText(title);

        this.setFont(new Font("Fira Sans", Font.PLAIN, 16));
        this.setBackground(ViewConstants.PRIMARY_COLOR);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
        this.setBorder(null);
        this.setPreferredSize(new Dimension(500, 45));
        this.setForeground(Color.WHITE);
    }
}

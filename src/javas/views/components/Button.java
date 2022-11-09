package javas.views.components;

import javas.constants.ViewConstants;

import javax.swing.*;
import java.awt.*;

public class Button extends JButton {
    public Button(String title) {
        init(title);
    }

    private void init(String title) {
        setText(title);

        setFont(new Font("Fira Sans", Font.PLAIN, 16));
        setBackground(ViewConstants.PRIMARY_COLOR);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setBorder(null);
        setMaximumSize(new Dimension(500, 45));
        setForeground(Color.WHITE);
    }
}

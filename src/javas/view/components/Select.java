package javas.view.components;

import javas.AppContants;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Select extends JComboBox {
    private Border border;

    public Select() {
        init();
    }

    private void init() {
        this.border = BorderFactory.createLineBorder(AppContants.BORDER_COLOR, 0);
        setBorder(border);
        setBackground(Color.white);
        setAlignmentX(Component.LEFT_ALIGNMENT);
        setFont(new Font("Fira Sans", Font.PLAIN, 16));
    }
}

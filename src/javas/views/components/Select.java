package javas.views.components;

import javas.constants.ViewConstants;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class Select extends JComboBox {
    private Border border;

    public Select(String[] values) {
        super(values);
        init();
    }

    private void init() {
        this.border = BorderFactory.createLineBorder(ViewConstants.BORDER_COLOR, 1);
        this.setBorder(null);
        this.setOpaque(true);
        this.setBackground(Color.white);
        this.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.setFont(new Font("Fira Sans", Font.PLAIN, 16));
    }
}

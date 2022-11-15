package javas.views.components;

import javax.swing.*;
import java.awt.*;

public class Select extends JComboBox {

    public Select(String[] values) {
        super(values);
        init();
    }

    private void init() {
        this.setBorder(null);
        this.setOpaque(true);
        this.setBackground(Color.white);
        this.setAlignmentX(Component.LEFT_ALIGNMENT);
        this.setFont(new Font("Fira Sans", Font.PLAIN, 16));
    }
}

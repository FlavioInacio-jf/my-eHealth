package javas.views.components;

import javax.swing.*;
import java.awt.*;

public class LabelGroup extends JPanel {
    public LabelGroup(String label, String value) {
        this.init(label, value);
    }

    private void init(String label, String value) {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel labelBloodType = new JLabel(label);
        labelBloodType.setFont(new Font("Fira Sans", Font.BOLD, 16));

        JLabel labelBloodTypeValue = new JLabel(value);
        labelBloodTypeValue.setFont(new Font("Fira Sans", Font.PLAIN, 16));

        this.setBackground(Color.WHITE);
        this.add(labelBloodType);
        this.add(labelBloodTypeValue);
    }
}

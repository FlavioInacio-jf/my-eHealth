package javas.views.components;

import javax.swing.*;
import java.awt.*;

public class LabelGroup extends JPanel {
    public LabelGroup(String label, String value) {
        this.init(label, value);
    }

    private void init(String label, String value) {
        this.setLayout(new FlowLayout());

        JLabel labelBloodType = new JLabel(label);
        JLabel labelBloodTypeValue = new JLabel(value);

        this.add(labelBloodType);
        this.add(labelBloodTypeValue);
    }
}

package javas.views.components;

import javax.swing.*;
import java.awt.*;

public class FormGroupInput {
    Input input;
    Label label;

    public FormGroupInput() {
    }

    public JPanel init(String title) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        this.input = new Input();
        this.label = new Label(title);
        this.label.setLabelFor(this.input);

        panel.add(this.label);
        panel.add(Box.createVerticalStrut(5));
        panel.add(this.input);
        return panel;
    }

    public String getText() {
        return this.input.getText();
    }
}

package javas.view.components;

import javax.swing.*;
import java.awt.*;

public class FormGroupInput {
    Input input;
    Label label;

    public FormGroupInput() {
    }

    public Box init(String title) {
        this.input = new Input();
        this.label = new Label(title);
        this.label.setLabelFor(this.input);

        Box box = new Box(BoxLayout.Y_AXIS);
        box.setBackground(Color.WHITE);
        box.add(this.label);
        box.add(Box.createVerticalStrut(5));
        box.add(this.input);
        box.setMaximumSize(new Dimension(500, 45));
        return box;
    }

    public String getText() {
        return this.input.getText();
    }
}

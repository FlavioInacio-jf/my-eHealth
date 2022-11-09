package javas.views.components;

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

        Box box = new Box(BoxLayout.X_AXIS);
        box.setBackground(Color.WHITE);
        box.add(this.label);
        box.add(this.input);
        return box;
    }

    public String getText() {
        return this.input.getText();
    }
}

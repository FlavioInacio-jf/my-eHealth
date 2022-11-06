package javas.view.components;

import javax.swing.*;
import java.awt.*;

public class FormGroup {
    Input input;
    Label label;

    public FormGroup() {
    }

    public Box init(String title) {
        this.input = new Input();
        this.label = new Label(title);
        Box box = new Box(BoxLayout.Y_AXIS);
        box.setBackground(Color.WHITE);
        box.add(this.label);
        box.add(this.input);
        box.setSize(100, 100);
        return box;
    }

    public String getText() {
        return this.input.getText();
    }
}

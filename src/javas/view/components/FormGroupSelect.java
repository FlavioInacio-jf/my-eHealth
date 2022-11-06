package javas.view.components;

import javax.swing.*;
import java.awt.*;

public class FormGroupSelect {
    Select select;
    Label label;

    public FormGroupSelect() {
    }

    public Box init(String title) {
        this.select = new Select();
        this.label = new Label(title);
        this.label.setLabelFor(this.select);

        Box box = new Box(BoxLayout.Y_AXIS);
        box.setBackground(Color.WHITE);
        box.add(this.label);
        box.add(Box.createVerticalStrut(5));
        box.add(this.select);
        box.setMaximumSize(new Dimension(500, 45));
        return box;
    }

    public Object getSelectedItem() {
        return this.select.getSelectedItem();
    }
}

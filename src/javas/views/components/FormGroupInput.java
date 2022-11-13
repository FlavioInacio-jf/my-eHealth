package javas.views.components;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.text.ParseException;

public class FormGroupInput extends JPanel {
    Input input;
    Label label;

    public FormGroupInput(String title) {
        this.init(title);
    }

    private void init(String title) {
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.input = new Input();
        this.label = new Label(title);
        this.label.setLabelFor(this.input);

        this.setBackground(Color.WHITE);
        this.add(this.label);
        this.add(Box.createVerticalStrut(5));
        this.add(this.input);
    }

    public void setMaskFormatter(String mask) {
        try {
            MaskFormatter maskFormatter = new MaskFormatter(mask);
            maskFormatter.install(this.input);
        }catch (ParseException error) {
        }

    }

    public String getText() {
        return this.input.getText();
    }

}

package javas.views.components;

import javax.swing.*;
import java.awt.*;

public class FormGroupSelect extends JPanel{
    Select select;
    Label label;

    public FormGroupSelect(String title, String[] values) {
        this.init(title, values);
    }

    private void init(String title, String[] values) {
        this.select = new Select(values);
        this.select.setBorder(null);
        this.label = new Label(title);
        this.label.setLabelFor(this.select);

        Box box = new Box(BoxLayout.X_AXIS);
        box.setBackground(Color.WHITE);
        box.add(this.label);
        box.add(Box.createHorizontalStrut(5));
        box.add(this.select);
        this.setMaximumSize(new Dimension(500, 45));
        this.add(box);
        this.setBackground(Color.WHITE);
    }

    public Object getSelectedItem() {
        return this.select.getSelectedItem();
    }

    public void setSelectItem(Object object) {
        this.select.getModel().setSelectedItem(object);
    }
}

package javas.views.components;

import javax.swing.*;
import java.awt.*;

public class Column extends JPanel {

    public Column(int columnQuantities, int gap) {
        this.init(columnQuantities, gap);
    }

    private void init(int columnQuantities, int gap) {
        JPanel column = new JPanel();
        GridLayout columnLayout = new GridLayout(1, columnQuantities);
        columnLayout.setHgap(gap);
        column.setLayout(columnLayout);
        this.setBackground(Color.WHITE);
        this.add(column);
    }
}

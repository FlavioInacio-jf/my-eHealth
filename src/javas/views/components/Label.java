package javas.views.components;
import javax.swing.*;
import java.awt.*;

public class Label extends JLabel {
    public Label (String title) {
        super(title);
        this.init();
    }

    public void init() {
        setFont(new Font("Fira Sans", Font.BOLD, 12));
        setBackground(Color.WHITE);
    }
}

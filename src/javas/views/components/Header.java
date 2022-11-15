package javas.views.components;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class Header extends JPanel {
    public  Header(String title, URL iconURL) {
        this.init(title, iconURL);
    }

    private void init(String text, URL iconURL) {
        this.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        Title title = new Title(text, SwingConstants.CENTER);
        Icon healthUnitIcon = new ImageIcon(iconURL);

        this.add(new JLabel(healthUnitIcon));
        this.setBackground(Color.WHITE);
        this.add(title);
    }
}

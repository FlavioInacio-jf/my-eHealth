package javas.views.components;

import javas.constants.ViewConstants;

import javax.swing.*;
import java.awt.*;

public class BaseFrame extends JFrame {
    public BaseFrame() {
        this.init();
    }
    private void init() {
        this.getContentPane().setBackground(Color.WHITE);
        this.setBounds(  ViewConstants.SCREEN_CENTER.x - ViewConstants.SCREEN_SIZE.x / 2,
                ViewConstants.SCREEN_CENTER.y - ViewConstants.SCREEN_SIZE.y  / 2,
                ViewConstants.SCREEN_SIZE.x, ViewConstants.SCREEN_SIZE.y);

        this.setResizable(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }
}

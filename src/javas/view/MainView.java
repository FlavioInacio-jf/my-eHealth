package javas.view;

import javas.AppContants;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
    private JPanel jPanelNorth, jPanelSouth, jPanelCenter;
    private JButton jButtonFirst, jButtonLast, jButtonNext,
                    jButtonPre, jButtonAdd, jButtonDelete,
                    jButtonUpdate, jButtonFind;
    public MainView() {
        this.init();
    }


    private void init() {
        setTitle(AppContants.MAINVIEW_TITLE);

        // North panel
        jPanelNorth = new JPanel();
        jPanelNorth.setLayout(new GridLayout(1, 5));



        // South panel
        jPanelSouth = new JPanel();
        jPanelSouth.setLayout(new GridLayout(1, 5));


        this.add(jPanelNorth, BorderLayout.NORTH);
        this.add(jPanelSouth, BorderLayout.SOUTH);


        setBounds(  AppContants.SCREEN_CENTER.x - AppContants.SCREEN_SIZE.x / 2,
                    AppContants.SCREEN_CENTER.y - AppContants.SCREEN_SIZE.y  / 2,
                    AppContants.SCREEN_SIZE.x, AppContants.SCREEN_SIZE.y);

        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }
}

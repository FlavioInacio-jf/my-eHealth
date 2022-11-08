package javas.view;

import javas.constants.ViewConstants;

import javax.swing.*;
import java.awt.*;

public class MainView extends JFrame {
    private JPanel jPanelNorth, jPanelSouth, jPanelCenter;
    private JButton jButtonFirst, jButtonLast, jButtonNext,
                    jButtonPre, jButtonAdd, jButtonDelete,
                    jButtonUpdate, jButtonFind;
    public MainView() {
        this.init();
    }


    private void init() {
        this.setTitle(ViewConstants.MAIN_VIEW_TITLE);

        // Content panel layout
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());

        // MenuBar
        JMenuBar menuBar = new JMenuBar();
        JMenu about = new JMenu("Sobre");
        menuBar.add(about);

        // Tabbed Panel
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Paciente", null, new PersonView(), "Ações do paciente");
        tabbedPane.addTab("Unidade de Saúde", null, new HealthUnitView(), "Ações da Unidade de Saúde");


        this.setJMenuBar(menuBar);
        contentPane.add(tabbedPane);

        this.setBounds(  ViewConstants.SCREEN_CENTER.x - ViewConstants.SCREEN_SIZE.x / 2,
                ViewConstants.SCREEN_CENTER.y - ViewConstants.SCREEN_SIZE.y  / 2,
                ViewConstants.SCREEN_SIZE.x, ViewConstants.SCREEN_SIZE.y);

        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String args[]) {
        new MainView();
    }
}

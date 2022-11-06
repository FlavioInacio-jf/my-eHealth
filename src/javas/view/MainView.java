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
        this.setTitle(AppContants.MAIN_VIEW_TITLE);

        Container contentPane = this.getContentPane();

        JMenuBar menuBar = new JMenuBar();
        menuBar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        JMenu personBar = new JMenu("Paciente");
        personBar.add(new JMenuItem("Cadastrar"));
        personBar.add(new JMenuItem("Atualizar"));
        personBar.add(new JMenuItem("Consultar"));
        personBar.add(new JMenuItem("Excluir"));

        JMenu healthUnitBar = new JMenu("Unidade de Saúde");
        healthUnitBar.add(new JMenuItem("Cadastrar"));
        healthUnitBar.add(new JMenuItem("Atualizar"));
        healthUnitBar.add(new JMenuItem("Consultar"));
        healthUnitBar.add(new JMenuItem("Excluir"));
        JMenu reportBar = new JMenu("Relatório");

        menuBar.add(personBar);
        menuBar.add(healthUnitBar);
        menuBar.add(reportBar);


        this.setJMenuBar(menuBar);

        this.setBounds(  AppContants.SCREEN_CENTER.x - AppContants.SCREEN_SIZE.x / 2,
                    AppContants.SCREEN_CENTER.y - AppContants.SCREEN_SIZE.y  / 2,
                    AppContants.SCREEN_SIZE.x, AppContants.SCREEN_SIZE.y);

        this.setResizable(false);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String args[]) {
        new MainView();
    }
}

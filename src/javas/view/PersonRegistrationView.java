package javas.view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PersonRegistrationView implements ActionListener {
    private JFrame frame;
    public PersonRegistrationView() {
       this.makeFrame();
    }

    public void actionPerformed(ActionEvent event) {
        System.out.println(event.getActionCommand());
    }
    private void makeFrame() {
        this.frame = new JFrame("Registrar pessoa");
        Container contentPane = this.frame.getContentPane();

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        JMenuItem openItem = new JMenuItem("Open");
        openItem.addActionListener(this);
        fileMenu.add(openItem);

        menuBar.add(new JMenu("Quit"));
        JLabel label = new JLabel("Nome");

        contentPane.add(label);
        frame.pack();
        frame.setVisible(true);
    }
}

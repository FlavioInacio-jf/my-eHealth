package javas.view;

import javas.constants.ViewConstants;
import javas.view.components.*;
import javas.view.components.Button;
import javas.view.components.Label;

import java.awt.*;
import javax.swing.*;

public class PersonView extends JPanel {
    public PersonView() {
        this.init();
    }

    private void init() {
        this.setLayout(new BorderLayout());
        this.setBorder(null);

        JPanel jPanelNorth = new JPanel();
        jPanelNorth.setBackground(Color.WHITE);
        JPanel jPanelSouth = new JPanel();
        jPanelSouth.setBackground(Color.WHITE);

        // Configure north area

        UIManager.put("Button.background", Color.WHITE);
        UIManager.put("Button.setPreferredSize", new Dimension(200, 50));

        jPanelNorth.setLayout(new FlowLayout(FlowLayout.LEFT));
        JButton addPersonButton = new JButton("Adicionar");
        addPersonButton.setPreferredSize(new Dimension(200, 50));
        addPersonButton.setIcon(new ImageIcon(this.getClass().getResource("icons/add-user-icon.png")));
        addPersonButton.setHorizontalAlignment(SwingConstants.CENTER);
        addPersonButton.setVerticalTextPosition(SwingConstants.BOTTOM);
        addPersonButton.setHorizontalTextPosition(SwingConstants.CENTER);
        addPersonButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
        addPersonButton.setBorder(null);

        jPanelNorth.add(addPersonButton);
        jPanelNorth.add(new JButton("Atualizar"));
        jPanelNorth.add(new JButton("Excluir"));
        jPanelNorth.add(new JButton("Relatório"));


        // Configure south area
        FlowLayout layoutPanelSouth = new FlowLayout();
        jPanelSouth.setLayout(layoutPanelSouth);

        Box firstName = new FormGroupInput().init("Primeiro nome:");
        Box lastName = new FormGroupInput().init("Último nome");
        Box CPF = new FormGroupInput().init("CPF");
        Box age = new FormGroupInput().init("Idade");
        Box bloodType = new FormGroupSelect().init("Grupo sanguíneo");

        Button addButton = new Button("Adicionar paciente");

        jPanelSouth.add(firstName);
        jPanelSouth.add(Box.createVerticalStrut(15));
        jPanelSouth.add(lastName);
        jPanelSouth.add(Box.createVerticalStrut(15));
        jPanelSouth.add(CPF);
        jPanelSouth.add(Box.createVerticalStrut(15));
        jPanelSouth.add(age);
        jPanelSouth.add(Box.createVerticalStrut(15));
        jPanelSouth.add(bloodType);
        jPanelSouth.add(Box.createVerticalStrut(15));
        jPanelSouth.add(addButton);


        this.add(jPanelNorth, BorderLayout.NORTH);
        this.add(jPanelSouth, BorderLayout.SOUTH);
        this.setBackground(Color.WHITE);
    }
}

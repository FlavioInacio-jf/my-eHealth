package javas.views.personViews;

import javas.constants.ViewConstants;
import javas.views.components.*;
import javas.views.components.Button;

import java.awt.*;
import javax.swing.*;

public class PersonView extends JPanel {
    public PersonView() {
        this.init();
    }

    private void init() {
        this.setLayout(new BorderLayout());
        this.setBorder(null);

        // Configure north area
        JPanel jPanelNorth = new JPanel();
        jPanelNorth.setBackground(Color.WHITE);

        jPanelNorth.setLayout(new FlowLayout(FlowLayout.LEFT));
        jPanelNorth.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, ViewConstants.BORDER_COLOR));

        ButtonWithIcon addPersonButton = new ButtonWithIcon("Adicionar");
        addPersonButton.setIcon(new ImageIcon(this.getClass().getResource("../icons/add-user-icon.png")));
        jPanelNorth.add(addPersonButton);

        ButtonWithIcon updatePersonButton = new ButtonWithIcon("Atualizar");
        updatePersonButton.setIcon(new ImageIcon(this.getClass().getResource("../icons/update-user-icon.png")));
        jPanelNorth.add(updatePersonButton);

        ButtonWithIcon deletePersonButton = new ButtonWithIcon("Excluir");
        deletePersonButton.setIcon(new ImageIcon(this.getClass().getResource("../icons/remove-user-icon.png")));
        jPanelNorth.add(deletePersonButton);

        ButtonWithIcon reportPersonButton = new ButtonWithIcon("Relatório");
        reportPersonButton.setIcon(new ImageIcon(this.getClass().getResource("../icons/report-user-icon.png")));
        jPanelNorth.add(reportPersonButton);

        ButtonWithIcon vaccinePersonButton = new ButtonWithIcon("Vacinar");
        vaccinePersonButton.setIcon(new ImageIcon(this.getClass().getResource("../icons/vaccine-icon.png")));
        jPanelNorth.add(vaccinePersonButton);
        this.add(jPanelNorth, BorderLayout.NORTH);


        // Configure center area
        JPanel jPanelCenter = new JPanel();
        jPanelCenter.setBackground(Color.WHITE);
        jPanelCenter.setLayout(new GridLayout(1, 2));

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new BoxLayout(formPanel, BoxLayout.Y_AXIS));

        Box firstName = new FormGroupInput().init("Primeiro nome:");
        Box lastName = new FormGroupInput().init("Último nome");
        Box CPF = new FormGroupInput().init("CPF");
        Box age = new FormGroupInput().init("Idade");
        Box bloodType = new FormGroupSelect().init("Grupo sanguíneo");

        Button addButton = new Button("Adicionar paciente");

        formPanel.add(firstName);
        formPanel.add(Box.createVerticalStrut(15));
        formPanel.add(lastName);
        formPanel.add(Box.createVerticalStrut(15));
        formPanel.add(CPF);
        formPanel.add(Box.createVerticalStrut(15));
        formPanel.add(age);
        formPanel.add(Box.createVerticalStrut(15));
        formPanel.add(bloodType);
        formPanel.add(Box.createVerticalStrut(15));
        formPanel.add(addButton);
        jPanelCenter.add(formPanel, BorderLayout.CENTER);
        jPanelCenter.add(new Button("Teste"));
        this.add(jPanelCenter);

        this.setBackground(Color.WHITE);
    }
}

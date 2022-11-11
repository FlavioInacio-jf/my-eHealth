package javas.views.personViews;

import javas.constants.ViewConstants;
import javas.views.components.*;
import javas.views.components.Button;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AddPersonView extends BaseFrame {
    public AddPersonView() {
        init();
    }

    private void init(){
        this.setTitle(ViewConstants.ADD_PERSON_VIEW_TITLE);
        Container contentPanel = this.getContentPane();
        contentPanel.setLayout(new BorderLayout());

        // Form layout setup
        JPanel panelNorth = new JPanel();
        panelNorth.setBorder(new EmptyBorder(15, 15, 0, 0));
        GridLayout formLayout = new GridLayout(7, 1);
        formLayout.setVgap(15);
        panelNorth.setLayout(formLayout);
        panelNorth.add(new Title("Registrar um novo paciente", SwingConstants.CENTER));

        JPanel firstName = new FormGroupInput("Primeiro nome:");
        JPanel lastName = new FormGroupInput("Último nome");
        JPanel CPF = new FormGroupInput("CPF");
        JPanel age = new FormGroupInput("Nascimento");
        Box bloodType = new FormGroupSelect().init("Grupo sanguíneo");

        Button addButton = new Button("Adicionar paciente");

        // First row
        JPanel firstRow = new JPanel();
        firstRow.setLayout(new BoxLayout(firstRow, BoxLayout.X_AXIS));
        firstRow.add(firstName);
        firstName.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 15));
        firstRow.add(lastName);

        // Second row
        JPanel secondRow = new JPanel();

        panelNorth.add(firstRow);
        panelNorth.add(CPF);
        panelNorth.add(age);
        panelNorth.add(bloodType);
        panelNorth.add(addButton);

        contentPanel.add(panelNorth, BorderLayout.NORTH);
    }
}

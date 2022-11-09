package javas.views.personViews;

import javas.constants.ViewConstants;
import javas.views.components.Button;
import javas.views.components.FormGroupInput;
import javas.views.components.FormGroupSelect;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AddPersonView extends JFrame {
    public AddPersonView() {
        init();
    }

    private void init(){
        this.setTitle(ViewConstants.ADD_PERSON_VIEW_TITLE);
        Container contentPanel = this.getContentPane();
        contentPanel.setLayout(new BorderLayout());

        JLabel title = new JLabel("Registrar um novo paciente", SwingConstants.CENTER);
        title.setFont(new Font("Fira Sans", Font.BOLD, 24));

        // Form layout setup
        JPanel panelNorth = new JPanel();
        panelNorth.setBorder(new EmptyBorder(15, 15, 0, 0));
        GridLayout formLayout = new GridLayout(7, 1);
        formLayout.setVgap(15);
        panelNorth.setLayout(formLayout);
        panelNorth.add(title);

        JPanel firstName = new FormGroupInput().init("Primeiro nome:");
        JPanel lastName = new FormGroupInput().init("Último nome");
        JPanel CPF = new FormGroupInput().init("CPF");
        JPanel age = new FormGroupInput().init("Nascimento");
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

        this.setBounds(  ViewConstants.SCREEN_CENTER.x - ViewConstants.SCREEN_SIZE.x / 2,
                ViewConstants.SCREEN_CENTER.y - ViewConstants.SCREEN_SIZE.y  / 2,
                ViewConstants.SCREEN_SIZE.x, ViewConstants.SCREEN_SIZE.y);
        this.setBackground(Color.WHITE);
        this.setResizable(true);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main (String [] args) {
        new AddPersonView();
    }
}

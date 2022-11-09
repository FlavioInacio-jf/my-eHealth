package javas.views.personViews;

import javas.views.components.Button;
import javas.views.components.FormGroupInput;
import javas.views.components.FormGroupSelect;

import javax.swing.*;
import java.awt.*;

public class AddPersonView extends JFrame {
    public AddPersonView() {}

    private void init(){
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
    }
}

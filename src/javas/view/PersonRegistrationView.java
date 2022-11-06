package javas.view;

import javas.AppContants;
import javas.view.components.*;
import javas.view.components.Button;
import javas.view.components.Label;

import java.awt.*;
import javax.swing.*;

public class PersonRegistrationView extends JFrame {

    private Label name;
    private Input field;
    public PersonRegistrationView() {
        this.init();
    }

    private void init() {
        JPanel jPanelNorth = new JPanel();

        setTitle(AppContants.PERSON_REGISTRATION_VIEW_TITLE);
        Container contentPane = getContentPane();
        BoxLayout layout = new BoxLayout(jPanelNorth, BoxLayout.Y_AXIS);

        jPanelNorth.setLayout(layout);

        Box firstName = new FormGroupInput().init("Primeiro nome:");
        Box lastName = new FormGroupInput().init("Último nome");
        Box CPF = new FormGroupInput().init("CPF");
        Box age = new FormGroupInput().init("Idade");
        Box bloodType = new FormGroupSelect().init("Grupo sanguíneo");

        Button addButton = new Button("Adicionar paciente");

        jPanelNorth.add(firstName);
        jPanelNorth.add(Box.createVerticalStrut(15));
        jPanelNorth.add(lastName);
        jPanelNorth.add(Box.createVerticalStrut(15));
        jPanelNorth.add(CPF);
        jPanelNorth.add(Box.createVerticalStrut(15));
        jPanelNorth.add(age);
        jPanelNorth.add(Box.createVerticalStrut(15));
        jPanelNorth.add(bloodType);
        jPanelNorth.add(Box.createVerticalStrut(15));
        jPanelNorth.add(addButton);


        add(jPanelNorth);

        setBounds(  AppContants.SCREEN_CENTER.x - AppContants.SCREEN_SIZE.x / 2,
                AppContants.SCREEN_CENTER.y - AppContants.SCREEN_SIZE.y  / 2,
                AppContants.SCREEN_SIZE.x, AppContants.SCREEN_SIZE.y);

        setResizable(false);
        contentPane.setBackground(Color.WHITE);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String args[]) {
        new PersonRegistrationView();
    }
}

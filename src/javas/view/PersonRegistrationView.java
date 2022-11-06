package javas.view;

import javas.AppContants;
import javas.view.components.FormGroup;
import javas.view.components.Input;
import javas.view.components.Label;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.Border;

public class PersonRegistrationView extends JFrame {

    private Label name;
    private Input field;
    public PersonRegistrationView() {
        this.init();
    }

    private void init() {
        setTitle(AppContants.PERSON_REGISTRATION_VIEW_TITLE);
        Container contentPane = getContentPane();

        JPanel jPanelNorth = new JPanel();
        jPanelNorth.setLayout(new GridLayout(1, 1));

        FormGroup name = new FormGroup();
        jPanelNorth.add(name.init("Name"));


        FormGroup idade = new FormGroup();
        jPanelNorth.add(idade.init("Idade"));



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

package javas.views;

import javas.config.AppDataSource;
import javas.constants.HealthUnitEntityConstants;
import javas.constants.PersonEntityConstants;
import javas.constants.VaccineEntityConstants;
import javas.constants.ViewConstants;
import javas.views.components.ButtonWithIcon;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

public class GeneralSettings extends JPanel {
    public GeneralSettings(){
        this.init();
    }

    private void init(){
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setBorder(new EmptyBorder(ViewConstants.SCREEN_SIZE.x / 7, 0, 0, 0));
        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);
        GridLayout mainPanelLayout = new GridLayout(1, 4);
        mainPanelLayout.setHgap(20);
        mainPanel.setLayout(mainPanelLayout);

        UIManager.put("Button.foreground", Color.BLACK);
        UIManager.put("Button.font", new Font("Fira Sans", Font.PLAIN, 18));

        ButtonWithIcon resetBD = new ButtonWithIcon("Resetar BD");
        resetBD.setPreferredSize(new Dimension(250, 250));
        resetBD.setIcon(new ImageIcon(this.getClass().getResource("icons/reset-bd.png")));
        resetBD.setBorder(BorderFactory.createLineBorder(ViewConstants.BORDER_COLOR, 1));
        resetBD.addActionListener(e-> this.resetDatabase());

        ButtonWithIcon createTables = new ButtonWithIcon("Criar tabelas");
        createTables.setIcon(new ImageIcon(this.getClass().getResource("icons/create-tables.png")));
        createTables.setBorder(BorderFactory.createLineBorder(ViewConstants.BORDER_COLOR, 1));
        createTables.addActionListener(e -> this.createTables());

        ButtonWithIcon connectBD = new ButtonWithIcon("Conectar BD");
        connectBD.setIcon(new ImageIcon(this.getClass().getResource("icons/connect-bd.png")));
        connectBD.setBorder(BorderFactory.createLineBorder(ViewConstants.BORDER_COLOR, 1));
        connectBD.addActionListener(e -> this.connectDatabase());

        ButtonWithIcon disconnectBD = new ButtonWithIcon("Desconectar BD");
        disconnectBD.setIcon(new ImageIcon(this.getClass().getResource("icons/disconnect-bd.png")));
        disconnectBD.setBorder(BorderFactory.createLineBorder(ViewConstants.BORDER_COLOR, 1));
        disconnectBD.addActionListener(e -> this.disconnectDatabase());

        mainPanel.add(connectBD);
        mainPanel.add(disconnectBD);
        mainPanel.add(createTables);
        mainPanel.add(resetBD);

        this.add(mainPanel, BorderLayout.CENTER);
        this.setBackground(Color.WHITE);
    }

    private void resetDatabase() {
        try {
            ArrayList<String> tables = new ArrayList<>();
            tables.add(PersonEntityConstants.ENTITY_NAME);
            tables.add(HealthUnitEntityConstants.ENTITY_NAME);
            tables.add(VaccineEntityConstants.ENTITY_NAME);
            Iterator<String> it = tables.iterator();

            Statement stm = AppDataSource.execute();
            while (it.hasNext()) {
                stm.execute(String.format("DELETE FROM %s", it.next()));
            }
            JOptionPane.showMessageDialog(this, "O banco de dados foi resetado com sucesso!");
        }catch (SQLException error) {
            JOptionPane.showMessageDialog(this, error.getMessage());
        }
    }

    private void createTables() {
        try {
            ArrayList<String> tables = new ArrayList<>();
            tables.add(HealthUnitEntityConstants.getQueryTable());
            tables.add(PersonEntityConstants.getQueryTable());
            tables.add(VaccineEntityConstants.getQueryTable());
            AppDataSource.createTables(tables);
            JOptionPane.showMessageDialog(this, "As tabelas foram criadas com sucesso!");
        }catch (Error error) {
            JOptionPane.showMessageDialog(this, error.getMessage());
        }

    }

    private void connectDatabase() {
        try {
            AppDataSource.connect();
            JOptionPane.showMessageDialog(this, "Conexão realizada com sucesso!");
        }catch (Error error) {
            JOptionPane.showMessageDialog(this, error.getMessage());
        }
    }

    private void disconnectDatabase() {
        try {
            AppDataSource.disconnect();
            JOptionPane.showMessageDialog(this, "O banco de dados foi desconectado com sucesso!");
        }catch (Error error) {
            JOptionPane.showMessageDialog(this, error.getMessage());
        }

    }
}

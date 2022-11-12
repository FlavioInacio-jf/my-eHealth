package javas;

import javas.config.AppDataSource;
import javas.constants.HealthUnitEntityConstants;
import javas.constants.PersonEntityConstants;
import javas.constants.VaccineEntityConstants;
import javas.views.MainView;

import javax.swing.*;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        try {
            // Create tables if they don't exist
            ArrayList<String> tables = new ArrayList<>();
            tables.add(HealthUnitEntityConstants.getQueryTable());
            tables.add(PersonEntityConstants.getQueryTable());
            tables.add(VaccineEntityConstants.getQueryTable());
            AppDataSource.createTables(tables);

            MainView mainView = new MainView();
            mainView.setVisible(true);
        }catch (Error error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
        
    }
}
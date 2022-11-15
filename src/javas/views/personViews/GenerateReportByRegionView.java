package javas.views.personViews;

import javas.constants.Addresses;
import javas.constants.HealthUnitEntityConstants;
import javas.constants.VaccineEntityConstants;
import javas.constants.ViewConstants;
import javas.modules.healthUnit.enums.UnitTypeEnum;
import javas.modules.vaccine.enums.VaccineName;
import javas.modules.vaccine.models.Vaccine;
import javas.views.components.*;
import javas.views.components.Button;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static javas.modules.vaccine.useCases.getAllVaccines.GetAllVaccines.getAllVaccinesController;

public class GenerateReportByRegionView extends BaseFrame {
    private final FormGroupSelect state;
    private final PieChart barUnitTypeAndUnvaccinated;
    private final PieChart pieVaccinesUsed;

    public GenerateReportByRegionView() {
        this.state = new FormGroupSelect("Estado", Addresses.validStates);
        this.barUnitTypeAndUnvaccinated = new PieChart("Vacinados por unidade de saúde");
        this.pieVaccinesUsed = new PieChart("Vacinados por vacina");
        this.init();
    }

    private void init() {
        this.setTitle(ViewConstants.STATISTICS_POPULATION_VIEW_TITLE);
        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPane.setLayout(new BorderLayout());

        // Header
        Header header = new Header(ViewConstants.STATISTICS_POPULATION_VIEW_TITLE, this.getClass().getResource("../icons/location-mark-icon.png"));

        JPanel column = new Column(1, 0);
        column.setBackground(Color.WHITE);
        column.add(this.state);

        Button button = new Button("Gerar estatísticas");
        column.add(button);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.WHITE);

        // GRAPHICS
        JPanel graphicPanel = new JPanel(new GridLayout(1, 2, 20, 20));
        graphicPanel.setBackground(Color.WHITE);
        graphicPanel.add(this.barUnitTypeAndUnvaccinated);
        graphicPanel.add(this.pieVaccinesUsed);

        mainPanel.add(column, BorderLayout.NORTH);
        mainPanel.add(graphicPanel, BorderLayout.CENTER);

        button.addActionListener(e -> this.generateStatistics());
        button.setBackground(Color.RED);

        contentPane.add(header, BorderLayout.NORTH);
        contentPane.add(mainPanel, BorderLayout.CENTER);
        this.setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
    }

    private void generateStatistics() {
        try {
            // populate
            String state = this.state.getSelectedItem().toString();
            HashMap<String, ArrayList<Vaccine>> stateAndVaccinesNameMap = new HashMap<>();
            for (String value: VaccineName.getNames()) {
                ArrayList<Vaccine> valueMap = getAllVaccinesController.execute(
                        String.format("%s='%s' AND %s='%s'", HealthUnitEntityConstants.STATE_COLUMN_NAME, state,
                                VaccineEntityConstants.NAME_COLUMN_NAME, value));
                stateAndVaccinesNameMap.put(value, valueMap);
            }

            // Populate pie chart
            for (Map.Entry<String, ArrayList<Vaccine>> pair : stateAndVaccinesNameMap.entrySet()) {
                this.pieVaccinesUsed.setValue(pair.getKey(), (double) pair.getValue().size());
            }


            // vaccines

            HashMap<String, ArrayList<Vaccine>> stateAndHealthUnitTypeMap = new HashMap<>();
            for (String value: UnitTypeEnum.getNames()) {
                ArrayList<Vaccine> valueMap = getAllVaccinesController.execute(
                        String.format("%s='%s' AND %s='%s'", HealthUnitEntityConstants.STATE_COLUMN_NAME, state,
                                HealthUnitEntityConstants.TYPE_COLUMN_NAME, value));
                stateAndHealthUnitTypeMap.put(value, valueMap);
            }

            // Populate pie chart
            for (Map.Entry<String, ArrayList<Vaccine>> pair : stateAndHealthUnitTypeMap.entrySet()) {
                this.barUnitTypeAndUnvaccinated.setValue(pair.getKey(), (double) pair.getValue().size());
            }
        } catch (Error error) {
            JOptionPane.showMessageDialog(this, error.getMessage());
        }
    }
}

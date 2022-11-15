package javas.views.personViews;

import javas.constants.*;
import javas.modules.healthUnit.enums.UnitTypeEnum;
import javas.modules.person.models.Person;
import javas.modules.vaccine.enums.VaccineName;
import javas.modules.vaccine.models.Vaccine;
import javas.views.components.*;
import javas.views.components.Button;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

import static javas.constants.VaccineEntityConstants.VALID_DOSES;
import static javas.modules.person.useCases.getAllPeople.GetAllPeople.getAllPeopleController;
import static javas.modules.vaccine.useCases.getAllVaccines.GetAllVaccines.getAllVaccinesController;

public class GenerateReportByRegionView extends BaseFrame {
    private final FormGroupSelect state;
    private final PieChart unitTypeChart, vaccinesUsedChart, vaccineByDoseChart, vaccinatedUnvaccinatedChart;

    public GenerateReportByRegionView() {
        this.state = new FormGroupSelect("Estado", Addresses.validStates);
        this.unitTypeChart = new PieChart("VACINADOS POR TIPO DE UNIDADE DE SAÚDE");
        this.vaccinesUsedChart = new PieChart("NOME DA VACINA");
        this.vaccineByDoseChart = new PieChart("APLICAÇÕES POR DOSE");
        this.vaccinatedUnvaccinatedChart = new PieChart("VACINADOS E NÂO VACINADOS");
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
        JPanel graphicPanel = new JPanel(new GridLayout(2, 2, 10, 10));
        graphicPanel.setBorder(new EmptyBorder(40, 0, 0, 0));
        graphicPanel.setBackground(Color.WHITE);

        graphicPanel.add(this.vaccinatedUnvaccinatedChart);
        graphicPanel.add(this.unitTypeChart);
        graphicPanel.add(this.vaccinesUsedChart);
        graphicPanel.add(this.vaccineByDoseChart);

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
            for (String value: VaccineName.getNames()) {
                ArrayList<Vaccine> list = getAllVaccinesController.execute(
                        String.format("%s='%s' AND %s='%s'", HealthUnitEntityConstants.STATE_COLUMN_NAME, state,
                                VaccineEntityConstants.NAME_COLUMN_NAME, value));
                this.vaccinesUsedChart.setValue(value, (double) list.size());
            }

            for (String key: UnitTypeEnum.getNames()) {
                ArrayList<Vaccine> list = getAllVaccinesController.execute(
                        String.format("%s='%s' AND %s='%s'", HealthUnitEntityConstants.STATE_COLUMN_NAME, state,
                                HealthUnitEntityConstants.TYPE_COLUMN_NAME, key));
                this.unitTypeChart.setValue(key, (double) list.size());
            }

            for (String key: VALID_DOSES) {
                ArrayList<Vaccine> list = getAllVaccinesController.execute(
                        String.format("%s='%s' AND %s='%s'", HealthUnitEntityConstants.STATE_COLUMN_NAME, state,
                                VaccineEntityConstants.DOSE_COLUMN_NAME, key));
                this.vaccineByDoseChart.setValue(key, (double) list.size());
            }

            ArrayList<Person> allPeopleByState = getAllPeopleController.execute(String.format("%s='%s'", PersonEntityConstants.STATE_COLUMN_NAME, state));
            int totalPeopleVaccinated = 0;
            int totalUnvaccinatedPeople = 0;
            Iterator<Person> it = allPeopleByState.iterator();
            while (it.hasNext()) {
                if (it.next().getVaccines().isEmpty()) {
                    totalUnvaccinatedPeople += 1;
                }
                else {
                    totalPeopleVaccinated += 1;
                }
            }
            this.vaccinatedUnvaccinatedChart.setValue("Vacinados", (double) totalPeopleVaccinated);
            this.vaccinatedUnvaccinatedChart.setValue("Não Vacinados", (double) totalUnvaccinatedPeople);


        } catch (Error error) {
            JOptionPane.showMessageDialog(this, error.getMessage());
        }
    }
}

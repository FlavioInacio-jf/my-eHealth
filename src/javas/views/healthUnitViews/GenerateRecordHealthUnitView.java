package javas.views.healthUnitViews;


import javas.constants.ViewConstants;
import javas.modules.healthUnit.models.HealthUnit;
import javas.modules.vaccine.models.Vaccine;
import javas.views.components.BaseFrame;
import javas.views.components.Button;
import javas.views.components.FormGroupInput;
import javas.views.components.Header;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.util.ArrayList;

import static javas.modules.healthUnit.useCases.getSingleHealthUnit.GetSingleHealthUnit.getSingleHealthUnitController;
import static javas.modules.vaccine.useCases.getAllVaccinesHealthUnit.GetAllVaccinesHealthUnit.getAllVaccinesHealthUnitController;

public class GenerateRecordHealthUnitView extends BaseFrame {
    private final FormGroupInput healthUnitCNPJ;
    public GenerateRecordHealthUnitView() {
        this.healthUnitCNPJ = new FormGroupInput("CNPJ");
        this.healthUnitCNPJ.setMaskFormatter("##.###.###/####-##");
        this.init();
    }

    private void init() {
        this.setTitle(ViewConstants.GENERATE_RECORD_HEATH_UNIT);

        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        // Header
        Header header = new Header("Gerar relatório de uma unidade de saúde", this.getClass().getResource("../icons/report-hospital-icon.png"));

        javas.views.components.Button buttonGenerate = new Button("Gerar relatório");
        buttonGenerate.addActionListener(e -> this.handleGenerateHealthUnitRecord());

        JPanel formPanel = new JPanel();
        formPanel.setBackground(Color.WHITE);
        formPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        formPanel.setAlignmentY(Component.TOP_ALIGNMENT);
        GridLayout formLayout = new GridLayout(2, 1);
        formLayout.setVgap(20);
        formPanel.setLayout(formLayout);
        formPanel.add(healthUnitCNPJ);
        formPanel.add(buttonGenerate);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(new FlowLayout());

        mainPanel.add(formPanel);

        contentPane.add(header);
        contentPane.add(mainPanel);
    }

    private void handleGenerateHealthUnitRecord(){
        String cnpj = this.healthUnitCNPJ.getText();
        if (!cnpj.matches("(^\\d{2}.\\d{3}.\\d{3}/\\d{4}-\\d{2}$)")) {
            JOptionPane.showMessageDialog(this, "CNPJ informado é inválido!");
        }
        else {
            try {
                HealthUnit healthUnit = getSingleHealthUnitController.execute(cnpj);
                ArrayList<Vaccine> vaccines = getAllVaccinesHealthUnitController.execute(healthUnit.getCNPJ());
                new RecordHealthUnitView(healthUnit, vaccines).setVisible(true);
            }catch (Error error) {
                JOptionPane.showMessageDialog(this, error.getMessage());
            }
        }
    }
}

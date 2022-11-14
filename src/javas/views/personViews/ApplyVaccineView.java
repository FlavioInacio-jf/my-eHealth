package javas.views.personViews;

import javas.constants.ViewConstants;
import javas.views.components.*;
import javas.views.components.Button;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static javas.constants.VaccineEntityConstants.VALID_DOSES;
import static javas.modules.vaccine.useCases.applyVaccine.ApplyVaccine.applyVaccineController;

public class ApplyVaccineView extends BaseFrame {
    FormGroupInput personCPF, healthUnitCNPJ, name, lot;
    FormGroupSelect dose;
    public ApplyVaccineView() {
        this.personCPF = new FormGroupInput("CPF (paciente):");
        personCPF.setMaskFormatter("###.###.###-##");
        this.healthUnitCNPJ = new FormGroupInput("CNPJ (Unidade de saúde):");
        healthUnitCNPJ.setMaskFormatter("##.###.###/####-##");
        this.name = new FormGroupInput("Nome:");
        this.dose = new FormGroupSelect("Dose", VALID_DOSES);
        this.lot = new FormGroupInput("Lote");

        this.init();
    }

    private void init() {
        this.setTitle(ViewConstants.APPLY_VACCINE_VIEW_TITLE);
        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        // Header
        Header header = new Header("Registrar nova aplicação de vacina", this.getClass().getResource("../icons/vaccine-icon.png"));

        // Form layout setup
        JPanel paneForm = new JPanel();
        paneForm.setBackground(Color.WHITE);
        GridLayout panelCenterLayout = new GridLayout(7, 1);
        panelCenterLayout.setVgap(20);
        paneForm.setLayout(panelCenterLayout);
        paneForm.setBorder(new EmptyBorder(15, 0, 0, 0));

        Button applyVaccineButton = new Button("Cadastrar vacina");
        applyVaccineButton.addActionListener(e -> {
            handleApplyVaccine();
        });
        paneForm.add(this.personCPF);
        paneForm.add(this.healthUnitCNPJ);
        paneForm.add(this.name);


        Column column = new Column(2, 10);
        column.add(this.lot);
        column.add(this.dose);

        paneForm.add(column);
        paneForm.add(applyVaccineButton);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(new FlowLayout());
        mainPanel.add(paneForm);

        contentPane.add(header);
        contentPane.add(mainPanel);
    }

    private void handleApplyVaccine() {
        try {
            String cpf = this.personCPF.getText();
            String cnpj = this.healthUnitCNPJ.getText();
            String vaccineName = this.name.getText();
            int vaccineDose =  Integer.parseInt(this.dose.getSelectedItem().toString());
            String vaccineLot = this.lot.getText();
            applyVaccineController.execute(cpf, cnpj, vaccineName, vaccineDose, vaccineLot);
            JOptionPane.showMessageDialog(this, "Vacina cadastrada com sucesso!");
        }catch (Error | IllegalAccessException | NumberFormatException error) {
            if (error instanceof NumberFormatException) {
                JOptionPane.showMessageDialog(this, "Dose \n O campo só");
            }
            else {
                JOptionPane.showMessageDialog(this, error.getMessage());
            }
        }
    }
}

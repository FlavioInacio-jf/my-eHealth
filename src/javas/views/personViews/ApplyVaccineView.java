package javas.views.personViews;

import javas.constants.ViewConstants;
import javas.views.components.BaseFrame;
import javas.views.components.Button;
import javas.views.components.FormGroupInput;
import javas.views.components.Title;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static javas.modules.vaccine.useCases.applyVaccine.ApplyVaccine.applyVaccineController;

public class ApplyVaccineView extends BaseFrame {
    FormGroupInput personCPF;
    FormGroupInput healthUnitCNPJ;
    FormGroupInput name;
    FormGroupInput date;
    FormGroupInput dose;
    FormGroupInput lot;
    public ApplyVaccineView() {
        this.personCPF = new FormGroupInput("CPF (paciente):");
        personCPF.setMaskFormatter("###.###.###-##");
        this.healthUnitCNPJ = new FormGroupInput("CNPJ (Unidade de saúde):");
        healthUnitCNPJ.setMaskFormatter("##.###.###/####-##");
        this.name = new FormGroupInput("Nome:");
        this.date = new FormGroupInput("Data");
        this.date.setMaskFormatter("##/##/####");
        this.dose = new FormGroupInput("Dose");
        this.lot = new FormGroupInput("Lote");

        this.init();
    }

    private void init() {
        this.setTitle(ViewConstants.APPLY_VACCINE_VIEW_TITLE);
        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        // Header
        JPanel header = new JPanel();
        header.setBackground(Color.WHITE);
        header.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        Title title = new Title("Registrar nova aplicação de vacina", SwingConstants.CENTER);
        Icon vaccineIcon = new ImageIcon(this.getClass().getResource("../icons/vaccine-icon.png"));

        header.add(new JLabel(vaccineIcon));
        header.add(title);


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
        paneForm.add(this.date);
        paneForm.add(this.dose);
        paneForm.add(this.lot);
        paneForm.add(applyVaccineButton);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(new FlowLayout());
        mainPanel.add(paneForm);

        contentPane.add(header);
        contentPane.add(mainPanel);

    }

    private void handleApplyVaccine() {
        String cpf = this.personCPF.getText();
        String cnpj = this.healthUnitCNPJ.getText();
        String vaccineName = this.name.getText();
        String vaccineDate = this.date.getText();
        int vaccineDose =  Integer.parseInt(this.dose.getText());
        String vaccineLot = this.lot.getText();

        try {
            applyVaccineController.execute(cpf, cnpj, vaccineName, vaccineDate, vaccineDose, vaccineLot);
            JOptionPane.showMessageDialog(this, "Vacina cadastrada com sucesso!");
        }catch (Error error) {
            JOptionPane.showMessageDialog(this, error.getMessage());
        }
    }
}

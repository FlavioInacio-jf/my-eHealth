package javas.views.personViews;

import javas.constants.ViewConstants;
import javas.views.components.BaseFrame;
import javas.views.components.Button;
import javas.views.components.FormGroupInput;
import javas.views.components.Title;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static javas.modules.person.useCases.getSinglePerson.GetSinglePerson.getSinglePersonController;

public class GenerateMedicalRecordView extends BaseFrame {
    public GenerateMedicalRecordView() {
        this.init();
    }

    private void init() {
        this.setTitle(ViewConstants.GENERATE_MEDICAL_RECORD_VIEW_TITLE);

        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        JPanel header = new JPanel();
        header.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        Title title = new Title("Gerar prontuário médico", SwingConstants.CENTER);
        Icon personIcon = new ImageIcon(this.getClass().getResource("../icons/report-user-icon.png"));

        header.add(new JLabel(personIcon));
        header.add(title);

        FormGroupInput personCPF = new FormGroupInput("CPF");
        personCPF.setMaskFormatter("###.###.###-##");

        javas.views.components.Button buttonGenerate = new Button("Gerar prontuário");
        buttonGenerate.addActionListener(e -> this.handleGenerateMedicalRecord(personCPF.getText()));

        JPanel formPanel = new JPanel();
        formPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        formPanel.setAlignmentY(Component.TOP_ALIGNMENT);
        GridLayout formLayout = new GridLayout(2, 1);
        formLayout.setVgap(20);
        formPanel.setLayout(formLayout);
        formPanel.add(personCPF);
        formPanel.add(buttonGenerate);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());

        mainPanel.add(formPanel);

        contentPane.add(header);
        contentPane.add(mainPanel);
    }


    private void handleGenerateMedicalRecord(String cpf){
        try {
            new MedialRecordView(getSinglePersonController.execute(cpf)).setVisible(true);
        }catch (Error error) {
            JOptionPane.showMessageDialog(this, error.getMessage());
        }
    }
}

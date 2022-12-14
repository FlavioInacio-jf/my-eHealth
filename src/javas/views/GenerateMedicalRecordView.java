package javas.views;

import javas.constants.ViewConstants;
import javas.views.components.*;
import javas.views.components.Button;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static javas.modules.person.useCases.getSinglePerson.GetSinglePerson.getSinglePersonController;

public class GenerateMedicalRecordView extends BaseFrame {
    private final FormGroupInput personCPF;
    public GenerateMedicalRecordView() {

        this.personCPF = new FormGroupInput("CPF");
        this.personCPF.setMaskFormatter("###.###.###-##");
        this.init();
    }

    private void init() {
        this.setTitle(ViewConstants.GENERATE_MEDICAL_RECORD_VIEW_TITLE);

        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        // Header
        Header header = new Header("Gerar prontuário médico", this.getClass().getResource("icons/report-user-icon.png"));

        javas.views.components.Button buttonGenerate = new Button("Gerar prontuário");
        buttonGenerate.addActionListener(e -> this.handleGenerateMedicalRecord());

        JPanel formPanel = new JPanel();
        formPanel.setBackground(Color.WHITE);
        formPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        formPanel.setAlignmentY(Component.TOP_ALIGNMENT);
        GridLayout formLayout = new GridLayout(2, 1);
        formLayout.setVgap(20);
        formPanel.setLayout(formLayout);
        formPanel.add(personCPF);
        formPanel.add(buttonGenerate);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(new FlowLayout());

        mainPanel.add(formPanel);

        contentPane.add(header);
        contentPane.add(mainPanel);
    }

    private void handleGenerateMedicalRecord(){
        String cpf = this.personCPF.getText();
        if (!cpf.matches("(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)")) {
            JOptionPane.showMessageDialog(this, "CPF informado é inválido!");
        }
        else {
            try {
                new MedialRecordView(getSinglePersonController.execute(cpf)).setVisible(true);
            }catch (Error error) {
                JOptionPane.showMessageDialog(this, error.getMessage());
            }
        }
    }
}

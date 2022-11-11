package javas.views.personViews;

import javas.constants.ViewConstants;
import javas.modules.app.models.Address;
import javas.modules.person.enums.BloodTypeEnum;
import javas.modules.person.enums.SexEnum;
import javas.modules.person.models.Person;
import javas.modules.person.repositories.IPersonRepository;
import javas.modules.person.repositories.implementations.PersonRepository;
import javas.modules.person.useCases.getSinglePerson.GetSinglePersonController;
import javas.modules.person.useCases.getSinglePerson.GetSinglePersonUseCase;
import javas.modules.vaccine.models.Vaccine;
import javas.views.components.BaseFrame;
import javas.views.components.Button;
import javas.views.components.FormGroupInput;
import javas.views.components.Title;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

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
        IPersonRepository personRepository = new PersonRepository();
        GetSinglePersonUseCase getSinglePersonUseCase = new GetSinglePersonUseCase(personRepository);
        GetSinglePersonController getSinglePersonController = new GetSinglePersonController(getSinglePersonUseCase);
        try {
            new MedialRecordView(getSinglePersonController.execute(cpf)).setVisible(true);

        }catch (Error error) {
            JOptionPane.showMessageDialog(this, error.getMessage());
        }

        Person person = new Person(null,
                            "Flávio Inácio",
                            "Silva", "855.888.888-88",
                            BloodTypeEnum.AB, SexEnum.FEMALE, "20/03/11",
                            new Address("d", "d", "d", "d", "d"));
        person.applyVaccine(new Vaccine(null, "Vacina 1", "11/10/2020", 1, "ooo"));
        person.applyVaccine(new Vaccine(null, "Vacina 1", "11/10/2020", 1, "ooo"));
        new MedialRecordView(person).setVisible(true);

    }
}

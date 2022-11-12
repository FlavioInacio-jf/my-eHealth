package javas.views.personViews;

import javas.constants.ViewConstants;
import javas.modules.person.enums.BloodTypeEnum;
import javas.modules.person.enums.SexEnum;
import javas.views.components.*;
import javas.views.components.Button;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static javas.modules.person.useCases.createPerson.CreatePerson.createPersonController;

public class AddPersonView extends BaseFrame {
    FormGroupInput firstName, lastName, cpf, birthDate, street, district, city, state, postalCode;
    FormGroupSelect bloodType, sex;
    Button addPersonButton;
    public AddPersonView() {
        this.firstName = new FormGroupInput("Primeiro nome:");
        this.lastName = new FormGroupInput("Último nome");
        this.cpf = new FormGroupInput("CPF");
        this.cpf.setMaskFormatter("###.###.###-##");
        this.birthDate = new FormGroupInput("Nascimento");
        this.birthDate.setMaskFormatter("##/##/####");
        this.bloodType = new FormGroupSelect("Grupo sanguíneo", BloodTypeEnum.getNames());
        this.sex = new FormGroupSelect("Sexo", SexEnum.getNames());
        this.street = new FormGroupInput("Rua");
        this.district = new FormGroupInput("Bairro");
        this.city = new FormGroupInput("Cidade");
        this.state = new FormGroupInput("Estado");
        this.birthDate.setMaskFormatter("##");
        this.postalCode = new FormGroupInput("CEP");
        this.birthDate.setMaskFormatter("####-###");


        this.addPersonButton = new Button("Adicionar paciente");

        this.init();
    }

    private void init(){
        this.setTitle(ViewConstants.ADD_PERSON_VIEW_TITLE);
        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        // Header
        JPanel header = new JPanel();
        header.setBackground(Color.WHITE);
        header.setLayout(new FlowLayout());
        Title title = new Title("Registrar um novo paciente", SwingConstants.CENTER);
        Icon vaccineIcon = new ImageIcon(this.getClass().getResource("../icons/add-user-icon.png"));

        header.add(new JLabel(vaccineIcon));
        header.add(title);

        // Form
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        mainPanel.setBackground(Color.WHITE);

        JPanel formPanel = new JPanel();
        formPanel.setBackground(Color.WHITE);
        GridLayout formPanelLayout = new GridLayout(7, 1);
        formPanelLayout.setVgap(20);
        formPanel.setLayout(formPanelLayout);

        JPanel firstRow = new Column(2, 0);
        firstRow.add(this.firstName);
        firstRow.add(this.lastName);
        formPanel.add(firstRow);

        JPanel secondRow = new Column(2, 0);
        secondRow.add(this.cpf);
        secondRow.add(this.birthDate);
        formPanel.add(secondRow);

        JPanel thirdRow = new Column(2, 0);
        thirdRow.add(this.sex);
        thirdRow.add(this.bloodType);
        formPanel.add(thirdRow);

        JPanel fourthRow = new Column(2, 0);
        fourthRow.add(this.street);
        fourthRow.add(this.district);
        formPanel.add(fourthRow);

        JPanel thursdayRow = new Column(2, 0);
        thursdayRow.add(this.city);
        thursdayRow.add(this.state);
        formPanel.add(thursdayRow);

        JPanel sixthRow = new Column(1, 0);
        sixthRow.add(this.postalCode);
        formPanel.add(sixthRow);

        this.addPersonButton.addActionListener(e -> this.handleAddPerson());
        formPanel.add(this.addPersonButton);

        mainPanel.add(formPanel);

        JScrollPane scrollPane = new JScrollPane(mainPanel);
        scrollPane.setBorder(null);

        contentPane.add(header);
        contentPane.add(scrollPane);
    }

    private void handleAddPerson() {

        String firstName = this.firstName.getText();
        String lastName = this.lastName.getText();
        String bloodType = this.bloodType.getSelectedItem().toString();
        String sex = this.sex.getSelectedItem().toString();
        String cpf = this.cpf.getText();
        String birthDate = this.birthDate.getText();
        String street = this.street.getText();
        String district = this.district.getText();
        String city = this.city.getText();
        String state = this.state.getText();
        String postalCode = this.postalCode.getText();

        try {
           createPersonController.execute(firstName, lastName, cpf,bloodType, sex, birthDate, street, district, city, state, postalCode);
            JOptionPane.showMessageDialog(this, "Paciente cadastrado com sucesso!");
        }catch (Error error) {
            JOptionPane.showMessageDialog(this, error.getMessage());
        }
    }
}

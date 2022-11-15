package javas.views;

import javas.constants.Addresses;
import javas.constants.ViewConstants;
import javas.modules.person.enums.BloodTypeEnum;
import javas.modules.person.enums.SexEnum;
import javas.modules.person.models.Person;
import javas.views.components.*;
import javas.views.components.Button;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;

import static javas.modules.person.useCases.getSinglePerson.GetSinglePerson.getSinglePersonController;
import static javas.modules.person.useCases.updatePerson.UpdatePerson.updatePersonController;

public class UpdatePersonView extends BaseFrame {
    private final FormGroupInput firstName, lastName, cpf, birthDate, street, district, city, postalCode;
    private final FormGroupSelect bloodType, sex, state;
    private final Button updatePersonButton;
    private final JPanel mainPanel;
    public UpdatePersonView() {
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
        this.state = new FormGroupSelect("Estado", Addresses.validStates);

        this.postalCode = new FormGroupInput("CEP");
        this.postalCode.setMaskFormatter("#####-###");


        this.updatePersonButton = new Button("Atualizar dados do paciente");

        this.mainPanel = new JPanel();
        this.mainPanel.setVisible(false);
        this.mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.mainPanel.setBackground(Color.WHITE);

        this.init();
    }

    private void init() {
        this.setTitle(ViewConstants.UPDATE_PERSON_VIEW_TITLE);
        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        // Header
        Header header = new Header("Atualizar dados de um paciente", this.getClass().getResource("icons/update-user-icon.png"));

        // Search date health unit
        JPanel searchDatePersonColumn = new Column(2, 0);
        Button searchPersonButton = new Button("Procurar dados do paciente");

        searchDatePersonColumn.add(this.cpf);
        searchDatePersonColumn.add(searchPersonButton);
        searchPersonButton.addActionListener( e -> this.handleSearchPerson());

        // Form


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
        thursdayRow.add(this.postalCode);
        thursdayRow.add(this.city);
        thursdayRow.add(this.state);
        formPanel.add(thursdayRow);

        this.updatePersonButton.addActionListener(e -> this.handleUpdatePerson());
        formPanel.add(this.updatePersonButton);

        mainPanel.add(formPanel);

        contentPane.add(header);
        contentPane.add(searchDatePersonColumn);
        contentPane.add(mainPanel);
    }
    private void handleUpdatePerson() {
        try {
            String firstName = this.firstName.getText();
            String lastName = this.lastName.getText();
            String bloodType = BloodTypeEnum.getEnum(this.bloodType.getSelectedItem().toString());
            String sex = SexEnum.getEnum(this.sex.getSelectedItem().toString());
            String cpf = this.cpf.getText();
            String birthDate = this.birthDate.getText();
            String street = this.street.getText();
            String district = this.district.getText();
            String city = this.city.getText();
            String state = this.state.getSelectedItem().toString();
            String postalCode = this.postalCode.getText();

            updatePersonController.execute(firstName, lastName, cpf,bloodType, sex, birthDate, street, district, city, state, postalCode);
            this.firstName.setText("");
            this.lastName.setText("");
            this.cpf.setText("");
            this.birthDate.setText("");
            this.street.setText("");
            this.district.setText("");
            this.city.setText("");
            this.postalCode.setText("");
            JOptionPane.showMessageDialog(this, "Paciente atualizado com sucesso!");

        }catch (Error | IllegalAccessException | IllegalArgumentException error) {
            JOptionPane.showMessageDialog(this, error.getMessage());
        }
    }

    public void handleSearchPerson() {
        String cpf = this.cpf.getText();
        try {
            if (!cpf.matches("(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)")) {
                JOptionPane.showMessageDialog(this, "CPF informado é inválido!");
            }
            else {
                Person person = getSinglePersonController.execute(cpf);
                this.firstName.setText(person.getFirstName());
                this.lastName.setText(person.getLastName());
                this.birthDate.setText(person.getBirthDate());
                this.bloodType.setSelectItem(person.getBloodType());
                this.sex.setSelectItem(person.getSex());

                this.street.setText(person.getAddress().getStreet());
                this.district.setText(person.getAddress().getDistrict());
                this.city.setText(person.getAddress().getCity());
                this.state.setSelectItem(person.getAddress().getState());
                this.postalCode.setText(person.getAddress().getPostalCode());
                this.mainPanel.setVisible(true);
            }
        }catch (Error error) {
            this.mainPanel.setVisible(false);
            JOptionPane.showMessageDialog(this, error.getMessage());
        }
    }
}

package javas.views.healthUnitViews;

import javas.constants.Addresses;
import javas.constants.ViewConstants;
import javas.modules.healthUnit.enums.UnitTypeEnum;
import javas.views.components.*;
import javas.views.components.Button;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static javas.modules.healthUnit.useCases.createHealthUnit.CreateHealthUnit.createHealthUnitController;

public class AddHealthUnitView extends BaseFrame {
    FormGroupInput name, cnpj, street, district, city, postalCode;
    FormGroupSelect type, state;
    Button addHealthUnitButton;
    public AddHealthUnitView() {
        this.name = new FormGroupInput("Nome");
        this.cnpj = new FormGroupInput("CNPJ");
        this.cnpj.setMaskFormatter("##.###.###/####-##");
        this.type = new FormGroupSelect("tipo", UnitTypeEnum.getNames());
        this.street = new FormGroupInput("Rua");
        this.district = new FormGroupInput("Bairro");
        this.city = new FormGroupInput("Cidade");
        this.state = new FormGroupSelect("Estado", Addresses.validStates);
        this.postalCode = new FormGroupInput("CEP");
        this.postalCode.setMaskFormatter("#####-###");

        this.addHealthUnitButton = new Button("Adicionar unidade de saúde");

        this.init();
    }

    private void init() {
        this.setTitle(ViewConstants.ADD_HEALTH_UNIT_TITLE);

        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        // Header
        Header header = new Header("Adicionar unidade de saúde", this.getClass().getResource("../icons/add-hospital-icon.png"));

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
        firstRow.add(this.name);
        firstRow.add(this.cnpj);
        formPanel.add(firstRow);

        JPanel secondRow = new Column(2, 0);
        secondRow.add(this.type);
        secondRow.add(this.street);
        formPanel.add(secondRow);

        JPanel fourthRow = new Column(2, 0);
        fourthRow.add(this.street);
        fourthRow.add(this.district);
        formPanel.add(fourthRow);

        JPanel thursdayRow = new Column(2, 0);
        thursdayRow.add(this.postalCode);
        thursdayRow.add(this.city);
        thursdayRow.add(this.state);
        formPanel.add(thursdayRow);

        this.addHealthUnitButton.addActionListener(e -> this.handleHealthUnit());
        formPanel.add(this.addHealthUnitButton);

        mainPanel.add(formPanel);

        contentPane.add(header);
        contentPane.add(mainPanel);
    }

    private void handleHealthUnit() {
        try {
            String name = this.name.getText();
            String cnpj = this.cnpj.getText();
            String type = UnitTypeEnum.getEnum(this.type.getSelectedItem().toString());
            String street = this.street.getText();
            String district = this.district.getText();
            String city = this.city.getText();
            String state = this.state.getSelectedItem().toString();
            String postalCode = this.postalCode.getText();

            createHealthUnitController.execute(type, name, cnpj, street, district, city, state, postalCode);
            JOptionPane.showMessageDialog(this, "Unidade de saúde cadastrado com sucesso!");
        }catch (Error | IllegalAccessException | IllegalArgumentException error) {
            JOptionPane.showMessageDialog(this, error.getMessage());
        }
    }
}

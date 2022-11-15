package javas.views;

import javas.constants.Addresses;
import javas.constants.ViewConstants;
import javas.modules.healthUnit.enums.UnitTypeEnum;
import javas.modules.healthUnit.models.HealthUnit;
import javas.views.components.*;
import javas.views.components.Button;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static javas.modules.healthUnit.useCases.getSingleHealthUnit.GetSingleHealthUnit.getSingleHealthUnitController;
import static javas.modules.healthUnit.useCases.updateHeathUnit.UpdateHealthUnit.updateHealthUnitController;

public class UpdateHealthUnitView extends BaseFrame {
    FormGroupInput name, cnpj, street, district, city, postalCode;
    FormGroupSelect type, state;
    Button addHealthUnitButton;
    JPanel formPanel;
    public UpdateHealthUnitView() {
        this.name = new FormGroupInput("Nome");
        this.cnpj = new FormGroupInput("CNPJ");
        this.cnpj.setMaskFormatter("##.###.###/####-##");
        this.type = new FormGroupSelect("Tipo", UnitTypeEnum.getNames());
        this.street = new FormGroupInput("Rua");
        this.district = new FormGroupInput("Bairro");
        this.city = new FormGroupInput("Cidade");
        this.state = new FormGroupSelect("Estado", Addresses.validStates);
        this.postalCode = new FormGroupInput("CEP");
        this.postalCode.setMaskFormatter("#####-###");

        this.addHealthUnitButton = new Button("Atualizar unidade de saúde");
        this.formPanel = new JPanel();
        this.formPanel.setVisible(false);
        this.init();
    }

    private void init() {
        this.setTitle(ViewConstants. UPDATE_HEALTH_UNIT_TITLE);

        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        // Header
        Header header = new Header("Atualizar dados da unidade de saúde", this.getClass().getResource("icons/update-hospital-icon.png"));

        // Search date health unit
        JPanel searchDateHealthUnitColumn = new Column(2, 0);
        Button searchHealthUnitButton = new Button("Procurar dados da unidade de saúde");

        searchDateHealthUnitColumn.add(this.cnpj);
        searchDateHealthUnitColumn.add(searchHealthUnitButton);
        searchHealthUnitButton.addActionListener( e -> this.handleSearchHealthUnit());

        // Form
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        mainPanel.setBackground(Color.WHITE);

        formPanel.setBackground(Color.WHITE);
        GridLayout formPanelLayout = new GridLayout(7, 1);
        formPanelLayout.setVgap(20);
        formPanel.setLayout(formPanelLayout);

        JPanel firstRow = new Column(2, 0);
        firstRow.add(this.name);
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

        this.addHealthUnitButton.addActionListener(e -> this.handleUpdateHealthUnit());
        formPanel.add(this.addHealthUnitButton);

        mainPanel.add(formPanel);

        contentPane.add(header);
        contentPane.add(searchDateHealthUnitColumn);
        contentPane.add(mainPanel);
    }

    public void handleUpdateHealthUnit() {
        try {
            String name = this.name.getText();
            String cnpj = this.cnpj.getText();
            String type = UnitTypeEnum.getEnum(this.type.getSelectedItem().toString());
            String street = this.street.getText();
            String district = this.district.getText();
            String city = this.city.getText();
            String state = this.state.getSelectedItem().toString();
            String postalCode = this.postalCode.getText();

            updateHealthUnitController.execute(type, name, cnpj, street, district, city, state, postalCode);

            this.name.setText("");
            this.cnpj.setText("");
            this.street.setText("");
            this.district.setText("");
            this.city.setText("");
            this.postalCode.setText("");
            JOptionPane.showMessageDialog(this, "Unidade de saúde atualizada com sucesso!");
        }catch (Error | IllegalAccessException | IllegalArgumentException error) {
            JOptionPane.showMessageDialog(this, error.getMessage());
        }
    }

    public void handleSearchHealthUnit() {
        try {
            if (!this.cnpj.getText().matches("(^\\d{2}.\\d{3}.\\d{3}/\\d{4}-\\d{2}$)")) {
                JOptionPane.showMessageDialog(this, "CNPJ informado é inválido!");
            }
            else {
                String cnpj = this.cnpj.getText().trim();
                HealthUnit healthUnit = getSingleHealthUnitController.execute(cnpj);
                this.name.setText(healthUnit.getName());
                this.type.setSelectItem(healthUnit.getType());
                this.street.setText(healthUnit.getAddress().getStreet());
                this.district.setText(healthUnit.getAddress().getDistrict());
                this.city.setText(healthUnit.getAddress().getCity());
                this.state.setSelectItem(healthUnit.getAddress().getState());
                this.postalCode.setText(healthUnit.getAddress().getPostalCode());
                this.formPanel.setVisible(true);
            }
        }catch (Error error) {
            this.formPanel.setVisible(false);
            JOptionPane.showMessageDialog(this, error.getMessage());
        }
    }
}

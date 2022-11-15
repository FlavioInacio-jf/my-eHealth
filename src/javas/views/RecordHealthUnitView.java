package javas.views;

import javas.modules.healthUnit.models.HealthUnit;
import javas.modules.vaccine.models.Vaccine;
import javas.views.components.BaseFrame;
import javas.views.components.LabelGroup;
import javas.views.components.Table;
import javas.views.components.Title;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class RecordHealthUnitView extends BaseFrame {
    private final HealthUnit healthUnit;
    private final ArrayList<Vaccine> vaccines;
    public RecordHealthUnitView(HealthUnit healthUnit, ArrayList<Vaccine> vaccines) {
        this.healthUnit = healthUnit;
        this.vaccines = vaccines;
        this.init();
    }

    private void init(){
        this.setTitle("Relatório da unidade de saúde de " + this.healthUnit.getName());

        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPane.setLayout(new BorderLayout());

        JPanel informationPanel = new JPanel();
        informationPanel.setBorder(new EmptyBorder(6, 0, 6, 0));
        informationPanel.setBackground(Color.WHITE);
        informationPanel.setLayout(new GridLayout(11, 1));
        LabelGroup labelGroupName = new LabelGroup("Nome:", this.healthUnit.getName());
        LabelGroup labelGroupType = new LabelGroup("Tipo:", this.healthUnit.getType().toString());
        LabelGroup labelGroupCNPJ = new LabelGroup("CNPJ:", this.healthUnit.getCNPJ());
        LabelGroup labelGroupStreet = new LabelGroup("Rua:", this.healthUnit.getAddress().getStreet());
        LabelGroup labelGroupDistrict = new LabelGroup("Bairro:", this.healthUnit.getAddress().getDistrict());
        LabelGroup labelGroupCity = new LabelGroup("Cidade:", this.healthUnit.getAddress().getCity());
        LabelGroup labelGroupState = new LabelGroup("Estado:", this.healthUnit.getAddress().getState());
        LabelGroup labelGroupPostalCode = new LabelGroup("CEP:", this.healthUnit.getAddress().getPostalCode());
        LabelGroup labelGroupTotalVaccinesApplied = new LabelGroup("Vacinas aplicadas", Integer.toString(this.vaccines.size()));
        Title title = new Title("Vacinas aplicadas nesta unidade de saúde", SwingConstants.CENTER);

        informationPanel.add(labelGroupName);
        informationPanel.add(labelGroupType);
        informationPanel.add(labelGroupCNPJ);
        informationPanel.add(labelGroupStreet);
        informationPanel.add(labelGroupDistrict);
        informationPanel.add(labelGroupCity);
        informationPanel.add(labelGroupState);
        informationPanel.add(labelGroupPostalCode);
        informationPanel.add(labelGroupTotalVaccinesApplied);

        informationPanel.add(title);


        // Vaccines Table
        JPanel contentTable = new JPanel();
        GridLayout contentTableLayout = new GridLayout(1, 1);
        contentTable.setLayout(contentTableLayout);
        contentTable.setBackground(Color.WHITE);
        contentTable.setBorder(null);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("NOME");
        model.addColumn("DATA");
        model.addColumn("DOSE");
        model.addColumn("LOTE");

        Table vaccinesTable = new Table(model) {
            @Override
            public boolean editCellAt(int row, int column, java.util.EventObject e){
                return false;
            }

            DefaultTableCellRenderer renderLeft = new DefaultTableCellRenderer();

            {
                renderLeft.setHorizontalAlignment(SwingConstants.LEFT);
            }

            @Override
            public TableCellRenderer getCellRenderer(int arg0, int arg1) {
                return renderLeft;
            }
        };

        // Populate table
        Iterator<Vaccine> it = this.vaccines.iterator();
        while(it.hasNext()) {
            Vaccine vaccine = it.next();
            model.addRow(new Object[]{
                    vaccine.getName(),
                    vaccine.getApplicationDate(),
                    vaccine.getDose(),
                    vaccine.getLot()});

        }
        contentTable.add(vaccinesTable.getTableHeader());
        contentTable.add(new JScrollPane(vaccinesTable));

        contentPane.add(contentTable, BorderLayout.CENTER);
        contentPane.add(informationPanel, BorderLayout.NORTH);
    }
}

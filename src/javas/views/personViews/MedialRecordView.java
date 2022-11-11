package javas.views.personViews;

import javas.modules.person.models.Person;
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
import java.util.Iterator;

public class MedialRecordView extends BaseFrame {
    public MedialRecordView (Person person) {
        this.init(person);
    }

    public void init(Person person) {
        this.setTitle("Registro médico de " + person.getFullName());

        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPane.setLayout(new BorderLayout());

        JPanel informationPanel = new JPanel();
        informationPanel.setBorder(new EmptyBorder(6, 0, 6, 0));
        informationPanel.setBackground(Color.WHITE);
        informationPanel.setLayout(new GridLayout(11, 1));
        LabelGroup labelGroupFirstName = new LabelGroup("Primeiro nome:", person.getFirstName());
        LabelGroup labelGroupLastName = new LabelGroup("Último nome:", person.getLastName());
        LabelGroup labelGroupCPF = new LabelGroup("CPF:", person.getCPF());
        LabelGroup labelGroupBloodType = new LabelGroup("Grupo sanguíneo:", person.getBloodType().toString());
        LabelGroup labelGroupSex  = new LabelGroup("Sexo:", person.getSex().toString());
        LabelGroup labelGroupStreet = new LabelGroup("Rua:", person.getAddress().getStreet());
        LabelGroup labelGroupDistrict = new LabelGroup("Bairro:", person.getAddress().getDistrict());
        LabelGroup labelGroupCity = new LabelGroup("Cidade:", person.getAddress().getCity());
        LabelGroup labelGroupState = new LabelGroup("Estado:", person.getAddress().getState());
        LabelGroup labelGroupPostalCode = new LabelGroup("CEP:", person.getAddress().getPostalCode());
        Title title = new Title("Vacinas recebidas", SwingConstants.CENTER);

        informationPanel.add(labelGroupFirstName);
        informationPanel.add(labelGroupLastName);
        informationPanel.add(labelGroupCPF);
        informationPanel.add(labelGroupBloodType);
        informationPanel.add(labelGroupSex);
        informationPanel.add(labelGroupStreet);
        informationPanel.add(labelGroupDistrict);
        informationPanel.add(labelGroupCity);
        informationPanel.add(labelGroupState);
        informationPanel.add(labelGroupPostalCode);

        informationPanel.add(title);


        // Vaccines Table
        JPanel contentTable = new JPanel();
        GridLayout contentTableLayout = new GridLayout(1, 1);
        contentTable.setLayout(contentTableLayout);
        contentTable.setBackground(Color.WHITE);
        contentTable.setBorder(null);
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("NOME");
        model.addColumn("DATA");
        model.addColumn("DOSE");
        model.addColumn("LOTE");
        model.addColumn("Nome Unidade de Saúde");

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
        Iterator it = person.getVaccines().iterator();
        while(it.hasNext()) {
            Vaccine vaccine = (Vaccine) it.next();
            model.addRow(new Object[]{
                    vaccine.getId(),
                    vaccine.getDate(),
                    vaccine.getName(),
                    vaccine.getDose(),
                    vaccine.getLot(),
                    vaccine.getHeathUnit().getName()});

        }
        contentTable.add(vaccinesTable.getTableHeader());
        contentTable.add(new JScrollPane(vaccinesTable));

        contentPane.add(contentTable, BorderLayout.CENTER);
        contentPane.add(informationPanel, BorderLayout.NORTH);
    }
}


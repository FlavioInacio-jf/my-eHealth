package javas.views.personViews;

import javas.constants.ViewConstants;
import javas.modules.person.models.Person;
import javas.views.components.*;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import static javas.modules.person.useCases.getAllPeople.GetAllPeople.getAllPeopleController;

public class PersonView extends JPanel {
    private GenerateMedicalRecordView generateMedicalRecordView;
    private ApplyVaccineView applyVaccineView;
    private DeletePersonView deletePersonView;
    private UpdatePersonView updatePersonView;
    private AddPersonView addPersonView;
    private ArrayList<Person> people;
    private DefaultTableModel model;

    public PersonView() {
        this.generateMedicalRecordView = new GenerateMedicalRecordView();
        this.applyVaccineView = new ApplyVaccineView();
        this.deletePersonView = new DeletePersonView();
        this.updatePersonView = new UpdatePersonView();
        this.addPersonView = new AddPersonView();
        this.people = new ArrayList<>();
        this.model = new DefaultTableModel();
        this.model.addColumn("Nome");
        this.model.addColumn("CPF");
        this.model.addColumn("Tipo Sanguíneo");
        this.model.addColumn("Sexo");
        this.model.addColumn("Data nascimento");
        this.model.addColumn("CIDADE");
        this.model.addColumn("UF");
        this.init();
    }

    private void init() {
        this.setLayout(new BorderLayout());
        this.setBorder(null);

        // Configure north area
        JPanel jPanelNorth = new JPanel();
        jPanelNorth.setBackground(Color.WHITE);

        jPanelNorth.setLayout(new FlowLayout(FlowLayout.LEFT));
        jPanelNorth.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, ViewConstants.BORDER_COLOR));

        ButtonWithIcon addPersonButton = new ButtonWithIcon("Adicionar");
        addPersonButton.setIcon(new ImageIcon(this.getClass().getResource("../icons/add-user-icon.png")));
        addPersonButton.addActionListener(e -> {
            if (!this.addPersonView.isVisible()) {
                addPersonView.setVisible(true);
            }
        });
        jPanelNorth.add(addPersonButton);

        ButtonWithIcon updatePersonButton = new ButtonWithIcon("Atualizar");
        updatePersonButton.setIcon(new ImageIcon(this.getClass().getResource("../icons/update-user-icon.png")));
        updatePersonButton.addActionListener(e -> {
            if (!this.updatePersonView.isVisible()){
                this.updatePersonView.setVisible(true);
            }
        });
        jPanelNorth.add(updatePersonButton);

        ButtonWithIcon deletePersonButton = new ButtonWithIcon("Excluir");
        deletePersonButton.setIcon(new ImageIcon(this.getClass().getResource("../icons/remove-user-icon.png")));
        deletePersonButton.addActionListener(e -> {
            if (!this.deletePersonView.isVisible()){
                this.deletePersonView.setVisible(true);
            }
        });
        jPanelNorth.add(deletePersonButton);

        ButtonWithIcon reportPersonButton = new ButtonWithIcon("Relatório");
        reportPersonButton.setIcon(new ImageIcon(this.getClass().getResource("../icons/report-user-icon.png")));
        reportPersonButton.addActionListener(e -> {
            this.generateMedicalRecordView.setVisible(true);
        });
        jPanelNorth.add(reportPersonButton);

        ButtonWithIcon vaccinePersonButton = new ButtonWithIcon("Vacinar");
        vaccinePersonButton.setIcon(new ImageIcon(this.getClass().getResource("../icons/vaccine-icon.png")));
        vaccinePersonButton.addActionListener(e -> {
            if (!this.applyVaccineView.isVisible()) {
                this.applyVaccineView.setVisible(true);
            }
        });
        jPanelNorth.add(vaccinePersonButton);
        this.add(jPanelNorth, BorderLayout.NORTH);

        // Configure center area
        JPanel jPanelCenter = new JPanel();
        jPanelCenter.setBackground(Color.WHITE);
        jPanelCenter.setLayout(new GridLayout(1, 2));

        // PopulateTable
        this.populateTable();

        // Initializing the JTable
        Table table = new Table(this.model) {
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


        jPanelCenter.add(table.getTableHeader());
        jPanelCenter.add(new JScrollPane(table));

        this.addPersonView.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                populateTable();
            }
        });
        this.deletePersonView.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                populateTable();
            }
        });
        this.add(jPanelCenter);
    }

    private void populateTable() {
        try {
            this.model.setRowCount(0);
            this.people = getAllPeopleController.execute();
            Iterator<Person> it = people.iterator();
            while (it.hasNext()){
                Person person = it.next();
                this.model.addRow(new Object[]{
                        person.getFullName(),
                        person.getCPF(),
                        person.getBloodType().toString(),
                        person.getSex().toString(),
                        person.getBirthDate(),
                        person.getAddress().getCity(),
                        person.getAddress().getState()
                });
            }
        }catch (IllegalArgumentException error) {
            JOptionPane.showMessageDialog(this, error.getMessage());
        }
    }
}

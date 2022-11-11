package javas.views.personViews;

import javas.constants.ViewConstants;
import javas.modules.person.models.Person;
import javas.views.components.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

public class PersonView extends JPanel {
    private GenerateMedicalRecordView generateMedicalRecordView;
    private ApplyVaccineView applyVaccineView;
    private DeletePersonView deletePersonView;
    private UpdatePersonView updatePersonView;
    private AddPersonView addPersonView;

    public PersonView() {
        this.generateMedicalRecordView = new GenerateMedicalRecordView();
        this.applyVaccineView = new ApplyVaccineView();
        this.deletePersonView = new DeletePersonView();
        this.updatePersonView = new UpdatePersonView();
        this.addPersonView = new AddPersonView();
        this.init();
    }

    private void init() {
        this.setLayout(new BorderLayout());
        this.setBorder(null);
        JScrollPane scrollPane = new JScrollPane();

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

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nome");
        model.addColumn("CPF");
        model.addColumn("Grupo sanguíneo");
        model.addColumn("Data nascimento");

        // PopulateTable
        ArrayList<Person> people = new ArrayList<>();
        Iterator<Person> it = people.iterator();
        while (it.hasNext()){
            Person person = it.next();
            model.addRow(new Object[]{
                            person.getFullName(),
                            person.getCPF(),
                            person.getBloodType().toString(),
                            person.getBirthDate()});
        }
        // Initializing the JTable
        JTable table = new JTable(model) {
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



        //Table header styles
        UIManager.put("TableHeader.cellBorder" , BorderFactory.createMatteBorder(0, 0, 0, 1, ViewConstants.BORDER_COLOR));
        JTableHeader tableHeader = table.getTableHeader();
        tableHeader.setFont(new Font("Fira Sans", Font.BOLD, 14));
        tableHeader.setBackground(ViewConstants.PRIMARY_COLOR);
        tableHeader.setForeground(Color.WHITE);
        tableHeader.setOpaque(false);
        tableHeader.setBorder(null);

        table.setFont(new Font("Fira Sans", Font.PLAIN, 16));
        table.setGridColor(ViewConstants.BORDER_COLOR);
        table.setIntercellSpacing(new Dimension(20, 0));
        table.setRowHeight(25);
        table.removeEditor();
        table.setRowSelectionAllowed(false);

        jPanelCenter.add(table.getTableHeader());
        jPanelCenter.add(new JScrollPane(table));
        this.add(jPanelCenter);


        this.setBackground(Color.WHITE);
    }
}

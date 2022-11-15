package javas.views;

import javas.constants.ViewConstants;
import javas.modules.healthUnit.models.HealthUnit;
import javas.views.components.ButtonWithIcon;
import javas.views.components.Table;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Iterator;

import static javas.modules.healthUnit.useCases.getAllHealthUnits.GetAllHealthUnits.getAllHealthUnitsController;

public class HealthUnitView extends JPanel {
    private final GenerateRecordHealthUnitView generateRecordHealthUnitView;
    private final DeleteHealthUnitView deleteHealthUnitView;
    private final UpdateHealthUnitView updateHealthUnitView;
    private final AddHealthUnitView addHealthUnitView;
    private ArrayList<HealthUnit> healthUnits;
    private final DefaultTableModel model;


    public HealthUnitView() {
        this.generateRecordHealthUnitView = new GenerateRecordHealthUnitView();
        this.deleteHealthUnitView = new DeleteHealthUnitView();
        this.updateHealthUnitView = new UpdateHealthUnitView();
        this.addHealthUnitView = new AddHealthUnitView();
        this.healthUnits = new ArrayList<>();
        this.model = new DefaultTableModel();

        this.model.addColumn("Nome");
        this.model.addColumn("Tipo");
        this.model.addColumn("CNPJ");
        this.model.addColumn("Rua");
        this.model.addColumn("Bairro");
        this.model.addColumn("Cidade");
        this.model.addColumn("CEP");
        this.model.addColumn("UF");

        this.init();
    }

    private void init(){
        this.setLayout(new BorderLayout());
        this.setBorder(null);

        // Configure north area
        JPanel jPanelNorth = new JPanel();
        jPanelNorth.setBackground(Color.WHITE);

        jPanelNorth.setLayout(new FlowLayout(FlowLayout.LEFT));
        jPanelNorth.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, ViewConstants.BORDER_COLOR));

        ButtonWithIcon addHealthUnitButton = new ButtonWithIcon("Adicionar");
        addHealthUnitButton.setIcon(new ImageIcon(this.getClass().getResource("icons/add-hospital-icon.png")));
        addHealthUnitButton.addActionListener(e -> {
            if (!this.addHealthUnitView.isVisible()) {
                this.addHealthUnitView.setVisible(true);
            }
        });
        jPanelNorth.add(addHealthUnitButton);

        ButtonWithIcon updateHealthUnitButton = new ButtonWithIcon("Atualizar");
        updateHealthUnitButton.setIcon(new ImageIcon(this.getClass().getResource("icons/update-hospital-icon.png")));
        updateHealthUnitButton.addActionListener(e -> {
            if (!this.updateHealthUnitView.isVisible()) {
                this.updateHealthUnitView.setVisible(true);
            }
        });
        jPanelNorth.add(updateHealthUnitButton);

        ButtonWithIcon deleteHealthUnitButton = new ButtonWithIcon("Excluir");
        deleteHealthUnitButton.setIcon(new ImageIcon(this.getClass().getResource("icons/remove-hospital-icon.png")));
        deleteHealthUnitButton.addActionListener(e -> {
            if (!this.deleteHealthUnitView.isVisible()) {
                this.deleteHealthUnitView.setVisible(true);
            }
        });
        jPanelNorth.add(deleteHealthUnitButton);

        ButtonWithIcon reportHealthUnitButton = new ButtonWithIcon("Relatório");
        reportHealthUnitButton.setIcon(new ImageIcon(this.getClass().getResource("icons/report-hospital-icon.png")));
        reportHealthUnitButton.addActionListener(e -> this.generateRecordHealthUnitView.setVisible(true));
        jPanelNorth.add(reportHealthUnitButton);

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

            final DefaultTableCellRenderer renderLeft = new DefaultTableCellRenderer();

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


        this.addHealthUnitView.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                populateTable();
            }
        });
        this.updateHealthUnitView.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                populateTable();
            }
        });

        this.deleteHealthUnitView.addWindowListener(new WindowAdapter() {
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
            this.healthUnits = getAllHealthUnitsController.execute();
            Iterator<HealthUnit> it = healthUnits.iterator();
            while (it.hasNext()){
                HealthUnit healthUnit = it.next();
                this.model.addRow(new Object[]{
                        healthUnit.getName(),
                        healthUnit.getType(),
                        healthUnit.getCNPJ(),
                        healthUnit.getAddress().getStreet(),
                        healthUnit.getAddress().getDistrict(),
                        healthUnit.getAddress().getCity(),
                        healthUnit.getAddress().getPostalCode(),
                        healthUnit.getAddress().getState()
                });
            }
        }catch (IllegalArgumentException error) {
            JOptionPane.showMessageDialog(this, error.getMessage());
        }
    }
}

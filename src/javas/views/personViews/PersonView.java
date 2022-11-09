package javas.views.personViews;

import javas.constants.ViewConstants;
import javas.modules.person.models.Person;
import javas.views.components.*;
import javas.views.components.Button;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

public class PersonView extends JPanel {
    public PersonView() {
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
        jPanelNorth.add(addPersonButton);

        ButtonWithIcon updatePersonButton = new ButtonWithIcon("Atualizar");
        updatePersonButton.setIcon(new ImageIcon(this.getClass().getResource("../icons/update-user-icon.png")));
        jPanelNorth.add(updatePersonButton);

        ButtonWithIcon deletePersonButton = new ButtonWithIcon("Excluir");
        deletePersonButton.setIcon(new ImageIcon(this.getClass().getResource("../icons/remove-user-icon.png")));
        jPanelNorth.add(deletePersonButton);

        ButtonWithIcon reportPersonButton = new ButtonWithIcon("Relatório");
        reportPersonButton.setIcon(new ImageIcon(this.getClass().getResource("../icons/report-user-icon.png")));
        jPanelNorth.add(reportPersonButton);

        ButtonWithIcon vaccinePersonButton = new ButtonWithIcon("Vacinar");
        vaccinePersonButton.setIcon(new ImageIcon(this.getClass().getResource("../icons/vaccine-icon.png")));
        jPanelNorth.add(vaccinePersonButton);
        this.add(jPanelNorth, BorderLayout.NORTH);

        // Configure center area
        JPanel jPanelCenter = new JPanel();
        jPanelCenter.setBackground(Color.WHITE);
        jPanelCenter.setLayout(new GridLayout(1, 2));

        String[] columnNames = { "Name", "Roll Number", "Department" };

        String[][] data = {
                { "Kundan Kumar Jha", "4031", "CSE" },
                { "Anand Jha", "6014", "IT" }
        };
        // Initializing the JTable
        JTable table = new JTable(data, columnNames) {
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

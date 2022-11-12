package javas.views.components;

import javas.constants.ViewConstants;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class Table extends JTable {
    public Table(DefaultTableModel model) {
        super(model);
        this.init();
    }

    private void init() {
        UIManager.put("TableHeader.cellBorder" , BorderFactory.createMatteBorder(0, 0, 0, 1, ViewConstants.BORDER_COLOR));
        JTableHeader tableHeader = this.getTableHeader();
        tableHeader.setFont(new Font("Fira Sans", Font.BOLD, 14));
        tableHeader.setBackground(ViewConstants.PRIMARY_COLOR);
        tableHeader.setForeground(Color.WHITE);
        tableHeader.setOpaque(false);
        tableHeader.setBorder(null);

        this.setFont(new Font("Fira Sans", Font.PLAIN, 16));
        this.setGridColor(ViewConstants.BORDER_COLOR);
        this.setIntercellSpacing(new Dimension(20, 0));
        this.setRowHeight(25);
        this.removeEditor();
        this.setRowSelectionAllowed(false);
        this.setBackground(Color.WHITE);
    }
}

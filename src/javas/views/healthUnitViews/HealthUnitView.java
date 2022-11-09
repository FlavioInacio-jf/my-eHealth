package javas.views.healthUnitViews;

import javas.constants.ViewConstants;
import javas.views.components.ButtonWithIcon;

import javax.swing.*;
import java.awt.*;

public class HealthUnitView extends JPanel {
    public HealthUnitView() {
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

        ButtonWithIcon addPersonButton = new ButtonWithIcon("Adicionar");
        addPersonButton.setIcon(new ImageIcon(this.getClass().getResource("../icons/add-hospital-icon.png")));
        jPanelNorth.add(addPersonButton);

        ButtonWithIcon updatePersonButton = new ButtonWithIcon("Atualizar");
        updatePersonButton.setIcon(new ImageIcon(this.getClass().getResource("../icons/update-hospital-icon.png")));
        jPanelNorth.add(updatePersonButton);

        ButtonWithIcon deletePersonButton = new ButtonWithIcon("Excluir");
        deletePersonButton.setIcon(new ImageIcon(this.getClass().getResource("../icons/remove-hospital-icon.png")));
        jPanelNorth.add(deletePersonButton);

        ButtonWithIcon reportPersonButton = new ButtonWithIcon("Relatório");
        reportPersonButton.setIcon(new ImageIcon(this.getClass().getResource("../icons/report-hospital-icon.png")));
        jPanelNorth.add(reportPersonButton);

        this.add(jPanelNorth, BorderLayout.NORTH);

        // Configure center area
        JPanel jPanelCenter = new JPanel();
        jPanelCenter.setBackground(Color.WHITE);
        jPanelCenter.setLayout(new GridLayout(1, 2));

        this.add(jPanelCenter);

        this.setBackground(Color.WHITE);
    }
}

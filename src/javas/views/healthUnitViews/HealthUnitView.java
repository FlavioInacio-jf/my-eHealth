package javas.views.healthUnitViews;

import javas.constants.ViewConstants;
import javas.views.components.ButtonWithIcon;
import javas.views.personViews.GenerateMedicalRecordView;

import javax.swing.*;
import java.awt.*;

public class HealthUnitView extends JPanel {
    private GenerateRecordHealthUnitView generateRecordHealthUnitView;
    private DeleteHealthUnitView deleteHealthUnitView;
    private UpdateHealthUnitView updateHealthUnitView;
    private AddHealthUnitView addHealthUnitView;


    public HealthUnitView() {
        this.generateRecordHealthUnitView = new GenerateRecordHealthUnitView();
        this.deleteHealthUnitView = new DeleteHealthUnitView();
        this.updateHealthUnitView = new UpdateHealthUnitView();
        this.addHealthUnitView = new AddHealthUnitView();
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
        addHealthUnitButton.setIcon(new ImageIcon(this.getClass().getResource("../icons/add-hospital-icon.png")));
        addHealthUnitButton.addActionListener(e -> {
            if (!this.addHealthUnitView.isVisible()) {
                this.addHealthUnitView.setVisible(true);
            }
        });
        jPanelNorth.add(addHealthUnitButton);

        ButtonWithIcon updateHealthUnitButton = new ButtonWithIcon("Atualizar");
        updateHealthUnitButton.setIcon(new ImageIcon(this.getClass().getResource("../icons/update-hospital-icon.png")));
        updateHealthUnitButton.addActionListener(e -> {
            if (!this.updateHealthUnitView.isVisible()) {
                this.updateHealthUnitView.setVisible(true);
            }
        });
        jPanelNorth.add(updateHealthUnitButton);

        ButtonWithIcon deleteHealthUnitButton = new ButtonWithIcon("Excluir");
        deleteHealthUnitButton.setIcon(new ImageIcon(this.getClass().getResource("../icons/remove-hospital-icon.png")));
        deleteHealthUnitButton.addActionListener(e -> {
            if (!this.deleteHealthUnitView.isVisible()) {
                this.deleteHealthUnitView.setVisible(true);
            }
        });
        jPanelNorth.add(deleteHealthUnitButton);

        ButtonWithIcon reportHealthUnitButton = new ButtonWithIcon("Relatório");
        reportHealthUnitButton.setIcon(new ImageIcon(this.getClass().getResource("../icons/report-hospital-icon.png")));
        reportHealthUnitButton.addActionListener(e -> {
            this.generateRecordHealthUnitView.setVisible(true);
        });
        jPanelNorth.add(reportHealthUnitButton);

        this.add(jPanelNorth, BorderLayout.NORTH);

        // Configure center area
        JPanel jPanelCenter = new JPanel();
        jPanelCenter.setBackground(Color.WHITE);
        jPanelCenter.setLayout(new GridLayout(1, 2));

        this.add(jPanelCenter);

        this.setBackground(Color.WHITE);
    }
}

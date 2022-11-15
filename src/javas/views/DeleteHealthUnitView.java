package javas.views;

import javas.modules.healthUnit.models.HealthUnit;
import javas.views.components.*;
import javas.constants.ViewConstants;
import javas.views.components.Button;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static javas.modules.healthUnit.useCases.deleteHealthUnit.DeleteHealthUnit.deleteHealthUnitController;
import static javas.modules.healthUnit.useCases.getSingleHealthUnit.GetSingleHealthUnit.getSingleHealthUnitController;

public class DeleteHealthUnitView extends BaseFrame {
    private final FormGroupInput healthUnitCNPJ;
    public DeleteHealthUnitView() {
        this.healthUnitCNPJ = new FormGroupInput("CNPJ");
        this.healthUnitCNPJ.setMaskFormatter("##.###.###/####-##");

        this.init();
    }

    private void init() {
        this.setTitle(ViewConstants.DELETE_HEALTH_UNIT_TITLE);

        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        Header header = new Header("Excluir unidade de saúde", this.getClass().getResource("icons/remove-hospital-icon.png"));

        javas.views.components.Button buttonDelete = new Button("Excluir unidade de saúde");
        buttonDelete.addActionListener(e -> this.handleDeleteHealthUnit());
        buttonDelete.setBackground(Color.RED);

        JPanel formPanel = new JPanel();
        formPanel.setBackground(Color.WHITE);
        formPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        formPanel.setAlignmentY(Component.TOP_ALIGNMENT);
        GridLayout formLayout = new GridLayout(2, 1);
        formLayout.setVgap(20);
        formPanel.setLayout(formLayout);
        formPanel.add(this.healthUnitCNPJ);
        formPanel.add(buttonDelete);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());

        mainPanel.add(formPanel);
        mainPanel.setBackground(Color.WHITE);

        contentPane.add(header);
        contentPane.add(mainPanel);
    }

    private void handleDeleteHealthUnit() {
        if (!healthUnitCNPJ.getText().matches("(^\\d{2}.\\d{3}.\\d{3}/\\d{4}-\\d{2}$)")) {
            JOptionPane.showMessageDialog(this, "CNPJ informado é inválido!");
        }
        else {
            int diaologConfirm = 1;
            try {
                String cnpj = this.healthUnitCNPJ.getText().trim();

                HealthUnit healthUnit = getSingleHealthUnitController.execute(cnpj);
                diaologConfirm  = JOptionPane.showConfirmDialog(this,
                        String.format("Excluir unidade de saúde? %s?", healthUnit.getName()),
                        "Confirmar exclusão da unidade de saúde",
                        JOptionPane.YES_NO_CANCEL_OPTION);

                if (diaologConfirm == 0) {
                    deleteHealthUnitController.execute(cnpj);
                    this.healthUnitCNPJ.setText("");
                    JOptionPane.showMessageDialog(this, "Unidade de saúde removida com sucesso!");
                }
            }catch (Error error) {
                JOptionPane.showMessageDialog(this, error.getMessage());
            }
        }

    }
}

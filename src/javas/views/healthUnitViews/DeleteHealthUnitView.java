package javas.views.healthUnitViews;

import javas.modules.healthUnit.repositories.IHealthUnitRepository;
import javas.modules.healthUnit.repositories.implementations.HealthUnitRepository;
import javas.modules.healthUnit.useCases.deleteHeathUnit.DeleteHealthUnitController;
import javas.modules.healthUnit.useCases.deleteHeathUnit.DeleteHealthUnitUseCase;
import javas.views.components.BaseFrame;
import javas.constants.ViewConstants;
import javas.views.components.Button;
import javas.views.components.FormGroupInput;
import javas.views.components.Title;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class DeleteHealthUnitView extends BaseFrame {
    public DeleteHealthUnitView() {
        this.init();
    }

    private void init() {
        this.setTitle(ViewConstants.DELETE_HEALTH_UNIT_TITLE);

        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        JPanel header = new JPanel();
        header.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        Title title = new Title("Excluir unidade de saúde", SwingConstants.CENTER);
        Icon healthUnitIcon = new ImageIcon(this.getClass().getResource("../icons/remove-hospital-icon.png"));

        header.add(new JLabel(healthUnitIcon));
        header.add(title);

        FormGroupInput healthUnitCNPJ = new FormGroupInput("CNPJ");
        healthUnitCNPJ.setMaskFormatter("##.###.###/####-##");

        javas.views.components.Button buttonDelete = new Button("Excluir unidade de saúde");
        buttonDelete.addActionListener(e -> this.handleDeleteHealthUnit(healthUnitCNPJ.getText()));
        buttonDelete.setBackground(Color.RED);

        JPanel formPanel = new JPanel();
        formPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        formPanel.setAlignmentY(Component.TOP_ALIGNMENT);
        GridLayout formLayout = new GridLayout(2, 1);
        formLayout.setVgap(20);
        formPanel.setLayout(formLayout);
        formPanel.add(healthUnitCNPJ);
        formPanel.add(buttonDelete);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());

        mainPanel.add(formPanel);

        contentPane.add(header);
        contentPane.add(mainPanel);
    }

    private void handleDeleteHealthUnit(String cnpj) {
        if (cnpj.length() < 14) {
            JOptionPane.showMessageDialog(this, "CNPJ inválido");
        }

        int diaologConfirm = JOptionPane.showConfirmDialog(this, JOptionPane.ERROR_MESSAGE, "Excluir unidade de saúde?", JOptionPane.YES_NO_CANCEL_OPTION);

        IHealthUnitRepository healthUnitRepository =  new HealthUnitRepository();
        DeleteHealthUnitUseCase deleteHealthUnitUseCase = new DeleteHealthUnitUseCase(healthUnitRepository);
        DeleteHealthUnitController deleteHealthUnitController = new DeleteHealthUnitController(deleteHealthUnitUseCase);

        if (diaologConfirm == 0) {
            try {
                deleteHealthUnitController.execute(cnpj);
                JOptionPane.showMessageDialog(this, "Unidade de saúde removida com sucesso!");
            }catch (Error error) {
                JOptionPane.showMessageDialog(this, error.getMessage());
            }
        }



    }
}

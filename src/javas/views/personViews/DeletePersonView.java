package javas.views.personViews;

import javas.constants.ViewConstants;
import javas.views.components.BaseFrame;
import javas.views.components.Button;
import javas.views.components.FormGroupInput;
import javas.views.components.Title;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static javas.modules.person.useCases.deletePerson.DeletePerson.deletePersonController;


public class DeletePersonView extends BaseFrame {
    public DeletePersonView() {
        this.init();
    }

    private void init() {
        this.setTitle(ViewConstants.DELETE_PERSON_VIEW_TITLE);

        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        JPanel header = new JPanel();
        header.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));

        Title title = new Title("Excluir paciente", SwingConstants.CENTER);
        Icon personIcon = new ImageIcon(this.getClass().getResource("../icons/remove-user-icon.png"));

        header.add(new JLabel(personIcon));
        header.add(title);

        FormGroupInput personCPF = new FormGroupInput("CPF");
        personCPF.setMaskFormatter("###.###.###-##");

        Button buttonDelete = new Button("Excluir paciente");
        buttonDelete.addActionListener(e -> this.handleDeletePerson(personCPF.getText()));
        buttonDelete.setBackground(Color.RED);

        JPanel formPanel = new JPanel();
        formPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        formPanel.setAlignmentY(Component.TOP_ALIGNMENT);
        GridLayout formLayout = new GridLayout(2, 1);
        formLayout.setVgap(20);
        formPanel.setLayout(formLayout);
        formPanel.add(personCPF);
        formPanel.add(buttonDelete);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());

        mainPanel.add(formPanel);

        contentPane.add(header);
        contentPane.add(mainPanel);
    }

    private void handleDeletePerson(String cpf) {

        if (cpf.length() < 14) {
            JOptionPane.showMessageDialog(this, "CPF inválido");
        }

        int diaologConfirm = JOptionPane.showConfirmDialog(this, JOptionPane.ERROR_MESSAGE, "Excluir esse usuário?", JOptionPane.YES_NO_CANCEL_OPTION);

        if (diaologConfirm == 0) {
            try {
                deletePersonController.execute(cpf);
                JOptionPane.showMessageDialog(this, "Paciente removido com sucesso!");
            }catch (Error error) {
                JOptionPane.showMessageDialog(this, error.getMessage());
            }
        }
    }
}

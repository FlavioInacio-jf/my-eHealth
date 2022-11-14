package javas.views.personViews;

import javas.constants.ViewConstants;
import static javas.modules.person.useCases.getSinglePerson.GetSinglePerson.getSinglePersonController;

import javas.modules.person.models.Person;
import javas.views.components.*;
import javas.views.components.Button;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

import static javas.modules.person.useCases.deletePerson.DeletePerson.deletePersonController;


public class DeletePersonView extends BaseFrame {
    private final FormGroupInput personCPF;

    public DeletePersonView() {
        this.personCPF = new FormGroupInput("CPF");
        this.personCPF.setMaskFormatter("###.###.###-##");
        this.init();
    }

    private void init() {
        this.setTitle(ViewConstants.DELETE_PERSON_VIEW_TITLE);

        JPanel contentPane = (JPanel) this.getContentPane();

        contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

        // Header
        Header header = new Header("Excluir paciente", this.getClass().getResource("../icons/remove-user-icon.png"));


        Button buttonDelete = new Button("Excluir paciente");
        buttonDelete.addActionListener(e -> this.handleDeletePerson());
        buttonDelete.setBackground(Color.RED);

        JPanel formPanel = new JPanel();
        formPanel.setBackground(Color.WHITE);
        formPanel.setAlignmentX(Component.CENTER_ALIGNMENT);
        formPanel.setAlignmentY(Component.TOP_ALIGNMENT);
        GridLayout formLayout = new GridLayout(2, 1);
        formLayout.setVgap(20);
        formPanel.setLayout(formLayout);
        formPanel.add(this.personCPF);
        formPanel.add(buttonDelete);

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setLayout(new FlowLayout());

        mainPanel.add(formPanel);

        contentPane.add(header);
        contentPane.add(mainPanel);
    }

    private void handleDeletePerson() {

        if (!this.personCPF.getText().matches("(^\\d{3}\\x2E\\d{3}\\x2E\\d{3}\\x2D\\d{2}$)")) {
            JOptionPane.showMessageDialog(this, "CPF informado é inválido!");
        }
        else  {
            int diaologConfirm = 1;
            String cpf = this.personCPF.getText();
            try {
                Person person = getSinglePersonController.execute(cpf);
                diaologConfirm  = JOptionPane.showConfirmDialog(this,
                        String.format("Excluir o usuário %s?", person.getFullName()),
                        "Confirmar exclusão do usuário",
                        JOptionPane.YES_NO_CANCEL_OPTION);

                if (diaologConfirm == 0) {
                    deletePersonController.execute(cpf);
                    this.personCPF.setText("");
                    JOptionPane.showMessageDialog(this, "Paciente removido com sucesso!");
                }
            }catch (Error error) {
                JOptionPane.showMessageDialog(this, error.getMessage());
            }
        }

    }
}

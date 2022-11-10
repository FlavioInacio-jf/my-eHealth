package javas.modules.person.useCases.deletePerson;

import javax.swing.*;

public class DeletePersonController {
    private DeletePersonUseCase deletePersonUseCase;

    public DeletePersonController(DeletePersonUseCase deletePersonUseCase) {
        this.deletePersonUseCase = deletePersonUseCase;
    }
    public void execute(String cpf) {
        try {
            this.deletePersonUseCase.handle(cpf);
            JOptionPane.showMessageDialog(null, "Paciente excluido com sucesso!");
        }catch (Error error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
    }
}

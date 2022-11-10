package javas.modules.person.useCases.deletePerson;

public class DeletePersonController {
    private DeletePersonUseCase deletePersonUseCase;

    public DeletePersonController(DeletePersonUseCase deletePersonUseCase) {
        this.deletePersonUseCase = deletePersonUseCase;
    }
    public void execute(String cpf) {
        try {
            this.deletePersonUseCase.handle(cpf);
        }catch (Error error) {
            throw new Error(error);
        }
    }
}

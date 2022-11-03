package javas.modules.person.useCases.updatePerson;

public class UpdatePersonController {
    private UpdatePersonUseCase updatePersonUseCase;

    public UpdatePersonController(UpdatePersonUseCase updatePersonUseCase) {
        this.updatePersonUseCase = updatePersonUseCase;
    }

    public void execute() {
        this.updatePersonUseCase.handle(null, null);
    }
}

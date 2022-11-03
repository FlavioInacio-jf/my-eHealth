package javas.modules.person.useCases.createPerson;

public class CreatePersonController {
    private CreatePersonUseCase createPersonUseCase;

    public CreatePersonController (CreatePersonUseCase createPersonUseCase) {
        this.createPersonUseCase = createPersonUseCase;
    }

    public void execute () {
        this.createPersonUseCase.handle(null);
    }
}

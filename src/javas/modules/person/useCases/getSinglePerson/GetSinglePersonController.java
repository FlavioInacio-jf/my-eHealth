package javas.modules.person.useCases.getSinglePerson;

public class GetSinglePersonController {
    private GetSinglePersonUseCase getSinglePersonUseCase;
    public GetSinglePersonController(GetSinglePersonUseCase getSinglePersonUseCase) {
        this.getSinglePersonUseCase = getSinglePersonUseCase;
    }

    public void execute() {
        this.getSinglePersonUseCase.handle();
    }
}

package java.modules.person.useCases.getAllPeople;

public class GetAllPeopleController {
    private GetAllPeopleUseCase getAllPeopleUseCase;

    public GetAllPeopleController(GetAllPeopleUseCase getAllPeopleUseCase) {
        this.getAllPeopleUseCase = getAllPeopleUseCase;
    }

    public void execute() {
        this.getAllPeopleUseCase.handle();
    }
}

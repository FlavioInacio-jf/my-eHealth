package javas.modules.person.useCases.getAllPeople;

import javas.modules.person.models.Person;

import java.util.ArrayList;

public class GetAllPeopleController {
    private final GetAllPeopleUseCase getAllPeopleUseCase;

    public GetAllPeopleController(GetAllPeopleUseCase getAllPeopleUseCase) {
        this.getAllPeopleUseCase = getAllPeopleUseCase;
    }

    public ArrayList<Person> execute() {
        return this.getAllPeopleUseCase.handle();
    }

    public ArrayList<Person> execute(String querySQL) {
        return this.getAllPeopleUseCase.handle(querySQL);
    }
}

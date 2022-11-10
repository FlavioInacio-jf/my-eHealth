package javas.modules.person.useCases.getAllPeople;

import javas.modules.person.models.Person;

import java.util.ArrayList;

public class GetAllPeopleController {
    private GetAllPeopleUseCase getAllPeopleUseCase;

    public GetAllPeopleController(GetAllPeopleUseCase getAllPeopleUseCase) {
        this.getAllPeopleUseCase = getAllPeopleUseCase;
    }

    public ArrayList<Person> execute() {
        try {
           return this.getAllPeopleUseCase.handle();
        }catch (Error error) {
            throw new Error(error);
        }
    }
}

package javas.modules.person.useCases.getAllPeople;

import javas.modules.person.models.Person;
import javas.modules.person.repositories.IPersonRepository;

public class GetAllPeopleUseCase {
    private IPersonRepository personRepository;
    public GetAllPeopleUseCase(IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person[] handle() {
        return null;
    }
}

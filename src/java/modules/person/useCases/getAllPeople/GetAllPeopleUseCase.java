package java.modules.person.useCases.getAllPeople;

import java.modules.person.models.Person;
import java.modules.person.repositories.IPersonRepository;
import java.modules.person.repositories.implementations.PersonRepository;

public class GetAllPeopleUseCase {
    private IPersonRepository personRepository;
    public GetAllPeopleUseCase(IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person[] handle() {
        return null;
    }
}

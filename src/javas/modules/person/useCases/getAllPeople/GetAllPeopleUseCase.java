package javas.modules.person.useCases.getAllPeople;

import javas.modules.person.models.Person;
import javas.modules.person.repositories.IPersonRepository;

import java.util.ArrayList;

public class GetAllPeopleUseCase {
    private IPersonRepository personRepository;
    public GetAllPeopleUseCase(IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public ArrayList<Person> handle() {
        return this.personRepository.getAll();
    }
}

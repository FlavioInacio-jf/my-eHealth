package java.modules.person.useCases.createPerson;

import java.modules.person.models.Person;
import java.modules.person.repositories.IPersonRepository;

public class CreatePersonUseCase {
    private IPersonRepository personRepository;

    public CreatePersonUseCase (IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person handle() {
        return null;
    }
}

package java.modules.person.useCases.getSinglePerson;

import java.modules.person.models.Person;
import java.modules.person.repositories.IPersonRepository;

public class GetSinglePersonUseCase {
    private IPersonRepository personRepository;
    public GetSinglePersonUseCase(IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    public Person handle() {
        return null;
    }
}

package javas.modules.person.useCases.getSinglePerson;

import javas.modules.person.models.Person;
import javas.modules.person.repositories.IPersonRepository;

public class GetSinglePersonUseCase {
    private IPersonRepository personRepository;
    public GetSinglePersonUseCase(IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    public Person handle() {
        return null;
    }
}

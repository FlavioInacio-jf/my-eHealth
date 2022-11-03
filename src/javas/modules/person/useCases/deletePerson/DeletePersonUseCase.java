package javas.modules.person.useCases.deletePerson;

import javas.modules.person.models.Person;
import javas.modules.person.repositories.IPersonRepository;

public class DeletePersonUseCase {
    private IPersonRepository personRepository;
    public DeletePersonUseCase(IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person handle() {
        return null;
    }
}

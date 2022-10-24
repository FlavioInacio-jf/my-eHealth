package java.modules.person.useCases.deletePerson;

import java.modules.person.models.Person;
import java.modules.person.repositories.IPersonRepository;

public class DeletePersonUseCase {
    private IPersonRepository personRepository;
    public DeletePersonUseCase(IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person handle() {
        return null;
    }
}

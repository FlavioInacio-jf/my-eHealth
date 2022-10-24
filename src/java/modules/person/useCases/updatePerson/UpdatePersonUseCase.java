package java.modules.person.useCases.updatePerson;

import java.modules.person.models.Person;
import java.modules.person.repositories.IPersonRepository;

public class UpdatePersonUseCase {
    private IPersonRepository personRepository;

    public UpdatePersonUseCase(IPersonRepository personRepository) {
       this.personRepository = personRepository;
    }

    public Person handle(String _id, Person person) {
        return null;
    }
}

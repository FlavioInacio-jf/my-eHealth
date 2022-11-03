package javas.modules.person.useCases.updatePerson;

import javas.modules.person.models.Person;
import javas.modules.person.repositories.IPersonRepository;

public class UpdatePersonUseCase {
    private IPersonRepository personRepository;

    public UpdatePersonUseCase(IPersonRepository personRepository) {
       this.personRepository = personRepository;
    }

    public Person handle(String _id, Person person) {
        return null;
    }
}

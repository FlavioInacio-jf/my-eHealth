package javas.modules.person.useCases.updatePerson;

import javas.modules.person.repositories.IPersonRepository;
import javas.modules.person.repositories.implementations.PersonRepository;

public class UpdatePerson {
    private static final IPersonRepository personRepository = new PersonRepository();
    private static final UpdatePersonUseCase updatePersonUseCase = new UpdatePersonUseCase(personRepository);
    public static final UpdatePersonController updatePersonController = new UpdatePersonController(updatePersonUseCase);
}

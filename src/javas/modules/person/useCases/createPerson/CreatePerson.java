package javas.modules.person.useCases.createPerson;

import javas.modules.person.repositories.IPersonRepository;
import javas.modules.person.repositories.implementations.PersonRepository;

public class CreatePerson {
    private static final IPersonRepository personRepository = new PersonRepository();
    private static final CreatePersonUseCase createPersonUseCase = new CreatePersonUseCase(personRepository);
    public static final CreatePersonController createPersonController = new CreatePersonController(createPersonUseCase);
}

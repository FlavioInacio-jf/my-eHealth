package javas.modules.person.useCases.deletePerson;

import javas.modules.person.repositories.IPersonRepository;
import javas.modules.person.repositories.implementations.PersonRepository;

public class DeletePerson {
    private static final IPersonRepository personRepository = new PersonRepository();
    private static final DeletePersonUseCase deletePersonUseCase = new DeletePersonUseCase(personRepository);
    public static final DeletePersonController deletePersonController = new DeletePersonController(deletePersonUseCase);
}

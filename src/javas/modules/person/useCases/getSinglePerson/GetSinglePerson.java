package javas.modules.person.useCases.getSinglePerson;

import javas.modules.person.repositories.IPersonRepository;
import javas.modules.person.repositories.implementations.PersonRepository;

public class GetSinglePerson {
    private static final IPersonRepository personRepository = new PersonRepository();
    private static final GetSinglePersonUseCase getSinglePersonUseCase =  new GetSinglePersonUseCase(personRepository);
    public static final GetSinglePersonController getSinglePersonController = new GetSinglePersonController(getSinglePersonUseCase);
}

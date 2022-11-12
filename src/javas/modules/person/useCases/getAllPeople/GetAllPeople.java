package javas.modules.person.useCases.getAllPeople;

import javas.modules.person.repositories.IPersonRepository;
import javas.modules.person.repositories.implementations.PersonRepository;

public class GetAllPeople {
    private static final IPersonRepository personRepository = new PersonRepository();
    private static final GetAllPeopleUseCase getAllPeopleUseCase = new GetAllPeopleUseCase(personRepository);
    public static GetAllPeopleController getAllPeopleController = new GetAllPeopleController(getAllPeopleUseCase);
}

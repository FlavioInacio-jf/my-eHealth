package javas.modules.person.useCases.getAllPeople;

import javas.modules.person.repositories.IPersonRepository;
import javas.modules.person.repositories.implementations.PersonRepository;
import javas.modules.vaccine.repositories.IVaccineRepository;
import javas.modules.vaccine.repositories.impementations.VaccineRepository;

public class GetAllPeople {
    private static final IPersonRepository personRepository = new PersonRepository();
    private static final IVaccineRepository vaccineRepository = new VaccineRepository();
    private static final GetAllPeopleUseCase getAllPeopleUseCase = new GetAllPeopleUseCase(personRepository, vaccineRepository);
    public static GetAllPeopleController getAllPeopleController = new GetAllPeopleController(getAllPeopleUseCase);
}

package javas.modules.person.useCases.getSinglePerson;

import javas.modules.person.repositories.IPersonRepository;
import javas.modules.person.repositories.implementations.PersonRepository;
import javas.modules.vaccine.repositories.IVaccineRepository;
import javas.modules.vaccine.repositories.impementations.VaccineRepository;

public class GetSinglePerson {
    private static final IPersonRepository personRepository = new PersonRepository();
    private static final IVaccineRepository vaccineRepository = new VaccineRepository();
    private static final GetSinglePersonUseCase getSinglePersonUseCase =  new GetSinglePersonUseCase(personRepository, vaccineRepository);
    public static final GetSinglePersonController getSinglePersonController = new GetSinglePersonController(getSinglePersonUseCase);
}

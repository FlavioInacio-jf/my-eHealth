package javas.modules.vaccine.useCases.getAllPersonVaccines;

import javas.modules.person.repositories.IPersonRepository;
import javas.modules.person.repositories.implementations.PersonRepository;
import javas.modules.vaccine.repositories.IVaccineRepository;
import javas.modules.vaccine.repositories.impementations.VaccineRepository;

public class GetAllPersonVaccines {
    private static final IVaccineRepository vaccineRepository = new VaccineRepository();
    private static final IPersonRepository personRepository = new PersonRepository();
    private static final GetAllPersonVaccinesUseCase getAllPersonVaccinesUseCase = new GetAllPersonVaccinesUseCase(vaccineRepository, personRepository);
    public static final GetAllPersonVaccinesController getAllPersonVaccinesController = new GetAllPersonVaccinesController(getAllPersonVaccinesUseCase);
}

package javas.modules.vaccine.useCases.applyVaccine;

import javas.modules.healthUnit.repositories.IHealthUnitRepository;
import javas.modules.healthUnit.repositories.implementations.HealthUnitRepository;
import javas.modules.person.repositories.IPersonRepository;
import javas.modules.person.repositories.implementations.PersonRepository;
import javas.modules.vaccine.repositories.IVaccineRepository;
import javas.modules.vaccine.repositories.impementations.VaccineRepository;

public class ApplyVaccine {
    private static final IVaccineRepository vaccineRepository = new VaccineRepository();
    private static final IPersonRepository personRepository = new PersonRepository();
    private static final IHealthUnitRepository healthUnitRepository =  new HealthUnitRepository();
    private static final ApplyVaccineUseCase applyVaccineUseCase = new ApplyVaccineUseCase( vaccineRepository,
            personRepository,
            healthUnitRepository
    );
    public static final ApplyVaccineController applyVaccineController = new ApplyVaccineController(applyVaccineUseCase);
}

package javas.modules.vaccine.useCases.applyVaccine;

import javas.errors.CustomError;
import javas.exceptions.HealthUnitErrorMessages;
import javas.exceptions.PersonErrorMessages;
import javas.modules.healthUnit.models.HealthUnit;
import javas.modules.healthUnit.repositories.IHealthUnitRepository;
import javas.modules.person.models.Person;
import javas.modules.person.repositories.IPersonRepository;
import javas.modules.vaccine.models.Vaccine;
import javas.modules.vaccine.repositories.IVaccineRepository;

public class ApplyVaccineUseCase {
    private IVaccineRepository vaccineRepository;
    private IPersonRepository personRepository;
    private IHealthUnitRepository healthUnitRepository;

    public ApplyVaccineUseCase(IVaccineRepository vaccineRepository,
                               IPersonRepository personRepository,
                               IHealthUnitRepository healthUnitRepository) {
        this.vaccineRepository = vaccineRepository;
        this.personRepository = personRepository;
        this.healthUnitRepository = healthUnitRepository;
    }

    public void handle(String userCPF, String healthUnitCNPJ, Vaccine vaccine) {
        Person personExists = this.personRepository.findByCPF(userCPF);

        if (personExists == null) {
            throw new CustomError(PersonErrorMessages.PERSON_NOT_FOUND_TITLE, PersonErrorMessages.PERSON_NOT_FOUND_DETAIL);
        }

        HealthUnit healthUnitExists =  this.healthUnitRepository.findByCNPJ(healthUnitCNPJ);
        if (healthUnitExists == null) {
            throw new CustomError(HealthUnitErrorMessages.HEALTH_UNIT_NOT_FOUND_TITLE,
                    HealthUnitErrorMessages.HEALTH_UNIT_NOT_FOUND_DETAIL);
        }

        this.vaccineRepository.crate(personExists.getId(), healthUnitExists.getId(), vaccine);
    }
}

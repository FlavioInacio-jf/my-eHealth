package javas.modules.vaccine.useCases.applyVaccine;

import javas.constants.VaccineEntityConstants;
import javas.errors.CustomError;
import javas.exceptions.HealthUnitErrorMessages;
import javas.exceptions.PersonErrorMessages;
import javas.modules.healthUnit.models.HealthUnit;
import javas.modules.healthUnit.repositories.IHealthUnitRepository;
import javas.modules.person.models.Person;
import javas.modules.person.repositories.IPersonRepository;
import javas.modules.vaccine.models.Vaccine;
import javas.modules.vaccine.repositories.IVaccineRepository;
import javas.exceptions.VaccineErrorMessages;

import java.util.ArrayList;

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

        ArrayList<Vaccine> doseAlreadyApplied = this.vaccineRepository.findAll(String.format("%s='%s' AND %s='%s'",
                                                                                            VaccineEntityConstants.PERSON_COLUMN_NAME_FK, personExists.getId(),
                                                                                            VaccineEntityConstants.DOSE_COLUMN_NAME, vaccine.getDose()));
        if (!doseAlreadyApplied.isEmpty()) {
            throw new CustomError(VaccineErrorMessages.DOSE_ALREADY_APPLIED_TITLE, VaccineErrorMessages.DOSE_ALREADY_APPLIED_DETAIL);
        }

        this.vaccineRepository.create(personExists.getId(), healthUnitExists.getId(), vaccine);
    }
}

package javas.modules.vaccine.useCases.getAllVaccinesHealthUnit;

import javas.errors.CustomError;
import javas.exceptions.HealthUnitErrorMessages;
import javas.modules.healthUnit.models.HealthUnit;
import javas.modules.healthUnit.repositories.IHealthUnitRepository;
import javas.modules.vaccine.models.Vaccine;
import javas.modules.vaccine.repositories.IVaccineRepository;

import java.util.ArrayList;

public class GetAllVaccinesHealthUnitUseCase {
    private IVaccineRepository vaccineRepository;
    private IHealthUnitRepository healthUnitRepository;

    public GetAllVaccinesHealthUnitUseCase(IVaccineRepository vaccineRepository,
                                           IHealthUnitRepository healthUnitRepository) {
        this.vaccineRepository = vaccineRepository;
        this.healthUnitRepository = healthUnitRepository;
    }

    public ArrayList<Vaccine> handle(String healthUnitCNPJ) {
        HealthUnit healthUnitExists = this.healthUnitRepository.findByCNPJ(healthUnitCNPJ);

        if (healthUnitExists == null) {
            throw new CustomError(HealthUnitErrorMessages.HEALTH_UNIT_NOT_FOUND_TITLE,
                                  HealthUnitErrorMessages.HEALTH_UNIT_NOT_FOUND_DETAIL);
        }

        ArrayList<Vaccine> vaccines = this.vaccineRepository.findByHealthUnitId(healthUnitExists.getId());

        return vaccines;
    }
}

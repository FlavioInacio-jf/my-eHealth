package javas.modules.healthUnit.useCases.updateHeathUnit;

import javas.errors.CustomError;
import javas.exceptions.HealthUnitErrorMessages;
import javas.modules.healthUnit.models.HealthUnit;
import javas.modules.healthUnit.repositories.IHealthUnitRepository;

public class UpdateHealthUnitUseCase {
    private IHealthUnitRepository heathUnitRepository;

    public UpdateHealthUnitUseCase(IHealthUnitRepository heathUnitRepository) {
        this.heathUnitRepository = heathUnitRepository;
    }

    public void handle(HealthUnit healthUnit) {
        HealthUnit healthUnitExists =  this.heathUnitRepository.findByCNPJ(healthUnit.getCNPJ());
        if (healthUnitExists == null) {
            throw new CustomError(HealthUnitErrorMessages.HEALTH_UNIT_NOT_FOUND_TITLE,
                    HealthUnitErrorMessages.HEALTH_UNIT_NOT_FOUND_DETAIL);
        }
        healthUnitExists.setId(healthUnitExists.getId());
        healthUnitExists.setName(healthUnit.getName());
        healthUnitExists.setAddress(healthUnit.getAddress());
        this.heathUnitRepository.update(healthUnitExists);
    }
}

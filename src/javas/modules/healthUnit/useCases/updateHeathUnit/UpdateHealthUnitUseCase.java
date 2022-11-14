package javas.modules.healthUnit.useCases.updateHeathUnit;

import javas.errors.CustomError;
import javas.exceptions.HealthUnitErrorMessages;
import javas.modules.healthUnit.models.HealthUnit;
import javas.modules.healthUnit.repositories.IHealthUnitRepository;

public class UpdateHealthUnitUseCase {
    private IHealthUnitRepository healthUnitRepository;

    public UpdateHealthUnitUseCase(IHealthUnitRepository heathUnitRepository) {
        this.healthUnitRepository = heathUnitRepository;
    }

    public void handle(HealthUnit healthUnit) {
        HealthUnit healthUnitExists = this.healthUnitRepository.findByCNPJ(healthUnit.getCNPJ());
        if (healthUnitExists == null) {
            throw new CustomError(HealthUnitErrorMessages.HEALTH_UNIT_NOT_FOUND_TITLE,
                    HealthUnitErrorMessages.HEALTH_UNIT_NOT_FOUND_DETAIL);
        }
        healthUnitExists.setId(healthUnitExists.getId());
        healthUnitExists.setName(healthUnit.getName());
        healthUnitExists.setType(healthUnit.getType());
        healthUnitExists.setAddress(healthUnit.getAddress());
        this.healthUnitRepository.update(healthUnitExists);
    }
}

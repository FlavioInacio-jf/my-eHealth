package javas.modules.healthUnit.useCases.createHealthUnit;

import javas.errors.CustomError;
import javas.exceptions.HealthUnitErrorMessages;
import javas.modules.healthUnit.models.HealthUnit;
import javas.modules.healthUnit.repositories.IHealthUnitRepository;

public class CreateHealthUnitUseCase {
    private IHealthUnitRepository healthUnitRepository;

    public CreateHealthUnitUseCase(IHealthUnitRepository heathUnitRepository) {
        this.healthUnitRepository = heathUnitRepository;
    }

    public void handle(HealthUnit healthUnit) {
        HealthUnit healthUnitAlreadyExists = this.healthUnitRepository.findByCNPJ(healthUnit.getCNPJ());
        if (healthUnitAlreadyExists != null) {
            throw new CustomError(HealthUnitErrorMessages.HEALTH_UNIT_ALREADY_EXIST_TITLE,
                                    HealthUnitErrorMessages.HEALTH_UNIT_ALREADY_EXIST_DETAIL);
        }

        this.healthUnitRepository.create(healthUnit);
    }
}

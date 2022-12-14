package javas.modules.healthUnit.useCases.deleteHealthUnit;

import javas.errors.CustomError;
import javas.exceptions.HealthUnitErrorMessages;
import javas.modules.healthUnit.models.HealthUnit;
import javas.modules.healthUnit.repositories.IHealthUnitRepository;

public class DeleteHealthUnitUseCase {
    private IHealthUnitRepository healthUnitRepository;

    public DeleteHealthUnitUseCase(IHealthUnitRepository heathUnitRepository) {
        this.healthUnitRepository = heathUnitRepository;
    }

    public void handle(String cnpj) {
        HealthUnit healthUnitAlreadyExists =  this.healthUnitRepository.findByCNPJ(cnpj);
        if (healthUnitAlreadyExists == null) {
            throw new CustomError(HealthUnitErrorMessages.HEALTH_UNIT_NOT_FOUND_TITLE,
                                    HealthUnitErrorMessages.HEALTH_UNIT_NOT_FOUND_DETAIL);
        }

        this.healthUnitRepository.delete(healthUnitAlreadyExists.getId());
    }
}

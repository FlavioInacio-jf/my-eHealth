package javas.modules.healthUnit.useCases.getSingleHealthUnit;

import javas.errors.CustomError;
import javas.exceptions.HealthUnitErrorMessages;
import javas.modules.healthUnit.models.HealthUnit;
import javas.modules.healthUnit.repositories.IHealthUnitRepository;

public class GetSingleHealthUnitUseCase {
    private IHealthUnitRepository healthUnitRepository;

    public GetSingleHealthUnitUseCase(IHealthUnitRepository heathUnitRepository) {
        this.healthUnitRepository = heathUnitRepository;
    }
    public HealthUnit handle(String cnpj) {
        HealthUnit healthUnitExists =  this.healthUnitRepository.findByCNPJ(cnpj);
        if (healthUnitExists == null) {
            throw new CustomError(HealthUnitErrorMessages.HEALTH_UNIT_NOT_FOUND_TITLE,
                    HealthUnitErrorMessages.HEALTH_UNIT_NOT_FOUND_DETAIL);
        }

       return healthUnitExists;
    }
}

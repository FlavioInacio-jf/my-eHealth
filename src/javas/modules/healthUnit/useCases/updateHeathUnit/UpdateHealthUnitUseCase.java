package javas.modules.healthUnit.useCases.updateHeathUnit;

import javas.modules.healthUnit.repositories.IHealthUnitRepository;

public class UpdateHealthUnitUseCase {
    private IHealthUnitRepository heathUnitRepository;

    public UpdateHealthUnitUseCase(IHealthUnitRepository heathUnitRepository) {
        this.heathUnitRepository = heathUnitRepository;
    }

    public void handle() {

    }
}

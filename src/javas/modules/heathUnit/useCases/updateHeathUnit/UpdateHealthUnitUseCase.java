package javas.modules.heathUnit.useCases.updateHeathUnit;

import javas.modules.heathUnit.repositories.IHealthUnitRepository;

public class UpdateHealthUnitUseCase {
    private IHealthUnitRepository heathUnitRepository;

    public UpdateHealthUnitUseCase(IHealthUnitRepository heathUnitRepository) {
        this.heathUnitRepository = heathUnitRepository;
    }

    public void handle() {

    }
}

package javas.modules.heathUnit.useCases.deleteHeathUnit;

import javas.modules.heathUnit.repositories.IHealthUnitRepository;

public class DeleteHealthUnitUseCase {
    private IHealthUnitRepository heathUnitRepository;

    public DeleteHealthUnitUseCase(IHealthUnitRepository heathUnitRepository) {
        this.heathUnitRepository = heathUnitRepository;
    }

    public void handle() {

    }
}

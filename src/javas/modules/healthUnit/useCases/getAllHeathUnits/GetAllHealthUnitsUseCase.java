package javas.modules.healthUnit.useCases.getAllHeathUnits;

import javas.modules.healthUnit.repositories.IHealthUnitRepository;

public class GetAllHealthUnitsUseCase {
    private IHealthUnitRepository heathUnitRepository;

    public GetAllHealthUnitsUseCase(IHealthUnitRepository heathUnitRepository) {
        this.heathUnitRepository = heathUnitRepository;
    }

    public void handle() {

    }
}

package javas.modules.heathUnit.useCases.getAllHeathUnits;

import javas.modules.heathUnit.repositories.IHealthUnitRepository;

public class GetAllHealthUnitsUseCase {
    private IHealthUnitRepository heathUnitRepository;

    public GetAllHealthUnitsUseCase(IHealthUnitRepository heathUnitRepository) {
        this.heathUnitRepository = heathUnitRepository;
    }

    public void handle() {

    }
}

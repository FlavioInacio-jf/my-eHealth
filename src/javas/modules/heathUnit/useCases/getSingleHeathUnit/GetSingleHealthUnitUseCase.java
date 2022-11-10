package javas.modules.heathUnit.useCases.getSingleHeathUnit;

import javas.modules.heathUnit.repositories.IHealthUnitRepository;

public class GetSingleHealthUnitUseCase {
    private IHealthUnitRepository heathUnitRepository;

    public GetSingleHealthUnitUseCase(IHealthUnitRepository heathUnitRepository) {
        this.heathUnitRepository = heathUnitRepository;
    }

    public void handle() {

    }
}

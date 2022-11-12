package javas.modules.healthUnit.useCases.getSingleHealthUnit;

import javas.modules.healthUnit.repositories.IHealthUnitRepository;
import javas.modules.healthUnit.repositories.implementations.HealthUnitRepository;

public class GetSingleHealthUnit {
    private static final IHealthUnitRepository healthUnitRepository = new HealthUnitRepository();
    private static final GetSingleHealthUnitUseCase healthUnitUseCase = new GetSingleHealthUnitUseCase(healthUnitRepository);
    public static final GetSingleHealthUnitController healthUnitController = new GetSingleHealthUnitController(healthUnitUseCase);
}

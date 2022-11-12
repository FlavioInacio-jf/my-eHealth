package javas.modules.healthUnit.useCases.getAllHealthUnits;

import javas.modules.healthUnit.repositories.IHealthUnitRepository;
import javas.modules.healthUnit.repositories.implementations.HealthUnitRepository;

public class GetAllHealthUnits {
    private final static IHealthUnitRepository healthUnitRepository = new HealthUnitRepository();
    private final static GetAllHealthUnitsUseCase getAllHealthUnitsUseCase = new GetAllHealthUnitsUseCase(healthUnitRepository);
    public final static GetAllHealthUnitsController getAllHealthUnitsController = new GetAllHealthUnitsController(getAllHealthUnitsUseCase);
}

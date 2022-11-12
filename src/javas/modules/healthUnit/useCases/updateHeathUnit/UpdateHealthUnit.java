package javas.modules.healthUnit.useCases.updateHeathUnit;

import javas.modules.healthUnit.repositories.IHealthUnitRepository;
import javas.modules.healthUnit.repositories.implementations.HealthUnitRepository;

public class UpdateHealthUnit {
    private static final IHealthUnitRepository healthUnitRepository = new HealthUnitRepository();
    private static final UpdateHealthUnitUseCase updateHealthUnitUseCase = new UpdateHealthUnitUseCase(healthUnitRepository);
    public static final UpdateHealthUnitController updateHealthUnitController = new UpdateHealthUnitController(updateHealthUnitUseCase);
}

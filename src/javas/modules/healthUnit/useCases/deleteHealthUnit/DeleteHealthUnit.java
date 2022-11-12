package javas.modules.healthUnit.useCases.deleteHealthUnit;

import javas.modules.healthUnit.repositories.IHealthUnitRepository;
import javas.modules.healthUnit.repositories.implementations.HealthUnitRepository;

public class DeleteHealthUnit {
    private static final IHealthUnitRepository healthUnitRepository =  new HealthUnitRepository();
    private static final DeleteHealthUnitUseCase deleteHealthUnitUseCase = new DeleteHealthUnitUseCase(healthUnitRepository);
    public static final DeleteHealthUnitController deleteHealthUnitController = new DeleteHealthUnitController(deleteHealthUnitUseCase);
}

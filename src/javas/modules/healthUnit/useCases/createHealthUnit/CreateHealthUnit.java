package javas.modules.healthUnit.useCases.createHealthUnit;

import javas.modules.healthUnit.repositories.IHealthUnitRepository;
import javas.modules.healthUnit.repositories.implementations.HealthUnitRepository;

public class CreateHealthUnit {
    private static final IHealthUnitRepository healthUnitRepository = new HealthUnitRepository();
    private static final CreateHealthUnitUseCase createHealthUnitUseCase = new CreateHealthUnitUseCase(healthUnitRepository);
    public static final CreateHealthUnitController createHealthUnitController =  new CreateHealthUnitController(createHealthUnitUseCase);
}

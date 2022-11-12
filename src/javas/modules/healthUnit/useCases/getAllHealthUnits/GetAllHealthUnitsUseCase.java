package javas.modules.healthUnit.useCases.getAllHealthUnits;

import javas.modules.healthUnit.models.HealthUnit;
import javas.modules.healthUnit.repositories.IHealthUnitRepository;

import java.util.ArrayList;

public class GetAllHealthUnitsUseCase {
    private IHealthUnitRepository heathUnitRepository;

    public GetAllHealthUnitsUseCase(IHealthUnitRepository heathUnitRepository) {
        this.heathUnitRepository = heathUnitRepository;
    }

    public ArrayList<HealthUnit> handle() {
        return this.heathUnitRepository.getAll();
    }
}

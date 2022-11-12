package javas.modules.healthUnit.useCases.getAllHealthUnits;

import javas.modules.healthUnit.models.HealthUnit;

import java.util.ArrayList;

public class GetAllHealthUnitsController {
    GetAllHealthUnitsUseCase getAllHealthUnitsUseCase;

    public GetAllHealthUnitsController(GetAllHealthUnitsUseCase getAllHealthUnitsUseCase) {
        this.getAllHealthUnitsUseCase = getAllHealthUnitsUseCase;
    }

    public ArrayList<HealthUnit> execute() {
        return this.getAllHealthUnitsUseCase.handle();
    }
}

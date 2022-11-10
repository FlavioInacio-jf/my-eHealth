package javas.modules.healthUnit.useCases.getAllHeathUnits;

import javas.modules.healthUnit.models.HealthUnit;

import java.util.ArrayList;

public class GetAllHealthUnitsController {
    GetAllHealthUnitsUseCase getAllHealthUnitsUseCase;

    public GetAllHealthUnitsController(GetAllHealthUnitsUseCase getAllHealthUnitsUseCase) {
        this.getAllHealthUnitsUseCase = getAllHealthUnitsUseCase;
    }

    public ArrayList<HealthUnit> execute() {
        try {
            return this.getAllHealthUnitsUseCase.handle();
        }catch (Error error) {
            throw new Error(error);
        }
    }
}

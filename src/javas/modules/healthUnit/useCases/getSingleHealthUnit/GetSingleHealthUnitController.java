package javas.modules.healthUnit.useCases.getSingleHealthUnit;

import javas.modules.healthUnit.models.HealthUnit;

public class GetSingleHealthUnitController {
    GetSingleHealthUnitUseCase getSingleHealthUnitUseCase;

    public GetSingleHealthUnitController(GetSingleHealthUnitUseCase getSingleHealthUnitUseCase){
        this.getSingleHealthUnitUseCase = getSingleHealthUnitUseCase;
    }
    public HealthUnit execute (String cnpj){
        return this.getSingleHealthUnitUseCase.handle(cnpj);
    }
}

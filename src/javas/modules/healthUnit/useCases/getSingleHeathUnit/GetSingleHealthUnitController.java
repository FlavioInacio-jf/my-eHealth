package javas.modules.healthUnit.useCases.getSingleHeathUnit;

import javas.modules.healthUnit.models.HealthUnit;

public class GetSingleHealthUnitController {
    GetSingleHealthUnitUseCase getSingleHealthUnitUseCase;

    public GetSingleHealthUnitController(GetSingleHealthUnitUseCase getSingleHealthUnitUseCase){
        this.getSingleHealthUnitUseCase = getSingleHealthUnitUseCase;
    }
    public HealthUnit execute (String cnpj){
        try {
            return this.getSingleHealthUnitUseCase.handle(cnpj);
        }catch (Error error) {
            throw new Error(error);
        }
    }
}

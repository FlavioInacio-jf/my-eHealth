package javas.modules.heathUnit.useCases.getSingleHeathUnit;

public class GetSingleHealthUnitController {
    GetSingleHealthUnitUseCase getSingleHealthUnitUseCase;

    public GetSingleHealthUnitController(GetSingleHealthUnitUseCase getSingleHealthUnitUseCase){
        this.getSingleHealthUnitUseCase = getSingleHealthUnitUseCase;
    }
    public void execute (String cnpj){
        try {
            this.getSingleHealthUnitUseCase.handle(cnpj);
        }catch (Error error) {
            throw new Error(error);
        }
    }
}

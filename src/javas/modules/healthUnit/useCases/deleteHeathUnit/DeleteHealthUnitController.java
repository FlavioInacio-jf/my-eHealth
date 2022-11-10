package javas.modules.healthUnit.useCases.deleteHeathUnit;

public class DeleteHealthUnitController {
    DeleteHealthUnitUseCase deleteHealthUnitUseCase;

    public DeleteHealthUnitController(DeleteHealthUnitUseCase deleteHealthUnitUseCase){
        this.deleteHealthUnitUseCase = deleteHealthUnitUseCase;
    }
    public void execute (String cnpj){
        try {
            this.deleteHealthUnitUseCase.handle(cnpj);
        }catch (Error error) {
            throw new Error(error);
        }
    }
}

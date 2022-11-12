package javas.modules.healthUnit.useCases.deleteHealthUnit;

public class DeleteHealthUnitController {
    DeleteHealthUnitUseCase deleteHealthUnitUseCase;

    public DeleteHealthUnitController(DeleteHealthUnitUseCase deleteHealthUnitUseCase){
        this.deleteHealthUnitUseCase = deleteHealthUnitUseCase;
    }
    public void execute (String cnpj){
        this.deleteHealthUnitUseCase.handle(cnpj);
    }
}

package javas.modules.vaccine.useCases.deleteVaccine;

public class DeleteVaccineController {
    private DeleteVaccineUseCase deleteVaccineUseCase;

    public DeleteVaccineController(DeleteVaccineUseCase deleteVaccineUseCase) {
        this.deleteVaccineUseCase = deleteVaccineUseCase;
    }

    public void execute(String _id) {
        try {
            this.deleteVaccineUseCase.handle(_id);
        }catch (Error error) {
            throw new Error(error);
        }
    }
}

package javas.modules.vaccine.useCases.updateVaccine;

import javas.modules.vaccine.models.Vaccine;
import javas.validations.Validation;

public class UpdateVaccineController {
    private UpdateVaccineUseCase updateVaccineUseCase;
    public UpdateVaccineController(UpdateVaccineUseCase updateVaccineUseCase) {
        this.updateVaccineUseCase = updateVaccineUseCase;
    }

    public void execute(
            String _id,
            String name,
            int dose,
            String lot
    ) throws IllegalAccessException {

        Vaccine vaccine = new Vaccine(_id, name, dose, lot);
        new Validation(vaccine).validate();
        this.updateVaccineUseCase.handle(vaccine);
    }
}

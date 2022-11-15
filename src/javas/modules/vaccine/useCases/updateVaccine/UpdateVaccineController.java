package javas.modules.vaccine.useCases.updateVaccine;

import javas.modules.vaccine.enums.VaccineName;
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
            String lot,
            String applicationDate
    ) throws IllegalAccessException {

        Vaccine vaccine = new Vaccine(_id, VaccineName.valueOf(name), dose, lot, applicationDate);
        new Validation(vaccine).validate();
        this.updateVaccineUseCase.handle(vaccine);
    }
}

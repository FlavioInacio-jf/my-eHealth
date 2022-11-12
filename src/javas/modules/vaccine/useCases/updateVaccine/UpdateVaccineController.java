package javas.modules.vaccine.useCases.updateVaccine;

import javas.modules.vaccine.models.Vaccine;

public class UpdateVaccineController {
    private UpdateVaccineUseCase updateVaccineUseCase;
    public UpdateVaccineController(UpdateVaccineUseCase updateVaccineUseCase) {
        this.updateVaccineUseCase = updateVaccineUseCase;
    }

    public void execute(
            String _id,
            String name,
            String date,
            int dose,
            String lot
    ) {

        Vaccine vaccine = new Vaccine(_id, name, date, dose, lot);
        this.updateVaccineUseCase.handle(vaccine);
    }
}

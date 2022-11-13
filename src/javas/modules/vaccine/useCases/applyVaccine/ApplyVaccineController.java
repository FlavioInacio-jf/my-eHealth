package javas.modules.vaccine.useCases.applyVaccine;

import javas.modules.vaccine.models.Vaccine;
import javas.validations.Validation;

public class ApplyVaccineController {
    private final ApplyVaccineUseCase applyVaccineUseCase;

    public ApplyVaccineController(ApplyVaccineUseCase applyVaccineUseCase) {
        this.applyVaccineUseCase = applyVaccineUseCase;
    }

    public void execute(String userCPF,
                        String healthUnitCNPJ,
                        String name,
                        int dose,
                        String lot ) throws IllegalAccessException {

        Vaccine vaccine = new Vaccine(null, name, dose, lot);
        new Validation(vaccine).validate();
        this.applyVaccineUseCase.handle(userCPF, healthUnitCNPJ, vaccine);
    }
}

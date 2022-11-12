package javas.modules.vaccine.useCases.applyVaccine;

import javas.modules.vaccine.models.Vaccine;

public class ApplyVaccineController {
    private final ApplyVaccineUseCase applyVaccineUseCase;

    public ApplyVaccineController(ApplyVaccineUseCase applyVaccineUseCase) {
        this.applyVaccineUseCase = applyVaccineUseCase;
    }

    public void execute(String userCPF,
                        String healthUnitCNPJ,
                        String name,
                        int dose,
                        String lot ) {

        Vaccine vaccine = new Vaccine(null, name, dose, lot);
        this.applyVaccineUseCase.handle(userCPF, healthUnitCNPJ, vaccine);
    }
}

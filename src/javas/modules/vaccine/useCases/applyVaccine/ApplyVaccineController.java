package javas.modules.vaccine.useCases.applyVaccine;

import javas.modules.vaccine.models.Vaccine;

public class ApplyVaccineController {
    private ApplyVaccineUseCase applyVaccineUseCase;

    public ApplyVaccineController(ApplyVaccineUseCase applyVaccineUseCase) {
        this.applyVaccineUseCase = applyVaccineUseCase;
    }

    public void execute(String userCPF,
                        String healthUnitCNPJ,
                        String name,
                        String date,
                        int dose,
                        String lot ) {
        try {
            Vaccine vaccine = new Vaccine(null, name, date, dose, lot);
            this.applyVaccineUseCase.handle(userCPF, healthUnitCNPJ, vaccine);
        }catch (Error error) {
            throw new Error(error);
        }
    }
}

package javas.modules.vaccine.useCases.applyVaccine;

import javas.modules.vaccine.enums.VaccineName;
import javas.modules.vaccine.models.Vaccine;
import javas.validations.Validation;

public class ApplyVaccineController {
    private final ApplyVaccineUseCase applyVaccineUseCase;

    public ApplyVaccineController(ApplyVaccineUseCase applyVaccineUseCase) {
        this.applyVaccineUseCase = applyVaccineUseCase;
    }

    public Vaccine execute(String userCPF,
                        String healthUnitCNPJ,
                        String name,
                        int dose,
                        String lot,
                        String applicationDate) throws IllegalAccessException {

        Vaccine vaccine = new Vaccine(null, VaccineName.valueOf(name), dose, lot, applicationDate);
        new Validation(vaccine).validate();
        this.applyVaccineUseCase.handle(userCPF, healthUnitCNPJ, vaccine);
        return vaccine;
    }
}

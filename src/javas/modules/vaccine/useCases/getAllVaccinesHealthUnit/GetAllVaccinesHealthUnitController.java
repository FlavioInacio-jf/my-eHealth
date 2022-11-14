package javas.modules.vaccine.useCases.getAllVaccinesHealthUnit;

import javas.modules.vaccine.models.Vaccine;

import java.util.ArrayList;

public class GetAllVaccinesHealthUnitController {
    GetAllVaccinesHealthUnitUseCase getAllVaccinesHealthUnitUseCase;

    public GetAllVaccinesHealthUnitController(GetAllVaccinesHealthUnitUseCase getAllVaccinesHealthUnitUseCase) {
        this.getAllVaccinesHealthUnitUseCase = getAllVaccinesHealthUnitUseCase;
    }

    public ArrayList<Vaccine> execute(String healthUnitCNPJ) {
        return this.getAllVaccinesHealthUnitUseCase.handle(healthUnitCNPJ);
    }
}

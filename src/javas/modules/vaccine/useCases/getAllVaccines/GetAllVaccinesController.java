package javas.modules.vaccine.useCases.getAllVaccines;

import javas.modules.vaccine.models.Vaccine;

import java.util.ArrayList;

public class GetAllVaccinesController {
    GetAllVaccinesUseCase getAllVaccinesUseCase;

    public GetAllVaccinesController(GetAllVaccinesUseCase getAllVaccinesUseCase) {
        this.getAllVaccinesUseCase = getAllVaccinesUseCase;
    }

    public ArrayList<Vaccine> execute(String querySQL) {
        return this.getAllVaccinesUseCase.handle(querySQL);
    }
}

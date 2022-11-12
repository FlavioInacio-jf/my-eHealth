package javas.modules.vaccine.useCases.getAllPersonVaccines;

import javas.modules.person.models.Person;

public class GetAllPersonVaccinesController {
    GetAllPersonVaccinesUseCase getAllPersonVaccinesUseCase;

    public GetAllPersonVaccinesController(GetAllPersonVaccinesUseCase getAllPersonVaccinesUseCase) {
        this.getAllPersonVaccinesUseCase = getAllPersonVaccinesUseCase;
    }

    public Person execute(String userCPF) {
        return this.getAllPersonVaccinesUseCase.handle(userCPF);
    }
}

package javas.modules.vaccine.useCases.getAllPersonVaccines;

import javas.modules.person.models.Person;

public class GetAllPersonVaccinesController {
    GetAllPersonVaccinesUseCase getAllPersonVaccinesUseCase;

    public GetAllPersonVaccinesController(GetAllPersonVaccinesUseCase getAllPersonVaccinesUseCase) {
        this.getAllPersonVaccinesUseCase = getAllPersonVaccinesUseCase;
    }

    public Person execute(String userCPF) {
        try {
            return this.getAllPersonVaccinesUseCase.handle(userCPF);
        }catch (Error error) {
            throw new Error(error);
        }
    }
}

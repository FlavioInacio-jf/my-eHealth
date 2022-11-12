package javas.modules.person.useCases.getSinglePerson;

import javas.modules.person.models.Person;

public class GetSinglePersonController {
    private GetSinglePersonUseCase getSinglePersonUseCase;
    public GetSinglePersonController(GetSinglePersonUseCase getSinglePersonUseCase) {
        this.getSinglePersonUseCase = getSinglePersonUseCase;
    }
    public Person execute(String cpf) {
        return this.getSinglePersonUseCase.handle(cpf);
    }
}

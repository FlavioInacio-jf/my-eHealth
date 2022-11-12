package javas.modules.person.useCases.getSinglePerson;

import javas.errors.CustomError;
import javas.exceptions.PersonErrorMessages;
import javas.modules.person.models.Person;
import javas.modules.person.repositories.IPersonRepository;

public class GetSinglePersonUseCase {
    private IPersonRepository personRepository;
    public GetSinglePersonUseCase(IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person handle(String cpf) {
        Person person = this.personRepository.findByCPF(cpf);

        if (person == null) {
            throw new CustomError(PersonErrorMessages.PERSON_NOT_FOUND_TITLE + "\n", PersonErrorMessages.PERSON_NOT_FOUND_DETAIL);
        }
        return person;
    }
}

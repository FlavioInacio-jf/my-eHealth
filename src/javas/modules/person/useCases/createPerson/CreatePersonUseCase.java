package javas.modules.person.useCases.createPerson;

import javas.errors.CustomError;
import javas.exceptions.PersonErrorMessages;
import javas.modules.person.models.Person;
import javas.modules.person.repositories.IPersonRepository;

public class CreatePersonUseCase {
    private IPersonRepository personRepository;

    public CreatePersonUseCase (IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void handle(Person person) {

        Person personAlreadyExists = this.personRepository.findByCPF(person.getCPF());

        if (personAlreadyExists != null) {
            throw new CustomError(PersonErrorMessages.PERSON_ALREADY_EXIST_TITLE,
                                  PersonErrorMessages.PERSON_ALREADY_EXIST_DETAIL);
        }

        this.personRepository.create(person);
    }
}

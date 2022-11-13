package javas.modules.person.useCases.deletePerson;

import javas.errors.CustomError;
import javas.exceptions.PersonErrorMessages;
import javas.modules.person.models.Person;
import javas.modules.person.repositories.IPersonRepository;

public class DeletePersonUseCase {
    private IPersonRepository personRepository;
    public DeletePersonUseCase(IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public void handle(String cpf) {
        Person personExists = this.personRepository.findByCPF(cpf);

        if (personExists == null) {
            throw new CustomError(PersonErrorMessages.PERSON_NOT_FOUND_TITLE, PersonErrorMessages.PERSON_NOT_FOUND_DETAIL);
        }

       this.personRepository.delete(personExists.getId());
    }
}

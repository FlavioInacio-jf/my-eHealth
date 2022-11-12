package javas.modules.person.useCases.updatePerson;

import javas.errors.CustomError;
import javas.exceptions.PersonErrorMessages;
import javas.modules.person.models.Person;
import javas.modules.person.repositories.IPersonRepository;

public class UpdatePersonUseCase {
    private IPersonRepository personRepository;

    public UpdatePersonUseCase(IPersonRepository personRepository) {
       this.personRepository = personRepository;
    }

    public Person handle(String cpf, Person person) {
        Person personExists = this.personRepository.findByCPF(cpf);

        if (personExists == null) {
            throw new CustomError(PersonErrorMessages.PERSON_NOT_FOUND_TITLE + "\n", PersonErrorMessages.PERSON_NOT_FOUND_DETAIL);
        }

        personExists.setFirstName(person.getFirstName());
        personExists.setLastName(person.getLastName());
        personExists.setBloodType(person.getBloodType());
        personExists.setBirthDate(person.getBirthDate());
        personExists.setSex(person.getSex());
        personExists.setAddress(person.getAddress());

        this.personRepository.update(personExists);
        return personExists;
    }
}

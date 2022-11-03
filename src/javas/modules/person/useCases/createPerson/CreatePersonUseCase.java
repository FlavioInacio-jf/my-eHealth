package javas.modules.person.useCases.createPerson;

import javas.modules.person.models.Person;
import javas.modules.person.repositories.IPersonRepository;

public class CreatePersonUseCase {
    private IPersonRepository personRepository;

    public CreatePersonUseCase (IPersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person handle(Person person) {
        Person personAlreadyExists = this.personRepository.findByCPF(person.getCPF());

        if (personAlreadyExists != null) {
            throw new Error("Person already exists");
        }

        return this.personRepository.create(person);
    }
}

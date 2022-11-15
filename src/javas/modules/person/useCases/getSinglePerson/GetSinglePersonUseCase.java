package javas.modules.person.useCases.getSinglePerson;

import javas.constants.VaccineEntityConstants;
import javas.errors.CustomError;
import javas.exceptions.PersonErrorMessages;
import javas.modules.person.models.Person;
import javas.modules.person.repositories.IPersonRepository;
import javas.modules.vaccine.repositories.IVaccineRepository;

public class GetSinglePersonUseCase {
    private IPersonRepository personRepository;
    private IVaccineRepository vaccineRepository;
    public GetSinglePersonUseCase(IPersonRepository personRepository, IVaccineRepository vaccineRepository) {
        this.personRepository = personRepository;
        this.vaccineRepository = vaccineRepository;
    }

    public Person handle(String cpf) {
        Person person = this.personRepository.findByCPF(cpf);

        if (person == null) {
            throw new CustomError(PersonErrorMessages.PERSON_NOT_FOUND_TITLE, PersonErrorMessages.PERSON_NOT_FOUND_DETAIL);
        }
        person.applyVaccines(this.vaccineRepository.findAll(String.format("%s='%s'", VaccineEntityConstants.PERSON_COLUMN_NAME_FK, person.getId())));
        return person;
    }
}

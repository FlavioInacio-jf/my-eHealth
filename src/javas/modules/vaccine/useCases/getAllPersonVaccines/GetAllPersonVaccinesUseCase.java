package javas.modules.vaccine.useCases.getAllPersonVaccines;

import javas.errors.CustomError;
import javas.exceptions.PersonErrorMessages;
import javas.modules.person.models.Person;
import javas.modules.person.repositories.IPersonRepository;
import javas.modules.vaccine.models.Vaccine;
import javas.modules.vaccine.repositories.IVaccineRepository;

import java.util.ArrayList;
import java.util.Iterator;

public class GetAllPersonVaccinesUseCase {
    private IVaccineRepository vaccineRepository;
    private IPersonRepository personRepository;

    public GetAllPersonVaccinesUseCase(IVaccineRepository vaccineRepository,
                                       IPersonRepository personRepository) {
        this.vaccineRepository = vaccineRepository;
        this.personRepository = personRepository;
    }

    public Person handle(String userCPF) {
        Person personExists = this.personRepository.findByCPF(userCPF);

        if (personExists == null) {
            throw new CustomError(PersonErrorMessages.PERSON_NOT_FOUND_TITLE, PersonErrorMessages.PERSON_NOT_FOUND_DETAIL);
        }

        ArrayList<Vaccine> vaccines = this.vaccineRepository.findByUserId(personExists.getId());
        Iterator<Vaccine> it = vaccines.iterator();

        while (it.hasNext()) {
            Vaccine vaccine = it.next();
            personExists.applyVaccine(vaccine);
        }
        return personExists;
    }
}

package javas.modules.person.useCases.getAllPeople;

import javas.constants.VaccineEntityConstants;
import javas.modules.person.models.Person;
import javas.modules.person.repositories.IPersonRepository;
import javas.modules.vaccine.repositories.IVaccineRepository;

import java.util.ArrayList;
import java.util.Iterator;

public class GetAllPeopleUseCase {
    private final IPersonRepository personRepository;
    private final IVaccineRepository vaccineRepository;
    public GetAllPeopleUseCase(IPersonRepository personRepository, IVaccineRepository vaccineRepository) {
        this.personRepository = personRepository;
        this.vaccineRepository = vaccineRepository;
    }

    public ArrayList<Person> handle() {
        ArrayList<Person> people = this.personRepository.getAll();
        Iterator<Person> it = people.iterator();
        while (it.hasNext()) {
            Person person = it.next();
            person.applyVaccines(this.vaccineRepository.findAll(String.format("%s='%s'", VaccineEntityConstants.PERSON_COLUMN_NAME_FK, person.getId())));
        }
        return people;
    }

    public ArrayList<Person> handle(String querySQL) {
        ArrayList<Person> people = this.personRepository.getAll(querySQL);
        Iterator<Person> it = people.iterator();
        while (it.hasNext()) {
            Person person = it.next();
            person.applyVaccines(this.vaccineRepository.findAll(String.format("%s='%s'", VaccineEntityConstants.PERSON_COLUMN_NAME_FK, person.getId())));
        }
        return people;
    }
}

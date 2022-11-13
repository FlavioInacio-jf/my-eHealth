package javas.modules.person.useCases.getAllPeople;

import javas.modules.person.models.Person;
import javas.modules.person.repositories.IPersonRepository;
import javas.modules.vaccine.repositories.IVaccineRepository;

import java.util.ArrayList;
import java.util.Iterator;

public class GetAllPeopleUseCase {
    private IPersonRepository personRepository;
    private IVaccineRepository vaccineRepository;
    public GetAllPeopleUseCase(IPersonRepository personRepository, IVaccineRepository vaccineRepository) {
        this.personRepository = personRepository;
        this.vaccineRepository = vaccineRepository;
    }

    public ArrayList<Person> handle() {
        ArrayList<Person> people = this.personRepository.getAll();
        Iterator<Person> it = people.iterator();
        while (it.hasNext()) {
            Person person = it.next();
            person.applyVaccines(this.vaccineRepository.findByUserId(person.getId()));
        }
        return people;
    }
}

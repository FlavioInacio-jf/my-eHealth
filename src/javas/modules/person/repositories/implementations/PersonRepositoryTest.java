package javas.modules.person.repositories.implementations;

//modelo

import javas.modules.person.enums.BloodTypeEnum;
import javas.modules.person.models.Person;
import javas.modules.person.repositories.IPersonRepository;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PersonRepositoryTest {

    public IPersonRepository repository;

    public PersonRepositoryTest(){
        this.repository = new PersonRepository();
    }

    @Test
    public void testCreate() {
        Person person = new Person(null, "Inácio", "Santos", null, null, null, null, null);
        this.repository.create(person);
        assertTrue(person.equals(this.repository.findById(person.getId())));
        this.repository.delete(person.getId());
    }

    @Test
    public void testUpdate() {
        Person person = new Person(null, "Inácio", "Santos", null, null, null, null, null);
        this.repository.create(person);
        person.setFirstName("Arthur");
        person.setFirstName("Correia");

        this.repository.update(person);
        assertTrue(person.equals(this.repository.findById(person.getId())));
        this.repository.delete(person.getId());
    }

    @Test
    public void testDelete() {
        Person person = new Person(null, "Inácio", "Santos", null, null, null, null, null);
        this.repository.create(person);
        assertTrue(person.equals(this.repository.findById(person.getId())));
        assertTrue(this.repository.delete(person.getId()));
        assertEquals(null, this.repository.findById(person.getId()));
    }

    @Test
    public void testFindById() {
        Person person = new Person(null, "Inácio", "Santos", null, null, null, null, null);
        this.repository.create(person);
        assertTrue(person.equals(this.repository.findById(person.getId())));
        this.repository.delete(person.getId());
    }

    @Test
    public void testFindByCPF() {
        Person person = new Person(null, "Inácio", "Santos", null, null, null, null, null);
        this.repository.create(person);
        assertTrue(person.equals(this.repository.findByCPF(person.getCPF())));
        this.repository.delete(person.getId());
    }

    @Test
    public void testFindAll() {
        Person person1 = new Person(null, "Inácio", "Santos", null, null, null, null, null);
        Person person2 = new Person(null, "Arthur", "Correia", null, null, null, null, null);
        Person person3 = new Person(null, "Saymon", "Anderson", null, null, null, null, null);
        Person person4 = new Person(null, "Carlos", "Estombelo", null, null, null, null, null);

        this.repository.create(person1);
        this.repository.create(person2);
        this.repository.create(person3);
        this.repository.create(person4);

        ArrayList<Person> listPeople;
        listPeople = this.repository.getAll();
        assertTrue(listPeople.size() == 4);
    }

}
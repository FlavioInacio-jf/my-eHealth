package javas.modules.person.repositories.implementations;

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
        Person person = new Person(null, "Inácio", "Santos");
        this.repository.create(person);
        assertTrue(person.equals(this.repository.findById(person.getId())));
        this.repository.delete(person.getId());
    }

    @Test
    public void testUpdate() {
        Person person = new Person(null, "Inácio", "Santos");
        this.repository.create(person);
        person.setFirstName("Arthur");
        person.setFirstName("Correia");

        this.repository.update(person);
        assertTrue(person.equals(this.repository.findById(_id)));
        this.repository.delete(_id);
    }

    @Test
    public void testDelete() {
        Person person = new Person(null, "Inácio",
                "Santos", "000.000.000-00", BloodTypeEnum.A_LESS, "11/09/2001");
        this.repository.create(person);
        assertTrue(person.equals(this.repository.findById(_id)));
        assertTrue(this.repository.delete(_id));
        assertEquals(null, this.repository.findById(_id));
    }

    @Test
    public void testFindById() {
        Person person = new Person(null, "Inácio",
                "Santos", "000.000.000-00", BloodTypeEnum.A_LESS, "11/09/2001");
        this.repository.create(person);
        assertTrue(person.equals(this.repository.findById(person.getId())));
        this.repository.delete(person.getId());
    }

    @Test
    public void testFindByCPF() {
        Person person = new Person(null, "Inácio",
                "Santos", cpf, BloodTypeEnum.A_LESS, "11/09/2001");
        this.repository.create(person);
        assertTrue(person.equals(this.repository.findByCPF(cpf)));
        this.repository.delete(person.getId());
    }

    @Test
    public void testFindAll() {
        Person p1, p2, p3, p4;
        ArrayList<Person> listPeople;

        p1 = new Person(null, "Inácio", "Santos");
        p2 = new Person(null, "Arthur", "Correia");
        p3 = new Person(null, "Saymon", "Anderson");
        p4 = new Person(null, "Zeca", "Pagodinho");

        listPeople = this.repository.getAll();
        assertTrue(listPeople.size() >= 4);
    }

}
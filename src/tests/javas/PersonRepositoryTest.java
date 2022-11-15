package tests.javas;

import javas.modules.app.models.Address;
import javas.modules.person.enums.BloodTypeEnum;
import javas.modules.person.enums.SexEnum;
import javas.modules.person.models.Person;
import javas.modules.person.repositories.IPersonRepository;
import javas.modules.person.repositories.implementations.PersonRepository;
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
        Address address = new Address("R. de Aracajú", "Desembargador", "Aracaju", "SE", "44544-000");
        Person person = new Person(null, "Inácio", "Santos", "555.555.556-05",
                BloodTypeEnum.A_LESS, SexEnum.FEMALE, "03/04/1950", address);
        this.repository.create(person);
        assertTrue(person.equals(this.repository.findById(person.getId())));

        this.repository.delete(person.getId());

    }

    @Test
    public void testUpdate() {
        Address address = new Address("R. de Aracajú", "Desembargador", "Aracaju", "SE", "44544-000");
        Person person = new Person(null, "Inácio", "Santos", "000.000.000-000", BloodTypeEnum.A_LESS, SexEnum.FEMALE, "11/11/2001", address);
        this.repository.create(person);
        person.setFirstName("Arthur");
        person.setFirstName("Correia");

        this.repository.update(person);
        assertTrue(person.equals(this.repository.findById(person.getId())));
        this.repository.delete(person.getId());
    }

    @Test
    public void testDelete() {
        Address address = new Address("R. de Aracajú", "Desembargador", "Aracaju", "SE", "44544-000");
        Person person = new Person(null, "Inácio", "Santos", "111.1111.111-85", BloodTypeEnum.A_LESS, SexEnum.FEMALE, "11/11/2001", address);
        this.repository.create(person);
        assertTrue(person.equals(this.repository.findById(person.getId())));
        this.repository.delete(person.getId());
        assertEquals(null, this.repository.findById(person.getId()));
    }

    @Test
    public void testFindById() {
        Address address = new Address("R. de Aracajú", "Desembargador", "Aracaju", "SE", "44544-000");
        Person person = new Person(null, "Inácio", "Santos", "555.555.586-05",
                BloodTypeEnum.A_LESS, SexEnum.FEMALE, "03/04/1950", address);
        this.repository.create(person);
        assertTrue(person.equals(this.repository.findById(person.getId())));
        this.repository.delete(person.getId());
    }

    @Test
    public void testFindByCPF() {
        Address address = new Address("R. de Aracajú", "Desembargador", "Aracaju", "SE", "44544-000");
        Person person = new Person(null, "Inácio", "Santos", "111.1111.111-85", BloodTypeEnum.A_LESS, SexEnum.FEMALE, "11/11/2001", address);
        this.repository.create(person);
        assertTrue(person.equals(this.repository.findByCPF(person.getCPF())));
        this.repository.delete(person.getId());
    }

    @Test
    public void testFindAll() {
        Address address1 = new Address("R. de Aracajú", "Desembargador", "Aracaju", "SE", "44544-000");
        Person person1 = new Person(null, "Inácio", "Santos", "111.1111.111-85", BloodTypeEnum.A_LESS, SexEnum.FEMALE, "11/11/2001", address1);

        Address address2 = new Address("R. de Aracajú", "Desembargador", "Aracaju", "SE", "44544-000");
        Person person2 = new Person(null, "Jose", "Inácio", "555.444.211-75", BloodTypeEnum.A_LESS, SexEnum.FEMALE, "11/11/2001", address2);

        this.repository.create(person1);
        this.repository.create(person2);

        ArrayList<Person> listPeople;
        listPeople = this.repository.getAll();
        assertTrue(listPeople.size() > 1);

        this.repository.delete(person1.getId());
        this.repository.delete(person2.getId());
    }

}
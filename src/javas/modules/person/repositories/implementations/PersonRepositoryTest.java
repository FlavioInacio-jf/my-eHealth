package javas.modules.person.repositories.implementations;

import javas.modules.person.enums.BloodType;
import javas.modules.person.models.Person;
import javas.modules.person.repositories.IPersonRepository;
import org.junit.Test;

import java.util.Date;
import java.util.UUID;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PersonRepositoryTest {


    public IPersonRepository repository;

    public PersonRepositoryTest(){
        this.repository = new PersonRepository();
    }

    @Test
    public void testCreate() {

    }

    @Test
    public void testUpdate() {}

    @Test
    public void testDelete() {
        String _id = UUID.randomUUID().toString();
        Person person = new Person(_id, "Inácio",
                "Santos", "000.000.000-00", BloodType.A_LESS, "11/09/2001");
        this.repository.create(person);
        assertTrue(person.equals(this.repository.findById(_id)));
        assertTrue(this.repository.delete(_id));
        assertEquals(null, this.repository.findById(_id));
    }

    @Test
    public void testFindById() {}

    @Test
    public void testFindByCPF() {}

    @Test
    public void testFindAll() {}
}

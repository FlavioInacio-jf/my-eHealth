package javas.modules.person.repositories.implementations;

import javas.modules.person.enums.BloodTypeEnum;
import javas.modules.person.models.Person;
import javas.modules.person.repositories.IPersonRepository;
import org.junit.Test;

import java.util.UUID;

import java.util.Random;
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
        String _CPF = genCPF();
        String _id = UUID.randomUUID().toString();
        Person person = new Person(_id, "Inácio",
                "Santos", _CPF, genBloodType(), genBirthDate());
        this.repository.create(person);
        assertTrue(person.equals(this.repository.findById(_id)));
        assertTrue(person.equals(this.repository.findByCPF(_CPF)));
        this.repository.delete(_id);
    }

    @Test
    public void testUpdate() {
        String oldCPF, oldBT, oldBD, newCPF, newBT, newBD;

        oldCPF = genCPF();
        oldBT = genBloodType();
        oldBD = genBirthDate();

        newCPF = genCPF();
        newBT = genBloodType();
        newBD = genBirthDate();

        String _id = UUID.randomUUID().toString();
        Person person = new Person(_id, "Inácio",
                "Santos", oldCPF, oldBT, oldBD);
        this.repository.create(person);

        Person updatedPerson = new Person(_id, "Arthur", "Correia", newCPF, newBT, newBD);
        this.repository.update(person);
        assertTrue(person.equals(this.repository.findById(_id)));
        this.repository.delete(_id);
    }

    @Test
    public void testDelete() {
        String _id = UUID.randomUUID().toString();
        Person person = new Person(_id, "Inácio",
                "Santos", "000.000.000-00", BloodTypeEnum.A_LESS, "11/09/2001");
        this.repository.create(person);
        assertTrue(person.equals(this.repository.findById(_id)));
        assertTrue(this.repository.delete(_id));
        assertEquals(null, this.repository.findById(_id));
    }

    @Test
    public void testFindById() {
        String _id = UUID.randomUUID().toString();
        Person person = new Person(_id, "Inácio",
                "Santos", "000.000.000-00", BloodTypeEnum.A_LESS, "11/09/2001");
        this.repository.create(person);
        assertTrue(person.equals(this.repository.findById(_id)));
        this.repository.delete(_id);
    }

    @Test
    public void testFindByCPF() {
        String cpf = genCPF();

        String _id = UUID.randomUUID().toString();
        Person person = new Person(_id, "Inácio",
                "Santos", cpf, BloodTypeEnum.A_LESS, "11/09/2001");
        this.repository.create(person);
        assertTrue(person.equals(this.repository.findByCPF(cpf)));
        this.repository.delete(_id);
    }

    @Test
    public void testFindAll() {
        Person p1, p2, p3, p4;
        ArrayList<Person> listPeople;

        p1 = new Person(_id, "Inácio",
                "Santos", genCPF(), genBloodType(), genBirthDate());
        p2 = new Person(_id, "Arthur",
                "Correia", genCPF(), genBloodType(), genBirthDate());
        p3 = new Person(_id, "Saymon",
                "Anderson", genCPF(), genBloodType(), genBirthDate());
        p4 = new Person(_id, "Zeca",
                "Pagodinho", genCPF(), genBloodType(), genBirthDate());

        listPeople = this.repository.findAll();
        assertTrue(listPeople.length().equals(4));
    }

    public String genCPF(){
        Random gen = new Random();

        String cpf, cpf_A, cpf_B, cpf_C, cpf_D;

        cpf_A = String.format("%03d", gen.nextInt(1000));
        cpf_B = String.format("%03d", gen.nextInt(1000));
        cpf_C = String.format("%03d", gen.nextInt(1000));
        cpf_D = String.format("%02d", gen.nextInt(100));

        cpf = cpf_A + '.' + cpf_B + '.' + cpf_C + '-' + cpf_D;

        return cpf;
    }

}
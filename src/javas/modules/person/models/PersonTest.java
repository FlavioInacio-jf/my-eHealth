package javas.modules.person.models;

import javas.modules.person.enums.BloodType;

import static org.junit.Assert.assertEquals;
import org.junit.Test;


import java.util.Date;
import java.util.UUID;

public class PersonTest {
    public PersonTest() {}

    @Test
    public void testGetId(){
        String _id = UUID.randomUUID().toString();
        Person person = new Person(_id, "Inácio",
                        "Santos", "000.000.000-00", BloodType.A_LESS, new Date());
        assertEquals(_id, person.getId());
    }

    @Test
    public void testGetFirstName() {
        String _id = UUID.randomUUID().toString();
        Person person = new Person(_id, "Jose",
                "Santos", "111.111.111-11", BloodType.A_PLUS, new Date());
        assertEquals("Jose", person.getFirstName());

    }

    @Test
    public void testGetLastName() {
        String _id = UUID.randomUUID().toString();
        Person person = new Person(_id, "João",
                "Oliveira", "222.222.222-22", BloodType.A, new Date());
        assertEquals("Oliveira", person.getLastName());
    }

    @Test
    public void testGetCPF() {
        String _id = UUID.randomUUID().toString();
        Person person = new Person(_id, "Marcelo",
                "Carvalho", "222.222.222-22", BloodType.A, new Date());
        assertEquals("222.222.222-22", person.getCPF());
    }

    @Test
    public void testBloodType() {
        String _id = UUID.randomUUID().toString();
        Person person = new Person(_id, "Felipe",
                "Picon", "555.555.555-55", BloodType.A, new Date());
        assertEquals(BloodType.A, person.bloodType());
    }

    @Test
    public void testGetBirthDate() {
        String _id = UUID.randomUUID().toString();
        final Date birthDate = new Date();
        Person person = new Person(_id, "Bianca",
                "Andrade", "888.888.888-88", BloodType.A, birthDate);
        assertEquals(birthDate, person.getBirthDate());
    }

    @Test
    public void testGetFullName() {
        String _id = UUID.randomUUID().toString();
        final Date birthDate = new Date();
        Person person = new Person(_id, "Ana",
                "Feitosa", "888.888.888-88", BloodType.A, birthDate);
        assertEquals("Ana Feitosa", person.getFullName());
    }

    @Test
    public void testGetQueryTable() {
        assertEquals("CREATE TABLE people" +
                "( _id TEXT NOT NULL PRIMARY KEY," +
                "firstName TEXT NOT NULL," +
                "lastName TEXT NOT NULL," +
                "cpf TEXT NOT NULL," +
                "bloodType Text," +
                "birthDate DATE )", Person.getQueryTable());
    }
}

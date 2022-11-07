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
                        "Santos", "000.000.000-00", BloodType.A_LESS, "11/09/2001");
        assertEquals(_id, person.getId());
    }

    @Test
    public void testSetId() {
        String _id = UUID.randomUUID().toString();
        Person person = new Person(_id, "Inácio",
                "Santos", "000.000.000-00", BloodType.A_LESS, "11/09/2001");
        String newId = UUID.randomUUID().toString();
        person.setId(newId);
        assertEquals(newId, person.getId());
    }

    @Test
    public void testGetFirstName() {
        String _id = UUID.randomUUID().toString();
        Person person = new Person(_id, "Jose",
                "Santos", "111.111.111-11", BloodType.A_PLUS, "11/09/2001");
        assertEquals("Jose", person.getFirstName());

    }

    @Test
    public void testSetFirstName() {
        String _id = UUID.randomUUID().toString();
        Person person = new Person(_id, "Inácio",
                "Santos", "000.000.000-00", BloodType.A_LESS, "11/09/2001");
        person.setFirstName("João");
        assertEquals("João", person.getFirstName());
    }

    @Test
    public void testGetLastName() {
        String _id = UUID.randomUUID().toString();
        Person person = new Person(_id, "João",
                "Oliveira", "222.222.222-22", BloodType.A, "11/09/2001");
        assertEquals("Oliveira", person.getLastName());
    }

    @Test
    public void testSetLastName() {
        String _id = UUID.randomUUID().toString();
        Person person = new Person(_id, "Inácio",
                "Santos", "000.000.000-00", BloodType.A_LESS, "11/09/2001");
        person.setLastName("Silva");
        assertEquals("Silva", person.getLastName());
    }

    @Test
    public void testGetCPF() {
        String _id = UUID.randomUUID().toString();
        Person person = new Person(_id, "Marcelo",
                "Carvalho", "222.222.222-22", BloodType.A,"11/09/2001");
        assertEquals("222.222.222-22", person.getCPF());
    }

    @Test
    public void testSetCPF() {
        String _id = UUID.randomUUID().toString();
        Person person = new Person(_id, "Marcelo",
                "Carvalho", "222.222.222-22", BloodType.A,"11/09/2001");
        person.setCPF("111.111.111-11");
        assertEquals("111.111.111-11", person.getCPF());
    }

    @Test
    public void testBloodType() {
        String _id = UUID.randomUUID().toString();
        Person person = new Person(_id, "Felipe",
                "Picon", "555.555.555-55", BloodType.A, "11/09/2001");
        assertEquals(BloodType.A, person.getBloodType());
    }

    @Test
    public void setBloodType() {
        String _id = UUID.randomUUID().toString();
        Person person = new Person(_id, "Felipe",
                "Picon", "555.555.555-55", BloodType.A, "11/09/2001");
        person.setBloodType(BloodType.A_PLUS);
        assertEquals(BloodType.A_PLUS, person.getBloodType());
    }

    @Test
    public void testGetBirthDate() {
        String _id = UUID.randomUUID().toString();
        Person person = new Person(_id, "Bianca",
                "Andrade", "888.888.888-88", BloodType.A, "11/09/2001");
        assertEquals("11/09/2001", person.getBirthDate());
    }

    @Test
    public void setGetBirthDate() {
        String _id = UUID.randomUUID().toString();
        Person person = new Person(_id, "Bianca",
                "Andrade", "888.888.888-88", BloodType.A, "11/09/2001");
        person.setBirthDate("01/01/1997");
        assertEquals("01/01/1997", person.getBirthDate());
    }

    @Test
    public void testGetFullName() {
        String _id = UUID.randomUUID().toString();
        Person person = new Person(_id, "Ana",
                "Feitosa", "888.888.888-88", BloodType.A, "11/09/2001");
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

package javas.modules.person.models;

import javas.modules.person.enums.BloodTypeEnum;

import static org.junit.Assert.assertEquals;

import javas.modules.person.enums.SexEnum;
import org.junit.Test;

public class PersonTest {
    public PersonTest() {}

    @Test
    public void testGetFirstName() {
        Person person = new Person(null, "Jose",
                "Santos", "111.111.111-11", BloodTypeEnum.A_PLUS, SexEnum.MALE, "11/09/2001", null);
        assertEquals("Jose", person.getFirstName());

    }

    @Test
    public void testSetFirstName() {
        Person person = new Person(null, "Inácio",
                "Santos", "000.000.000-00", BloodTypeEnum.A_LESS, SexEnum.MALE, "11/09/2001", null);
        person.setFirstName("João");
        assertEquals("João", person.getFirstName());
    }

    @Test
    public void testGetLastName() {
        Person person = new Person(null, "João",
                "Oliveira", "222.222.222-22", BloodTypeEnum.A, SexEnum.MALE, "11/09/2001", null);
        assertEquals("Oliveira", person.getLastName());
    }

    @Test
    public void testSetLastName() {
        Person person = new Person(null, "Inácio",
                "Santos", "000.000.000-00", BloodTypeEnum.A_LESS, SexEnum.MALE, "11/09/2001", null);
        person.setLastName("Silva");
        assertEquals("Silva", person.getLastName());
    }

    @Test
    public void testGetCPF() {
        Person person = new Person(null, "Marcelo",
                "Carvalho", "222.222.222-22", BloodTypeEnum.A, SexEnum.MALE, "11/09/2001", null);
        assertEquals("222.222.222-22", person.getCPF());
    }

    @Test
    public void testSetCPF() {
        Person person = new Person(null, "Marcelo",
                "Carvalho", "222.222.222-22", BloodTypeEnum.A, SexEnum.MALE, "11/09/2001", null);
        person.setCPF("111.111.111-11");
        assertEquals("111.111.111-11", person.getCPF());
    }

    @Test
    public void testBloodType() {
        Person person = new Person(null, "Felipe",
                "Picon", "555.555.555-55", BloodTypeEnum.A, SexEnum.MALE, "11/09/2001", null);
        assertEquals(BloodTypeEnum.A, person.getBloodType());
    }

    @Test
    public void setBloodType() {
        Person person = new Person(null, "Felipe",
                "Picon", "555.555.555-55", BloodTypeEnum.A, SexEnum.MALE, "11/09/2001", null);
        person.setBloodType(BloodTypeEnum.A_PLUS);
        assertEquals(BloodTypeEnum.A_PLUS, person.getBloodType());
    }

    @Test
    public void testGetBirthDate() {
        Person person = new Person(null, "Bianca",
                "Andrade", "888.888.888-88", BloodTypeEnum.A, SexEnum.MALE, "17/12/2005", null);
        assertEquals("17/12/2005", person.getBirthDate());
    }

    @Test
    public void setGetBirthDate() {
        Person person = new Person(null, "Bianca",
                "Andrade", "888.888.888-88", BloodTypeEnum.A, "11/09/2001");
        person.setBirthDate("01/01/1997");
        assertEquals("01/01/1997", person.getBirthDate());
    }

    @Test
    public void testGetFullName() {
        Person person = new Person(null, "Ana",
                "Feitosa", "888.888.888-88", BloodTypeEnum.A, "11/09/2001");
        assertEquals("Ana Feitosa", person.getFullName());
    }

    @Test
    public void testApplyVaccine() {

    }

    @Test
    public void testGetVaccines() {

    }

    @Test
    public void testGetAddress() {

    }

    @Test
    public void testSetAddress() {

    }

    @Test
    public void testGetSex() {

    }

    @Test
    public void testSetSex() {
    }

    @Test
    public void equals() {
    }
}

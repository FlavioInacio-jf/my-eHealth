package javas.modules.healthUnit.models;

import javas.modules.person.enums.BloodTypeEnum;
import javas.modules.app.models.Address;
import javas.modules.healthUnit.enums.UnitTypeEnum;
import javas.modules.person.models.Person;

import java.util.ArrayList;

import javas.modules.person.enums.SexEnum;
import org.junit.Test;

import static org.junit.Assert.*;

public class HealthUnitTest {
    private final Address endereco;

    private final HealthUnit healthUnit;

    private final Person patient;

    private final ArrayList<Person> patients;

    public HealthUnitTest() {
        this.endereco = new Address("Rua flavao", "Bairro Oliveira", "Aracaju", "Sergipe", "987909123");

       this.healthUnit = new HealthUnit(null,UnitTypeEnum.HOSPITAL,
                "Hospital Inacio", "21. 987. 127/0001-24", endereco);

        this.patient = new Person("teste", "Jose",
                "Santos", "111.111.111-11", BloodTypeEnum.A_PLUS, SexEnum.MALE, "11/09/2001", null);

       this.patients = new ArrayList<>();
    }


    
        @Test
    public void testGetType() {
        assertEquals(UnitTypeEnum.HOSPITAL, healthUnit.getType());
    }

    @Test
    public void testSetType() {

        healthUnit.setType(UnitTypeEnum.UBS);
        assertEquals(UnitTypeEnum.UBS, healthUnit.getType());
    }

    @Test
    public void testGetName() {
        assertEquals("Hospital Inacio", healthUnit.getName());
    }

    @Test
    public void testSetName() {
        healthUnit.setName("Hospital Saymon");
        assertEquals("Hospital Saymon", healthUnit.getName());
    }

    @Test
    public void testGetAddress() {
        assertEquals(endereco, healthUnit.getAddress());
    }

    @Test
    public void testSetAddress() {
        Address endereco2 = new Address("Rua Saymao", "Bairro oi", "Aracaju", "Sergipe", "987909123");
        healthUnit.setAddress(endereco2);

        assertEquals(endereco2, healthUnit.getAddress());
    }

    @Test
    public void testAddPerson() {

        healthUnit.addPerson(patient);
        patients.add(patient);
        
        assertEquals(patients, healthUnit.getPeople());
    }

    @Test
    public void testRemovePerson() {
        Person paciente2 = new Person(null, "Roberto",
        "Tico", "212.212.212-22", BloodTypeEnum.AB, SexEnum.MALE, "12/12/2002", null);

        patients.add(paciente2);
        healthUnit.addPerson(patient);
        healthUnit.addPerson(paciente2);
        healthUnit.removePerson("teste");

        assertEquals(patients, healthUnit.getPeople());
    }

    @Test
    public void testGetCNPJ() {
        assertEquals("21. 987. 127/0001-24", healthUnit.getCNPJ());
    }

    @Test
    public void testSetCNPJ() {
        healthUnit.setCNPJ("21. 987. 127/0001-98");
        assertEquals("21. 987. 127/0001-98", healthUnit.getCNPJ());
    }

    @Test
    public void testEquals() {
        HealthUnit healthUnit2 = this.healthUnit;
        assertTrue(this.healthUnit.equals(healthUnit2));

        HealthUnit healthUnit3 = new HealthUnit(null,UnitTypeEnum.HOSPITAL,
                "Hospital Inacio", "21. 987. 127/0001-24", null);

        assertFalse(this.healthUnit.equals(healthUnit3));
    }

}

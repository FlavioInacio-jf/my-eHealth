package javas.modules.healthUnit.models;

import javas.modules.person.enums.BloodTypeEnum;
import javas.modules.app.models.Address;
import javas.modules.healthUnit.enums.UnitTypeEnum;
import javas.modules.person.models.Person;

import java.util.ArrayList;
import java.util.Iterator;

import javas.modules.person.enums.SexEnum;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HealthUnitTest {
    public HealthUnitTest() {}

    Address endereco = new Address("Rua flavao", "Bairro Oliveira", "Aracaju", "Sergipe", "987909123");
    
    HealthUnit unidade = new HealthUnit(null,UnitTypeEnum.HOSPITAL,
    "Hospital Inacio", "21. 987. 127/0001-24", endereco);
    
    Person paciente = new Person("teste", "Jose",
        "Santos", "111.111.111-11", BloodTypeEnum.A_PLUS, SexEnum.MALE, "11/09/2001", null);

    ArrayList<Person> pacientes = new ArrayList<>();
    
        @Test
    public void testGetType() { 
        
        assertEquals(UnitTypeEnum.HOSPITAL, unidade.getType());
    }

    @Test
    public void testSetType() {

        unidade.setType(UnitTypeEnum.UBS);
        assertEquals(UnitTypeEnum.UBS, unidade.getType());
    }

    @Test
    public void testGetName() {
        assertEquals("Hospital Inacio", unidade.getName());
    }

    @Test
    public void testSetName() {
        unidade.setName("Hospital Saymon");
        assertEquals("Hospital Saymon", unidade.getName());
    }

    @Test
    public void testGetAddress() {
        assertEquals(endereco, unidade.getAddress());
    }

    @Test
    public void testSetAddress() {
        Address endereco2 = new Address("Rua Saymao", "Bairro oi", "Aracaju", "Sergipe", "987909123");
        unidade.setAddress(endereco2);

        assertEquals(endereco2, unidade.getAddress());
    }

    @Test
    public void testAddPerson() {
        
        unidade.addPerson(paciente);
        pacientes.add(paciente);
        
        assertEquals(pacientes, unidade.getPeople());
    }

    @Test
    public void testRemovePerson() {
        Person paciente2 = new Person(null, "Roberto",
        "Tico", "212.212.212-22", BloodTypeEnum.AB, SexEnum.MALE, "12/12/2002", null);
        
        pacientes.add(paciente2);
        unidade.addPerson(paciente);
        unidade.addPerson(paciente2);
        unidade.removePerson("teste");

        assertEquals(pacientes, unidade.getPeople());
    }

    @Test
    public void testGetCNPJ() {

        assertEquals("21. 987. 127/0001-24", unidade.getCNPJ());
    }

    @Test
    public void testSetCNPJ() {
        unidade.setCNPJ("21. 987. 127/0001-98");
        assertEquals("21. 987. 127/0001-98", unidade.getCNPJ());
    }

    @Test
    public void testEquals() {

    }

}

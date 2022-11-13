package javas.modules.vaccine.models;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javas.modules.app.models.Address;
import javas.modules.healthUnit.enums.UnitTypeEnum;
import javas.modules.healthUnit.models.HealthUnit;
import org.junit.Test;

public class VaccineTest {
    public VaccineTest() {}

    @Test
    public void testGetName() {
        Vaccine vaccine = new Vaccine(null, "Hepatite C", 1, "157");
        assertEquals("Hepatite C", vaccine.getName());
    }

    @Test
    public void testSetName() {
        Vaccine vaccine = new Vaccine(null, "Hepatite C", 1, "157");
        assertEquals("Hepatite C", vaccine.getName());
        vaccine.setName("Influenza");
        assertEquals("Influenza", vaccine.getName());
    }

    @Test
    public void testGetDose() {
        Vaccine vaccine = new Vaccine(null, "Hepatite C", 1, "157");
        assertEquals(1, vaccine.getDose());
    }

    @Test
    public void testSetDose() {
        Vaccine vaccine = new Vaccine(null, "Hepatite C", 1, "157");
        assertEquals(1, vaccine.getDose());
        vaccine.setDose(4);
        assertEquals(4, vaccine.getDose());
    }

    @Test
    public void testGetLot() {
        Vaccine vaccine = new Vaccine(null, "Hepatite C", 1, "157");
        assertEquals("157", vaccine.getLot());
    }

    @Test
    public void testSetLot() {
        Vaccine vaccine = new Vaccine(null, "Hepatite C", 1, "157");
        assertEquals("157", vaccine.getLot());
        vaccine.setLot("2361");
        assertEquals("2361", vaccine.getLot());
    }

    @Test
    public void testGetHealthUnit() {
        Address address = new Address("a", "b", "c", "d", "e");
        HealthUnit hUnit = new HealthUnit(null,UnitTypeEnum.HOSPITAL, "HUSE", "1234", address);
        Vaccine vaccine = new Vaccine(null, "Hepatite C", 1, "157");
        vaccine.setHeathUnit(hUnit);
        assertEquals(hUnit, vaccine.getHeathUnit());
    }

    @Test
    public void testSetHealthUnit() {
        Address address = new Address("a", "b", "c", "d", "e");
        HealthUnit hUnit = new HealthUnit(null, UnitTypeEnum.HOSPITAL, "HUSE", "1234", address);
        Vaccine vaccine = new Vaccine(null, "Hepatite C", 1, "157");
        vaccine.setHeathUnit(hUnit);
        assertEquals(hUnit, vaccine.getHeathUnit());
    }

    @Test
    public void testEquals() {
        Address address = new Address("a", "b", "c", "d", "e");
        HealthUnit hUnit = new HealthUnit(null,UnitTypeEnum.HOSPITAL, "HUSE", "1234", address);
        Vaccine vaccine = new Vaccine(null, "Hepatite C",  1, "157");
        vaccine.setHeathUnit(hUnit);

        Address address2 = new Address("a", "b", "c", "d", "e");
        HealthUnit hUnit2 = new HealthUnit(null,UnitTypeEnum.HOSPITAL, "HUSE", "1234", address2);
        Vaccine vaccine2 = new Vaccine(null, "Hepatite C",  1, "157");
        vaccine2.setHeathUnit(hUnit2);

        Address address3 = new Address("a1", "b2", "c3", "d4", "e5");
        HealthUnit hUnit3 = new HealthUnit(null,UnitTypeEnum.UBS, "Nestor Piva", "12312512", address3);
        Vaccine vaccine3 = new Vaccine(null, "Influenza", 5, "62191");
        vaccine3.setHeathUnit(hUnit3);

        assertTrue(vaccine2.equals(vaccine));
        assertTrue(vaccine3.equals(vaccine));
    }
}

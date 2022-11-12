package javas.modules.vaccine.models;

import org.junit.Test;

public class VaccineTest {
    public VaccineTest() {}

    @Test
    public void getName() {
        Vaccine vaccine = new Vaccine(null, "Hepatite C", "14/02/2020", 1, "157");
        assertEquals("Hepatite C", vaccine.getName());
    }

    @Test
    public void setName(String Name) {
        Vaccine vaccine = new Vaccine(null, "Hepatite C", "14/02/2020", 1, "157");
        assertEquals("Hepatite C", vaccine.getName());
        vaccine.setName("Influenza");
        assertEquals("Influenza", vaccine.getName());
    }

    @Test
    public void getDate() {
        Vaccine vaccine = new Vaccine(null, "Hepatite C", "14/02/2020", 1, "157");
        assertEquals("14/02/2020", vaccine.getDate());
    }

    @Test
    public void setDate(String date) {
        Vaccine vaccine = new Vaccine(null, "Hepatite C", "14/02/2020", 1, "157");
        assertEquals("14/02/2020", vaccine.getDate());
        vaccine.setDate("01/06/2021");
        assertEquals("01/06/2021", vaccine.getDate());
    }

    @Test
    public void getDose() {
        Vaccine vaccine = new Vaccine(null, "Hepatite C", "14/02/2020", 1, "157");
        assertEquals(1, vaccine.getDose());
    }

    @Test
    public void setDose() {
        Vaccine vaccine = new Vaccine(null, "Hepatite C", "14/02/2020", 1, "157");
        assertEquals(1, vaccine.getDose());
        vaccine.setDose(4);
        assertEquals(4, vaccine.getDose());
    }

    @Test
    public void getLot() {
        Vaccine vaccine = new Vaccine(null, "Hepatite C", "14/02/2020", 1, "157");
        assertEquals("157", vaccine.getLot());
    }

    @Test
    public void setLot() {
        Vaccine vaccine = new Vaccine(null, "Hepatite C", "14/02/2020", 1, "157");
        assertEquals("157", vaccine.getLot());
        vaccine.setLot("2361");
        assertEquals("2361", vaccine.getLot());
    }

    @Test
    public void getHealthUnit() {
        Address address = new Address("a", "b", "c", "d", "e");
        HealthUnit hUnit = new HealthUnit(null,UnitTypeEnum.HOSPITAL, "HUSE", "1234", address);
        Vaccine vaccine = new Vaccine(null, "Hepatite C", "14/02/2020", 1, "157");
        vaccine.setHeathUnit(hUnit);
        assertEquals(hUnit, vaccine.getHeathUnit());
    }

    @Test
    public void setHealthUnit() {
        Address address = new Address("a", "b", "c", "d", "e");
        HealthUnit hUnit = new HealthUnit(null,UnitTypeEnum.HOSPITAL, "HUSE", "1234", address);
        Vaccine vaccine = new Vaccine(null, "Hepatite C", "14/02/2020", 1, "157");
        vaccine.setHeathUnit(hUnit);
        assertEquals(hUnit, vaccine.getHeathUnit());
    }

    @Test
    public void testEquals() {
        Address address = new Address("a", "b", "c", "d", "e");
        HealthUnit hUnit = new HealthUnit(null,UnitTypeEnum.HOSPITAL, "HUSE", "1234", address);
        Vaccine vaccine = new Vaccine(null, "Hepatite C", "14/02/2020", 1, "157");
        vaccine.setHeathUnit(hUnit);

        Address address2 = new Address("a", "b", "c", "d", "e");
        HealthUnit hUnit2 = new HealthUnit(null,UnitTypeEnum.HOSPITAL, "HUSE", "1234", address2);
        Vaccine vaccine2 = new Vaccine(null, "Hepatite C", "14/02/2020", 1, "157");
        vaccine2.setHeathUnit(hUnit2);

        Address address3 = new Address("a1", "b2", "c3", "d4", "e5");
        HealthUnit hUnit3 = new HealthUnit(null,UnitTypeEnum.UBS, "Nestor Piva", "12312512", address3);
        Vaccine vaccine3 = new Vaccine(null, "Influenza", "11/08/2013", 5, "62191");
        vaccine3.setHeathUnit(hUnit3);

        assertTrue(vaccine2, vaccine);
        assertFalse(vaccine3, vaccine);
    }
}

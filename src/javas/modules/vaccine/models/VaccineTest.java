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
    public void getHeathUnit() {

    }

    @Test
    public void setHeathUnit() {

    }

    @Test
    public void testEquals() {

    }
}

package javas.modules.healthUnit.models;

import org.junit.Test;


public class HealthUnitTest {

<<<<<<< Updated upstream:src/javas/modules/healthUnit/models/HealthUnitTest.java
    public HealthUnitTest() {}
=======
    public HeathUnitTest() {
    }
>>>>>>> Stashed changes:src/javas/modules/heathUnit/models/HeathUnitTest.java

    @Test
    public void testGetType() {
        HeathUnit unidade = new HeathUnit( HOSPITAL, "Hospital Inacio",  "(79) 998999-67868",
         "Rua Josuel dos Santos 89",  "Bairro Inacio", "Aracaju", "Sergipe", "79034-690" );
        assertEquals(HOSPITAL, unidade.getType());
    }

    @Test
    public void testSetType() {
        HeathUnit unidade = new HeathUnit( HOSPITAL, "Hospital Inacio",  "(79) 998999-67868",
         "Rua Josuel dos Santos 89",  "Bairro Inacio", "Aracaju", "Sergipe", "79034-690" );
        unidade.setType(UBS);
        assertEquals(UBS, unidade.getType());
    }

    @Test
    public void testGetName() {
        HeathUnit unidade = new HeathUnit( HOSPITAL, "Hospital Inacio",  "(79) 998999-67868",
         "Rua Josuel dos Santos 89",  "Bairro Inacio", "Aracaju", "Sergipe", "79034-690" );
         assertEquals("Hospital Inacio", unidade.getName());
    }

    @Test
    public void testSetName() {
        HeathUnit unidade = new HeathUnit( HOSPITAL, "Hospital Inacio",  "(79) 998999-67868",
         "Rua Josuel dos Santos 89",  "Bairro Inacio", "Aracaju", "Sergipe", "79034-690" );
         unidade.setName("Hospital Saymon");
         assertEquals("Hospital Saymon", unidade.getName());
    }

    @Test
    public void testGetAddress() {

    }

    @Test
    public void testSetAddress() {

    }

    @Test
    public void testAddPerson() {

    }

    @Test
    public void testRemovePerson() {

    }

    @Test
    public void testGetCNPJ() {

    }

    @Test
    public void testSetCNPJ() {

    }

    @Test
    public void testEquals() {

    }



}

package tests.javas;

import javas.modules.app.models.Address;
import org.junit.Test;

import static org.junit.Assert.*;

public class AddressTest {
    private final Address address;
    public AddressTest() {
        this.address = new Address("Abbey Road","Farolandia" , "Paris",
                "Florida", "586939291");
    }

    @Test
    public void getStreet() {
        assertEquals("Abbey Road", address.getStreet());
    }

    @Test
    public void setStreet() {
        address.setStreet("Oliveira");

        assertEquals("Oliveira", address.getStreet());
    }

    @Test
    public void getDistrict() {
        assertEquals("Farolandia", address.getDistrict());
    }

    @Test
    public void setDistrict() {
        address.setDistrict("Coroa do Meio");

        assertEquals("Coroa do Meio", address.getDistrict());
    }

    @Test
    public void getCity() {
        assertEquals("Paris", address.getCity());
    }

    @Test
    public void setCity() {
        address.setCity("BH");
        
        assertEquals("BH", address.getCity());
    }

    @Test
    public void getState() {
        assertEquals("Florida", address.getState());
    }

    @Test
    public void setState() {
        address.setState("Cidade do Mexico");

        assertEquals("Cidade do Mexico", address.getState());
    }

    @Test
    public void getPostalCode() {
        assertEquals("586939291", address.getPostalCode());
    }

    @Test
    public void setPostalCode() {
        address.setPostalCode("5869399999");

        assertEquals("5869399999", address.getPostalCode());
    }

    @Test
    public void testEquals() {
        Address address1 = new Address("Abbey Road","Farolandia" , "Paris",
     "Florida", "586939291");
        Address address2 = address1;

        assertTrue(address1.equals(address2));

        Address address3 = new Address("Road","Farolandia" , "Paris",
                "Florida", "586939291");
        assertFalse(address1.equals(address3));
    }
}

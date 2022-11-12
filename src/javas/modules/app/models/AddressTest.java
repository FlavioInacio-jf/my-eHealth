package javas.modules.app.models;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AddressTest {
    public AddressTest() {}

    Address endereco = new Address("Abbey Road","Farolandia" , "Paris", 
    "Florida", "586939291");

    @Test
    public void getStreet() {
        assertEquals("Abbey Road", endereco.getStreet());
    }

    @Test
    public void setStreet() {
        endereco.setStreet("Oliveira");

        assertEquals("Oliveira", endereco.getStreet());
    }

    @Test
    public void getDistrict() {
        assertEquals("Farolandia", endereco.getDistrict());
    }

    @Test
    public void setDistrict() {
        endereco.setDistrict("Coroa do Meio");

        assertEquals("Coroa do Meio", endereco.getDistrict());
    }

    @Test
    public void getCity() {
        assertEquals("Paris", endereco.getCity());
    }

    @Test
    public void setCity() {
        endereco.setCity("BH");
        
        assertEquals("BH", endereco.getCity());
    }

    @Test
    public void getState() {
        assertEquals("Florida", endereco.getState());
    }

    @Test
    public void setState() {
        endereco.setState("Cidade do Mexico");

        assertEquals("Cidade do Mexico", endereco.getState());
    }

    @Test
    public void getPostalCode() {
        assertEquals("586939291", endereco.getPostalCode());
    }

    @Test
    public void setPostalCode() {
        endereco.setPostalCode("5869399999");

        assertEquals("5869399999", endereco.getPostalCode());
    }

    @Test
    public void testEquals() {
        Address endereco2 = new Address("Abbey Road","Farolandia" , "Paris", 
     "Florida", "586939291");

     endereco.equals(endereco2);
    }
}

package tests.javas;

import javas.modules.app.models.Address;
import javas.modules.person.enums.BloodTypeEnum;
import javas.modules.person.enums.SexEnum;
import javas.modules.person.models.Person;


import javas.validations.*;

import org.junit.Test;

public class CreatePersonControllerTest {
    public CreatePersonControllerTest() {}

    @Test
    public void testExecute() throws IllegalAccessException {
        Address address = new Address("Rua teste", "bairro teste", "cidade teste", 
        "estado teste", "13165-000");
        
        Person person = new Person(null, "josuel", 
        "sobrenomeTeste", "999.888.777-23", 
        BloodTypeEnum.A, SexEnum.MALE, "11/09/2001", address);
        
        new Validation(person).validate();
        new Validation(address).validate();
    }
}

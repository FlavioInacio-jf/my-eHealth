package javas.modules.app.models;

import javas.modules.person.enums.BloodTypeEnum;
import javas.modules.person.models.Person;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class ModelBaseTest {
    public ModelBaseTest() {
    }

    @Test
    public void testGetId(){
        String _id = UUID.randomUUID().toString();
        Person person = new Person(_id, "Inácio",
                "Santos", "000.000.000-00", BloodTypeEnum.A_LESS, "11/09/2001");
        assertEquals(_id, person.getId());
    }

    @Test
    public void testSetId() {
        String _id = UUID.randomUUID().toString();
        Person person = new Person(null, "Inácio",
                "Santos", "000.000.000-00", BloodTypeEnum.A_LESS, "11/09/2001");
        person.setId(_id);
        assertEquals(_id, person.getId());
    }
}

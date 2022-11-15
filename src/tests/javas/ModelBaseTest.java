package tests.javas;

import javas.modules.app.models.ModelBase;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.assertEquals;

public class ModelBaseTest {
    public ModelBaseTest() {
    }

    @Test
    public void testGetId(){
        String _id = UUID.randomUUID().toString();
        ModelBase modelBase = new ModelBase(_id);
        assertEquals(_id, modelBase.getId());
    }

    @Test
    public void testSetId() {
        String _id = UUID.randomUUID().toString();
        ModelBase modelBase = new ModelBase(null);
        modelBase.setId(_id);
        assertEquals(_id, modelBase.getId());
    }
}

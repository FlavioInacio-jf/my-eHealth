package javas.modules.vaccine.repositories.impementations;

import javas.modules.vaccine.models.Vaccine;
import javas.modules.vaccine.repositories.IVaccineRepository;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VaccineRepositoryTest {

    public IVaccineRepository repository;

    public VaccineRepositoryTest() {this.repository = new VaccineRepository();}

    @Test
    public void testCreate() {
        Vaccine vaccine = new Vaccine(null, "Hepatite C", 1, "157");
        this.repository.create(null, null, vaccine);
        assertTrue(vaccine.equals(this.repository.findById(vaccine.getId())));
        this.repository.delete(vaccine.getId());
    }

    @Test
    public void testUpdate() {
        Vaccine vaccine = new Vaccine(null, "Hepatite C", 1, "157");
        this.repository.create(null, null, vaccine);

        vaccine.setDose(2);
        this.repository.update(vaccine);

        Vaccine updatedVaccine = this.repository.findById(vaccine.getId())));

        assertEquals(2, updatedVaccine.getDose());
        this.repository.delete(vaccine.getId());
    }

    @Test
    public void testDelete() {
        Vaccine vaccine = new Vaccine(null, "Hepatite C", 1, "157");
        this.repository.create(null, null, vaccine);

        assertTrue(vaccine.equals(this.repository.findById(vaccine.getId())));
        this.repository.delete(vaccine.getId());
        assertEquals(null, this.repository.findById(vaccine.getId())
    }

    @Test
    public void testFindById() {

    }

    @Test
    public void testFindByUserId() {

    }

    @Test
    public void testFindByHealthUnitId() {
    }
}

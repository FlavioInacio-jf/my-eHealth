package javas.modules.vaccine.repositories.impementations;

import javas.modules.person.models.Vaccine;
import javas.modules.person.repositories.IVaccineRepository;
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
        this.repository.crate(null, null, vaccine);

    }

    @Test
    public void testUpdate() {

    }

    @Test
    public void testDelete() {

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

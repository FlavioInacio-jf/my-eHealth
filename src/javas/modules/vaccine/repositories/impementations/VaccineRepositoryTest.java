package javas.modules.vaccine.repositories.impementations;

import javas.modules.vaccine.enums.VaccineName;
import javas.modules.vaccine.models.Vaccine;
import javas.modules.vaccine.repositories.IVaccineRepository;
import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VaccineRepositoryTest {

    public IVaccineRepository repository;

    public VaccineRepositoryTest() {this.repository = new VaccineRepository();}

    @Test
    public void testCreate() {
        Vaccine vaccine = new Vaccine(null,  VaccineName.JANSSEN, 1, "157", "02/11/2022");
        this.repository.create(null, null, vaccine);
        assertTrue(vaccine.equals(this.repository.findById(vaccine.getId())));
        this.repository.delete(vaccine.getId());
    }

    @Test
    public void testUpdate() {
        Vaccine vaccine = new Vaccine(null, VaccineName.JANSSEN, 1, "157", "02/11/2022");
        this.repository.create(null, null, vaccine);

        vaccine.setDose(2);
        this.repository.update(vaccine);

        Vaccine updatedVaccine = this.repository.findById(vaccine.getId());

        assertEquals(2, updatedVaccine.getDose());
        this.repository.delete(vaccine.getId());
    }

    @Test
    public void testDelete() {
        Vaccine vaccine = new Vaccine(null, VaccineName.JANSSEN, 1, "157", "02/11/2022");
        this.repository.create(null, null, vaccine);

        assertTrue(vaccine.equals(this.repository.findById(vaccine.getId())));
        this.repository.delete(vaccine.getId());
        assertEquals(null, this.repository.findById(vaccine.getId()));
    }

    @Test
    public void testFindById() {
        Vaccine vaccine = new Vaccine(null, VaccineName.JANSSEN, 1, "157", "02/11/2022");
        this.repository.create(null, null, vaccine);

        assertTrue(vaccine.equals(this.repository.findById(vaccine.getId())));
        this.repository.delete(vaccine.getId());
    }

    @Test
    public void testFindAll() {
        Vaccine vaccine = new Vaccine(null, VaccineName.JANSSEN, 1, "157", "02/11/2022");
        this.repository.create(null, null, vaccine);

        assertTrue(vaccine.equals(this.repository.findAll("")));
        this.repository.delete(vaccine.getId());
    }
}

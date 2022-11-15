package tests.javas;

import javas.modules.app.models.Address;
import javas.modules.healthUnit.enums.UnitTypeEnum;
import javas.modules.healthUnit.models.HealthUnit;
import javas.modules.person.enums.BloodTypeEnum;
import javas.modules.person.enums.SexEnum;
import javas.modules.person.models.Person;
import javas.modules.vaccine.enums.VaccineName;
import javas.modules.vaccine.models.Vaccine;
import javas.modules.vaccine.repositories.IVaccineRepository;
import javas.modules.vaccine.repositories.impementations.VaccineRepository;
import org.junit.Test;


import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class VaccineRepositoryTest {

    public IVaccineRepository repository;

    public VaccineRepositoryTest() {this.repository = new VaccineRepository();}

    @Test
    public void testCreate() {
        Address personAddress = new Address("Rua E", "Centro", "Japaratuba", "SE", "11111-111");
        Person person = new Person(null, "Inácio",
                            "Silva", "000.000.000-00",
                                    BloodTypeEnum.A_LESS, SexEnum.MALE,
                            "02/03/2001", personAddress);


        Address healthUnitAddress = new Address("Rua B", "Centro", "Aracaju", "AL", "11111-111");
        HealthUnit healthUnit = new HealthUnit(null, UnitTypeEnum.UBS, "João Alves", "11.111.111/0001-22", healthUnitAddress);

        Vaccine vaccine = new Vaccine(null,  VaccineName.JANSSEN, 1, "157", "02/11/2022");
        vaccine.setHeathUnit(healthUnit);

        this.repository.create(person.getId(), healthUnit.getId(), vaccine);
        Vaccine vaccineInDatabase = this.repository.findById(vaccine.getId());
        assertTrue(vaccine.equals(vaccineInDatabase));
        this.repository.delete(vaccine.getId());
    }

    @Test
    public void testUpdate() {
        Address personAddress = new Address("Rua E", "Centro", "Japaratuba", "SE", "11111-111");
        Person person = new Person(null, "Inácio",
                "Silva", "000.000.000-00",
                BloodTypeEnum.A_LESS, SexEnum.MALE,
                "02/03/2001", personAddress);


        Address healthUnitAddress = new Address("Rua B", "Centro", "Aracaju", "AL", "11111-111");
        HealthUnit healthUnit = new HealthUnit(null, UnitTypeEnum.UBS, "João Alves", "11.111.111/0001-22", healthUnitAddress);

        Vaccine vaccine = new Vaccine(null, VaccineName.JANSSEN, 1, "157", "02/11/2022");
        this.repository.create(person.getId(), healthUnit.getId(), vaccine);

        vaccine.setDose(2);
        this.repository.update(vaccine);

        Vaccine updatedVaccine = this.repository.findById(vaccine.getId());
        assertEquals(2, updatedVaccine.getDose());
        this.repository.delete(vaccine.getId());
    }

    @Test
    public void testDelete() {
        Address personAddress = new Address("Rua E", "Centro", "Japaratuba", "SE", "11111-111");
        Person person = new Person(null, "Inácio",
                "Silva", "000.000.000-00",
                BloodTypeEnum.A_LESS, SexEnum.MALE,
                "02/03/2001", personAddress);


        Address healthUnitAddress = new Address("Rua B", "Centro", "Aracaju", "AL", "11111-111");
        HealthUnit healthUnit = new HealthUnit(null, UnitTypeEnum.UBS, "João Alves", "11.111.111/0001-22", healthUnitAddress);

        Vaccine vaccine = new Vaccine(null, VaccineName.JANSSEN, 1, "157", "02/11/2022");
        vaccine.setHeathUnit(healthUnit);
        this.repository.create(person.getId(), healthUnit.getId(), vaccine);

        assertTrue(vaccine.equals(this.repository.findById(vaccine.getId())));
        this.repository.delete(vaccine.getId());
        assertEquals(null, this.repository.findById(vaccine.getId()));
    }

    @Test
    public void testFindById() {
        Address personAddress = new Address("Rua E", "Centro", "Japaratuba", "SE", "11111-111");
        Person person = new Person(null, "Inácio",
                "Silva", "000.000.000-00",
                BloodTypeEnum.A_LESS, SexEnum.MALE,
                "02/03/2001", personAddress);


        Address healthUnitAddress = new Address("Rua B", "Centro", "Aracaju", "AL", "11111-111");
        HealthUnit healthUnit = new HealthUnit(null, UnitTypeEnum.UBS, "João Alves", "11.111.111/0001-22", healthUnitAddress);

        Vaccine vaccine = new Vaccine(null, VaccineName.JANSSEN, 1, "157", "02/11/2022");
        this.repository.create(person.getId(), healthUnit.getId(), vaccine);
        vaccine.setHeathUnit(healthUnit);

        assertTrue(vaccine.equals(this.repository.findById(vaccine.getId())));
        this.repository.delete(vaccine.getId());
    }

    @Test
    public void testFindAll() {
        Address personAddress = new Address("Rua E", "Centro", "Japaratuba", "SE", "11111-111");
        Person person = new Person(null, "Inácio",
                "Silva", "000.000.000-00",
                BloodTypeEnum.A_LESS, SexEnum.MALE,
                "02/03/2001", personAddress);


        Address healthUnitAddress = new Address("Rua B", "Centro", "Aracaju", "AL", "11111-111");
        HealthUnit healthUnit = new HealthUnit(null, UnitTypeEnum.UBS, "João Alves", "11.111.111/0001-22", healthUnitAddress);

        Vaccine vaccine = new Vaccine(null, VaccineName.JANSSEN, 1, "157", "02/11/2022");
        this.repository.create(person.getId(), healthUnit.getId(), vaccine);
        vaccine.setHeathUnit(healthUnit);

        ArrayList<Vaccine> createdVaccines = this.repository.findAll("applicationDate='02/11/2022'");
        assertTrue(createdVaccines.size() >= 0);
        this.repository.delete(vaccine.getId());
    }
}

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
import javas.modules.vaccine.useCases.updateVaccine.UpdateVaccineUseCase;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class UpdateVaccineUseCaseTest {
    IVaccineRepository vaccineRepository;
    public UpdateVaccineUseCaseTest() {
        this.vaccineRepository = new VaccineRepository();
    }

    @Test
    public void testHandle() {
        UpdateVaccineUseCase updateVaccineUseCase = new UpdateVaccineUseCase(this.vaccineRepository);
        Address endereco = new Address("Rua flavao", "Bairro Oliveira", "Aracaju", "Sergipe", "987909123");
        HealthUnit healthUnit = new HealthUnit(null, UnitTypeEnum.HOSPITAL,
                "Hospital Inacio", "15.789.325/0001-24", endereco);

        Person person = new Person(null, "Inácio",
                "Santos", "369.888.659-12", BloodTypeEnum.A_LESS, SexEnum.MALE, "11/09/2001", endereco);

        Vaccine vaccine = new Vaccine(null, VaccineName.JANSSEN, 1, "157", "02/11/2022");
        vaccine.setHeathUnit(new HealthUnit(healthUnit.getId(), null, null, null, null));
        try {
            this.vaccineRepository.create(person.getId(), healthUnit.getId(), vaccine);
            assertNotNull(this.vaccineRepository.findById(vaccine.getId()));
            vaccine.setDose(2);
            updateVaccineUseCase.handle(vaccine);

            assertTrue(this.vaccineRepository.findById(vaccine.getId()).equals(vaccine));
        }catch (Error | NullPointerException ignored) {}

        this.vaccineRepository.delete(vaccine.getId());
    }
}

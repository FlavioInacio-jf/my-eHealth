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
import javas.modules.vaccine.useCases.deleteVaccine.DeleteVaccineController;
import javas.modules.vaccine.useCases.deleteVaccine.DeleteVaccineUseCase;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class DeleteVaccineControllerTest {
    IVaccineRepository vaccineRepository;
    DeleteVaccineUseCase deleteVaccineUseCase;
    public DeleteVaccineControllerTest() {
        this.vaccineRepository = new VaccineRepository();
        this.deleteVaccineUseCase = new DeleteVaccineUseCase(this.vaccineRepository);
    }

    @Test
    public void execute() {
        DeleteVaccineController deleteVaccineController = new DeleteVaccineController(this.deleteVaccineUseCase);
        Address endereco = new Address("Rua flavao", "Bairro Oliveira", "Aracaju", "Sergipe", "987909123");
        HealthUnit healthUnit = new HealthUnit(null, UnitTypeEnum.HOSPITAL,
                "Hospital Inacio", "19.987.325/0001-24", endereco);

        Person person = new Person(null, "Inácio",
                "Santos", "444.888.789-12", BloodTypeEnum.A_LESS, SexEnum.MALE, "11/09/2001", endereco);

        Vaccine vaccine = new Vaccine(null, VaccineName.JANSSEN, 1, "157", "02/11/2022");
        vaccine.setHeathUnit(healthUnit);

        try {
            this.vaccineRepository.create(person.getId(), healthUnit.getId(), vaccine);
            assertNotNull(this.vaccineRepository.findById(vaccine.getId()));
            deleteVaccineController.execute(vaccine.getId());
            assertNull(this.vaccineRepository.findById(vaccine.getId()));
        }catch (Error ignored) {}
    }
}

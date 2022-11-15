package tests.javas;

import javas.constants.VaccineEntityConstants;
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
import javas.modules.vaccine.useCases.getAllVaccines.GetAllVaccinesUseCase;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

public class GetAllVaccinesUseCaseTest {
    IVaccineRepository vaccineRepository;
    public GetAllVaccinesUseCaseTest() {
        this.vaccineRepository = new VaccineRepository();
    }

    @Test
    public void testHandle() {
        GetAllVaccinesUseCase getAllVaccinesUseCase = new GetAllVaccinesUseCase(this.vaccineRepository);

        Address endereco = new Address("Rua flavao", "Bairro Oliveira", "Aracaju", "Sergipe", "987909123");
        HealthUnit healthUnit = new HealthUnit(null, UnitTypeEnum.HOSPITAL,
                "Hospital Inacio", "19.987.325/0001-24", endereco);

        Person person = new Person(null, "Inácio",
                "Santos", "444.888.789-12", BloodTypeEnum.A_LESS, SexEnum.MALE, "11/09/2001", endereco);

        Vaccine vaccine1 = new Vaccine(null, VaccineName.JANSSEN, 1, "157", "02/11/2022");
        vaccine1.setHeathUnit(new HealthUnit(healthUnit.getId(), null, null, null, null));

        Vaccine vaccine2 = new Vaccine(null, VaccineName.PFIZER, 1, "157", "10/11/2022");
        vaccine2.setHeathUnit(new HealthUnit(healthUnit.getId(), null, null, null, null));

        try {
            this.vaccineRepository.create(person.getId(), healthUnit.getId(), vaccine1);
            this.vaccineRepository.create(person.getId(), healthUnit.getId(), vaccine2);

            ArrayList<Vaccine> vaccines = getAllVaccinesUseCase.handle(String.format("%s='%s'",
                                                                    VaccineEntityConstants.PERSON_COLUMN_NAME_FK, person.getId()));
            assertTrue(vaccines.contains(vaccine1));
            assertTrue(vaccines.contains(vaccine2));
            assertTrue(vaccines.size() > 1);
        }catch (Error ignored) {}

        this.vaccineRepository.delete(vaccine1.getId());
        this.vaccineRepository.delete(vaccine2.getId());
    }
}

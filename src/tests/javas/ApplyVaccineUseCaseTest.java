package tests.javas;

import javas.modules.app.models.Address;
import javas.modules.healthUnit.enums.UnitTypeEnum;
import javas.modules.healthUnit.models.HealthUnit;
import javas.modules.healthUnit.repositories.IHealthUnitRepository;
import javas.modules.healthUnit.repositories.implementations.HealthUnitRepository;
import javas.modules.person.enums.BloodTypeEnum;
import javas.modules.person.enums.SexEnum;
import javas.modules.person.models.Person;
import javas.modules.person.repositories.IPersonRepository;
import javas.modules.person.repositories.implementations.PersonRepository;
import javas.modules.vaccine.enums.VaccineName;
import javas.modules.vaccine.models.Vaccine;
import javas.modules.vaccine.repositories.IVaccineRepository;
import javas.modules.vaccine.repositories.impementations.VaccineRepository;
import javas.modules.vaccine.useCases.applyVaccine.ApplyVaccineUseCase;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class ApplyVaccineUseCaseTest {
    private IVaccineRepository vaccineRepository;
    private IHealthUnitRepository healthUnitRepository;
    private IPersonRepository personRepository;
    public ApplyVaccineUseCaseTest(){
        this.vaccineRepository = new VaccineRepository();
        this.healthUnitRepository = new HealthUnitRepository();
        this.personRepository = new PersonRepository();
    }

    @Test
    public void testHandle() {
        ApplyVaccineUseCase applyVaccineUseCase = new ApplyVaccineUseCase(this.vaccineRepository,
                                                                          this.personRepository,
                                                                          this.healthUnitRepository);

        Address endereco = new Address("Rua flavao", "Bairro Oliveira", "Aracaju", "Sergipe", "987909123");
        HealthUnit healthUnit = new HealthUnit(null, UnitTypeEnum.HOSPITAL,
                "Hospital Inacio", "19.987.325/0001-24", endereco);

        Person person = new Person(null, "Inácio",
                "Santos", "444.888.789-12", BloodTypeEnum.A_LESS, SexEnum.MALE, "11/09/2001", endereco);
        try {
            this.personRepository.create(person);
            this.healthUnitRepository.create(healthUnit);
        }catch (Error ignored) {
        }

        Vaccine vaccine = new Vaccine(null, VaccineName.JANSSEN, 1, "157", "02/11/2022");
        vaccine.setHeathUnit(healthUnit);

        try {
            applyVaccineUseCase.handle(person.getCPF(), healthUnit.getCNPJ(), vaccine);
        }catch (Error ignored) {
        }

        assertNotNull(this.vaccineRepository.findById(vaccine.getId()));
        this.vaccineRepository.delete(vaccine.getId());
        this.healthUnitRepository.delete(healthUnit.getId());
        this.personRepository.delete(person.getId());
    }

}

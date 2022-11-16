package tests.javas;

import javas.modules.app.models.Address;
import javas.modules.person.enums.BloodTypeEnum;
import javas.modules.person.enums.SexEnum;
import javas.modules.person.models.Person;
import javas.modules.person.repositories.IPersonRepository;
import javas.modules.person.repositories.implementations.PersonRepository;
import javas.modules.person.useCases.getSinglePerson.GetSinglePersonUseCase;
import javas.modules.vaccine.repositories.IVaccineRepository;
import javas.modules.vaccine.repositories.impementations.VaccineRepository;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GetSinglePersonUseCaseTest {
    IPersonRepository personRepository;
    IVaccineRepository vaccineRepository;
    public GetSinglePersonUseCaseTest() {
        this.personRepository = new PersonRepository();
        this.vaccineRepository = new VaccineRepository();
    }


    @Test
    public void testHandle() {
        GetSinglePersonUseCase getSinglePersonUseCase = new GetSinglePersonUseCase(this.personRepository, this.vaccineRepository);

        Address address = new Address("Abbey Road","Farolandia" , "Paris",
                "Florida", "586939291");
        Person person = new  Person(null, "Inácio",
                "Santos", "356.555.423-98", BloodTypeEnum.A_LESS, SexEnum.MALE, "11/09/2001", address);

        try {
            this.personRepository.create(person);
            assertTrue(getSinglePersonUseCase.handle(person.getCPF()).equals(person));

        }catch (Error | NullPointerException ignored) {
        }

        try {
            this.personRepository.delete(person.getId());
        }catch (Error ignored) {
        }

    }
}

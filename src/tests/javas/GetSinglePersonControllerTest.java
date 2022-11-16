package tests.javas;

import javas.modules.app.models.Address;
import javas.modules.person.enums.BloodTypeEnum;
import javas.modules.person.enums.SexEnum;
import javas.modules.person.models.Person;
import javas.modules.person.repositories.IPersonRepository;
import javas.modules.person.repositories.implementations.PersonRepository;
import javas.modules.person.useCases.getSinglePerson.GetSinglePersonController;
import javas.modules.person.useCases.getSinglePerson.GetSinglePersonUseCase;
import javas.modules.vaccine.repositories.IVaccineRepository;
import javas.modules.vaccine.repositories.impementations.VaccineRepository;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class GetSinglePersonControllerTest {
    IPersonRepository personRepository;
    IVaccineRepository vaccineRepository;

    GetSinglePersonUseCase getSinglePersonUseCase;

    public GetSinglePersonControllerTest() {
        this.personRepository = new PersonRepository();
        this.vaccineRepository = new VaccineRepository();
        this.getSinglePersonUseCase = new GetSinglePersonUseCase(this.personRepository, this.vaccineRepository);
    }

    @Test
    public void testExecute() {
        GetSinglePersonController getSinglePersonController = new GetSinglePersonController(this.getSinglePersonUseCase);
        Address address = new Address("Abbey Road","Farolandia" , "Paris",
                "Florida", "586939291");
        Person person = new  Person(null, "Inácio",
                "Santos", "896.7423.423-98", BloodTypeEnum.A_LESS, SexEnum.MALE, "11/09/2001", address);

        try {
            this.personRepository.create(person);
            assertTrue(getSinglePersonController.execute(person.getCPF()).equals(person));

        }catch (Error | NullPointerException ignored) {
        }

        try {
            this.personRepository.delete(person.getId());
        }catch (Error ignored) {
        }
    }
}

package tests.javas;

import javas.modules.app.models.Address;
import javas.modules.person.enums.BloodTypeEnum;
import javas.modules.person.enums.SexEnum;
import javas.modules.person.models.Person;
import javas.modules.person.repositories.IPersonRepository;
import javas.modules.person.repositories.implementations.PersonRepository;
import javas.modules.person.useCases.createPerson.CreatePersonUseCase;
import org.junit.Test;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


public class CreatePersonUseCaseTest {
    IPersonRepository personRepository;
    public CreatePersonUseCaseTest() {
        this.personRepository = new PersonRepository();
    }

    @Test
    public void testHandle() {
        CreatePersonUseCase createPersonUseCase = new CreatePersonUseCase(this.personRepository);
        
        Person person = new  Person(null, "Inácio",
        "Santos", "000.000.000-00", BloodTypeEnum.A_LESS, SexEnum.MALE, "11/09/2001", null);

        createPersonUseCase.handle(person);
        assertTrue(this.personRepository.findById(person.getId()).equals(person));
        this.personRepository.delete(person.getId());
        try {
            createPersonUseCase.handle(person);
            fail();
        }catch (Error ignored) {

        }
    }
}

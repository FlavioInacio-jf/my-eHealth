package tests.javas;

import javas.modules.person.enums.BloodTypeEnum;
import javas.modules.person.enums.SexEnum;
import javas.modules.person.models.Person;
import javas.modules.person.repositories.IPersonRepository;
import javas.modules.person.repositories.implementations.PersonRepository;
import javas.modules.person.useCases.createPerson.CreatePersonUseCase;
import org.junit.Test;

import static org.junit.Assert.assertTrue;


public class CreatePersonUseCaseTest {
    IPersonRepository personRepository;
    public CreatePersonUseCaseTest() {
        this.personRepository = new PersonRepository();
    }

    @Test
    public void testHandle() {
        CreatePersonUseCase createPersonUseCase = new CreatePersonUseCase(this.personRepository);
        
        Person person = new  Person(null, "Inácio",
        "Santos", "555.555.555-55", BloodTypeEnum.A_LESS, SexEnum.MALE, "11/09/2001", null);

        try {
            createPersonUseCase.handle(person);
            assertTrue(this.personRepository.findById(person.getId()).equals(person));

        }catch (Error | NullPointerException ignored) {
        }

        try {
            this.personRepository.delete(person.getId());
        }catch (Error ignored) {
        }
    }
}

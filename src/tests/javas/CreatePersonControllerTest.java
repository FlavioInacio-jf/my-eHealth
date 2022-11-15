package tests.javas;

import javas.modules.person.repositories.IPersonRepository;
import javas.modules.person.repositories.implementations.PersonRepository;
import javas.modules.person.useCases.createPerson.CreatePersonController;
import javas.modules.person.useCases.createPerson.CreatePersonUseCase;
import org.junit.Test;

import static org.junit.Assert.fail;

public class CreatePersonControllerTest {
    
    IPersonRepository personRepository;
    CreatePersonUseCase createPersonUseCase;
    public CreatePersonControllerTest() {
        this.personRepository = new PersonRepository();
        this.createPersonUseCase = new CreatePersonUseCase(this.personRepository);
    }

    @Test
    public void testExecute() throws IllegalAccessException {
        CreatePersonController createPersonController = new CreatePersonController(this.createPersonUseCase);
        try {
            createPersonController.execute("Inácio",
            "Santos", "000.000.000-00", "O+", "MALE", "11/09/2001", "Rua teste",
            "Bairro teste", "cidade teste", "estado teste","44445-000");
        } catch (IllegalAccessException | Error e) {
            fail();
        }

        try {
            createPersonController.execute("Inácio",
            "Santos", "000.000.000-00", "O+", "MALE", "11/09/2001", "Rua teste",
            "Bairro teste", "cidade teste", "estado teste","44445-000");
            fail();
        } catch (IllegalAccessException | Error e) {
        }
        this.personRepository.delete(this.personRepository.findByCPF("21.987.127/0001-24").getId());
    }    
}


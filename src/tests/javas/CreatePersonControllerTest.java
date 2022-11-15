package tests.javas;

import javas.modules.app.models.Address;
import javas.modules.person.enums.BloodTypeEnum;
import javas.modules.person.enums.SexEnum;
import javas.modules.person.models.Person;
import javas.modules.person.repositories.IPersonRepository;
import javas.modules.person.repositories.implementations.PersonRepository;
import javas.modules.person.useCases.createPerson.CreatePersonController;
import javas.modules.person.useCases.createPerson.CreatePersonUseCase;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreatePersonControllerTest {
    IPersonRepository personRepository;
    CreatePersonUseCase createPersonUseCase;
    public CreatePersonControllerTest() {
        this.personRepository = new PersonRepository();
        this.createPersonUseCase = new CreatePersonUseCase(this.personRepository);
    }

    @Test
    public void testExecute() {
        CreatePersonController createPersonController = new CreatePersonController(this.createPersonUseCase);
        try {
            Address address = new Address("Rua flavao", "Bairro Oliveira", "Aracaju", "Sergipe", "98790-923");
            Person person = new  Person(null, "Inácio",
                    "Santos", "123.564.555-55", BloodTypeEnum.A_LESS, SexEnum.MALE, "11/09/2001", address);

            Person personCreated = createPersonController.execute(person.getFirstName(),
                    person.getLastName(), person.getCPF(), "A_LESS", "MALE",
                    person.getBirthDate(), address.getStreet(), address.getDistrict(), address.getCity(), address.getState(), address.getPostalCode());

            assertNotNull(this.personRepository.findById(personCreated.getId()));
            this.personRepository.delete(personCreated.getId());

        } catch (IllegalAccessException | IllegalArgumentException | Error e) {
            fail();
        }


    }    
}


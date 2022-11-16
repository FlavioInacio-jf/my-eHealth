package tests.javas;


import javas.modules.app.models.Address;
import javas.modules.person.enums.BloodTypeEnum;
import javas.modules.person.enums.SexEnum;
import javas.modules.person.models.Person;
import javas.modules.person.repositories.IPersonRepository;
import javas.modules.person.repositories.implementations.PersonRepository;
import javas.modules.person.useCases.deletePerson.DeletePersonController;
import javas.modules.person.useCases.deletePerson.DeletePersonUseCase;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeletePersonControllerTest {
    IPersonRepository personRepository;
    DeletePersonUseCase deletePersonUseCase;
    public DeletePersonControllerTest() {
        this.personRepository = new PersonRepository();
        this.deletePersonUseCase = new DeletePersonUseCase(this.personRepository);
    }

    @Test
    public void testExecute() {
        DeletePersonController deletePersonController = new DeletePersonController(this.deletePersonUseCase);

        try {
            Address address = new Address("Rua flavao", "Bairro Oliveira",
                    "Aracaju", "Sergipe", "987909123");
            Person person = new  Person(null, "Inácio",
                    "Santos", "456.896.111-13", BloodTypeEnum.A_LESS, SexEnum.MALE, "11/09/2001", address);

            this.personRepository.create(person);
            assertTrue(person.equals(this.personRepository.findById(person.getId())));
            deletePersonController.execute(person.getCPF());
            assertNull(this.personRepository.findById(person.getId()));
            deletePersonController.execute(person.getCPF());
            fail();
        }catch (Error ignored) {
        }
    }
}

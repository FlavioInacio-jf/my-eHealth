package tests.javas;

import javas.modules.app.models.Address;
import javas.modules.person.enums.BloodTypeEnum;
import javas.modules.person.enums.SexEnum;
import javas.modules.person.models.Person;
import javas.modules.person.repositories.IPersonRepository;
import javas.modules.person.repositories.implementations.PersonRepository;
import javas.modules.person.useCases.deletePerson.DeletePersonUseCase;
import org.junit.Test;

import static org.junit.Assert.*;

public class DeletePersonUseCaseTest {
    IPersonRepository personRepository;
    public DeletePersonUseCaseTest() {
        this.personRepository = new PersonRepository();
    }

    @Test
    public void testHandle() {
        DeletePersonUseCase deletePersonUseCase = new DeletePersonUseCase(this.personRepository);
        try {
            Address address = new Address("Rua flavao", "Bairro Oliveira",
                    "Aracaju", "Sergipe", "987909123");
            Person person = new  Person(null, "Inácio",
                    "Santos", "456.896.111-13", BloodTypeEnum.A_LESS, SexEnum.MALE, "11/09/2001", address);

            this.personRepository.create(person);
            assertTrue(person.equals(this.personRepository.findById(person.getId())));
            deletePersonUseCase.handle(person.getCPF());
            assertNull(this.personRepository.findById(person.getId()));
            deletePersonUseCase.handle(person.getCPF());
            fail();
        }catch (Error ignored) {
        }
    }
}

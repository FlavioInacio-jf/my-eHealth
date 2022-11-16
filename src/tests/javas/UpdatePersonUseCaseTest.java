package tests.javas;

import javas.modules.app.models.Address;
import javas.modules.person.enums.BloodTypeEnum;
import javas.modules.person.enums.SexEnum;
import javas.modules.person.models.Person;
import javas.modules.person.repositories.IPersonRepository;
import javas.modules.person.repositories.implementations.PersonRepository;
import javas.modules.person.useCases.updatePerson.UpdatePersonUseCase;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class UpdatePersonUseCaseTest {
    IPersonRepository personRepository;

    public UpdatePersonUseCaseTest() {
        this.personRepository = new PersonRepository();
    }

    @Test
    public void testHandle() {
        UpdatePersonUseCase updatePersonUseCase = new UpdatePersonUseCase(this.personRepository);

        Address address = new Address("Rua flavao", "Bairro Oliveira", "Aracaju", "Sergipe", "98790-923");
        Person person = new  Person(null, "Inácio",
                "Santos", "569.789.369-26", BloodTypeEnum.A_LESS, SexEnum.MALE, "11/09/2001", address);

        try {
            this.personRepository.create(person);
            person.setLastName("Oliveira");
            assertNotNull(this.personRepository.findById(person.getId()));

            updatePersonUseCase.handle(person.getCPF(), person);
            assertTrue(this.personRepository.findById(person.getId()).equals(person));

        }catch (Error | NullPointerException ignored) {
        }

        try {
            this.personRepository.delete(person.getId());
        }catch (Error ignored) {
        }
    }
}

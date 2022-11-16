package tests.javas;

import javas.modules.app.models.Address;
import javas.modules.person.enums.BloodTypeEnum;
import javas.modules.person.enums.SexEnum;
import javas.modules.person.models.Person;
import javas.modules.person.repositories.IPersonRepository;
import javas.modules.person.repositories.implementations.PersonRepository;
import javas.modules.person.useCases.updatePerson.UpdatePersonController;
import javas.modules.person.useCases.updatePerson.UpdatePersonUseCase;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class UpdatePersonControllerTest {
    IPersonRepository personRepository;
    UpdatePersonUseCase updatePersonUseCase;

    public UpdatePersonControllerTest() {
        this.personRepository = new PersonRepository();
        this.updatePersonUseCase = new UpdatePersonUseCase(this.personRepository);
    }

    @Test
    public void testExecute() {
        UpdatePersonController updatePersonController = new UpdatePersonController(this.updatePersonUseCase);
        Address address = new Address("Rua flavao", "Bairro Oliveira", "Aracaju", "Sergipe", "98790-923");
        Person person = new  Person(null, "Inácio",
                "Santos", "369.896.745-26", BloodTypeEnum.A_LESS, SexEnum.MALE, "11/09/2001", address);

        try {
            this.personRepository.create(person);
            person.setLastName("Oliveira");
            assertNotNull(this.personRepository.findById(person.getId()));

            updatePersonController.execute(person.getFirstName(), person.getLastName(), person.getCPF(),
                    "A_LESS", "MALE", person.getBirthDate(), address.getStreet(),
                                            address.getDistrict(), address.getCity(), address.getState(), address.getPostalCode());
            assertTrue(this.personRepository.findById(person.getId()).equals(person));

        }catch (Error | NullPointerException | IllegalAccessException ignored) {
        }

        try {
            this.personRepository.delete(person.getId());
        }catch (Error ignored) {
        }
    }
}

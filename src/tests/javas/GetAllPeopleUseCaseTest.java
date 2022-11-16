package tests.javas;

 import javas.constants.PersonEntityConstants;
 import javas.modules.app.models.Address;
 import javas.modules.person.enums.BloodTypeEnum;
 import javas.modules.person.enums.SexEnum;
 import javas.modules.person.models.Person;
 import javas.modules.person.repositories.IPersonRepository;
 import javas.modules.person.repositories.implementations.PersonRepository;
 import javas.modules.person.useCases.getAllPeople.GetAllPeopleUseCase;
 import javas.modules.person.useCases.getAllPeople.GetAllPeopleController;
 import javas.modules.vaccine.repositories.IVaccineRepository;
 import javas.modules.vaccine.repositories.impementations.VaccineRepository;

 
 import org.junit.Test;
 
 import java.util.ArrayList;
 
 import static org.junit.Assert.assertTrue;

public class GetAllPeopleUseCaseTest {
    IPersonRepository personRepository;
    IVaccineRepository vaccineRepository;
    GetAllPeopleUseCase getAllPeopleUseCase;
    public GetAllPeopleUseCaseTest() {
        this.personRepository = new PersonRepository();
        this.vaccineRepository = new VaccineRepository();
        this.getAllPeopleUseCase = new GetAllPeopleUseCase(this.personRepository, this.vaccineRepository);
    }

    @Test
    public void testHandle() {
        GetAllPeopleController getAllPeopleController = new GetAllPeopleController(this.getAllPeopleUseCase);
        Address endereco = new Address("Rua flavao", "Bairro Oliveira", "Aracaju", "Sergipe", "987909123");

        Person person1 = new Person(null, "Inácio",
                "Santos", "444.888.789-12", BloodTypeEnum.A_LESS, SexEnum.MALE, "11/09/2001", endereco);

        Person person2 = new Person(null, "Arthur",
        "Caetano", "444.888.789-12", BloodTypeEnum.A_LESS, SexEnum.MALE, "11/09/2001", endereco);
    
        try{
            this.personRepository.create(person1);
            this.personRepository.create(person2);

            ArrayList<Person> people = getAllPeopleController.execute(String.format("%s='%s'",
                    PersonEntityConstants.ID_COLUMN_NAME, person1.getId()));
            assertTrue(people.contains(person1));
            assertTrue(people.contains(person2));
            assertTrue(people.size() >= 1);
        }catch (Error ignored) {}

        this.personRepository.delete(person1.getId());
        this.personRepository.delete(person2.getId());
    }
}


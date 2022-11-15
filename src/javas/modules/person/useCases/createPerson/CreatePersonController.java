package javas.modules.person.useCases.createPerson;

import javas.modules.app.models.Address;
import javas.modules.person.enums.BloodTypeEnum;
import javas.modules.person.enums.SexEnum;
import javas.modules.person.models.Person;
import javas.validations.Validation;
//
public class CreatePersonController {
    private CreatePersonUseCase createPersonUseCase;

    public CreatePersonController (CreatePersonUseCase createPersonUseCase) {
        this.createPersonUseCase = createPersonUseCase;
    }

    public void execute (
            String firstName,
            String lastName,
            String cpf,
            String bloodType,
            String sex,
            String birthDate,
            String street,
            String district,
            String city,
            String state,
            String postalCode // CEP
    ) throws IllegalAccessException {
        Address address = new Address(street, district, city, state, postalCode);
        Person person = new Person(null, firstName, lastName, cpf, BloodTypeEnum.valueOf(bloodType), SexEnum.valueOf(sex), birthDate, address);
        new Validation(person).validate();
        new Validation(address).validate();
        this.createPersonUseCase.handle(person);
    }
}

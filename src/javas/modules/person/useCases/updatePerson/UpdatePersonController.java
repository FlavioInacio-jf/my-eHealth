package javas.modules.person.useCases.updatePerson;

import javas.modules.app.models.Address;
import javas.modules.person.enums.BloodTypeEnum;
import javas.modules.person.enums.SexEnum;
import javas.modules.person.models.Person;

public class UpdatePersonController {
    private UpdatePersonUseCase updatePersonUseCase;

    public UpdatePersonController(UpdatePersonUseCase updatePersonUseCase) {
        this.updatePersonUseCase = updatePersonUseCase;
    }

    public void execute(
            String firstName,
            String lastName,
            String cpf,
            String bloodType,
            SexEnum sex,
            String birthDate,
            String street,
            String district,
            String city,
            String state,
            String postalCode // CEP
    ) {
        try {
            Address address = new Address(street, district, city, state, postalCode);
            Person person = new Person(null, firstName, lastName, cpf, BloodTypeEnum.valueOf(bloodType), sex, birthDate, address);
            this.updatePersonUseCase.handle(cpf, person);
        }catch (Error error) {
            throw new Error(error);
        }
    }
}

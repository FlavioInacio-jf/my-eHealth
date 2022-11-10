package javas.modules.person.useCases.createPerson;

import javas.modules.app.models.Address;
import javas.modules.person.enums.BloodTypeEnum;
import javas.modules.person.enums.SexEnum;
import javas.modules.person.models.Person;

import javax.swing.*;

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
            this.createPersonUseCase.handle(person);
        }catch (Error error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
        }
    }
}

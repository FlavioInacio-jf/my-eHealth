package javas.validations;

import javas.errors.CustomError;
import javas.modules.app.models.Address;
import javas.modules.person.enums.BloodTypeEnum;
import javas.modules.person.enums.SexEnum;
import javas.modules.person.models.Person;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidationTest {

    @Test
    public void testValidate()  {
        try {
            Person person = new Person(null, "", "",
                    null, null,
                    null, null, null);
            new Validation(person).validate();
            fail();
        }catch (CustomError | IllegalAccessException ignored) {
        }

        try {
            Person person = new Person(null, " ", "",
                    "000.000.000-00", null,
                    null, null, null);
            new Validation(person).validate();
            fail();
        }catch (CustomError | IllegalAccessException ignored) {
        }

        try {
            Person person = new Person(null, "Primeiro nome ", "Último nome",
                    "000.000.000-00", BloodTypeEnum.A_LESS,
                    SexEnum.FEMALE, "11/03/2012",
                    new Address("Rua de teste", "Bairro teste", "Aracaju", "SE", "44444-000"));
            new Validation(person).validate();

        }catch (CustomError | IllegalAccessException error) {
            fail();
        }


        try {
            Person person = new Person(null, "", "Último nome",
                    "000.000.000-00", BloodTypeEnum.A_LESS,
                    SexEnum.FEMALE, "11/03/2012",
                    new Address("Rua de teste", "Bairro teste", "Aracaju", "SE", "44444-000"));
            new Validation(person).validate();
            fail();
        }catch (CustomError | IllegalAccessException ignored) {

        }

        try {
            Person person = new Person(null, "Nome teste", "",
                    "000.000.000-00", BloodTypeEnum.A_LESS,
                    SexEnum.FEMALE, "11/03/2012",
                    new Address("Rua de teste", "Bairro teste", "Aracaju", "SE", "44444-000"));
            new Validation(person).validate();
            fail();
        }catch (CustomError | IllegalAccessException error) {
            throw new RuntimeException(error);
        }

        try {
            Person person = new Person(null, "Nome teste", "Último nome",
                    "000.000.000-0", BloodTypeEnum.A_LESS,
                    SexEnum.FEMALE, "11/03/2012",
                    new Address("Rua de teste", "Bairro teste", "Aracaju", "SE", "44444-000"));
            new Validation(person).validate();
            fail();
        }catch (CustomError | IllegalAccessException error) {
            throw new RuntimeException(error);
        }

        try {
            Person person = new Person(null, "Nome teste", "Último nome",
                    "000.000.000-00", null,
                    SexEnum.FEMALE, "11/03/2012",
                    new Address("Rua de teste", "Bairro teste", "Aracaju", "SE", "44444-000"));
            new Validation(person).validate();
            fail();
        }catch (CustomError | IllegalAccessException error) {
            throw new RuntimeException(error);
        }

        try {
            Person person = new Person(null, "Nome teste", "Último nome",
                    "000.000.000-00", BloodTypeEnum.A_LESS,
                    null, "11/03/2012",
                    new Address("Rua de teste", "Bairro teste", "Aracaju", "SE", "44444-000"));
            new Validation(person).validate();
            fail();
        }catch (CustomError | IllegalAccessException ignored) {

        }

        try {
            Person person = new Person(null, "Nome teste", "Último nome",
                    "000.000.000-00", BloodTypeEnum.A_LESS,
                    SexEnum.FEMALE, "22/03/2012",
                    new Address("Rua de teste", "Bairro teste", "Aracaju", "SE", "44444-000"));
            new Validation(person).validate();
            fail();
        }catch (CustomError | IllegalAccessException ignored) {

        }

        try {
            Person person = new Person(null, "Nome teste", "Último nome",
                    "000.000.000-00", BloodTypeEnum.A_LESS,
                    SexEnum.FEMALE, "11/03/2012",
                    null);
            new Validation(person).validate();
            fail();
        }catch (CustomError | IllegalAccessException error) {
            throw new RuntimeException(error);
        }

        try {
            Address address = new Address("", "Bairro teste", "Aracaju", "SE", "44444-000");
            new Validation(address).validate();
            fail();
        }catch (CustomError | IllegalAccessException ignored) {

        }

        try {
            Address address = new Address("Rua", "Bairro teste", "Aracaju", "SE", "4444-000");
            new Validation(address).validate();
            fail();
        }catch (CustomError | IllegalAccessException ignored) {

        }
    }
}

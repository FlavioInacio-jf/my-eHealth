package javas.util;

import javas.errors.CustomError;
import javas.exceptions.PersonErrorMessages;
import javas.modules.app.models.Address;
import javas.modules.person.enums.BloodTypeEnum;
import javas.modules.person.enums.SexEnum;
import javas.modules.person.models.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetToPerson {
    public ResultSetToPerson() {}

    public static Person convert(ResultSet rs) {
        try {

            // Person Columns
            String _id = rs.getString(1);
            String firstName = rs.getString(2);
            String lastName = rs.getString(3);
            String cpf = rs.getString(4);
            BloodTypeEnum bloodType = BloodTypeEnum.valueOf(rs.getString(5));
            String birthDate = rs.getString(6);
            SexEnum sex = SexEnum.valueOf(rs.getString(7));

            // Address Columns
            String street = rs.getNString(8);
            String district = rs.getString(9);
            String city = rs.getString(10);
            String postalCode = rs.getString(11);
            String state = rs.getString(12);

            Address address = new Address(street, district, city, postalCode, state);
            return new Person(_id, firstName, lastName, cpf, bloodType, sex, birthDate, address);
        }catch (SQLException error) {
            throw new CustomError(PersonErrorMessages.FAILED_CONVERT_RESULT_SET_TO_PERSON, error.getMessage());
        }
    }
}


package javas.util;

import javas.errors.CustomError;
import javas.exceptions.HealthUnitErrorMessages;
import javas.modules.app.models.Address;
import javas.modules.heathUnit.enums.UnitTypeEnum;
import javas.modules.heathUnit.models.HealthUnit;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetToHealthUnit {
    public ResultSetToHealthUnit() {}

    public static HealthUnit convert(ResultSet rs) {
        try {

            // Heath Unit Columns
            String _id = rs.getString(1);
            UnitTypeEnum type = UnitTypeEnum.valueOf(rs.getString(2));
            String name = rs.getString(3);
            String cnpj = rs.getString(4);

            // Address Columns
            String street = rs.getNString(5);
            String district = rs.getString(6);
            String city = rs.getString(7);
            String postalCode = rs.getString(8);
            String state = rs.getString(9);

            Address address = new Address(street, district, city, postalCode, state);
            return new HealthUnit(_id, type, name, cnpj, address);
        }catch (SQLException error) {
            throw new CustomError(HealthUnitErrorMessages.FAILED_CONVERT_RESULT_SET_TO_HEALTH_UNIT, error.getMessage());
        }
    }
}

package javas.util;

import javas.errors.CustomError;
import javas.exceptions.VaccineErrorMessages;
import javas.modules.vaccine.models.Vaccine;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultSetToVaccine {
    public ResultSetToVaccine() {}

    public static Vaccine convert(ResultSet rs) {
        try {
            // Vaccine Columns
            String _id = rs.getString(1);
            String name = rs.getString(2);
            String date = rs.getString(3);
            int dose = rs.getInt(4);
            String lot = rs.getString(5);

            return new Vaccine(_id, name, date, dose, lot);
        }catch (SQLException error) {
            throw new CustomError(VaccineErrorMessages.FAILED_CONVERT_RESULT_SET_TO_VACCINE, error.getMessage());
        }
    }
}

package javas.modules.vaccine.repositories.impementations;

import javas.config.AppDataSource;
import javas.constants.VaccineEntityConstants;
import javas.errors.CustomError;
import javas.exceptions.VaccineErrorMessages;
import javas.modules.vaccine.models.Vaccine;
import javas.modules.vaccine.repositories.IVaccineRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class VaccineRepository implements IVaccineRepository {

    private final Statement repository;

    public VaccineRepository() {
        this.repository = AppDataSource.execute();
    }
    @Override
    public Vaccine crate(String _idUser, String _idHealthUnit, Vaccine data) {
        return this.save(_idUser, _idHealthUnit, data);
    }

    private Vaccine save(String _idUser, String _idHealthUnit, Vaccine data) {
        try {
            final String query = String.format("INSERT INTO %s VALUES ('%s', '%s', '%s', %s, '%s', '%s', '%s')",
                    VaccineEntityConstants.ENTITY_NAME,
                    data.getId(), data.getName(),
                    data.getDate(), data.getDose(),
                    data.getLot(), _idHealthUnit,
                    _idUser);
            this.repository.execute(query);
            this.repository.close();
            return data;
        }catch (SQLException error) {
            throw new CustomError(VaccineErrorMessages.UNABLE_CREATE_VACCINE, error.getMessage());
        }
    }

    @Override
    public boolean update(Vaccine data) {
        try {
            final String query = String.format("UPDATE %s SET %s='%s', %s='%s', %s='%s', %s='%s, WHERE %s='%s'",
                    VaccineEntityConstants.ENTITY_NAME,
                    VaccineEntityConstants.NAME_COLUMN_NAME,
                    data.getName(),
                    VaccineEntityConstants.DATE_COLUMN_NAME,
                    data.getDate(),
                    VaccineEntityConstants.DOSE_COLUMN_NAME,
                    data.getDose(),
                    VaccineEntityConstants.LOT_COLUMN_NAME,
                    data.getLot(),
                    VaccineEntityConstants.ID_COLUMN_NAME,
                    data.getId());
            this.repository.executeUpdate(query);
            this.repository.close();
            return true;
        }catch (SQLException error) {
            throw new CustomError(VaccineErrorMessages.UNABLE_UPDATE_VACCINE, error.getMessage());
        }
    }

    @Override
    public boolean delete(String _id) {
        try {
            final String query = String.format("DELETE FROM %s WHERE %s='%s'", VaccineEntityConstants.ENTITY_NAME, VaccineEntityConstants.ID_COLUMN_NAME, _id);
            this.repository.execute(query);
            this.repository.close();
            return true;
        }catch (SQLException error) {
            throw new CustomError(VaccineErrorMessages.UNABLE_DELETE_VACCINE, error.getMessage());
        }
    }

    @Override
    public ArrayList<Vaccine> findByUserId(String userId) {
        return this.getAll(VaccineEntityConstants.PERSON_COLUMN_NAME_FK, userId);
    }

    @Override
    public ArrayList<Vaccine> findByHeathUnitId(String healthUnitId) {
        return this.getAll(VaccineEntityConstants.HEATH_UNIT_COLUMN_NAME_FK, healthUnitId);
    }

    @Override
    public Vaccine findById(String _id) {
       ArrayList<Vaccine> vaccines = this.getAll(VaccineEntityConstants.ID_COLUMN_NAME, _id);
       if (vaccines.isEmpty()) {
           return null;
       }
        return vaccines.get(0);
    }

    private ArrayList<Vaccine> getAll(String columnName, String valueColumn) {
        ArrayList<Vaccine> listVaccines = new ArrayList<>();
        try {
            final String query = String.format("SELECT * FROM %s where %s='%s'", VaccineEntityConstants.ENTITY_NAME, columnName, valueColumn);
            ResultSet rs = this.repository.executeQuery(query);
            while (rs.next()) {
                listVaccines.add(this.resultSetToVaccine(rs));
            }
            this.repository.close();
            return listVaccines;
        }catch (SQLException error) {
            throw new CustomError(VaccineErrorMessages.UNABLE_SEARCH_VACCINE, error.getMessage());
        }
    }


    private Vaccine resultSetToVaccine(ResultSet rs) {
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

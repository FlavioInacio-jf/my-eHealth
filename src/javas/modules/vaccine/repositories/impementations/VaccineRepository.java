package javas.modules.vaccine.repositories.impementations;

import javas.config.AppDataSource;
import javas.constants.VaccineEntityConstants;
import javas.errors.CustomError;
import javas.exceptions.VaccineErrorMessages;
import javas.modules.vaccine.models.Vaccine;
import javas.modules.vaccine.repositories.IVaccineRepository;
import javas.util.ResultSetToVaccine;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class VaccineRepository implements IVaccineRepository {

    private Statement repository;

    public VaccineRepository() {
        this.repository = AppDataSource.execute();
    }
    @Override
    public Vaccine crate(String _idUser, String _idHeathUnit, Vaccine data) {
        return this.save(_idUser, _idHeathUnit, data);
    }

    private Vaccine save(String _idUser, String _idHeathUnit, Vaccine data) {
        try {
            final String query = String.format("INSERT INTO %s VALUES ('%s', '%s', '%s', %s, '%s', '%s', '%s')",
                    VaccineEntityConstants.ENTITY_NAME,
                    data.getId(), data.getName(),
                    data.getDate(), data.getDose(),
                    data.getLot(), _idHeathUnit,
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
    public Vaccine findById(String _id) {
        // return this.findOne(VaccineEntityConstants.ID_COLUMN_NAME, _id);
        return null;
    }

    @Override
    public ArrayList<Vaccine> findByUserCPF(String userCPF) {
        // return this.findOne(VaccineEntityConstants.PERSON_COLUMN_NAME_FK, userCPF);
        return null;
    }

    @Override
    public ArrayList<Vaccine> findByHeathUnitCNPJ(String heathUnitCNPJ) {
        return null;
    }

    private Vaccine findOne(String columnName, String valueColumn) {
        try {
            final String query = String.format("SELECT * FROM %s WHERE %s='%s' LIMIT 1", VaccineEntityConstants.ENTITY_NAME, columnName, valueColumn);
            ResultSet rs = this.repository.executeQuery(query);
            while (rs.next()) {
                return ResultSetToVaccine.convert(rs);
            }
            this.repository.close();
        }catch (SQLException error) {
            throw new CustomError(VaccineErrorMessages.UNABLE_SEARCH_VACCINE, error.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<Vaccine> getAll(String _idUser) {
        ArrayList<Vaccine> listVaccines = new ArrayList<>();
        try {
            final String query = String.format("SELECT * FROM %s where %s='%s'", VaccineEntityConstants.ENTITY_NAME, VaccineEntityConstants.PERSON_COLUMN_NAME_FK, _idUser);
            ResultSet rs = this.repository.executeQuery(query);
            while (rs.next()) {
                listVaccines.add(ResultSetToVaccine.convert(rs));
            }
            this.repository.close();
            return listVaccines;
        }catch (SQLException error) {
            throw new CustomError(VaccineErrorMessages.UNABLE_SEARCH_VACCINE, error.getMessage());
        }
    }
}

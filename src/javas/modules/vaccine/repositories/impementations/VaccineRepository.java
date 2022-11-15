package javas.modules.vaccine.repositories.impementations;

import javas.config.AppDataSource;
import javas.constants.HealthUnitEntityConstants;
import javas.constants.VaccineEntityConstants;
import javas.errors.CustomError;
import javas.exceptions.VaccineErrorMessages;
import javas.modules.app.models.Address;
import javas.modules.healthUnit.enums.UnitTypeEnum;
import javas.modules.healthUnit.models.HealthUnit;
import javas.modules.vaccine.enums.VaccineName;
import javas.modules.vaccine.models.Vaccine;
import javas.modules.vaccine.repositories.IVaccineRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class VaccineRepository implements IVaccineRepository {

    private final Statement statement;

    public VaccineRepository() {
        this.statement = AppDataSource.execute();
    }
    @Override
    public Vaccine create(String _idUser, String _idHealthUnit, Vaccine data) {
        return this.save(_idUser, _idHealthUnit, data);
    }

    private Vaccine save(String _idUser, String _idHealthUnit, Vaccine data) {
        try {
            final String query = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s) VALUES ('%s', '%s', %s, '%s', '%s', '%s', '%s')",
                    VaccineEntityConstants.ENTITY_NAME,
                    VaccineEntityConstants.ID_COLUMN_NAME,
                    VaccineEntityConstants.NAME_COLUMN_NAME,
                    VaccineEntityConstants.DOSE_COLUMN_NAME,
                    VaccineEntityConstants.LOT_COLUMN_NAME,
                    VaccineEntityConstants.APPLICATION_DATE_COLUMN_NAME,
                    VaccineEntityConstants.HEATH_UNIT_COLUMN_NAME_FK,
                    VaccineEntityConstants.PERSON_COLUMN_NAME_FK,
                    data.getId(),
                    data.getName().toString(),
                    data.getDose(),
                    data.getLot(),
                    data.getApplicationDate(),
                    _idHealthUnit,
                    _idUser);
            this.statement.execute(query);
            this.statement.close();
            return data;
        }catch (SQLException error) {
            throw new CustomError(VaccineErrorMessages.UNABLE_CREATE_VACCINE, error.getMessage());
        }
    }

    @Override
    public boolean update(Vaccine data) {
        try {
            final String query = String.format("UPDATE %s SET %s='%s', %s='%s', %s='%s, %s='%s',, WHERE %s='%s'",
                    VaccineEntityConstants.ENTITY_NAME,
                    VaccineEntityConstants.NAME_COLUMN_NAME,
                    data.getName().toString(),
                    VaccineEntityConstants.DOSE_COLUMN_NAME,
                    data.getDose(),
                    VaccineEntityConstants.LOT_COLUMN_NAME,
                    data.getLot(),
                    VaccineEntityConstants.APPLICATION_DATE_COLUMN_NAME,
                    data.getApplicationDate(),
                    VaccineEntityConstants.ID_COLUMN_NAME,
                    data.getId());
            this.statement.executeUpdate(query);
            this.statement.close();
            return true;
        }catch (SQLException error) {
            throw new CustomError(VaccineErrorMessages.UNABLE_UPDATE_VACCINE, error.getMessage());
        }
    }

    @Override
    public boolean delete(String _id) {
        try {
            final String query = String.format("DELETE FROM %s WHERE %s='%s'", VaccineEntityConstants.ENTITY_NAME, VaccineEntityConstants.ID_COLUMN_NAME, _id);
            this.statement.execute(query);
            this.statement.close();
            return true;
        }catch (SQLException error) {
            throw new CustomError(VaccineErrorMessages.UNABLE_DELETE_VACCINE, error.getMessage());
        }
    }

    @Override
    public Vaccine findById(String _id) {
       ArrayList<Vaccine> vaccines = this.findAll(String.format("%s='%s'", VaccineEntityConstants.ID_COLUMN_NAME, _id));
       if (vaccines.isEmpty()) {
           return null;
       }
        return vaccines.get(0);
    }

    @Override
    public ArrayList<Vaccine> findAll(String query) {
        ArrayList<Vaccine> listVaccines = new ArrayList<>();
        try {
            final String querySQL = String.format("SELECT * FROM %s INNER JOIN %s ON %s.%s = %s.%s where %s",
                                                                                            VaccineEntityConstants.ENTITY_NAME,
                                                                                            HealthUnitEntityConstants.ENTITY_NAME,
                                                                                            VaccineEntityConstants.ENTITY_NAME,
                                                                                            VaccineEntityConstants.HEATH_UNIT_COLUMN_NAME_FK,
                                                                                            HealthUnitEntityConstants.ENTITY_NAME,
                                                                                            HealthUnitEntityConstants.ID_COLUMN_NAME,
                                                                                            query);
            ResultSet rs = this.statement.executeQuery(querySQL);
            while (rs.next()) {
                listVaccines.add(this.resultSetToVaccine(rs));
            }
            this.statement.close();
            return listVaccines;
        }catch (SQLException error) {
            throw new CustomError(VaccineErrorMessages.UNABLE_SEARCH_VACCINE, error.getMessage());
        }
    }

    private Vaccine resultSetToVaccine(ResultSet rs) {
        try {
            // Vaccine Columns
            String _id = rs.getString(VaccineEntityConstants.ID_COLUMN_NAME);
            VaccineName name = VaccineName.valueOf(VaccineName.getEnum(rs.getString(VaccineEntityConstants.NAME_COLUMN_NAME)));
            int dose = rs.getInt(VaccineEntityConstants.DOSE_COLUMN_NAME);
            String lot = rs.getString(VaccineEntityConstants.LOT_COLUMN_NAME);
            String applicationDate = rs.getString(VaccineEntityConstants.APPLICATION_DATE_COLUMN_NAME);

            // Health Unit
            String healthUnitID = rs.getString(VaccineEntityConstants.HEATH_UNIT_COLUMN_NAME_FK);
            UnitTypeEnum type = UnitTypeEnum.valueOf(UnitTypeEnum.getEnum(rs.getString(HealthUnitEntityConstants.TYPE_COLUMN_NAME)));
            String corporateName = rs.getString(HealthUnitEntityConstants.NAME_COLUMN_NAME);
            String cnpj = rs.getString(HealthUnitEntityConstants.CNPJ_COLUMN_NAME);

            // Address Columns
            String street = rs.getString(HealthUnitEntityConstants.STREET_COLUMN_NAME);
            String district = rs.getString(HealthUnitEntityConstants.DISTRICT_COLUMN_NAME);
            String city = rs.getString(HealthUnitEntityConstants.CITY_COLUMN_NAME);
            String postalCode = rs.getString(HealthUnitEntityConstants.POSTAL_CODE_COLUMN_NAME);
            String state = rs.getString(HealthUnitEntityConstants.STATE_COLUMN_NAME);

            Vaccine vaccine = new Vaccine(_id, name, dose, lot, applicationDate);
            Address address = new Address(street, district, city, postalCode, state);
            vaccine.setHeathUnit(new HealthUnit(healthUnitID, type, corporateName, cnpj, address));
            return vaccine;
        }catch (SQLException error) {
            throw new CustomError(VaccineErrorMessages.FAILED_CONVERT_RESULT_SET_TO_VACCINE, error.getMessage());
        }
    }
}

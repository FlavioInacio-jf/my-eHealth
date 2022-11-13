package javas.modules.healthUnit.repositories.implementations;

import javas.config.AppDataSource;
import javas.constants.HealthUnitEntityConstants;
import javas.errors.CustomError;
import javas.exceptions.HealthUnitErrorMessages;
import javas.modules.app.models.Address;
import javas.modules.healthUnit.enums.UnitTypeEnum;
import javas.modules.healthUnit.models.HealthUnit;
import javas.modules.healthUnit.repositories.IHealthUnitRepository;
import javas.modules.person.repositories.IPersonRepository;
import javas.modules.person.repositories.implementations.PersonRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class HealthUnitRepository implements IHealthUnitRepository {
    private final Statement statement;
    private final IPersonRepository personRepository;

    public HealthUnitRepository() {
        this.statement = AppDataSource.execute();
        this.personRepository = new PersonRepository();
    }

    @Override
    public HealthUnit create(HealthUnit data) {
        return this.save(data);
    }

    private HealthUnit save(HealthUnit data) {
        try {
            final String query = String.format("INSERT INTO %s VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                    HealthUnitEntityConstants.ENTITY_NAME,
                    data.getId(), data.getType().toString(),
                    data.getName(),
                    data.getCNPJ(),
                    data.getAddress().getStreet(),
                    data.getAddress().getDistrict(),
                    data.getAddress().getCity(),
                    data.getAddress().getState(),
                    data.getAddress().getPostalCode());
            this.statement.execute(query);
            this.statement.close();
            return data;
        }catch (SQLException error) {
            throw new CustomError(HealthUnitErrorMessages.UNABLE_CREATE_HEALTH_UNIT, error.getMessage());
        }
    }

    @Override
    public boolean update(HealthUnit data) {
        try {
            final String query = String.format("UPDATE %s SET %s='%s', %s='%s', %s='%s', %s='%s', " +
                            "                                 %s='%s', %s='%s', " +
                            "                                 %s='%s', %s='%s',  WHERE _id='%s'",
                    HealthUnitEntityConstants.ENTITY_NAME,
                    HealthUnitEntityConstants.TYPE_COLUMN_NAME,
                    data.getType().toString(),
                    HealthUnitEntityConstants.NAME_COLUMN_NAME,
                    data.getName(),
                    HealthUnitEntityConstants.CNPJ_COLUMN_NAME,
                    data.getCNPJ(),
                    HealthUnitEntityConstants.STREET_COLUMN_NAME,
                    data.getAddress().getStreet(),
                    HealthUnitEntityConstants.DISTRICT_COLUMN_NAME,
                    data.getAddress().getDistrict(),
                    HealthUnitEntityConstants.CITY_COLUMN_NAME,
                    data.getAddress().getCity(),
                    HealthUnitEntityConstants.POSTAL_CODE_COLUMN_NAME,
                    data.getAddress().getPostalCode(),
                    HealthUnitEntityConstants.STATE_COLUMN_NAME,
                    data.getAddress().getState(),
                    data.getId());
            this.statement.executeUpdate(query);
            this.statement.close();
            return true;
        }catch (SQLException error) {
            throw new CustomError(HealthUnitErrorMessages.UNABLE_UPDATE_HEALTH_UNIT, error.getMessage());
        }
    }

    @Override
    public boolean delete(String _id) {
        try {
            final String query = String.format("DELETE FROM %s WHERE %s='%s'", HealthUnitEntityConstants.ENTITY_NAME, HealthUnitEntityConstants.ID_COLUMN_NAME, _id);
            this.statement.execute(query);
            this.statement.close();
            return true;
        }catch (SQLException error) {
            throw new CustomError(HealthUnitErrorMessages.UNABLE_DELETE_HEALTH_UNIT, error.getMessage());
        }
    }

    @Override
    public HealthUnit findByName(String name) {
        return this.findOne(HealthUnitEntityConstants.NAME_COLUMN_NAME, name);
    }

    @Override
    public HealthUnit findByCNPJ(String cnpj) {
        return this.findOne(HealthUnitEntityConstants.CNPJ_COLUMN_NAME, cnpj);
    }

    @Override
    public HealthUnit findById(String _id) {
        return this.findOne(HealthUnitEntityConstants.ID_COLUMN_NAME, _id);
    }

    private HealthUnit findOne(String columnName, String valueColumn) {
        try {
            final String query = String.format("SELECT * FROM %s WHERE %s='%s' LIMIT 1", HealthUnitEntityConstants.ENTITY_NAME, columnName, valueColumn);
            ResultSet rs = this.statement.executeQuery(query);
            while (rs.next()) {
                return this.resultSetToHealthUnit(rs);
            }

            this.statement.close();
        }catch (SQLException error) {
            throw new CustomError(HealthUnitErrorMessages.UNABLE_SEARCH_HEALTH_UNIT, error.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<HealthUnit> getAll() {
        ArrayList<HealthUnit> listHealthUnit = new ArrayList<>();
        try {
            final String query = String.format("SELECT * FROM %s", HealthUnitEntityConstants.ENTITY_NAME);
            ResultSet rs = this.statement.executeQuery(query);
            while (rs.next()) {
                listHealthUnit.add(this.resultSetToHealthUnit(rs));
            }
            this.statement.close();
            return listHealthUnit;
        }catch (SQLException error) {
            throw new CustomError(HealthUnitErrorMessages.UNABLE_SEARCH_HEALTH_UNIT, error.getMessage());
        }
    }

    private  HealthUnit resultSetToHealthUnit(ResultSet rs) {
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

package javas.modules.heathUnit.repositories.implementations;

import javas.config.AppDataSource;
import javas.constants.HealthUnitEntityConstants;
import javas.errors.CustomError;
import javas.exceptions.HealthUnitErrorMessages;
import javas.modules.heathUnit.models.HealthUnit;
import javas.modules.heathUnit.repositories.IHealthUnitRepository;
import javas.util.ResultSetToHealthUnit;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class HealthUnitRepository implements IHealthUnitRepository {
    private Statement repository;

    public HealthUnitRepository() {
        this.repository = AppDataSource.execute();
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
            this.repository.execute(query);
            this.repository.close();
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
            this.repository.executeUpdate(query);
            this.repository.close();
            return true;
        }catch (SQLException error) {
            throw new CustomError(HealthUnitErrorMessages.UNABLE_UPDATE_HEALTH_UNIT, error.getMessage());
        }
    }

    @Override
    public boolean delete(String _id) {
        try {
            final String query = String.format("DELETE FROM %s WHERE %s='%s'", HealthUnitEntityConstants.ENTITY_NAME, HealthUnitEntityConstants.ID_COLUMN_NAME, _id);
            this.repository.execute(query);
            this.repository.close();
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
            ResultSet rs = this.repository.executeQuery(query);
            while (rs.next()) {
                return ResultSetToHealthUnit.convert(rs);
            }
            this.repository.close();
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
            ResultSet rs = this.repository.executeQuery(query);
            while (rs.next()) {
                listHealthUnit.add(ResultSetToHealthUnit.convert(rs));
            }
            this.repository.close();
            return listHealthUnit;
        }catch (SQLException error) {
            throw new CustomError(HealthUnitErrorMessages.UNABLE_SEARCH_HEALTH_UNIT, error.getMessage());
        }
    }
}

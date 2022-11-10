package javas.modules.heathUnit.repositories.implementations;

import javas.config.AppDataSource;
import javas.constants.HeathUnitEntityConstants;
import javas.errors.CustomError;
import javas.exceptions.HeathUnitErrorMessages;
import javas.modules.heathUnit.models.HeathUnit;
import javas.modules.heathUnit.repositories.IHeathUnitsRepository;
import javas.util.ResultSetToHeathUnit;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class HeathUnitsRepository implements IHeathUnitsRepository {
    private Statement repository;

    public HeathUnitsRepository() {
        this.repository = AppDataSource.execute();
    }

    @Override
    public HeathUnit create(HeathUnit data) {
        return this.save(data);
    }

    private HeathUnit save(HeathUnit data) {
        try {
            final String query = String.format("INSERT INTO %s VALUES ('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                    HeathUnitEntityConstants.ENTITY_NAME,
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
            throw new CustomError(HeathUnitErrorMessages.UNABLE_CREATE_HEATH_UNIT, error.getMessage());
        }
    }

    @Override
    public boolean update(HeathUnit data) {
        try {
            final String query = String.format("UPDATE %s SET %s='%s', %s='%s', %s='%s', %s='%s', " +
                            "                                 %s='%s', %s='%s', " +
                            "                                 %s='%s', %s='%s',  WHERE _id='%s'",
                    HeathUnitEntityConstants.ENTITY_NAME,
                    HeathUnitEntityConstants.TYPE_COLUMN_NAME,
                    data.getType().toString(),
                    HeathUnitEntityConstants.NAME_COLUMN_NAME,
                    data.getName(),
                    HeathUnitEntityConstants.CNPJ_COLUMN_NAME,
                    data.getCNPJ(),
                    HeathUnitEntityConstants.STREET_COLUMN_NAME,
                    data.getAddress().getStreet(),
                    HeathUnitEntityConstants.DISTRICT_COLUMN_NAME,
                    data.getAddress().getDistrict(),
                    HeathUnitEntityConstants.CITY_COLUMN_NAME,
                    data.getAddress().getCity(),
                    HeathUnitEntityConstants.POSTAL_CODE_COLUMN_NAME,
                    data.getAddress().getPostalCode(),
                    HeathUnitEntityConstants.STATE_COLUMN_NAME,
                    data.getAddress().getState(),
                    data.getId());
            this.repository.executeUpdate(query);
            this.repository.close();
            return true;
        }catch (SQLException error) {
            throw new CustomError(HeathUnitErrorMessages.UNABLE_UPDATE_HEATH_UNIT, error.getMessage());
        }
    }

    @Override
    public boolean delete(String _id) {
        try {
            final String query = String.format("DELETE FROM %s WHERE %s='%s'", HeathUnitEntityConstants.ENTITY_NAME, HeathUnitEntityConstants.ID_COLUMN_NAME, _id);
            this.repository.execute(query);
            this.repository.close();
            return true;
        }catch (SQLException error) {
            throw new CustomError(HeathUnitErrorMessages.UNABLE_DELETE_HEATH_UNIT, error.getMessage());
        }
    }

    @Override
    public HeathUnit findByName(String name) {
        return this.findOne(HeathUnitEntityConstants.NAME_COLUMN_NAME, name);
    }

    @Override
    public HeathUnit findByCNPJ(String cnpj) {
        return this.findOne(HeathUnitEntityConstants.CNPJ_COLUMN_NAME, cnpj);
    }

    @Override
    public HeathUnit findById(String _id) {
        return this.findOne(HeathUnitEntityConstants.ID_COLUMN_NAME, _id);
    }

    private HeathUnit findOne(String columnName, String valueColumn) {
        try {
            final String query = String.format("SELECT * FROM %s WHERE %s='%s' LIMIT 1", HeathUnitEntityConstants.ENTITY_NAME, columnName, valueColumn);
            ResultSet rs = this.repository.executeQuery(query);
            while (rs.next()) {
                return ResultSetToHeathUnit.convert(rs);
            }
            this.repository.close();
        }catch (SQLException error) {
            throw new CustomError(HeathUnitErrorMessages.UNABLE_SEARCH_HEATH_UNIT, error.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<HeathUnit> getAll() {
        ArrayList<HeathUnit> listHeathUnit = new ArrayList<>();
        try {
            final String query = String.format("SELECT * FROM %s", HeathUnitEntityConstants.ENTITY_NAME);
            ResultSet rs = this.repository.executeQuery(query);
            while (rs.next()) {
                listHeathUnit.add(ResultSetToHeathUnit.convert(rs));
            }
            this.repository.close();
            return listHeathUnit;
        }catch (SQLException error) {
            throw new CustomError(HeathUnitErrorMessages.UNABLE_SEARCH_HEATH_UNIT, error.getMessage());
        }
    }
}

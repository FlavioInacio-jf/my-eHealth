package javas.modules.person.repositories.implementations;

import javas.config.AppDataSource;
import javas.constants.PersonEntityConstants;
import javas.errors.CustomError;
import javas.exceptions.PersonErrorMessages;
import javas.modules.app.models.Address;  //
import javas.modules.person.enums.BloodTypeEnum;
import javas.modules.person.enums.SexEnum;
import javas.modules.person.repositories.IPersonRepository;
import javas.modules.person.models.Person;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PersonRepository implements IPersonRepository {

    private final Statement statement;

    public PersonRepository() {
        this.statement = AppDataSource.execute();
    }
    @Override
    public Person create(Person data) {
        return  this.save(data);
    }

    private Person save(Person data) {
        try {
            final String query = String.format("INSERT INTO %s (%s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s, %s) " +
                                                                "VALUES ('%s', '%s', '%s', '%s', '%s', " +
                                                                "'%s', '%s', '%s', '%s', '%s', '%s', '%s')",
                                                PersonEntityConstants.ENTITY_NAME,
                                                PersonEntityConstants.ID_COLUMN_NAME,
                                                PersonEntityConstants.FIRST_NAME_COLUMN_NAME,
                                                PersonEntityConstants.LAST_NAME_COLUMN_NAME,
                                                PersonEntityConstants.CPF_COLUMN_NAME,
                                                PersonEntityConstants.BLOOD_TYPE_COLUMN_NAME,
                                                PersonEntityConstants.BIRTH_DATE_COLUMN_NAME,
                                                PersonEntityConstants.SEX_COLUMN_NAME,
                                                PersonEntityConstants.STREET_COLUMN_NAME,
                                                PersonEntityConstants.DISTRICT_COLUMN_NAME,
                                                PersonEntityConstants.CITY_COLUMN_NAME,
                                                PersonEntityConstants.POSTAL_CODE_COLUMN_NAME,
                                                PersonEntityConstants.STATE_COLUMN_NAME,
                                                data.getId(), data.getFirstName(),
                                                data.getLastName(), data.getCPF(),
                                                data.getBloodType().getValue(), data.getBirthDate(),
                                                data.getSex().getValue(), data.getAddress().getStreet(),
                                                data.getAddress().getDistrict(), data.getAddress().getCity(),
                                                data.getAddress().getPostalCode(), data.getAddress().getState());
            this.statement.execute(query);
            this.statement.close();
            return data;
        }catch (SQLException error) {
            throw new CustomError(PersonErrorMessages.UNABLE_CREATE_PERSON, error.getMessage());
        }
    }

    @Override
    public boolean update(Person data)  {
        try {
            final String query = String.format("UPDATE %s SET %s='%s', %s='%s', %s='%s', %s='%s', " +
                            "                                 %s='%s', %s='%s', %s='%s', %s='%s', %s='%s'," +
                            "                                 %s='%s',  WHERE %s='%s'",
                                                PersonEntityConstants.ENTITY_NAME,
                                                PersonEntityConstants.FIRST_NAME_COLUMN_NAME,
                                                data.getFirstName(),
                                                PersonEntityConstants.LAST_NAME_COLUMN_NAME,
                                                data.getLastName(),
                                                PersonEntityConstants.BLOOD_TYPE_COLUMN_NAME,
                                                data.getBloodType().getValue(),
                                                PersonEntityConstants.BIRTH_DATE_COLUMN_NAME,
                                                data.getBirthDate(),
                                                PersonEntityConstants.SEX_COLUMN_NAME,
                                                data.getSex().getValue(),
                                                PersonEntityConstants.STREET_COLUMN_NAME,
                                                data.getAddress().getStreet(),
                                                PersonEntityConstants.DISTRICT_COLUMN_NAME,
                                                data.getAddress().getDistrict(),
                                                PersonEntityConstants.CITY_COLUMN_NAME,
                                                data.getAddress().getCity(),
                                                PersonEntityConstants.POSTAL_CODE_COLUMN_NAME,
                                                data.getAddress().getPostalCode(),
                                                PersonEntityConstants.STATE_COLUMN_NAME,
                                                data.getAddress().getState(),
                                                PersonEntityConstants.ID_COLUMN_NAME,
                                                data.getId());
            this.statement.executeUpdate(query);
            this.statement.close();
            return true;
        }catch (SQLException error) {
            throw new CustomError(PersonErrorMessages.UNABLE_UPDATE_PERSON, error.getMessage());
        }
    }

    @Override
    public boolean delete(String _id) {
        try {
            final String query = String.format("DELETE FROM %s WHERE %s='%s'", PersonEntityConstants.ENTITY_NAME, PersonEntityConstants.ID_COLUMN_NAME, _id);
            this.statement.execute(query);
            this.statement.close();
            return true;
        }catch (SQLException error) {
            throw new CustomError(PersonErrorMessages.UNABLE_DELETE_PERSON, error.getMessage());
        }
    }

    @Override
    public Person findById(String _id) {
        return this.findOne(PersonEntityConstants.ID_COLUMN_NAME, _id);
    }

    @Override
    public Person findByCPF(String cpf) {
       return this.findOne(PersonEntityConstants.CPF_COLUMN_NAME, cpf);
    }

    private Person findOne(String columnName, String valueColumn) {
        try {
            final String query = String.format("SELECT * FROM %s WHERE %s='%s' LIMIT 1", PersonEntityConstants.ENTITY_NAME, columnName, valueColumn);
            ResultSet rs = this.statement.executeQuery(query);
            while (rs.next()) {
                return this.resultSetToPerson(rs);
            }
            this.statement.close();
        }catch (SQLException error) {
            throw new CustomError(PersonErrorMessages.UNABLE_SEARCH_PERSON, error.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<Person> getAll() {
        ArrayList<Person> listPeople = new ArrayList<>();
        try {
            final String query = String.format("SELECT * FROM %s", PersonEntityConstants.ENTITY_NAME);
            ResultSet rs = this.statement.executeQuery(query);
            while (rs.next()) {
                listPeople.add(this.resultSetToPerson(rs));
            }
            this.statement.close();
            return listPeople;
        }catch (SQLException error) {
            throw new CustomError(PersonErrorMessages.UNABLE_SEARCH_PERSON, error.getMessage());
        }
    }

    @Override
    public ArrayList<Person> getAll(String querySQL) {
        ArrayList<Person> listPeople = new ArrayList<>();
        try {
            final String query = String.format("SELECT * FROM %s WHERE %s", PersonEntityConstants.ENTITY_NAME, querySQL);
            ResultSet rs = this.statement.executeQuery(query);
            while (rs.next()) {
                listPeople.add(this.resultSetToPerson(rs));
            }
            this.statement.close();
            return listPeople;
        }catch (SQLException error) {
            throw new CustomError(PersonErrorMessages.UNABLE_SEARCH_PERSON, error.getMessage());
        }
    }

    private Person resultSetToPerson(ResultSet rs) {
        try {
            // Person Columns
            String _id = rs.getString(PersonEntityConstants.ID_COLUMN_NAME);

            String firstName = rs.getString(PersonEntityConstants.FIRST_NAME_COLUMN_NAME);
            String lastName = rs.getString(PersonEntityConstants.LAST_NAME_COLUMN_NAME);
            String cpf = rs.getString(PersonEntityConstants.CPF_COLUMN_NAME);
            BloodTypeEnum bloodType = BloodTypeEnum.valueOf(BloodTypeEnum.getEnum(rs.getString(PersonEntityConstants.BLOOD_TYPE_COLUMN_NAME)));
            String birthDate = rs.getString(PersonEntityConstants.BIRTH_DATE_COLUMN_NAME);
            SexEnum sex = SexEnum.valueOf(SexEnum.getEnum(rs.getString(PersonEntityConstants.SEX_COLUMN_NAME)));

            // Address Columns
            String street = rs.getString(PersonEntityConstants.STREET_COLUMN_NAME);
            String district = rs.getString(PersonEntityConstants.DISTRICT_COLUMN_NAME);
            String city = rs.getString(PersonEntityConstants.CITY_COLUMN_NAME);
            String postalCode = rs.getString(PersonEntityConstants.POSTAL_CODE_COLUMN_NAME);
            String state = rs.getString(PersonEntityConstants.STATE_COLUMN_NAME);


            Address address = new Address(street, district, city, state, postalCode);
            return new Person(_id, firstName, lastName, cpf, bloodType, sex, birthDate, address);
        }catch (SQLException error) {

            throw new CustomError(PersonErrorMessages.FAILED_CONVERT_RESULT_SET_TO_PERSON, error.getMessage());
        }
    }
}

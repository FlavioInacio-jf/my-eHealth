package javas.modules.person.repositories.implementations;

import javas.config.AppDataSource;
import javas.constants.PersonEntityConstants;
import javas.exceptions.PersonErrorMessages;
import javas.modules.person.enums.BloodTypeEnum;
import javas.modules.person.repositories.IPersonRepository;
import javas.modules.person.models.Person;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class PersonRepository implements IPersonRepository {

    private Statement repository;

    public PersonRepository() {
        this.repository = AppDataSource.execute();
    }
    @Override
    public Person create(Person data) {
        return  this.save(data);
    }

    private Person save(Person data) {
        try {
            final String query = String.format("INSERT INTO %s VALUES ('%s', '%s', '%s', '%s', '%s', '%s')",
                                                PersonEntityConstants.ENTITY_NAME,
                                                data.getId(), data.getFirstName(),
                                                data.getLastName(), data.getCPF(),
                                                data.getBloodType().toString(), data.getBirthDate());
            this.repository.execute(query);
            this.repository.close();
            return data;
        }catch (SQLException error) {
            JOptionPane.showMessageDialog(null, PersonErrorMessages.UNABLE_CREATE_PERSON);
            return null;
        }
    }

    @Override
    public boolean update(Person data) {
        try {
            final String query = String.format("UPDATE %s SET %s='%s', %s='%s', %s='%s', %s='%s', %s='%s',  WHERE _id='%s'",
                                                PersonEntityConstants.ENTITY_NAME,
                                                PersonEntityConstants.FIRST_NAME_COLUMN_NAME,
                                                data.getFirstName(),
                                                PersonEntityConstants.LAST_NAME_COLUMN_NAME,
                                                data.getLastName(),
                                                PersonEntityConstants.CPF_COLUMN_NAME,
                                                data.getCPF(),
                                                PersonEntityConstants.BLOOD_TYPE_COLUMN_NAME,
                                                data.getBloodType().toString(),
                                                PersonEntityConstants.BIRTH_DATE_COLUMN_NAME,
                                                data.getBirthDate(),
                                                data.getId());
            this.repository.executeUpdate(query);
            this.repository.close();
            return true;
        }catch (SQLException error) {
            JOptionPane.showMessageDialog(null, PersonErrorMessages.UNABLE_UPDATE_PERSON);
            return false;
        }
    }

    @Override
    public boolean delete(String _id) {
        try {
            final String query = String.format("DELETE FROM %s WHERE %s='%s'", PersonEntityConstants.ENTITY_NAME, PersonEntityConstants.ID_COLUMN_NAME, _id);
            this.repository.execute(query);
            this.repository.close();
            return true;
        }catch (SQLException error) {
            JOptionPane.showMessageDialog(null, PersonErrorMessages.UNABLE_DELETE_PERSON);
            return false;
        }
    }

    @Override
    public Person findById(String _id) {
        try {
            final String query = String.format("SELECT * FROM %s WHERE %s='%s' LIMIT 1", PersonEntityConstants.ENTITY_NAME, PersonEntityConstants.ID_COLUMN_NAME, _id);
            ResultSet rs = this.repository.executeQuery(query);
            while (rs.next()) {
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                String cpf = rs.getString(4);
                String bloodType = rs.getString(5);
                String birthDate = rs.getString(6);
                return new Person(rs.getString(1), firstName, lastName, cpf, BloodTypeEnum.valueOf(bloodType), birthDate);
            }
        }catch (SQLException error) {
            JOptionPane.showMessageDialog(null, PersonErrorMessages.UNABLE_SEARCH_PERSON);
            return null;
        }
        return null;
    }

    @Override
    public Person findByCPF(String cpf) {
        try {
            final String query = String.format("SELECT * FROM %s WHERE %s='%s' LIMIT 1", PersonEntityConstants.ENTITY_NAME, PersonEntityConstants.CPF_COLUMN_NAME, cpf);
            ResultSet rs = this.repository.executeQuery(query);
            while (rs.next()) {
                String _id = rs.getString(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                String bloodType = rs.getString(5);
                String birthDate = rs.getString(6);
                return new Person(_id, firstName, lastName, rs.getString(4), BloodTypeEnum.valueOf(bloodType), birthDate);
            }
        }catch (SQLException error) {
            JOptionPane.showMessageDialog(null, PersonErrorMessages.UNABLE_SEARCH_PERSON);
            return null;
        }
        return null;
    }

    @Override
    public ArrayList<Person> findAll() {
        try {
            ArrayList<Person> listPeople = new ArrayList<Person>();
            final String query = String.format("SELECT * FROM %s", PersonEntityConstants.ENTITY_NAME);
            ResultSet rs = this.repository.executeQuery(query);
            while (rs.next()) {
                String _id = rs.getString(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                String cpf = rs.getString(4);
                String bloodType = rs.getString(5);
                String birthDate = rs.getString(6);
                listPeople.add(new Person(_id, firstName, lastName, cpf, BloodTypeEnum.valueOf(bloodType), birthDate));
            }

            return listPeople;
        }catch (SQLException error) {
            JOptionPane.showMessageDialog(null, PersonErrorMessages.UNABLE_SEARCH_PERSON);
            return null;
        }
    }
}

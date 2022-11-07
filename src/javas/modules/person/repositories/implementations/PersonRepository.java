package javas.modules.person.repositories.implementations;

import javas.config.AppDataSource;
import javas.modules.person.enums.BloodType;
import javas.modules.person.repositories.IPersonRepository;
import javas.modules.person.models.Person;

import javax.swing.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
            final String query = String.format("INSERT INTO people VALUES ('%s', '%s', '%s', '%s', '%s', '%s')",
                                                data.getId(), data.getFirstName(),
                                                data.getLastName(), data.getCPF(),
                                                data.getBloodType().toString(), data.getBirthDate());
            this.repository.execute(query);
            this.repository.close();
            return data;
        }catch (SQLException error) {
            JOptionPane.showMessageDialog(null, error.getMessage());
            return null;
        }
    }

    @Override
    public boolean update(Person data) {
        try {
            final String query = String.format("UPDATE people SET firstName='%s', lastName='%s', cpf='%s', bloodType='%s', birthDate='%s',  WHERE _id='%s'",
                                                data.getFirstName(), data.getLastName(), data.getCPF(), data.getBloodType().toString(), data.getBirthDate(), data.getId());
            this.repository.executeUpdate(query);
            this.repository.close();
            return true;
        }catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar o usuário! ");
            return false;
        }
    }

    @Override
    public boolean delete(String _id) {
        try {
            final String query = String.format("DELETE FROM people WHERE _id='%s'", _id);
            this.repository.execute(query);
            this.repository.close();
            return true;
        }catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o usuário! ");
            return false;
        }
    }

    @Override
    public Person findById(String _id) {
        try {
            final String query = String.format("SELECT * FROM people WHERE _id='%s' LIMIT 1", _id);
            ResultSet rs = this.repository.executeQuery(query);
            while (rs.next()) {
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                String cpf = rs.getString(4);
                String bloodType = rs.getString(5);
                String birthDate = rs.getString(6);
                return new Person(rs.getString(1), firstName, lastName, cpf, BloodType.valueOf(bloodType), birthDate);
            }
        }catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o usuário! ");
            return null;
        }
        return null;
    }

    @Override
    public Person findByCPF(String cpf) {
        try {
            final String query = String.format("SELECT * FROM people WHERE cpf='%s' LIMIT 1", cpf);
            ResultSet rs = this.repository.executeQuery(query);
            while (rs.next()) {
                String _id = rs.getString(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                String bloodType = rs.getString(5);
                String birthDate = rs.getString(6);
                return new Person(_id, firstName, lastName, rs.getString(4), BloodType.valueOf(bloodType), birthDate);
            }
        }catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o usuário! ");
            return null;
        }
        return null;
    }

    @Override
    public List<Person> findAll() {
        try {
            ArrayList<Person> listPeople = new ArrayList<Person>();
            final String query = "SELECT * FROM people";
            ResultSet rs = this.repository.executeQuery(query);
            while (rs.next()) {
                String _id = rs.getString(1);
                String firstName = rs.getString(2);
                String lastName = rs.getString(3);
                String cpf = rs.getString(4);
                String bloodType = rs.getString(5);
                String birthDate = rs.getString(6);
                listPeople.add(new Person(_id, firstName, lastName, cpf, BloodType.valueOf(bloodType), birthDate));
            }

            return listPeople;
        }catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar os usuários! ");
            return null;
        }
    }
}

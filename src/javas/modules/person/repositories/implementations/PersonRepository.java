package javas.modules.person.repositories.implementations;

import javas.config.AppDataSource;
import javas.modules.person.repositories.IPersonRepository;
import javas.modules.person.models.Person;

import javax.swing.*;
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
            final String query = String.format("INSERT INTO people VALUES (%s, '%s', '%s', '%s', '%s', %s)",
                                                data.getId(), data.getFirstName(),
                                                data.getLastName(), data.getCPF(),
                                                data.bloodType(), data.getAge());
            this.repository.execute(query);
            this.repository.close();
            return data;
        }catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Não foi possível criar o usuário no banco!");
            return null;
        }
    }

    @Override
    public void update(String _id) {

    }

    @Override
    public void delete(String _id) {
        try {
            final String query = String.format("DELETE FROM people WHERE _id='%s'", _id);
            this.repository.execute(query);
            this.repository.close();
        }catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o usuário! ");
        }
    }

    @Override
    public Person findById(String _id) {
        try {
            final String query = String.format("SELECT * FROM people WHERE _id='%s' LIMIT 1", _id);
            return (Person) this.repository.executeQuery(query);
        }catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o usuário! ");
            return null;
        }
    }

    @Override
    public Person findByCPF(String cpf) {
        try {
            final String query = String.format("SELECT * FROM people WHERE cpf='%s' LIMIT 1", cpf);
            return (Person) this.repository.executeQuery(query);
        }catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar o usuário! ");
            return null;
        }
    }

    @Override
    public ArrayList<Person> findAll() {
        try {
            final String query = "SELECT * FROM people";
            return (ArrayList<Person>) this.repository.executeQuery(query);
        }catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Não foi possível buscar os usuários! ");
            return null;
        }
    }
}

package javas.modules.person.repositories.implementations;

import javas.config.AppDataSource;
import javas.modules.person.repositories.IPersonRepository;
import javas.modules.person.models.Person;

import javax.swing.*;
import java.sql.SQLException;
import java.sql.Statement;

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
            final String query = String.format("DELETE FROM people WHERE _id= '%'", _id);
            this.repository.execute(query);
            this.repository.close();
        }catch (SQLException error) {
            JOptionPane.showMessageDialog(null, "Não foi possível excluir o usuário! ");
        }
    }

    @Override
    public Person findById(String _id) {
        return null;
    }

    @Override
    public Person findByCPF(String cpf) {
        return null;
    }

    @Override
    public Person[] findAll() {
        return new Person[0];
    }
}

package javas.modules.person.repositories;

import javas.modules.person.models.Person;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public interface IPersonRepository {
    public Person create(Person data);
    public boolean update(Person data);
    public boolean delete(String _id);

    public Person findById(String _id);
    public Person findByCPF(String cpf);
    public ArrayList<Person> getAll();
}

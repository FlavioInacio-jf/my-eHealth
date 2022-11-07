package javas.modules.person.repositories;

import javas.modules.person.models.Person;

import java.util.ArrayList;

public interface IPersonRepository {
    public Person create(Person data);
    public void update(String _id);
    public void delete(String _id);
    public Person findById(String _id);
    public Person findByCPF(String cpf);
    public ArrayList<Person> findAll();
}

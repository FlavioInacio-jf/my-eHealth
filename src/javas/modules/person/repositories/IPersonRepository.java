package javas.modules.person.repositories;

import javas.modules.person.models.Person;

import java.util.ArrayList;

public interface IPersonRepository {
     Person create(Person data);
     boolean update(Person data);
     boolean delete(String _id);
     Person findById(String _id);
     Person findByCPF(String cpf);
     ArrayList<Person> getAll();
}

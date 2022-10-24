package java.modules.person.repositories.implementations;

import java.modules.person.models.Person;
import java.modules.person.repositories.IPersonRepository;

public class PersonRepository implements IPersonRepository {
    @Override
    public Person create(Person data) {
        return null;
    }

    @Override
    public void update(String _id) {

    }

    @Override
    public Person delete(String _id) {
        return null;
    }

    @Override
    public Person findById(String _id) {
        return null;
    }

    @Override
    public Person[] findAll() {
        return new Person[0];
    }
}

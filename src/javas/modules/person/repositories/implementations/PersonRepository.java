package javas.modules.person.repositories.implementations;

import javas.modules.person.repositories.IPersonRepository;
import javas.modules.person.models.Person;

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
    public Person findByCPF(String cpf) {
        return null;
    }

    @Override
    public Person[] findAll() {
        return new Person[0];
    }
}

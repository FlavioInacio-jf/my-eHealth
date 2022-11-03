package javas.modules.person.repositories;

import javas.modules.person.models.Person;

public interface IPersonRepository {
    public Person create(Person data);
    public void update(String _id);
    public Person delete(String _id);
    public Person findById(String _id);
    public Person findByCPF(String cpf);
    public Person[] findAll();
}

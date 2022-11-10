package javas.modules.heathUnit.models;

import javas.modules.app.models.Address;
import javas.modules.app.models.ModelBase;
import javas.modules.heathUnit.enums.UnitTypeEnum;
import javas.modules.person.models.Person;

import java.util.ArrayList;
import java.util.Iterator;

public class HeathUnit extends ModelBase {
    private UnitTypeEnum type;
    private String name;
    private Address address;
    private ArrayList<Person> people;
    
    public HeathUnit(
            String _id,
            UnitTypeEnum type,
            String name,
            Address address
        )
        {
        super(_id);
        this.people = new ArrayList<Person>();
        this.type = type;
        this.address = address;
        this.name = name;
    }

    public UnitTypeEnum getType(){
        return this.type;
    }

    public void setType(UnitTypeEnum type){
        this.type = type;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void addPerson(Person person) {
        this.people.add(person);
    }

    public boolean removePerson(String _id) {

        Iterator<Person> it = people.iterator();

        while (it.hasNext()) {
            Person person = it.next();
            if (person.getId() == _id) {
                it.remove();
                return true;
            }
        }

        return false;
    }

    @Override
    public boolean equals(Object object) {
        return true;
    }
}

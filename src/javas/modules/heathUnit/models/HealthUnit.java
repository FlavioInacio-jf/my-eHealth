package javas.modules.heathUnit.models;

import javas.modules.app.models.Address;
import javas.modules.app.models.ModelBase;
import javas.modules.heathUnit.enums.UnitTypeEnum;
import javas.modules.person.models.Person;

import java.util.ArrayList;
import java.util.Iterator;

public class HealthUnit extends ModelBase {
    private UnitTypeEnum type;
    private String name;
    private String cnpj;
    private Address address;
    private ArrayList<Person> people;
    
    public HealthUnit(
            String _id,
            UnitTypeEnum type,
            String name,
            String cnpj,
            Address address
        )
        {
        super(_id);
        this.people = new ArrayList<>();
        this.type = type;
        this.cnpj = cnpj;
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

    public String getCNPJ() {
        return this.cnpj;
    }

    public void setCNPJ(String cnpj) {
        this.cnpj = cnpj;
    }

    public boolean removePerson(String _id) {

        Iterator<Person> it = people.iterator();

        while (it.hasNext()) {
            Person person = it.next();
            if (person.getId().equals(_id)) {
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

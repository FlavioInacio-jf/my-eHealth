package javas.modules.healthUnit.models;

import javas.modules.app.models.Address;
import javas.modules.app.models.ModelBase;
import javas.modules.healthUnit.enums.UnitTypeEnum;
import javas.modules.person.models.Person;
import javas.validations.IsEnum;
import javas.validations.NotEmpty;
import javas.validations.NotNull;
import javas.validations.Validate;

import java.util.ArrayList;
import java.util.Iterator;

public class HealthUnit extends ModelBase {

    @Validate(fieldName = "Tipo")
    @NotNull()
    @IsEnum(enumClass = UnitTypeEnum.class, values = {"hospital", "ubs", "upa"})
    private UnitTypeEnum type;

    @Validate(fieldName = "Nome")
    @NotEmpty()
    private String name;

    @Validate(fieldName = "CNPJ")
    @NotEmpty(regexp = "(^\\d{2}.\\d{3}.\\d{3}/\\d{4}-\\d{2}$)", message = "CNPJ informado é inválido!")
    private String cnpj;

    @Validate(fieldName = "Endereço")
    @NotNull()
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

    public ArrayList<Person> getPeople(){
        return this.people;
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
        if (this == object) {
            return true;
        }
        if (!(object instanceof HealthUnit)) {
            return false;
        }
        HealthUnit objectHealthUnit = (HealthUnit) object;
        
        return  this.type.equals(objectHealthUnit.getType()) &&
                this.people.equals(objectHealthUnit.getPeople()) &&
                this.getId().equals(objectHealthUnit.getId()) &&
                this.name.equals(objectHealthUnit.getName()) &&
                this.cnpj.equals(objectHealthUnit.getCNPJ()) &&
                this.address.equals(objectHealthUnit.getAddress()); 
    }
}
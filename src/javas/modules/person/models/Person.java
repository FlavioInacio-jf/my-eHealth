package javas.modules.person.models;

import javas.modules.app.models.Address;
import javas.modules.app.models.ModelBase;
import javas.modules.person.enums.BloodTypeEnum;
import javas.modules.person.enums.SexEnum;
import javas.modules.vaccine.models.Vaccine;

import java.util.ArrayList;

public class Person extends ModelBase {

    private String firstName;

    private String lastName;

    private String cpf;

    private BloodTypeEnum bloodTypeEnum;

    private SexEnum sex;

    private String birthDate;

    private ArrayList<Vaccine> vaccines;
    private Address address;

    public Person(
            String _id,
            String firstName,
            String lastName,
            String cpf,
            BloodTypeEnum bloodTypeEnum,
            SexEnum sex,
            String birthDate,
            Address address
    ) {
        super(_id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpf = cpf;
        this.bloodTypeEnum = bloodTypeEnum;
        this.birthDate = birthDate;
        this.vaccines = new ArrayList<>();
        this.address = address;
        this.sex = sex;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCPF() {
        return this.cpf;
    }

    public void setCPF(String cpf) {
        this.cpf = cpf;
    }

    public BloodTypeEnum getBloodType() {
        return this.bloodTypeEnum;
    }

    public void setBloodType(BloodTypeEnum bloodTypeEnum) {
        this.bloodTypeEnum = bloodTypeEnum;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public void applyVaccine(Vaccine vaccine) {
        this.vaccines.add(vaccine);
    }

    public ArrayList<Vaccine> getVaccines() {
        return  this.vaccines;
    }

    public Address getAddress() {
        return this.address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public SexEnum getSex() {
        return this.sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Person)) {
            return false;
        }
        Person objectPerson = (Person) object;
        return  getId().equals(objectPerson.getId()) &&
                this.firstName.equals(objectPerson.getFirstName()) &&
                this.lastName.equals(objectPerson.getLastName()) &&
                this.cpf.equals(objectPerson.getCPF()) &&
                this.bloodTypeEnum.equals(objectPerson.getBloodType()) &&
                this.birthDate.equals(objectPerson.getBirthDate());
    }

}

package javas.modules.person.models;

import javas.modules.app.models.ModelBase;
import javas.modules.heathUnit.models.HeathUnit;
import javas.modules.person.enums.BloodType;
import javas.modules.vaccine.models.Vaccine;

import java.util.ArrayList;

public class Person extends ModelBase {

    private String firstName;

    private String lastName;

    private String cpf;

    private BloodType bloodType;

    private String birthDate;

    private ArrayList<Vaccine> vaccines;
    private HeathUnit heathUnit;

    public Person(
            String _id,
            String firstName,
            String lastName,
            String cpf,
            BloodType bloodType,
            String birthDate
    ) {
        super(_id);
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpf = cpf;
        this.bloodType = bloodType;
        this.birthDate = birthDate;
        this.vaccines = new ArrayList<>();
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

    public BloodType getBloodType() {
        return this.bloodType;
    }

    public void setBloodType(BloodType bloodType) {
        this.bloodType = bloodType;
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
                this.bloodType.equals(objectPerson.getBloodType()) &&
                this.birthDate.equals(objectPerson.getBirthDate());

    }

}

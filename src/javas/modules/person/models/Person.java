package javas.modules.person.models;

import javas.modules.person.enums.BloodType;

import java.util.Date;
import java.util.UUID;

public class Person {
    private String _id;
    private String firstName;

    private String lastName;

    private String cpf;
    private BloodType bloodType;
    private String birthDate;

    public Person(
            String _id,
            String firstName,
            String lastName,
            String cpf,
            BloodType bloodType,
            String birthDate
    ) {
        this._id = _id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpf = cpf;
        this.bloodType = bloodType;
        this.birthDate = birthDate;

        if (this._id == null) {
            this._id = UUID.randomUUID().toString();
        }
    }

    public String getId(){
        return this._id;
    }

    public void setId(String _id) {
        this._id = _id;
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

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Person)) {
            return false;
        }
        Person objectPerson = (Person) object;
        return  this._id.equals(objectPerson.getId()) &&
                this.firstName.equals(objectPerson.getFirstName()) &&
                this.lastName.equals(objectPerson.getLastName()) &&
                this.cpf.equals(objectPerson.getCPF()) &&
                this.bloodType.equals(objectPerson.getBloodType()) &&
                this.birthDate.equals(objectPerson.getBirthDate());

    }

    public static  String getQueryTable() {
        return "CREATE TABLE people" +
                "( _id TEXT NOT NULL," +
                "firstName TEXT NOT NULL," +
                "lastName TEXT NOT NULL," +
                "cpf TEXT NOT NULL," +
                "bloodType Text," +
                "birthDate text," +
                "PRIMARY KEY (_id))";
    }

}

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
    private Date birthDate;

    public Person(
            String _id,
            String firstName,
            String lastName,
            String cpf,
            BloodType bloodType,
            Date birthDate
    ) {
        this._id = _id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpf = cpf;
        this.bloodType = bloodType;
        this.birthDate =  birthDate;

        if (this._id == null) {
            this._id = UUID.randomUUID().toString();
        }
    }

    public String getId(){

        return this._id;
    }
    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getCPF() {
        return this.cpf;
    }

    public BloodType bloodType() {
        return this.bloodType;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public String getFullName() {
        return this.firstName + this.lastName;
    }

    public static  String getQueryTable() {
        return "CREATE TABLE people" +
                "( _id TEXT NOT NULL PRIMARY KEY," +
                "firstName TEXT NOT NULL," +
                "lastName TEXT NOT NULL," +
                "cpf TEXT NOT NULL," +
                "bloodType Text," +
                "birthDate DATE )";
    }

}

package javas.modules.person.models;

import javas.modules.person.enums.BloodTypeEnum;

import java.util.UUID;

public class Person {
    private String _id;
    private String firstName;

    private String lastName;

    private String cpf;
    private BloodTypeEnum bloodType;
    private byte age;

    public Person(
            String _id,
            String firstName,
            String lastName,
            String cpf,
            BloodTypeEnum bloodType,
            byte age
    ) {
        this._id = _id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.cpf = cpf;
        this.bloodType = bloodType;
        this.age =  age;

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

    public BloodTypeEnum bloodType() {
        return this.bloodType;
    }

    public byte getAge() {
        return this.age;
    }

    public String getFullName() {
        return this.firstName + this.lastName;
    }

}

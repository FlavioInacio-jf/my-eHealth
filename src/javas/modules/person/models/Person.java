package javas.modules.person.models;

import javas.modules.app.models.Address;
import javas.modules.app.models.ModelBase;
import javas.modules.person.enums.BloodTypeEnum;
import javas.modules.person.enums.SexEnum;
import javas.modules.vaccine.models.Vaccine;
import javas.validations.*;

import java.util.ArrayList;
import java.util.Iterator;

public class Person extends ModelBase {

    @Validate(fieldName = "Primeiro nome")
    @NotEmpty()
    private String firstName;

    @Validate(fieldName = "Último nome")
    @NotEmpty()
    private String lastName;

    @Validate(fieldName = "CPF")
    @NotEmpty()
    private String cpf;

    @Validate(fieldName = "Tipo Sanguíneo")
    @NotNull()
    @IsEnum(enumClass = BloodTypeEnum.class,
            values = {"A", "A+", "A-", "B", "B-", "B+", "AB",
                        "AB+", "AB-", "O", "O-", "O+"}
    )
    private BloodTypeEnum bloodType;

    @Validate(fieldName = "Sexo")
    @NotNull()
    @IsEnum(enumClass = SexEnum.class, values = {"MASCULINO", "FEMININO"})
    private SexEnum sex;

    @Validate(fieldName = "Data de nascimento")
    @NotEmpty()
    private String birthDate;

    private ArrayList<Vaccine> vaccines;

    @Validate(fieldName = "Endereço")
    @NotNull()
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
        this.bloodType = bloodTypeEnum;
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
        return this.bloodType;
    }

    public void setBloodType(BloodTypeEnum bloodTypeEnum) {
        this.bloodType = bloodTypeEnum;
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

    public void applyVaccines(ArrayList<Vaccine> vaccines) {
        Iterator<Vaccine> it = vaccines.iterator();
        while (it.hasNext()) {
            this.applyVaccine(it.next());
        }
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
                this.getCreatedAt().equals(objectPerson.getCreatedAt()) &&
                this.cpf.equals(objectPerson.getCPF()) && this.vaccines.equals(objectPerson.getVaccines()) &&
                this.bloodType.equals(objectPerson.getBloodType()) && this.sex.equals(objectPerson.getSex()) &&
                this.birthDate.equals(objectPerson.getBirthDate()) && this.address.equals(objectPerson.getAddress());
    }

}

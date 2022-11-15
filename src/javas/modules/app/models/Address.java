package javas.modules.app.models;

import javas.validations.NotEmpty;
import javas.validations.Validate;

public class Address {

    @Validate(fieldName = "Rua")
    @NotEmpty()
    private String street;

    @Validate(fieldName = "Bairro")
    @NotEmpty()
    private String district; // bairro

    @Validate(fieldName = "Cidade")
    @NotEmpty()
    private String city;

    @Validate(fieldName = "Estado")
    @NotEmpty()
    private String state;

    @Validate(fieldName = "CEP")
    @NotEmpty(regexp = "[0-9]{5}-[0-9]{3}", message = "CEP informado é inválido!")
    private String postalCode; // CEP

    public Address(
        String street, 
        String district,
        String city,
        String state,
        String postalCode
    ){
        this.street = street;
        this.district = district;
        this.city = city;
        this.state = state;
        this.postalCode = postalCode;
    }

    public String getStreet(){
        return this.street;
    }

    public void setStreet(String street){
        this.street = street;
    }

    public String getDistrict(){
        return this.district;
    }

    public void setDistrict(String district){
        this.district = district;
    }

    public String getCity(){
        return this.city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getState(){
        return this.state;
    }

    public void setState(String state){
        this.state = state;
    }

    public String getPostalCode(){
        return this.postalCode;
    }

    public void setPostalCode(String postalCode){
        this.postalCode = postalCode;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Address)) {
            return false;
        }
        Address objectAddress = (Address) object;
        return  this.street.equals(objectAddress.getStreet()) &&
                this.district.equals(objectAddress.getDistrict()) &&
                this.city.equals(objectAddress.getCity()) &&
                this.state.equals(objectAddress.getState()) &&
                this.postalCode.equals(objectAddress.getPostalCode());
    }

}

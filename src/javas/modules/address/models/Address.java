package javas.modules.address.models;

public class Address {
    private String street;
    private String district; // bairro
    private String city;
    private String state;
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
        return street;
    }

    public void setStreet(String street){
        this.street = street;
    }

    public String getDistrict(){
        return district;
    }

    public void setDistrict(String district){
        this.district = district;
    }

    public String getCity(){
        return city;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getEstado(){
        return state;
    }

    public void setEstado(String state){
        this.state = state;
    }

    public String getPostalCode(){
        return postalCode;
    }

    public void setPostalCode(String postalCode){
        this.postalCode = postalCode;
    }

}
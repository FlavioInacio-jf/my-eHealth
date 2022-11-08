package javas.modules.address.models;

public class Address {
    private String Street;
    private String District; // bairro
    private String City;
    private String Municipio;
    private String Estado;
    private int CEP;

    public Address(
    String Street,
    String District, 
    String City, 
    String Municipio, 
    String Estado, 
    int CEP
    ){
        this.Street = Street;
        this.District = District;
        this.City = City;
        this.Municipio = Municipio;
        this.Estado = Estado;
        this.CEP = CEP;
    }

    public String getStreet(){
        return Street;
    }

    public void setStreet(String street){
        this.Street = street;
    }

    public String getDistrict(){
        return District;
    }

    public void setDistrict(String district){
        this.District = district;
    }

    public String getCity(){
        return City;
    }

    public void setCity(String city){
        this.City = city;
    }

    public String getMunicipio(){
        return Municipio;
    }

    public void setMunicipio(String municipio){
        this.Municipio = municipio;
    }

    public String getEstado(){
        return Estado;
    }

    public void setEstado(String estado){
        this.Estado = estado;
    }

    public int getCep(int cep){
        return cep;
    }

    public void setCep(int cep){
        this.CEP = cep;
    }

    public void printAddress(){
        System.out.println("------------------------");
        System.out.println("Estado: " + Estado);
        System.out.println("Municipio : " + Municipio);
        System.out.println("Cidade: " + City);
        System.out.println("Bairro: " + District);
        System.out.println("Rua: " + Street);
        System.out.println("CEP: " + CEP );
        System.out.println("------------------------");
    }
}
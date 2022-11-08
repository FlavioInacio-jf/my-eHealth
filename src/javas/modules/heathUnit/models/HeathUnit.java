package javas.modules.heathUnit.models;

import javas.modules.address.models.Address;

public class HeathUnit extends Address{
    private String type;
    private String name;
    private String contactNumber;
    
    public HeathUnit(
        String type, 
        String Name, 
        String ContactNumber,
        String Street,
        String District, 
        String City, 
        String Municipio, 
        String Estado, 
        int CEP
        )
        {
        super(Street, District, City, Municipio, Estado, CEP);
        this.type = type;
        this.name = Name;
        this.contactNumber = ContactNumber;
    }

    public String getType(){
        return type;
    }

    public void setType(String Type){
        type = Type;
    }

    public String getName(){
        return name;
    }

    public void setName(String Name){
        name = Name;
    }

    public String getContactNumber(){
        return contactNumber;
    }

    public void setContactNumber(String ContactNumber){
        contactNumber = ContactNumber;
    }
}

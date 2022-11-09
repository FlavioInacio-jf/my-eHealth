package javas.modules.heathUnit.models;

import javas.modules.address.models.Address;

public class HeathUnit extends Address{
    private Enum type;
    private String name;
    private String contactNumber;
    
    public HeathUnit(
        Enum type, 
        String name, 
        String contactNumber,
        String street,
        String district, 
        String city, 
        String state, 
        String postalCode
        )
        {
        super(street, district, city, state, postalCode);
        this.type = type;
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public Enum getType(){
        return type;
    }

    public void setType(Enum Type){
        type = Type;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        name = name;
    }

    public String getContactNumber(){
        return contactNumber;
    }

    public void setContactNumber(String contactNumber){
        contactNumber = contactNumber;
    }
}

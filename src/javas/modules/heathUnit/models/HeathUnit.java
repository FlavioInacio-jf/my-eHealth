package javas.modules.heathUnit.models;

import javas.modules.address.models.Address;
import javas.modules.heathUnit.enums.UnitTypeEnum;

public class HeathUnit extends Address{
    private UnitTypeEnum type;
    private String name;
    
    public HeathUnit(
        UnitTypeEnum type, 
        String name,
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
    }

    public UnitTypeEnum getType(){
        return type;
    }

    public void setType(UnitTypeEnum type){
        this.type = type;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

}

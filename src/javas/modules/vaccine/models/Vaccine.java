package javas.modules.vaccine.models;

import javas.modules.heathUnit.models.HeathUnit;
import javas.modules.heathUnit.enums.UnitTypeEnum;

import java.util.UUID;

public class Vaccine extends HeathUnit{
    private String _id;
    private String name;
    private String date;
    private int dose;
    private String lot;
    private String uf;

    public Vaccine(
             String _id,
             String name,
             String date,
             int dose,
             String lot,
             String uf,
             UnitTypeEnum type,
             String contactNumber,
             String street,
             String district,
             String city,
             String state,
             String postalCode
    ){
         super(type, name, contactNumber, street, district, city, state, postalCode);
         this.name = name;
         this.date = date;
         this.dose = dose;
         this.lot = lot;
         this.uf = uf;
         this._id = _id;
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

    public String getName(){
        return name;
    }

    public void setName(String Name){
        this.name = Name;
    }

    public String getDate(){
        return this.date;
    }

    public void setDate(String date){
        this.date = date;
    }

    public int getDose(){
        return this.dose;
    }

    public void setDose(int dose){
        this.dose = dose;
    }

    public String getLot(){
        return this.lot;
    }

    public void setLot(String lot){
        this.lot = lot;
    }
}

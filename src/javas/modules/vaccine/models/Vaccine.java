package javas.modules.vaccine.models;

import javas.modules.app.models.ModelBase;
import javas.modules.heathUnit.models.HeathUnit;

public class Vaccine extends ModelBase {
    private String name;
    private String date;
    private int dose;
    private String lot;
    private String uf;
    private HeathUnit heathUnit;

    public Vaccine(
             String _id,
             String name,
             String date,
             int dose,
             String lot,
             String uf
    ){
         super(_id);
         this.name = name;
         this.date = date;
         this.dose = dose;
         this.lot = lot;
         this.uf = uf;
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

    public HeathUnit getHeathUnit() {
        return this.heathUnit;
    }
    public void setHeathUnit(HeathUnit heathUnit) {
        this.heathUnit = heathUnit;
    }
}

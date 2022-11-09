package javas.modules.vaccine.models;

import javas.modules.app.models.ModelBase;
import javas.modules.heathUnit.models.HeathUnit;
import javas.modules.person.models.Person;

public class Vaccine extends ModelBase {
    private String name;
    private String date;
    private int dose;
    private String lot;
    private HeathUnit heathUnit;

    public Vaccine(
             String _id,
             String name,
             String date,
             int dose,
             String lot
    ){
         super(_id);
         this.name = name;
         this.date = date;
         this.dose = dose;
         this.lot = lot;
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

    @Override
    public boolean equals(Object object) {
       return true;
    }
}

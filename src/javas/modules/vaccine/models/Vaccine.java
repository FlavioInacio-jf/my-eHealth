package javas.modules.vaccine.models;

import javas.modules.heathUnit.models.HeathUnit;

public class Vaccine extends HeathUnit{
    private String name;
    private String date;
    private int dose;
    private String lote;
    private String uf;

    public Vaccine(
     String name, 
     String date, 
     int dose,
     String lote,
     String uf,
     Enum type,  
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
     this.lote = lote;
     this.uf = uf;
    }

    public String getName(){
        return name;
    }

    public void setName(String Name){
        this.name = Name;
    }

    public String getDate(){
        return date;
    };

    public void setDate(String Date){
        this.date = Date;
    };

    public int getDose(){
        return dose;
    }

    public void setDose(int Dose){
        this.dose = Dose;
    }

    public String getLote(){
        return lote;
    }

    public void setLote(String Lote){
        this.lote = Lote;
    }

    private String getUf(){
        return uf;
    };

    private void setUF(String uf){
        this.uf = uf;
    }
}

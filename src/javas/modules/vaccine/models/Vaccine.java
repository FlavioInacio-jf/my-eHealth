package javas.modules.vaccine.models;

import javas.modules.heathUnit.models.HeathUnit;

public class Vaccine extends HeathUnit{
    private String name;
    private String date;
    private int dose;
    private String lote;
    private String UF;

    public Vaccine(
     String name, 
     String date, 
     int dose,
     String lote,
     String UF,
     String type, 
     String Name, 
     String ContactNumber,
     String Street,
     String District, 
     String  Municipio,
     String City, 
     String Estado, 
     int CEP
    ){
     super(type, Name, ContactNumber, Street, District, Municipio, City, Estado, CEP);
     this.name = name;
     this.date = date;
     this.dose = dose;
     this.lote = lote;
     this.UF = UF;
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

    private String getUF(){
        return UF;
    };

    private void setUF(String Uf){
        this.UF = Uf;
    }
}

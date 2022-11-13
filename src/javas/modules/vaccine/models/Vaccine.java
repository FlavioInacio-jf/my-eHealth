package javas.modules.vaccine.models;

import javas.modules.app.models.ModelBase;
import javas.modules.healthUnit.models.HealthUnit;
import javas.validations.NotEmpty;
import javas.validations.NotNull;
import javas.validations.NumericOnly;
import javas.validations.Validate;

public class Vaccine extends ModelBase {

    @Validate(fieldName = "Nome")
    @NotNull()
    @NotEmpty()
    private String name;

    @Validate(fieldName = "Dose")
    @NotNull()
    @NumericOnly()
    private int dose;

    @Validate(fieldName = "Lote")
    @NotEmpty()
    private String lot;
    private HealthUnit healthUnit;

    public Vaccine(
             String _id,
             String name,
             int dose,
             String lot
    ){
         super(_id);
         this.name = name;
         this.dose = dose;
         this.lot = lot;
    }

    public String getName(){
        return name;
    }

    public void setName(String Name){
        this.name = Name;
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

    public HealthUnit getHeathUnit() {
        return this.healthUnit;
    }
    public void setHeathUnit(HealthUnit healthUnit) {
        this.healthUnit = healthUnit;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Vaccine objectVaccine)) {
            return false;
        }
        return getId().equals(objectVaccine.getId()) && this.name.equals(objectVaccine.getName()) && this.getCreatedAt().equals(objectVaccine.getCreatedAt()) && this.getDose() == objectVaccine.getDose() && this.lot.equals(objectVaccine.getLot()) && this.healthUnit.equals(objectVaccine.getHeathUnit());
    }
}

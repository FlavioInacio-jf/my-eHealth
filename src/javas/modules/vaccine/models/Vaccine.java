package javas.modules.vaccine.models;

import javas.modules.app.models.ModelBase;
import javas.modules.healthUnit.models.HealthUnit;
import javas.modules.vaccine.enums.VaccineName;
import javas.validations.*;


public class Vaccine extends ModelBase {

    @Validate(fieldName = "Nome")
    @NotNull()
    @IsEnum(enumClass = VaccineName.class, values = {"Astrazeneca/Oxford",
                                                     "Pfizer BioNTech (RNA)",
                                                     "Janssen", "CoronaVac",
                                                     "Sputnik V", "Covaxin"})
    private VaccineName name;

    @Validate(fieldName = "Dose")
    @NumericOnly()
    private int dose;

    @Validate(fieldName = "Data")
    @NotEmpty(regexp = "^(1[0-2]|0[1-9])/(3[01]"
            + "|[12][0-9]|0[1-9])/[0-9]{4}$", message = "Data da aplicação da vacina informada é inválida!")
    private String applicationDate;

    @Validate(fieldName = "Lote")
    @NotEmpty()
    private String lot;
    private HealthUnit healthUnit;

    public Vaccine(
             String _id,
             VaccineName name,
             int dose,
             String lot,
             String applicationDate
    ){
         super(_id);
         this.name = name;
         this.dose = dose;
         this.lot = lot;
         this.applicationDate = applicationDate;
    }

    public VaccineName getName(){
        return name;
    }

    public void setName(VaccineName Name){
        this.name = Name;
    }

    public int getDose(){
        return this.dose;
    }
    public void setDose(int dose){
        this.dose = dose;
    }

    public void setApplicationDate(String applicationDate){
        this.applicationDate = applicationDate;
    }

    public String getApplicationDate(){
        return this.applicationDate;
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
        return getId().equals(objectVaccine.getId()) &&
                this.name.equals(objectVaccine.getName()) &&
                this.getApplicationDate().equals(objectVaccine.getApplicationDate()) &&
                this.getDose() == objectVaccine.getDose() &&
                this.lot.equals(objectVaccine.getLot()) &&
                this.healthUnit.equals(objectVaccine.getHeathUnit());
    }
}

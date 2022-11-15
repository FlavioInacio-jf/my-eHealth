package javas.modules.vaccine.enums;

import javas.exceptions.VaccineErrorMessages;

import java.util.Arrays;

public enum VaccineName {
    ASTRAZENECA("Astrazeneca/Oxford"),
    PFIZER("Pfizer BioNTech (RNA)"),
    JANSSEN("Janssen"),
    CORONAVAC("CoronaVac"),
    SPUTNIK("Sputnik V"),
    COVAXIN("Covaxin");

    private final String name;
    VaccineName(String name) {
        this.name = name;
    }

    public static String[] getNames() {
        String valuesStr = Arrays.toString(VaccineName.values());
        return valuesStr.substring(1, valuesStr.length()-1).replace(" ", "").split(",");
    }

    @Override
    public String toString() {
        return this.name;
    }


    public String getValue() {
        return this.name;
    }

    public static String getEnum(String value) {
        for(VaccineName item : values())
            if(item.getValue().equalsIgnoreCase(value)) return item.name();
        throw new IllegalArgumentException(VaccineErrorMessages.VACCINE_NAME_INVALID);
    }
}

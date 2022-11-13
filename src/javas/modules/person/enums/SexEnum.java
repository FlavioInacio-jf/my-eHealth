package javas.modules.person.enums;

import javas.exceptions.PersonErrorMessages;

import java.util.Arrays;

public enum SexEnum {
    MALE("MASCULINO"),
    FEMALE("FEMININO");

    private String name;
    SexEnum(String name) {
        this.name = name;
    }

    public static String[] getNames() {
        String valuesStr = Arrays.toString(SexEnum.values());
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
        for(SexEnum item : values())
            if(item.getValue().equalsIgnoreCase(value)) return item.name();
        throw new IllegalArgumentException(PersonErrorMessages.SEX_INVALID);
    }
}

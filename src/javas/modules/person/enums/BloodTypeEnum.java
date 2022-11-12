package javas.modules.person.enums;

import javas.exceptions.PersonErrorMessages;

import java.util.Arrays;

public enum BloodTypeEnum {
    A("A"), A_PLUS("A+"), A_LESS("A-"),
    B("B"), B_PLUS("B+"), B_LESS("B-"),
    AB("AB"), AB_PLUS("AB+"), AB_LESS("AB-"),
    O("O"), O_PLUS("O+"), O_LESS("O-");

    private String name;
    BloodTypeEnum(String name) {
        this.name = name;
    }

    public static String[] getNames() {
        String valuesStr = Arrays.toString(BloodTypeEnum.values());
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
        for(BloodTypeEnum item : values())
            if(item.getValue().equalsIgnoreCase(value)) return item.name();
        throw new IllegalArgumentException(PersonErrorMessages.BLOOD_TYPE_INVALID);
    }
}

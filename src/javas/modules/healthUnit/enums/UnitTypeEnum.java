package javas.modules.healthUnit.enums;

import javas.exceptions.HealthUnitErrorMessages;

import java.util.Arrays;

public enum UnitTypeEnum {

    HOSPITAL("hospital"), UBS("ubs"), UPA("upa");

    private String type;
    UnitTypeEnum(String type) {
        this.type = type;
    }

    public static String[] getNames() {
        String valuesStr = Arrays.toString(UnitTypeEnum.values());
        return valuesStr.substring(1, valuesStr.length()-1).replace(" ", "").split(",");
    }
    @Override
    public String toString() {
        return this.type;
    }

    public String getValue() {
        return this.type;
    }

    public static String getEnum(String value) {
        for(UnitTypeEnum item : values())
            if(item.getValue().equalsIgnoreCase(value)) return item.name();
        throw new IllegalArgumentException(HealthUnitErrorMessages.HEALTH_UNIT_TYPE_INVALID);
    }

}

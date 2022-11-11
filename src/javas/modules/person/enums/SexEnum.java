package javas.modules.person.enums;

import java.util.Arrays;

public enum SexEnum {
    MALE{
        @Override
        public String toString() {
            return "masculino";
        }
    }, FEMALE{
        @Override
        public String toString() {
            return "feminino";
        }
    };

    public static String[] getNames() {
        String valuesStr = Arrays.toString(SexEnum.values());
        return valuesStr.substring(1, valuesStr.length()-1).replace(" ", "").split(",");
    }
}

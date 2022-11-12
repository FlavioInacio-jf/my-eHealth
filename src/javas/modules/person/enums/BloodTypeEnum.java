package javas.modules.person.enums;

import java.util.Arrays;

public enum BloodTypeEnum {
    A{
        @Override
        public String toString() {
            return "a";
        }
    }, A_PLUS{
        @Override
        public String toString() {
            return "a+";
        }
    }, A_LESS{
        @Override
        public String toString() {
            return "a-";
        }
    }, B{
        @Override
        public String toString() {
            return "b";
        }
    }, B_PLUS{
        @Override
        public String toString() {
            return "b+";
        }
    }, B_LESS{
        @Override
        public String toString() {
            return "a-";
        }
    }, AB{
        @Override
        public String toString() {
            return "ab";
        }
    }, AB_PLUS{
        @Override
        public String toString() {
            return "ab+";
        }
    }, AB_LESS{
        @Override
        public String toString() {
            return "ab-";
        }
    }, O{
        @Override
        public String toString() {
            return "o";
        }
    }, O_PLUS{
        @Override
        public String toString() {
            return "o+";
        }
    }, O_LESS{
        @Override
        public String toString() {
            return "o-";
        }
    };

    public static String[] getNames() {
        String valuesStr = Arrays.toString(BloodTypeEnum.values());
        return valuesStr.substring(1, valuesStr.length()-1).replace(" ", "").split(",");
    }

}

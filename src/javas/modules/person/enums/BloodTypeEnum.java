package javas.modules.person.enums;

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
    }
}

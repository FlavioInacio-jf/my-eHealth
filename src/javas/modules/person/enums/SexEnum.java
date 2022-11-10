package javas.modules.person.enums;

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
    }
}

package javas.modules.healthUnit.enums;

public enum UnitTypeEnum {
    HOSPITAL{
        @Override
        public String toString() {
            return "hospital";
        }
    }, UBS {
        @Override
        public String toString() {
            return "ubs";
        }
    }, UPA {
       @Override
       public String toString() {
           return "upa";
       }
    };
}

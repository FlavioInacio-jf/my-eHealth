package javas.constants;

public class VaccineEntityConstants {
    public static final String ENTITY_NAME = "vaccines";
    public static final String ID_COLUMN_NAME = "_id";
    public static final String NAME_COLUMN_NAME = "name";
    public static final String DATE_COLUMN_NAME = "date";
    public static final String DOSE_COLUMN_NAME = "dose";
    public static final String LOT_COLUMN_NAME = "lot";

    public static final String HEATH_UNIT_COLUMN_NAME_FK = "heathUnitID";
    public static final String PERSON_COLUMN_NAME_FK = "personID";

    public static  String getQueryTable() {
        return String.format("CREATE TABLE IF NOT EXISTS %s ", ENTITY_NAME) +
                String.format("( %s TEXT NOT NULL,", ID_COLUMN_NAME) +
                String.format("%s TEXT NOT NULL,", NAME_COLUMN_NAME) +
                String.format("%s TEXT NOT NULL,", DATE_COLUMN_NAME) +
                String.format("%s INT NOT NULL,", DOSE_COLUMN_NAME) +
                String.format("%s TEXT NOT NULL,", LOT_COLUMN_NAME) +
                String.format("%s TEXT NOT NULL,", HEATH_UNIT_COLUMN_NAME_FK) +
                String.format("%s TEXT NOT NULL,", PERSON_COLUMN_NAME_FK) +
                String.format("PRIMARY KEY (%s)", ID_COLUMN_NAME) +
                String.format("FOREIGN KEY (%s) REFERENCES %s(%s)",
                        HEATH_UNIT_COLUMN_NAME_FK,
                        HealthUnitEntityConstants.ENTITY_NAME,
                        HealthUnitEntityConstants.ID_COLUMN_NAME) +
                String.format("FOREIGN KEY (%s) REFERENCES %s(%s))",
                        PERSON_COLUMN_NAME_FK,
                        PersonEntityConstants.ENTITY_NAME,
                        PersonEntityConstants.ID_COLUMN_NAME);
    }
}

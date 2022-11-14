package javas.constants;

public class VaccineEntityConstants {
    public static final String ENTITY_NAME = "vaccines";
    public static final String ID_COLUMN_NAME = "_id";
    public static final String NAME_COLUMN_NAME = "name";
    public static final String DOSE_COLUMN_NAME = "dose";
    public static final String LOT_COLUMN_NAME = "lot";
    public static final String APPLICATION_DATE_COLUMN_NAME = "applicationDate";

    public static final String HEATH_UNIT_COLUMN_NAME_FK = "heathUnitID";
    public static final String PERSON_COLUMN_NAME_FK = "personID";
    public static final String CREATED_AT_COLUMN_NAME = "createdAd";
    public static final String[] VALID_DOSES = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};

    public static  String getQueryTable() {
        return String.format("CREATE TABLE IF NOT EXISTS %s ", ENTITY_NAME) +
                String.format("( %s VARCHAR NOT NULL,", ID_COLUMN_NAME) +
                String.format("%s VARCHAR NOT NULL,", NAME_COLUMN_NAME) +
                String.format("%s VARCHAR NOT NULL,", DOSE_COLUMN_NAME) +
                String.format("%s VARCHAR NOT NULL,", LOT_COLUMN_NAME) +
                String.format("%s VARCHAR NOT NULL,", APPLICATION_DATE_COLUMN_NAME) +
                String.format("%s VARCHAR NOT NULL,", HEATH_UNIT_COLUMN_NAME_FK) +
                String.format("%s VARCHAR NOT NULL,", PERSON_COLUMN_NAME_FK) +
                String.format("%s TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,", CREATED_AT_COLUMN_NAME) +
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

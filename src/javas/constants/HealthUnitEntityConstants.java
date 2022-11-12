package javas.constants;

public class HealthUnitEntityConstants {
    public static final String ENTITY_NAME = "healthUnits";
    public static final String ID_COLUMN_NAME = "_id";
    public static final String NAME_COLUMN_NAME = "name";
    public static final String CNPJ_COLUMN_NAME = "cnpj";
    public static final String TYPE_COLUMN_NAME = "type";
    public static final String STREET_COLUMN_NAME = "street";
    public static final String DISTRICT_COLUMN_NAME = "district";
    public static final String CITY_COLUMN_NAME = "city";
    public static final String STATE_COLUMN_NAME = "uf";
    public static final String POSTAL_CODE_COLUMN_NAME = "postalCode";

    public static  String getQueryTable() {
        return String.format("CREATE TABLE IF NOT EXISTS %s ", ENTITY_NAME) +
                String.format("( %s TEXT NOT NULL,", ID_COLUMN_NAME) +
                String.format("%s TEXT NOT NULL,", NAME_COLUMN_NAME) +
                String.format("%s TEXT NOT NULL,", TYPE_COLUMN_NAME) +
                String.format("%s TEXT NOT NULL,", STREET_COLUMN_NAME) +
                String.format("%s TEXT NOT NULL,", DISTRICT_COLUMN_NAME) +
                String.format("%s TEXT NOT NULL,", CITY_COLUMN_NAME) +
                String.format("%s TEXT NOT NULL,", POSTAL_CODE_COLUMN_NAME) +
                String.format("%s TEXT NOT NULL,", STATE_COLUMN_NAME) +
                String.format("PRIMARY KEY (%s))", ID_COLUMN_NAME);
    }
}

package javas.constants;

public class PersonEntityConstants {
    public static final String ENTITY_NAME = "people";
    public static final String ID_COLUMN_NAME = "_id";
    public static final String FIRST_NAME_COLUMN_NAME = "firstName";
    public static final String LAST_NAME_COLUMN_NAME = "lastName";
    public static final String CPF_COLUMN_NAME = "cpf";
    public static final String BLOOD_TYPE_COLUMN_NAME = "bloodType";
    public static final String SEX_COLUMN_NAME = "sex";
    public static final String STREET_COLUMN_NAME = "street";
    public static final String DISTRICT_COLUMN_NAME = "district";
    public static final String CITY_COLUMN_NAME = "city";

    public static final String STATE_COLUMN_NAME = "uf";
    public static final String POSTAL_CODE_COLUMN_NAME = "postalCode";
    public static final String BIRTH_DATE_COLUMN_NAME = "birthDate";


    public static  String getQueryTable() {
        return String.format("CREATE TABLE IF NOT EXISTS %s ", ENTITY_NAME) +
                String.format("( %s TEXT NOT NULL,", ID_COLUMN_NAME) +
                String.format("%s TEXT NOT NULL,", FIRST_NAME_COLUMN_NAME) +
                String.format("%s TEXT NOT NULL,", LAST_NAME_COLUMN_NAME) +
                String.format("%s TEXT NOT NULL UNIQUE,", CPF_COLUMN_NAME) +
                String.format("%s TEXT NOT NULL,", BLOOD_TYPE_COLUMN_NAME) +
                String.format("%s TEXT NOT NULL,", BIRTH_DATE_COLUMN_NAME) +
                String.format("%s TEXT NOT NULL,", SEX_COLUMN_NAME) +
                String.format("%s TEXT NOT NULL,", STREET_COLUMN_NAME) +
                String.format("%s TEXT NOT NULL,", DISTRICT_COLUMN_NAME) +
                String.format("%s TEXT NOT NULL,", CITY_COLUMN_NAME) +
                String.format("%s TEXT NOT NULL,", POSTAL_CODE_COLUMN_NAME) +
                String.format("%s TEXT NOT NULL,", STATE_COLUMN_NAME) +
                String.format("PRIMARY KEY (%s))", ID_COLUMN_NAME);
    }
}

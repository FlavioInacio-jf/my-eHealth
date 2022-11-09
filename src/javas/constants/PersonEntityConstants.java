package javas.constants;

public class PersonEntityConstants {
    public static final String ENTITY_NAME = "people";
    public static final String ID_COLUMN_NAME = "_id";
    public static final String FIRST_NAME_COLUMN_NAME = "firstName";
    public static final String LAST_NAME_COLUMN_NAME = "lastName";
    public static final String CPF_COLUMN_NAME = "cpf";
    public static final String BLOOD_TYPE_COLUMN_NAME = "bloodType";
    public static final String BIRTH_DATE_COLUMN_NAME = "birthDate";

    public static  String getQueryTable() {
        return String.format("CREATE TABLE %s ", ENTITY_NAME) +
                String.format("( %s TEXT NOT NULL,", ID_COLUMN_NAME) +
                String.format("%s TEXT NOT NULL,", FIRST_NAME_COLUMN_NAME) +
                String.format("%s TEXT NOT NULL,", LAST_NAME_COLUMN_NAME) +
                String.format("%s TEXT NOT NULL,", CPF_COLUMN_NAME) +
                String.format("%s Text,", BLOOD_TYPE_COLUMN_NAME) +
                String.format("%s text,", BIRTH_DATE_COLUMN_NAME) +
                String.format("PRIMARY KEY (%s))", ID_COLUMN_NAME);
    }
}

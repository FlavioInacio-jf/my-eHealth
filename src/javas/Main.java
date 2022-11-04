package javas;

import javas.config.AppDataSource;
import javas.modules.person.models.Person;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        AppDataSource.connect();
        ArrayList<String> tables = new ArrayList<String>();
        tables.add(Person.getQueryTable());
        AppDataSource.init(tables);
    }
}
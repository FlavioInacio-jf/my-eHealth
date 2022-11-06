package javas;

import javas.config.AppDataSource;
import javas.modules.person.models.Person;
import javas.view.MainView;
import javas.view.PersonRegistrationView;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // AppDataSource.connect();
        // ArrayList<String> tables = new ArrayList<String>();
        // tables.add(Person.getQueryTable());
        // AppDataSource.init(tables);

        MainView view = new MainView();
    }
}
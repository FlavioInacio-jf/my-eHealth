package javas;

import javas.config.AppDataSource;

public class Main {
    public static void main(String[] args) {
        AppDataSource.connect();
        //ArrayList<String> tables = new ArrayList<String>();
        //tables.add(Person.getQueryTable());
        //AppDataSource.init(tables);

        // PersonRegistrationView view = new PersonRegistrationView();
    }
}
package javas.views.components;

import javas.modules.person.models.Person;

import javax.swing.*;
import java.sql.Array;
import java.util.ArrayList;

public class TablePerson extends JTable {
    String [] columns;
    public TablePerson(ArrayList<Person> data) {

        super();
    }

    private void init() {
    }
}

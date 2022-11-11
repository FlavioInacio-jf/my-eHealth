package javas.views;

import javas.constants.ViewConstants;
import javas.views.components.BaseFrame;
import javas.views.components.TabbedPane;
import javas.views.healthUnitViews.HealthUnitView;
import javas.views.personViews.PersonView;

import javax.swing.*;
import java.awt.*;

public class MainView extends BaseFrame {
    public MainView() {
        this.init();
    }

    // AppDataSource.connect();
    //ArrayList<String> tables = new ArrayList<String>();
    //tables.add(Person.getQueryTable());
    //AppDataSource.init(tables);

    // PersonRegistrationView view = new PersonRegistrationView();
    private void init() {
        this.setTitle(ViewConstants.MAIN_VIEW_TITLE);

        // Content panel layout
        Container contentPane = this.getContentPane();
        contentPane.setLayout(new BorderLayout());

        // MenuBar
        JMenuBar menuBar = new JMenuBar();
        JMenu about = new JMenu("Sobre");
        menuBar.add(about);

        // Tabbed Panel
        TabbedPane tabbedPane = new TabbedPane();

        tabbedPane.addTab("Paciente",null, new PersonView(), "Ações do paciente");
        tabbedPane.addTab("Unidade de Saúde", null, new HealthUnitView(), "Ações da Unidade de Saúde");
        tabbedPane.addTab("Configurações", null, new GeneralSettings(), "Configurações do banco de dados");


        this.setJMenuBar(menuBar);
        contentPane.add(tabbedPane);

    }
}

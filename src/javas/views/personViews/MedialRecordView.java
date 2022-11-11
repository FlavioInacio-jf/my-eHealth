package javas.views.personViews;

import javas.modules.app.models.Address;
import javas.modules.person.enums.BloodTypeEnum;
import javas.modules.person.enums.SexEnum;
import javas.modules.person.models.Person;
import javas.modules.vaccine.models.Vaccine;
import javas.views.components.BaseFrame;
import javas.views.components.Label;
import javas.views.components.LabelGroup;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

public class MedialRecordView extends BaseFrame {
    public MedialRecordView (Person person) {
        this.init(person);
    }

    public void init(Person person) {
        this.setTitle(person.getFullName());

        JPanel contentPane = (JPanel) this.getContentPane();
        contentPane.setBorder(new EmptyBorder(20, 20, 20, 20));
        contentPane.setLayout(new BorderLayout());

        JPanel informationPanel = new JPanel();
        informationPanel.setLayout(new GridLayout(10, 1));
        LabelGroup labelGroupFirstName = new LabelGroup("Primeiro nome:", person.getFirstName());
        LabelGroup labelGroupLastName = new LabelGroup("Último nome:", person.getLastName());
        LabelGroup labelGroupCPF = new LabelGroup("CPF:", person.getCPF());
        LabelGroup labelGroupBloodType = new LabelGroup("Grupo sanguíneo:", person.getBloodType().toString());
        LabelGroup labelGroupSex  = new LabelGroup("Sexo:", person.getSex().toString());
        LabelGroup labelGroupStreet = new LabelGroup("Rua:", person.getAddress().getStreet());
        LabelGroup labelGroupDistrict = new LabelGroup("Bairro:", person.getAddress().getDistrict());
        LabelGroup labelGroupCity = new LabelGroup("Cidade:", person.getAddress().getCity());
        LabelGroup labelGroupState = new LabelGroup("Estado:", person.getAddress().getState());
        LabelGroup labelGroupPostalCode = new LabelGroup("CEP:", person.getAddress().getPostalCode());

        informationPanel.add(labelGroupFirstName);
        informationPanel.add(labelGroupLastName);
        informationPanel.add(labelGroupCPF);
        informationPanel.add(labelGroupBloodType);
        informationPanel.add(labelGroupSex);
        informationPanel.add(labelGroupStreet);
        informationPanel.add(labelGroupDistrict);
        informationPanel.add(labelGroupCity);
        informationPanel.add(labelGroupState);
        informationPanel.add(labelGroupPostalCode, BorderLayout.NORTH);

        JPanel vaccinesPanel = new JPanel();

        Iterator it = person.getVaccines().iterator();
        while(it.hasNext()) {
            Vaccine vaccine = (Vaccine) it.next();
            vaccinesPanel.add(new Label(vaccine.getName()));

        }

        contentPane.add(vaccinesPanel, BorderLayout.CENTER);
        contentPane.add(informationPanel, BorderLayout.NORTH);
    }
}


package javas.view;

import javax.swing.*;

public class HealthUnitView extends JPanel {
    public HealthUnitView() {
        this.init();
    }

    private void init(){

        //healthUnitBar.add(new JMenuItem("Cadastrar"));
        //healthUnitBar.add(new JMenuItem("Atualizar"));
        //healthUnitBar.add(new JMenuItem("Excluir"));
        //JMenu reportBar = new JMenu("Relatório");

        this.add(new JLabel("Unidade de saude"));
    }
}

package javas.constants;

import java.awt.*;

public class ViewConstants {
    public static final String MAIN_VIEW_TITLE = "My eHealth";

    public static final Point SCREEN_SIZE = new Point(1400, 780);
    public static final Point SCREEN_CENTER = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
    public static final Color PRIMARY_COLOR = new Color(11, 77, 155);
    public static final Color BORDER_COLOR = new Color(229, 229, 229);



    // Person views constants
    public static final String ADD_PERSON_VIEW_TITLE = "Cadastrar Paciente";
    public static final String DELETE_PERSON_VIEW_TITLE = "Excluir paciente";
    public static final String GENERATE_MEDICAL_RECORD_VIEW_TITLE = "Gerar relatório médico";
    public static final String APPLY_VACCINE_VIEW_TITLE =  "Cadastrar vacina";



    // Health unit views constants
    public static final String DELETE_HEALTH_UNIT_TITLE = "Excluir unidade de saúde";
    public static final String GENERATE_RECORD_HEATH_UNIT = "Gerar relatório unidade de saúdes";
}

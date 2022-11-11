package javas.views.components;

import javas.constants.ViewConstants;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import java.awt.*;

public class TabbedPane extends JTabbedPane {

    public TabbedPane() {
        UIManager.put("TabbedPane.borderColor", null);
        UIManager.put("TabbedPane.darkShadow", ColorUIResource.TRANSLUCENT);
        UIManager.put("TabbedPane.light", ColorUIResource.WHITE);
        UIManager.put("TabbedPane.highlight", ColorUIResource.WHITE);
        UIManager.put("TabbedPane.focus", ColorUIResource.WHITE);
        UIManager.put("TabbedPane.selected", ViewConstants.PRIMARY_COLOR);
        UIManager.put("TabbedPane.foreground", ColorUIResource.WHITE);
        UIManager.put("TabbedPane.unselectedBackground", ColorUIResource.GRAY);
        UIManager.put("TabbedPane.selectHighlight", ViewConstants.PRIMARY_COLOR);
        UIManager.put("TabbedPane.tabAreaBackground", ColorUIResource.WHITE);
        UIManager.put("TabbedPane.borderHightlightColor", ColorUIResource.TRANSLUCENT);
        Insets insets = UIManager.getInsets("TabbedPane.contentBorderInsets");
        insets.top = -1;
        insets.bottom = -1;
        insets.left = -1;
        insets.right = -1;
        UIManager.put("TabbedPane.contentBorderInsets", insets);
        this.setFocusable(false);
    }
}

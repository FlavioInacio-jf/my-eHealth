package javas.views.components;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.RectangleInsets;

import javax.swing.*;
import java.awt.*;

public class PieChart extends JPanel {
    DefaultPieDataset pie;
    public  PieChart(String title) {
        this.pie = new DefaultPieDataset();
        this.init(title);

    }

    private void init(String title) {
        JFreeChart chart = ChartFactory.createPieChart(title, this.pie, true, true, true);
        chart.getPlot().setBackgroundPaint(Color.WHITE);
        chart.getPlot().setInsets(new RectangleInsets(0, 0, 0, 0));
        chart.getPlot().setOutlinePaint(null);

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(null);
        chartPanel.setBackground(Color.WHITE);
        chartPanel.setBorder(null);
        chart.setBorderVisible(false);

        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(300, 300));
        this.setMaximumSize(new Dimension(300, 300));
        this.setMinimumSize(new Dimension(300, 300));
        this.add(chartPanel);
    }

    public void setValue(Comparable<?> key, Double value) {
        this.pie.setValue(key, value);
    }
}

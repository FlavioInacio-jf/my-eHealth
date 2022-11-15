package javas.views.components;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.RectangleInsets;

import javax.swing.*;
import java.awt.*;

public class BarChart extends JPanel {
    private final DefaultCategoryDataset bar;

    public BarChart(String title, String categoryAxisLabel, String valueAxisLabel) {
        this.bar = new DefaultCategoryDataset();
        this.init(title, categoryAxisLabel, valueAxisLabel);
    }

    private void init(String title, String categoryAxisLabel, String valueAxisLabel) {
        JFreeChart chart = ChartFactory.createBarChart(title, categoryAxisLabel, valueAxisLabel, this.bar);
        chart.getPlot().setBackgroundPaint(Color.WHITE);
        chart.getPlot().setInsets(new RectangleInsets(0, 0, 0, 0));

        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setBorder(null);
        chartPanel.setBackground(Color.WHITE);

        this.setBackground(Color.WHITE);
        chartPanel.setBorder(null);
        chart.setBorderVisible(false);
        this.add(chartPanel);
    }

    public void setValue(Number value, Comparable<?> rowKey,
                         Comparable<?> columnKey) {
        this.bar.setValue(value, rowKey, columnKey);
    }
}

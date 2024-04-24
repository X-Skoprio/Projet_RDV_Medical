package Reporting;

import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import java.awt.BorderLayout;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import java.sql.*;
import java.util.*;

import static model.CliniqueImpl.connect;
import static model.CliniqueImpl.getAllPatientAge;

public class Diagramme {

    private static JFrame frame;
    private static ChartPanel chartPanel;
    private static JFreeChart currentChart;
    private static boolean showingPieChart = true;

    public static void displayPatientAgeDistributionChart() {
        frame = new JFrame("Distribution des patients par age");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Create a button to switch charts
        JButton toggleButton = new JButton("Charte suivante");
        toggleButton.addActionListener(e -> toggleChart());

        // Create initial chart panel with pie chart
        currentChart = createPieChart(createPieDataset());
        chartPanel = new ChartPanel(currentChart);

        // Layout setup
        frame.setLayout(new BorderLayout());
        frame.add(chartPanel, BorderLayout.CENTER);
        frame.add(toggleButton, BorderLayout.SOUTH);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static void toggleChart() {
        if (showingPieChart) {
            currentChart = createHistogram(createCategoryDataset());
        } else {
            currentChart = createPieChart(createPieDataset());
        }
        chartPanel.setChart(currentChart);
        showingPieChart = !showingPieChart;
    }

    private static PieDataset createPieDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        Map<String, Integer> ageDistribution = getAgeDistribution();
        for (Map.Entry<String, Integer> entry : ageDistribution.entrySet()) {
            dataset.setValue(entry.getKey(), entry.getValue());
        }
        return dataset;
    }

    private static CategoryDataset createCategoryDataset() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        Map<String, Integer> ageDistribution = getAgeDistribution();
        for (Map.Entry<String, Integer> entry : ageDistribution.entrySet()) {
            dataset.addValue(entry.getValue(), "Age Groups", entry.getKey());
        }
        return dataset;
    }

    private static JFreeChart createHistogram(CategoryDataset dataset) {
        return ChartFactory.createBarChart(
                "Histogramme de la distribution des patients par age",
                "Age",
                "Frequence",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false);
    }

    private static JFreeChart createPieChart(PieDataset dataset) {
        return ChartFactory.createPieChart(
                "Distribution age patients",
                dataset,
                true,
                true,
                false);
    }

    private static Map<String, Integer> getAgeDistribution() {
        Map<String, Integer> distribution = new HashMap<>();
        try {
            List<Integer> ages = getAllPatientAge();
            for (int age : ages) {
                String key = (age / 10 * 10) + "-" + ((age / 10 * 10) + 9);
                distribution.put(key, distribution.getOrDefault(key, 0) + 1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return distribution;
    }


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        connect();
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                displayPatientAgeDistributionChart();
            }
        });
    }
}

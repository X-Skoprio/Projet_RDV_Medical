package Reporting;

import javax.swing.*;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import java.sql.*;
import java.util.*;

import static model.CliniqueImpl.connect;
import static model.CliniqueImpl.getAllPatientAge;

public class ChartUtils {

    public static void displayPatientAgeDistributionChart() {
        JFrame frame = new JFrame("Patient Age Distribution Chart");
        frame.setContentPane(createChartPanel());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null); // Center on screen
        frame.setVisible(true);
    }

    private static JPanel createChartPanel() {
        JFreeChart chart = createPieChart(createDataset());
        return new ChartPanel(chart);
    }

    private static PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        Map<Integer, Integer> ageDistribution = getAgeDistribution();
        for (Map.Entry<Integer, Integer> entry : ageDistribution.entrySet()) {
            dataset.setValue("Age " + entry.getKey(), entry.getValue());
        }
        return dataset;
    }

    private static Map<Integer, Integer> getAgeDistribution() {
        Map<Integer, Integer> distribution = new HashMap<>();
        try {
            List<Integer> ages = getAllPatientAge();
            for (int age : ages) {
                distribution.put(age, distribution.getOrDefault(age, 0) + 1);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return distribution;
    }



    private static JFreeChart createPieChart(PieDataset dataset) {
        return ChartFactory.createPieChart(
                "Patient Age Distribution",
                dataset,
                true,   // include legend
                true,
                false);
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

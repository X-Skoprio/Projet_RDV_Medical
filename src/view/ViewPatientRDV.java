package view;

import javax.swing.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;

public class ViewPatientRDV {
    private JFrame frame;
    private JTabbedPane tabbedPane;

    public ViewPatientRDV() {
        frame = new JFrame("Liste des RDVs");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));

        tabbedPane = new JTabbedPane();
        frame.add(tabbedPane);
    }

    public void addRdvTable(String tabName, Object[][] data, String[] columnNames) {
        DefaultTableModel model = new DefaultTableModel(data, columnNames);
        JTable table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        tabbedPane.addTab(tabName, scrollPane);
    }

    public void display() {
        frame.setVisible(true);
    }
}


package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import controller.ControlleurPatientRDV.*;

import java.awt.*;

public class ViewEmployeConsulterPatients {
    private JFrame frame;
    private JTabbedPane tabbedPane;

    public ViewEmployeConsulterPatients() {
        frame = new JFrame("Consulter les patients");
        frame.setSize(1000, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tabbedPane = new JTabbedPane();
        frame.add(tabbedPane);
    }

    public void addListPatientTable(String tabName, Object[][] data, String[] columnNames) {
        DefaultTableModel model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column >= 6;  // Les boutons sont éditables
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return (columnIndex >= 6) ? JButton.class : String.class;
            }
        };

        JTable table = new JTable(model);
        table.getTableHeader().setReorderingAllowed(false);
        table.setFillsViewportHeight(true);

        // Configuration de la hauteur des lignes pour une meilleure visibilité
        table.setRowHeight(30);


        // Setting up button columns
        setUpButtonColumn(table, 6, "Voir RDV");
        setUpButtonColumn(table, 7, "Supprimer");

        JScrollPane scrollPane = new JScrollPane(table);
        tabbedPane.addTab(tabName, scrollPane);
    }



    private void setUpButtonColumn(JTable table, int column, String label) {
        table.getColumn(table.getColumnName(column)).setCellRenderer(new ButtonRenderer());
        table.getColumn(table.getColumnName(column)).setCellEditor(new ButtonEditor(new JCheckBox(), label));
    }
    public void display() {
        frame.setVisible(true);
    }
}


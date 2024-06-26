package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import controller.ControlleurPatientRDV.*;

import java.awt.*;

public class ViewEmployeConsulterPatients extends JFrame {
    private JFrame frame;
    private JTabbedPane tabbedPane;

    private static DefaultTableModel model;

    public ViewEmployeConsulterPatients() {
        frame = new JFrame("Consulter les patients");
        frame.setSize(1000, 600);

        tabbedPane = new JTabbedPane();
        frame.add(tabbedPane);
    }

    public void addListPatientTable(String tabName, Object[][] data, String[] columnNames) {
         model = new DefaultTableModel(data, columnNames) {
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
        setUpButtonColumn(table, 6, "Voir RDV Patient");
        setUpButtonColumn(table, 7, "Supprimer Patient");

        JScrollPane scrollPane = new JScrollPane(table);
        tabbedPane.addTab(tabName, scrollPane);
    }

    public void removeRow(DefaultTableModel model, int rowIndex) {
        model.removeRow(rowIndex);
    }

    private void setUpButtonColumn(JTable table, int column, String label) {
        table.getColumn(table.getColumnName(column)).setCellRenderer(new ButtonRenderer());
        table.getColumn(table.getColumnName(column)).setCellEditor(new ButtonEditor(new JCheckBox(), label));
    }
    public void display() {
        frame.setVisible(true);
    }

    public static DefaultTableModel getModel() {
        return model;
    }
}


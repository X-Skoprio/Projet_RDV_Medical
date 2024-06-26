package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import controller.Patient.ControlleurPatient;
import controller.ControlleurPatientRDV.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewPatientListeRdv extends JFrame{
    private JFrame frame;
    private JTabbedPane tabbedPane;

    private static DefaultTableModel model;

    public ViewPatientListeRdv() {
        frame = new JFrame("Rendez-vous Details");
        frame.setSize(1000, 600);
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout()); // Use BorderLayout for the frame


        tabbedPane = new JTabbedPane();
        frame.add(tabbedPane);

    }

    public void addRdvTable(String tabName, Object[][] data, String[] columnNames) {
        model = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column >= 5;  // Les boutons sont éditables
            }
            @Override
            public Class<?> getColumnClass(int columnIndex) {
                return (columnIndex >= 5) ? JButton.class : String.class;
            }
        };

        JTable table = new JTable(model);
        table.getTableHeader().setReorderingAllowed(false);
        table.setFillsViewportHeight(true);

        // Configuration de la hauteur des lignes pour une meilleure visibilité
        table.setRowHeight(30);


        // Setting up button columns
        setUpButtonColumn(table, 5, "Modifier");
        setUpButtonColumn(table, 6, "Supprimer");

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

    public void removeRow(DefaultTableModel model, int rowIndex) {
        model.removeRow(rowIndex);
    }

    public static DefaultTableModel getModelListeRdv() {
        return model;
    }
}


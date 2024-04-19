package view;

import controller.ControlleurPatientRDV.ButtonEditor;
import controller.ControlleurPatientRDV.ButtonRenderer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;

public class ViewEmployeConsulterPatients extends JFrame {
    private JTable patientsTable;
    private static DefaultTableModel tableModel;

    public ViewEmployeConsulterPatients() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Consulter les Patients");
        setSize(800, 400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tableModel = new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return column == 6;
            }

            @Override
            public Class<?> getColumnClass(int columnIndex) {
                if (columnIndex == 6) {
                    return JButton.class;
                } else {
                    return String.class;
                }
            }
        };

        tableModel.setColumnIdentifiers(new String[]{"Nom", "Prenom", "Age", "Email", "Mdp", "Details", "Action"});
        patientsTable = new JTable(tableModel);
        patientsTable.getColumn("Action").setCellRenderer(new ButtonRenderer());
        patientsTable.getColumn("Action").setCellEditor(new ButtonEditor(new JCheckBox(), "label"));

        JScrollPane scrollPane = new JScrollPane(patientsTable);
        add(scrollPane, BorderLayout.CENTER);
    }

    public static DefaultTableModel getTableModel() {
        return tableModel;
    }
}

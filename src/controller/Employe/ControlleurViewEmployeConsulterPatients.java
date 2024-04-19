package controller.Employe;

import model.Patient;
import view.ViewEmployeConsulterPatients;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.SQLException;
import java.util.List;

import static model.CliniqueImpl.getAllPatient;

public class ControlleurViewEmployeConsulterPatients {
    private static ViewEmployeConsulterPatients viewEmployeConsulterPatients;

    public ControlleurViewEmployeConsulterPatients(ViewEmployeConsulterPatients view) {
        this.viewEmployeConsulterPatients = view;
        initListeners();
    }

    private void initListeners() {
        // Implement listeners if needed for other buttons or interactions
    }

    public void remplirTableau(List<Patient> patients) {
        DefaultTableModel tableModel = viewEmployeConsulterPatients.getTableModel();
        tableModel.setRowCount(0);
        for (Patient patient : patients) {
            Object[] rowData = {
                    patient.getNom(),
                    patient.getPrenom(),
                    patient.getAge(),
                    patient.getEmail(),
                    patient.getMdp(),
                    patient.getDetails(),
                    "Supprimer"
            };
            tableModel.addRow(rowData);
        }
    }

    public static void showViewEmployeConsulterPatientWindow() throws SQLException {
        SwingUtilities.invokeLater(() -> {
            viewEmployeConsulterPatients = new ViewEmployeConsulterPatients();
            new ControlleurViewEmployeConsulterPatients(viewEmployeConsulterPatients);
            viewEmployeConsulterPatients.setTitle("Consulter Patients Window");
            viewEmployeConsulterPatients.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            viewEmployeConsulterPatients.setLocationRelativeTo(null);
            viewEmployeConsulterPatients.setVisible(true);
            try {
                List<Patient> patients = getAllPatient();
                viewEmployeConsulterPatients.getTableModel().setRowCount(0); // Clear table first
                new ControlleurViewEmployeConsulterPatients(viewEmployeConsulterPatients).remplirTableau(patients);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
    }
}

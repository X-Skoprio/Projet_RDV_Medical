package controller.Employe;

import controller.ControlleurPatientRDV.RdvController;
import view.*;
import model.*;

import javax.swing.*;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import view.ViewEmployeConsulterPatients.*;

public class ControlleurViewEmployeConsulterPatients {


    public static ViewEmployeConsulterPatients viewEmployeConsulterPatients;


    public ControlleurViewEmployeConsulterPatients(ViewEmployeConsulterPatients view) throws SQLException {
        ControlleurViewEmployeConsulterPatients.viewEmployeConsulterPatients = view;
        iniViewEmployeConsulterPatients();
    }

    public static void iniViewEmployeConsulterPatients() throws SQLException {

        //a refaire adapter sans l'objet patient
        String[] columnNames = {"Nom", "Prenom", "Age","Email", "Mot de passe", "Details", "Voir RDV", "Supprimer Patient"};
        Object[][] data = CliniqueImpl.getAllPatient().stream().map(patient -> new Object[] {
                patient.getNom(),
                patient.getPrenom(),
                patient.getAge(),
                patient.getEmail(),
                patient.getMdp(),
                patient.getDetails(),
                "Voir RDV",
                "Supprimer Patient"
        }).toArray(Object[][]::new);

        viewEmployeConsulterPatients.addListPatientTable("Liste des patients", data, columnNames);
        viewEmployeConsulterPatients.display();

    }


    public static void showViewEmployeConsulterPatientWindow() {
        SwingUtilities.invokeLater(() -> {

            ViewEmployeConsulterPatients view = new ViewEmployeConsulterPatients();
            try {
                new ControlleurViewEmployeConsulterPatients(view);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }

    public static ViewEmployeConsulterPatients getViewEmployeConsulterPatients() {
        return viewEmployeConsulterPatients;
    }
}

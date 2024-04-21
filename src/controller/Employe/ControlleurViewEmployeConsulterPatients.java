package controller.Employe;

import controller.ControlleurPatientRDV.RdvController;
import view.*;
import model.*;

import javax.swing.*;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import view.ViewEmployeConsulterPatients.*;

/**
 * Contrôleur pour la vue de consultation des patients par les employés.
 */
public class ControlleurViewEmployeConsulterPatients {


    public static ViewEmployeConsulterPatients viewEmployeConsulterPatients;

    /**
     * Constructeur du contrôleur pour la vue de consultation des patients.
     * @param view La vue pour la consultation des patients.
     * @throws SQLException En cas d'erreur SQL.
     */
    public ControlleurViewEmployeConsulterPatients(ViewEmployeConsulterPatients view) throws SQLException {
        ControlleurViewEmployeConsulterPatients.viewEmployeConsulterPatients = view;

        iniViewEmployeConsulterPatients();
    }
/**
 * Initialise la vue pour la consultation des patients.
 * @throws SQLException si erreur SQL.
 */
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

    /**
     * Affiche la fenêtre de consultation des patients par les employés.
     */
    public static void showViewEmployeConsulterPatientWindow() {
        SwingUtilities.invokeLater(() -> {

            //patientCharge.ajouterRendezVous(new RendezVous("patient@email.com", "medecin@email.com", LocalDateTime.parse("2023-01-10 09:00"), LocalDateTime.parse("2023-01-10 10:00"),  "Consultation"));
            //patientCharge.ajouterRendezVous(new RendezVous("another@email.com", "anothermed@email.com",LocalDateTime.parse("2023-02-15 11:00"), LocalDateTime.parse("2023-02-15 12:00"),  "Follow-up"));

            ViewEmployeConsulterPatients view = new ViewEmployeConsulterPatients();
            try {
                new ControlleurViewEmployeConsulterPatients(view);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }
    /**
     * Récupère la vue pour la consultation des patients.
     * @return La vue pour la consultation des patients.
     */
    public static ViewEmployeConsulterPatients getViewEmployeConsulterPatients() {
        return viewEmployeConsulterPatients;
    }
}

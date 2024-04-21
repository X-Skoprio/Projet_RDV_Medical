package controller.Employe;

import view.*;
import model.*;

import javax.swing.*;
import java.sql.SQLException;

/**
 * Contrôleur pour la vue de gestion des médecins par les employés.
 */
public class ControlleurViewEmployeGererMedecins {


    private static ViewEmployeGererMedecins view;

    /**
     * Controlleur qui va créer la vue EmployeGererMedecins
     * @param view composante graphique que l'on va afficher à l'écran.
     * @throws SQLException Si erreur sql.
     */
    public ControlleurViewEmployeGererMedecins(ViewEmployeGererMedecins view) throws SQLException {
        ControlleurViewEmployeGererMedecins.view = view;

        iniViewEmployeConsulterPatients();
    }
    /**
     * Initialise la vue pour la gestion des médecins.
     * @throws SQLException Si erreur SQL
     */
    public static void iniViewEmployeConsulterPatients() throws SQLException {

        //a refaire adapter sans l'objet patient
        String[] columnNames = {"Nom", "Prenom", "Email", "Specialisation", "Voir RDV Medecin", "Supprimer Medecin"};
        Object[][] data = CliniqueImpl.getAllMedecin().stream().map(Medecin -> new Object[] {
                Medecin.getNom(),
                Medecin.getPrenom(),
                Medecin.getEmail(),
                Medecin.getSpecialisation(),
                "Voir RDV Medecin",
                "Supprimer Medecin"
        }).toArray(Object[][]::new);

        view.addListPatientTable("Liste des Medecins", data, columnNames);
        view.display();

    }

    /**
     * Affiche la fenêtre de gestion des médecins par les employés.
     */
    public static void showViewEmployeGererMedecinWindow() {
        SwingUtilities.invokeLater(() -> {

            //patientCharge.ajouterRendezVous(new RendezVous("patient@email.com", "medecin@email.com", LocalDateTime.parse("2023-01-10 09:00"), LocalDateTime.parse("2023-01-10 10:00"),  "Consultation"));
            //patientCharge.ajouterRendezVous(new RendezVous("another@email.com", "anothermed@email.com",LocalDateTime.parse("2023-02-15 11:00"), LocalDateTime.parse("2023-02-15 12:00"),  "Follow-up"));

            ViewEmployeGererMedecins view = new ViewEmployeGererMedecins();
            try {
                new ControlleurViewEmployeGererMedecins(view);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        });
    }
    /**
     * Récupère la vue pour la gestion des médecins.
     * @return La vue pour la gestion des médecins.
     */
    public static ViewEmployeGererMedecins getViewEmployeGererMedecins() {
        return view;
    }
}

package controller.Employe;

import view.*;
import model.*;

import javax.swing.*;
import java.sql.SQLException;

public class ControlleurViewEmployeGererMedecins {


    private static ViewEmployeGererMedecins view;


    public ControlleurViewEmployeGererMedecins(ViewEmployeGererMedecins view) throws SQLException {
        ControlleurViewEmployeGererMedecins.view = view;

        iniViewEmployeConsulterPatients();
    }

    public static void iniViewEmployeConsulterPatients() throws SQLException {

        //a refaire adapter sans l'objet patient
        String[] columnNames = {"Nom", "Prenom", "Email", "Specialisation", "Voir RDV", "Supprimer Medecins"};
        Object[][] data = CliniqueImpl.getAllMedecin().stream().map(Medecin -> new Object[] {
                Medecin.getNom(),
                Medecin.getPrenom(),
                Medecin.getEmail(),
                Medecin.getSpecialisation(),

                "Voir RDV",
                "Supprimer Medecin"
        }).toArray(Object[][]::new);

        view.addListPatientTable("Liste des Medecins", data, columnNames);
        view.display();

    }


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

    public static ViewEmployeGererMedecins getViewEmployeGererMedecins() {
        return view;
    }
}

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

        view.addListPatientTable("Liste des patients", data, columnNames);
        view.display();

    }


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


}

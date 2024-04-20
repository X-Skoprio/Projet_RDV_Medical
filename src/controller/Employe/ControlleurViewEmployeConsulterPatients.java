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

    private List<RendezVous> ListRdv;
    private static ViewEmployeConsulterPatients view;


    public ControlleurViewEmployeConsulterPatients(ViewEmployeConsulterPatients view) throws SQLException {
        this.view = view;

        initView();
    }

    private void initView() throws SQLException {

        //a refaire adapter sans l'objet patient
        String[] columnNames = {"Nom", "Prenom", "Age","Email", "Mot de passe", "Details", "Voir RDV", "Supprimer"};
        Object[][] data = CliniqueImpl.getAllPatient().stream().map(patient -> new Object[] {
                patient.getNom(),
                patient.getPrenom(),
                patient.getAge(),
                patient.getEmail(),
                patient.getMdp(),
                patient.getDetails(),
                "Voir RDV",
                "supprimer"
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

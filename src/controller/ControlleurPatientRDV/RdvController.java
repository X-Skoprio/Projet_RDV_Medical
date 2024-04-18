package controller.ControlleurPatientRDV;

import view.*;
import model.*;

import javax.swing.*;
import java.time.LocalDateTime;
import java.util.List;

public class RdvController {
    private RdvView view;


    public RdvController( ) {

        initView();
    }

    private void initView() {

        //a refaire adapter sans l'objet patient
       /* String[] columnNames = {"Date Debut", "Date Fin", "Email Patient", "Email Medecin", "Description", "Modifier", "Supprimer"};
        Object[][] data = patientCharge.getListRendezVous().stream().map(rdv -> new Object[] {
                rdv.getDateDebut(),
                rdv.getDateFin(),
                rdv.getEmailPatient(),
                rdv.getEmailMedecin(),
                rdv.getDescription(),
                "modifier",
                "supprimer"
        }).toArray(Object[][]::new);

        view.addRdvTable("Rendez-vous", data, columnNames);
        view.display();*/
    }

    public void ShowPatientRdvWindow() {
        /* SwingUtilities.invokeLater(() -> {

            //patientCharge.ajouterRendezVous(new RendezVous("patient@email.com", "medecin@email.com", LocalDateTime.parse("2023-01-10 09:00"), LocalDateTime.parse("2023-01-10 10:00"),  "Consultation"));
            //patientCharge.ajouterRendezVous(new RendezVous("another@email.com", "anothermed@email.com",LocalDateTime.parse("2023-02-15 11:00"), LocalDateTime.parse("2023-02-15 12:00"),  "Follow-up"));

            RdvView view = new RdvView();
            new RdvController();
        });*/
    }
}
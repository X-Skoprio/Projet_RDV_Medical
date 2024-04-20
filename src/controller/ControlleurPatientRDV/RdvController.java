package controller.ControlleurPatientRDV;

import view.*;
import model.*;

import javax.swing.*;
import java.util.List;

public class RdvController {

    private List<RendezVous> ListRdv;
    private static ViewPatientListeRdv view;


    public RdvController(ViewPatientListeRdv view) {
        this.view = view;

        initView();
    }

    public RdvController(ViewPatientListeRdv view,String email) {
        this.view = view;

        initView(email);
    }

    public RdvController(ViewPatientListeRdv view,String email, String vide) {
        this.view = view;

        initView(email,"");
    }

    private void initView(String email) {

        String[] columnNames = {"Date Debut", "Date Fin", "Email Patient", "Email Medecin", "Description", "Modifier", "Supprimer"};
        Object[][] data = CliniqueImpl.getRendezVousByEmailPatient(email).stream().map(rdv -> new Object[] {
                rdv.getDateDebut(),
                rdv.getDateFin(),
                rdv.getEmailPatient(),
                rdv.getEmailMedecin(),
                rdv.getDescription(),
                "modifier",
                "supprimer"
        }).toArray(Object[][]::new);

        view.addRdvTable("Rendez-vous", data, columnNames);
        view.display();
    }

    private void initView(String email, String vide) {

        String[] columnNames = {"Date Debut", "Date Fin", "Email Patient", "Email Medecin", "Description", "Modifier RDV", "Supprimer RDV"};
        Object[][] data = CliniqueImpl.getRendezVousByEmailMedecin(email).stream().map(rdv -> new Object[] {
                rdv.getDateDebut(),
                rdv.getDateFin(),
                rdv.getEmailPatient(),
                rdv.getEmailMedecin(),
                rdv.getDescription(),
                "Modifier RDV",
                "Supprimer RDV"
        }).toArray(Object[][]::new);

        view.addRdvTable("Rendez-vous des medecins", data, columnNames);
        view.display();
    }

    private void initView() {

       String[] columnNames = {"Date Debut", "Date Fin", "Email Patient", "Email Medecin", "Description", "Modifier", "Supprimer"};
        Object[][] data = CliniqueImpl.getRendezVousByEmailPatient(Login.getEmail()).stream().map(rdv -> new Object[] {
                rdv.getDateDebut(),
                rdv.getDateFin(),
                rdv.getEmailPatient(),
                rdv.getEmailMedecin(),
                rdv.getDescription(),
                "modifier",
                "supprimer"
        }).toArray(Object[][]::new);

        view.addRdvTable("Rendez-vous", data, columnNames);
        view.display();
    }

    public static void ShowPatientRdvWindow() {
        SwingUtilities.invokeLater(() -> {

            ViewPatientListeRdv view = new ViewPatientListeRdv();
            new RdvController(view);
        });
    }

    public static void ShowPatientRdvWindow(String email) {
        SwingUtilities.invokeLater(() -> {

            ViewPatientListeRdv view = new ViewPatientListeRdv();
            new RdvController(view,email);
        });
    }

    public static void ShowPatientRdvWindow(String email,String vide) {
        SwingUtilities.invokeLater(() -> {

            ViewPatientListeRdv view = new ViewPatientListeRdv();
            new RdvController(view,email, vide);
        });
    }

    public static ViewPatientListeRdv getViewPatientListeRdv() {
        return view;
    }
}
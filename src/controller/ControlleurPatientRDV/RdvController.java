package controller.ControlleurPatientRDV;

import view.*;
import model.*;

import javax.swing.*;
import java.util.List;

/**
 * Classe qui va controller les actions d'un patient lorsqu'il intéragit avec un RDV
 */
public class RdvController {

    private List<RendezVous> ListRdv;
    private static ViewPatientListeRdv view;

    /**
     * Constructeur de la classe qui affiche la liste des RDV du patient/
     * @param view
     */
    public RdvController(ViewPatientListeRdv view) {
        this.view = view;

        initView();
    }

    /**
     * affiche la liste des rendez vous d'un patient spécifique grâce à son mail
     * @param view
     * @param email le mail du patient en question
     */
    public RdvController(ViewPatientListeRdv view,String email) {
        this.view = view;

        initView(email);
    }

    /**
     * Affiche la liste des rdv selon le medecin
     * @param view la liste
     * @param email le mail du medecin
     * @param vide une chaine vide pour différencier les constructeur.
     */
    public RdvController(ViewPatientListeRdv view,String email, String vide) {
        this.view = view;

        initView(email,"");
    }

    /**
     * 1er Constructeur qui va afficher les rdv de tous les patients.
     */
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

    /**
     * 2e constrcuteur qui va afficher les rdv d'un patient spécifique
     * @param email  mail du patient en question
     */
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

    /**
     * Va afficher les rdv d'un MEDECIN specifique
     * @param email  mail du medecin
     * @param vide   chaine vide pour ne pas confondre les constructeurs.
     */
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


    /**
     * Initialise les fenetres graphique qui vont s'ouvrir en fonction des action du controlleur
     * en fonction du constructeur
     */
    public static void ShowPatientRdvWindow() {
        SwingUtilities.invokeLater(() -> {

            ViewPatientListeRdv view = new ViewPatientListeRdv();
            new RdvController(view);
        });
    }

    /**
     * Initialise les fenetres graphique qui vont s'ouvrir en fonction des action du controlleur
     * en fonction du constructeur
     */
    public static void ShowPatientRdvWindow(String email) {
        SwingUtilities.invokeLater(() -> {

            ViewPatientListeRdv view = new ViewPatientListeRdv();
            new RdvController(view,email);
        });
    }

    /**
     * Initialise les fenetres graphique qui vont s'ouvrir en fonction des action du controlleur
     * en fonction du constructeur
     */
    public static void ShowPatientRdvWindow(String email,String vide) {
        SwingUtilities.invokeLater(() -> {

            ViewPatientListeRdv view = new ViewPatientListeRdv();
            new RdvController(view,email, vide);
        });
    }

    /**
     * Renvoie la vue des rendez-vous.
     *
     * @return La vue des rendez-vous.
     */
    public static ViewPatientListeRdv getViewPatientListeRdv() {
        return view;
    }
}
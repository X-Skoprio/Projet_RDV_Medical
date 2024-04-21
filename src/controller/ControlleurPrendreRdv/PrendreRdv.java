package controller.ControlleurPrendreRdv;

import model.CliniqueImpl;
import model.Login;
import model.Medecin;
import model.RendezVous;
import view.ViewPatient;
import view.ViewPatientPrendreRdv;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.sql.SQLException;
import java.util.*;
import java.time.format.DateTimeFormatter;
import java.lang.*;

/**
 * Classe qui permet de prendre un RDV et de le renvoyer à la base de donnée.
 */
public class PrendreRdv {

    private static ViewPatientPrendreRdv view;
    private String selectedDoctorEmail;
    private static String emailMedecin;

    /**
     * Constructeur des composants graphiques.
     * @param view
     */
    public PrendreRdv(ViewPatientPrendreRdv view) {
        this.view = view;
        initView();
    }

    /**
     * Initialise l'affichage graphique.
     */
    private void initView() {
        try {
            view.displayDoctors(CliniqueImpl.getAllMedecin(), this::handleDoctorSelection);
            view.getReturnButton().addActionListener(this::handleReturnAction); // Setup return button listener
            view.setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
            view.showMessage("Erreur de chargement table medecin");
        }
    }

    /**
     * Permet de choisir le medecin que l'on veut à l'aide d'un action listener.
     * @param e action listener.
     */
    private void handleDoctorSelection(ActionEvent e) {
        emailMedecin = e.getActionCommand();
        view.showMessage("Choisir ce medecin");
        view.dispose();
        ChoixHorairesRdv.ShowChoixHorairesWindow();
    }

    /**
     * Utilisation du bouton retour et donc on efface l'écran.
     * @param e si l'action listener e est activé.
     */
    private void handleReturnAction(ActionEvent e) {
        view.dispose(); // Or navigate back to another screen

    }

    /**
     * Affichage de la fenetre prise de RDV.
     */
    public static void showPrendreRdvWindow() {
        SwingUtilities.invokeLater(() -> {
            view = new ViewPatientPrendreRdv(); // Create the ViewLogin window
            new PrendreRdv(view);
        });
    }

    /**
     * Retrouve le mail du Medecin lors de la prise de RDV/
     * @return email du Medecin
     */
    public static String getEmailMedecin(){return emailMedecin;}

}


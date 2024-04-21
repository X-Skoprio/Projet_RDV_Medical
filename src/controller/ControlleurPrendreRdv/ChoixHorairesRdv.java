package controller.ControlleurPrendreRdv;

import controller.Patient.ControlleurPatient;
import model.CliniqueImpl;
import model.Login;
import model.RendezVous;
import view.ViewChoixHorairesRdv;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

/**
 * Classe qui va nous permettre de choisir l'heure du RDV selon les dipso.
 *
 *
 */
public class ChoixHorairesRdv {

    private static ViewChoixHorairesRdv view;

    /**
     * Constructeur de la classe qui récuprère le composant graphique.
     * @param view
     */
    public ChoixHorairesRdv(ViewChoixHorairesRdv view) {

        this.view = view;
        initView();
    }

    /**
     * Initialise l'affichage du temps et des deux boutons : confirmer et retour arrière.
     */
    private void initView() {

        view.setDays(getAvailableDays());
        view.addDaySelectionListener(e -> updateHours());
        view.addHourSelectionListener(e -> enableConfirmation());
        view.addConfirmButtonListener(e -> confirmAppointment());
        view.addBackButtonListener(e -> goBack());
        view.display();
    }

    /**
     * Met à jour le temps en fonction du temps actuel.
     * Utilise une liste.
     */
    private void updateHours() {
        String selectedDay = view.getSelectedDay();
        LocalDate date = LocalDate.parse(selectedDay, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        List<String> hours = getAvailableHours();
        List<LocalDateTime> bookedTimes = CliniqueImpl.rdvIndispo(PrendreRdv.getEmailMedecin(), date);
        view.setHours(hours, bookedTimes);
    }

    private void enableConfirmation() {

    }

    /**
     * Va confirmer le rendez vous en vérifiant que la tranche horaire est dispo.
     * Utilise une excpetion pour renvoyer un message d'erreur.
     */
    private void confirmAppointment() {
        String selectedDay = view.getSelectedDay();
        String selectedHour = view.getSelectedHour();
        if(selectedHour != null && selectedHour.contains("(booked)")) {
            JOptionPane.showMessageDialog(view, "Horaire indisponible");
        }
        else{
                if (selectedDay != null && selectedHour != null) {

                    LocalDateTime startTime = LocalDateTime.parse(selectedDay + "T" + selectedHour + ":00", DateTimeFormatter.ISO_LOCAL_DATE_TIME);
                    LocalDateTime endTime = startTime.plusHours(1);

                    String description = "Routine check-up";

                    JOptionPane.showMessageDialog(view, "Vous avez planifié un rdv le " + selectedDay + " at " + selectedHour + ".");
                    RendezVous rdv = new RendezVous(Login.getEmail(), PrendreRdv.getEmailMedecin(), startTime, endTime, description);
                    try {
                        CliniqueImpl.Prendre1Rdv(rdv);
                    }
                    catch(SQLException e){
                        throw new RuntimeException(e);
                    }
                } else {
                    JOptionPane.showMessageDialog(view, "Merci de selectionner un jour et un horaire.", "Selection incomplete", JOptionPane.ERROR_MESSAGE);
                }
            view.dispose();

        }

    }

    /**
     * Initialise le bouton RETOUR
     */
    private void goBack() {
        // Handle going back, could refresh view or change view state
        view.dispose();
        PrendreRdv.showPrendreRdvWindow();
    }

    /**
     * Recupere les jours disponibles en fonction de l'emploi du temps.
     * @return les jours disponibles
     */
    public static List<String> getAvailableDays() {
        List<String> days = new ArrayList<>();
        LocalDateTime today = LocalDateTime.now();
        for (int i = 0; i < 21; i++) {
            days.add(today.plusDays(i).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        }
        return days;
    }

    /**
     * Recupere les heures dispo en fonction de l'emploi du temps.
     * @return les heures disponibles
     */
    public static List<String> getAvailableHours() {
        List<String> hours = new ArrayList<>();
        for (int i = 8; i <= 18; i++) {
            hours.add(String.format("%02d:00", i));
        }
        return hours;
    }

    /**
     * Affiche le choix des heures disponibles à l'écran.
     */
    public static void ShowChoixHorairesWindow() {
        SwingUtilities.invokeLater(() -> {
            view = new ViewChoixHorairesRdv();
            new ChoixHorairesRdv(view);
        });
    }

}

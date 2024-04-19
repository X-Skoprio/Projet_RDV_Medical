package controller.ControlleurPrendreRdv;

import controller.Patient.ControlleurPatient;
import model.CliniqueImpl;
import model.Login;
import model.RendezVous;
import view.ViewChoixHorairesRdv;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;

public class ChoixHorairesRdv {

    private static ViewChoixHorairesRdv view;

    public ChoixHorairesRdv(ViewChoixHorairesRdv view) {

        this.view = view;
        initView();
    }

    private void initView() {

        view.setDays(getAvailableDays());
        view.addDaySelectionListener(e -> updateHours());
        view.addHourSelectionListener(e -> enableConfirmation());
        view.addConfirmButtonListener(e -> confirmAppointment());
        view.addBackButtonListener(e -> goBack());
        view.display();
    }

    private void updateHours() {
        view.setHours(getAvailableHours());
    }

    private void enableConfirmation() {

    }

    private void confirmAppointment() {
        String selectedDay = view.getSelectedDay();
        String selectedHour = view.getSelectedHour();
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
        ControlleurPatient.showPatientWindow();
    }

    private void goBack() {
        // Handle going back, could refresh view or change view state
        view.dispose();
        PrendreRdv.showPrendreRdvWindow();
    }
    public static List<String> getAvailableDays() {
        List<String> days = new ArrayList<>();
        LocalDateTime today = LocalDateTime.now();
        for (int i = 0; i < 21; i++) {
            days.add(today.plusDays(i).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        }
        return days;
    }

    public List<String> getAvailableHours() {
        List<String> hours = new ArrayList<>();
        for (int i = 8; i <= 18; i++) {
            hours.add(String.format("%02d:00", i));
        }
        return hours;
    }

    public static void ShowChoixHorairesWindow() {
        SwingUtilities.invokeLater(() -> {
            view = new ViewChoixHorairesRdv();
            new ChoixHorairesRdv(view);
        });
    }

}

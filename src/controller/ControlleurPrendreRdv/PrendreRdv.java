package controller.ControlleurPrendreRdv;

import model.CliniqueImpl;
import model.Login;
import model.Medecin;
import model.RendezVous;
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
public class PrendreRdv {

    private ViewPatientPrendreRdv view;

    public PrendreRdv(ViewPatientPrendreRdv view) {
        this.view = view;
        initController();
    }

    private void initController() {
        try {
            view.displayDoctors(CliniqueImpl.getAllMedecin(), this::handleDoctorSelection);
            view.setVisible(true);
        } catch (SQLException e) {
            e.printStackTrace();
            view.showMessage("Error loading doctors.");
        }
    }

    private void handleDoctorSelection(ActionEvent e) {
        Medecin selectedDoctor = view.getSelectedDoctor();
        List<LocalDateTime> dates = IntStream.range(0, 21).mapToObj(i -> LocalDateTime.now().plusDays(i)).collect(Collectors.toList());
        view.displayDates(dates, event -> handleDateSelection(selectedDoctor));
    }

    private void handleDateSelection(Medecin medecin) {
        LocalDateTime selectedDate = view.getSelectedDate();
        List<String> times = IntStream.range(8, 20).mapToObj(i -> selectedDate.withHour(i).format(DateTimeFormatter.ofPattern("HH:mm")))
                .collect(Collectors.toList());
        view.displayTimes(times, event -> handleTimeSelection(medecin, selectedDate));
    }

    private void handleTimeSelection(Medecin medecin, LocalDateTime selectedDate) {
        String selectedTime = view.getSelectedTime();
        LocalDateTime startTime = LocalDateTime.parse(selectedDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")) + " " + selectedTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        LocalDateTime endTime = startTime.plusHours(1);
        try {
            if (CliniqueImpl.RdvDispoTest(medecin.getEmail(), Timestamp.valueOf(startTime))) {
                if (JOptionPane.showConfirmDialog(view, "Confirm your appointment at " + startTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))) == JOptionPane.YES_OPTION) {
                    RendezVous rdv = new RendezVous(Login.getEmail(), medecin.getEmail(), startTime, endTime,"Routine check");
                    CliniqueImpl.Prendre1Rdv(rdv);
                    view.showMessage("Appointment booked successfully.");
                }
            } else {
                view.showMessage("This slot is already booked.");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            view.showMessage("Failed to book the appointment.");
        }
    }

    public static void main(String[] args) {

        ViewPatientPrendreRdv view = new ViewPatientPrendreRdv();
        new PrendreRdv(view);
    }
}


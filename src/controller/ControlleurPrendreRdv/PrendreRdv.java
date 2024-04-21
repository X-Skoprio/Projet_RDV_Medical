package controller.ControlleurPrendreRdv;

import controller.Patient.ControlleurPatient;
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

public class PrendreRdv {

    private static ViewPatientPrendreRdv view;
    private String selectedDoctorEmail;
    private static String emailMedecin;

    public PrendreRdv(ViewPatientPrendreRdv view) {
        this.view = view;
        initView();
    }


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

    private void handleDoctorSelection(ActionEvent e) {
        emailMedecin = e.getActionCommand();
        view.showMessage("Choisir ce medecin");
        view.dispose();
        ChoixHorairesRdv.ShowChoixHorairesWindow();
    }

    private void handleReturnAction(ActionEvent e) {
        view.dispose(); // Or navigate back to another screen

    }

    public static void showPrendreRdvWindow() {
        SwingUtilities.invokeLater(() -> {
            view = new ViewPatientPrendreRdv(); // Create the ViewLogin window
            new PrendreRdv(view);
        });
    }

    public static String getEmailMedecin(){return emailMedecin;}

}


package controller;


import view.*;
import model.*;
import controller.ControlleurPatientRDV.RdvController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ControlleurPatient {


    private ViewPatient view;
    private Patient patientCharge;
    private Runnable onPrendreRDVButtonClicked;
    private Runnable onConsultRDVButtonClicked;

    public ControlleurPatient(ViewPatient view, Patient patientCharge) {
        this.view = view;
        this.patientCharge = patientCharge;
        initListeners();
    }

    private void initListeners() {
        // Patient button action listener
        this.view.getPrendreRDVButton().addActionListener(e -> onPrendreRDVButtonClick());
        this.view.getConsultRDVButton().addActionListener(e -> onConsultRDVButtonClicked());
    }

    private void onPrendreRDVButtonClick() {
        System.out.println("Patient button clicked");
        if (onPrendreRDVButtonClicked != null) {
            onPrendreRDVButtonClicked.run(); //
        }
    }

    private void onConsultRDVButtonClick() {
        System.out.println("Patient button clicked");
        if (onConsultRDVButtonClicked != null) {
            onConsultRDVButtonClicked.run(); //
        }
    }

    public void showPatientWindow(Patient patientCharge) {
        SwingUtilities.invokeLater(() -> {
            view = new ViewPatient(patientCharge); // Create the ViewLogin window
            view.setTitle("Patient Window"); // Optional: Set the window title
            view.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Set the default close operation
            view.pack(); // Size the window to fit the preferred size and layouts of its subcomponents
            view.setLocationRelativeTo(null); // Center the window on the screen
            view.setVisible(true); // Make the window visible

            // Assuming you have methods in ViewLogin to get the buttons
            view.getPrendreRDVButton().addActionListener(e -> onPrendreRDVButtonClicked());
            view.getConsultRDVButton().addActionListener(e -> onConsultRDVButtonClicked());
        });
    }

    private void onPrendreRDVButtonClicked() {
        view.dispose(); // Close the ViewPatient window

        ControlleurLoginDetails.ShowLoginDetails();
    }

    private void onConsultRDVButtonClicked() {

        view.dispose(); // Close the ViewPatient window

        RdvController rdvController = new RdvController(patientCharge);
        rdvController.ShowPatientRdvWindow();
    }



}

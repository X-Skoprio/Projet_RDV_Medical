package controller;

import view.ViewLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlleurLogin {
    private ViewLogin view;
    private Runnable onPatientButtonClicked;

    public ControlleurLogin(ViewLogin view, Runnable onPatientButtonClicked) {
        this.view = view;
        this.onPatientButtonClicked = onPatientButtonClicked; // Callback for when the patient button is clicked

        initListeners();
    }

    private void initListeners() {
        // Patient button action listener
        this.view.getPatientButton().addActionListener(e -> onButtonPatientClick());

        // Employee button action listener
        this.view.getEmployeeButton().addActionListener(e -> onButtonEmployeClick());
    }

    private void onButtonPatientClick() {
        System.out.println("Patient button clicked");
        if (onPatientButtonClicked != null) {
            onPatientButtonClicked.run(); // Execute the callback, if provided
        }
    }

    private void onButtonEmployeClick() {
        System.out.println("Employee button clicked");
        // Additional logic for handling the employee button click can be added here
    }

    // The main method would likely be moved to a Main class or MainController class
}

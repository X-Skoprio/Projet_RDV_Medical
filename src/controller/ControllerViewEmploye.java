package controller;

import view.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**Va controler toutes les fonctions d'affichages et graphiques qui concernent l'employé */

public class ControllerViewEmploye {

    private ViewEmploye view;
    private Runnable onGererPatientsButtonClicked;

    public ControllerViewEmploye(ViewEmploye view) {
        this.view = view;

        initListeners();
    }

    private void initListeners() {
        // Patient button action listener
        this.view.getGererPatientButton().addActionListener(e -> onGererPatientsButtonClick());
    }

    private void onGererPatientsButtonClick() {
        System.out.println(" Gérer Patient button clicked");
        if (onGererPatientsButtonClicked != null) {
            onGererPatientsButtonClicked.run();
        }
    }
    

    public void showGererPatientWindow() {
        SwingUtilities.invokeLater(() -> {
            view = new ViewEmploye(); // Create the ViewLogin window
            view.setTitle("Employe Window"); // Optional: Set the window title
            view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set the default close operation
            view.pack(); // Size the window to fit the preferred size and layouts of its subcomponents
            view.setLocationRelativeTo(null); // Center the window on the screen
            view.setVisible(true); // Make the window visible

            // Assuming you have methods in ViewLogin to get the buttons
            view.getGererPatientButton().addActionListener(e -> onGererPatientsButtonClicked());

        });
    }

    private void onGererPatientsButtonClicked() {
        view.dispose(); // Close the ViewLogin window

    }


}

package controller;

import view.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**Va controler toutes les fonctions d'affichages et graphiques qui concernent l'employé */

public class ControllerViewEmploye {

    private static ViewEmploye viewEmploye;
    private static ViewEmployeGererPatients VEGP;
    private ViewEmployeGererMedecin viewM;
    public Runnable onGererPatientsButtonClicked;
    public Runnable onGererMedecinButtonClicked;

    public ControllerViewEmploye(ViewEmploye view) {
        this.viewEmploye = view;

        initListeners();
    }


    private void initListeners() {
        // Patient button action listener
        this.viewEmploye.getGererPatientButton().addActionListener(e -> onGererPatientsButtonClick());
        this.viewEmploye.getGererMedecinButton().addActionListener(e -> onGererMedecinButtonClick());
    }

    private void onGererPatientsButtonClick() {
        System.out.println(" Gérer Patient button clicked");

        if (onGererPatientsButtonClicked != null) {
            onGererPatientsButtonClicked.run();
        }
    }

    private void onGererMedecinButtonClick(){
        System.out.println(" Gérer Medecin button clicked");

        if (onGererMedecinButtonClicked != null) {
            onGererMedecinButtonClicked.run();
        }
    }
    

    //Affichage graphique uniquement de la fenetre patient, les actions se déroulent dans une autre fonctions.
    public void showGererPatientWindow() {
        SwingUtilities.invokeLater(() -> {
            System.out.println(" Gérer Patient button clicked");
            VEGP = new ViewEmployeGererPatients(); // Create the ViewLogin window
            VEGP.setTitle("Employe Window"); // Optional: Set the window title
            VEGP.setVisible(true); // Make the window visible

            // Assuming you have methods in ViewLogin to get the buttons
             viewEmploye.getGererPatientButton().addActionListener(e -> onGererPatientsButtonClicked());

        });
    }

    public void showGererMedecinWindonw(){
        SwingUtilities.invokeLater(() -> {
            System.out.println(" Gérer Patient button clicked");
            viewM = new ViewEmployeGererMedecin(); // Create the ViewLogin window
            viewM.setTitle("Employe Window"); // Optional: Set the window title
            viewM.setVisible(true); // Make the window visible

            // Assuming you have methods in ViewLogin to get the buttons
            viewEmploye.getGererPatientButton().addActionListener(e -> onGererPatientsButtonClicked());

        });
    }
    //Action qui se déroule qd on clique sur le boutton
    private void onGererPatientsButtonClicked() {
        System.out.println(" Gérer Patient button clicked");
        viewEmploye.dispose(); // Close the ViewLogin window

        showGererPatientWindow();

    }

    //Action qui se déroule qd on clique sur le boutton
    private void onGererMedecinButtonClicked(){
        viewEmploye.dispose();
        System.out.println(" Gérer Medecin button clicked");
        showGererMedecinWindonw();

    }
//Main qui nous permet de tester
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ViewEmploye().setVisible(true));
    }

}

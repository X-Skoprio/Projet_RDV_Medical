package controller.Employe;

import view.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**Va controler toutes les fonctions d'affichages et graphiques qui concernent l'employé */

public class ControllerViewEmploye {

    private ViewEmploye view;
    private Runnable onGererPatientsButtonClick;

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
        if (onGererPatientsButtonClick != null) {
            onGererPatientsButtonClick.run();
        }
    }

    public void showGererPatientWindow() {

    }

    private void onLoginButtonClicked() {
        view.dispose(); // Close the ViewLogin window

    }


}

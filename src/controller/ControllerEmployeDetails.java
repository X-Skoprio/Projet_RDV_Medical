package controller;

import model.CliniqueImpl;
import view.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Arrays;
import model.*;



public class ControllerEmployeDetails {
    private static ViewEmployeGererPatients patientsDetails;
    private Runnable onGererPatientButtonClicked;

    public ControlleurLoginDetails(ViewEmployeGererPatients ViewGererPatient) throws SQLException, ClassNotFoundException {
        ControllerEmployeDetails.patientsDetails = ViewGererPatient;
        initListeners();
    }
    private void initListeners() {
        // Patient button action listener
        patientsDetails.get.addActionListener(e -> onGererPatientButtonClicked());
    }

    public static void ShowGererPatients() {
        SwingUtilities.invokeLater(() -> {
            patientsDetails = new ViewEmployeGererPatients(); // Create the ViewLogin window
            patientsDetails.setTitle("Login Window"); // Optional: Set the window title
            patientsDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set the default close operation
            patientsDetails.pack(); // Size the window to fit the preferred size and layouts of its subcomponents
            patientsDetails.setLocationRelativeTo(null); // Center the window on the screen
            patientsDetails.setVisible(true); // Make the window visible

           // LoginDetails.getLoginButton().addActionListener(e -> onSendLoginButtonClicked());
        });
    }
}

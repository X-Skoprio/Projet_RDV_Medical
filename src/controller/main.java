package controller;

import view.ViewLoginDetails;

import javax.swing.*;

public class main {
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            ViewLoginDetails LoginDetails = new ViewLoginDetails(); // Initialize the login view
            new ControlleurLoginDetails(LoginDetails); // Attach the controller to the view
        });
    }
}

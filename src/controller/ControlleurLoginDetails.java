package controller;

import view.ViewLoginDetails;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
//import

public class ControlleurLoginDetails {
    private static ViewLoginDetails LoginDetails;
    private Runnable onSendLoginButtonClicked;

    public ControlleurLoginDetails(ViewLoginDetails LoginDetails) {
        ControlleurLoginDetails.LoginDetails = LoginDetails;
        initListeners();
    }
    private void initListeners() {
        // Patient button action listener
        LoginDetails.getLoginButton().addActionListener(e -> onSendLoginButtonClicked());
    }

    private void onSendLoginButtonClick() {
        System.out.println("Patient button clicked");
        if (onSendLoginButtonClicked != null) {
            onSendLoginButtonClicked.run(); //
        }
    }

    private static void onSendLoginButtonClicked() {
        LoginDetails.dispose(); // Close the ViewLogin window

        String email = LoginDetails.getEmailField().getText();
        String password = new String(LoginDetails.getPasswordField().getPassword());

        System.out.println(email + "  " + password);
    }


    public static void ShowLoginDetails() {
        SwingUtilities.invokeLater(() -> {
            LoginDetails = new ViewLoginDetails(); // Create the ViewLogin window
            LoginDetails.setTitle("Login Window"); // Optional: Set the window title
            LoginDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set the default close operation
            LoginDetails.pack(); // Size the window to fit the preferred size and layouts of its subcomponents
            LoginDetails.setLocationRelativeTo(null); // Center the window on the screen
            LoginDetails.setVisible(true); // Make the window visible

            LoginDetails.getLoginButton().addActionListener(e -> onSendLoginButtonClicked());

        });
    }




    private void performLogin() {
        // Get email and password from the view
        String email = LoginDetails.getEmailField().getText();
        String password = new String(LoginDetails.getPasswordField().getPassword());

        // Perform login logic here
        System.out.println("Attempting login with email: " + email + " and password: " + password);

        // You can add more logic here, such as validating the credentials,
        // showing error messages, or transitioning to another view upon success.
    }

}

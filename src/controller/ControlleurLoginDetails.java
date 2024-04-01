package controller;

import view.ViewLoginDetails;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlleurLoginDetails {
    private ViewLoginDetails LoginDetails;

    public ControlleurLoginDetails(ViewLoginDetails LoginDetails) {
        this.LoginDetails = LoginDetails;
        initController();
    }

    private void initController() {
        // Action listener for the login button
        LoginDetails.getLoginButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                performLogin();
            }
        });

        // Action listener for the return button
        LoginDetails.getReturnButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                returnToMainMenu();
            }
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

    private void returnToMainMenu() {
        // Logic to return to the main menu
        System.out.println("Returning to main menu");

        // This could involve closing the current view and opening the main menu view.
        // For example: LoginDetails.dispose(); (if loginView should close)
        // and then initialize and show the main menu view.
    }
}

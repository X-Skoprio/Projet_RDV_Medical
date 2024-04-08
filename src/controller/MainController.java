package controller;

import javax.swing.*;

import view.*;


public class MainController extends JFrame {
    private static ViewLogin viewLogin;
    private static ViewLoginDetails viewLoginDetails;

    public MainController() {
        // You can initiate other controller setup here if needed
    }

    public void showLoginWindow() {
        SwingUtilities.invokeLater(() -> {
            viewLogin = new ViewLogin(); // Create the ViewLogin window
            viewLogin.setTitle("Login Window"); // Optional: Set the window title
            viewLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set the default close operation
            viewLogin.pack(); // Size the window to fit the preferred size and layouts of its subcomponents
            viewLogin.setLocationRelativeTo(null); // Center the window on the screen
            viewLogin.setVisible(true); // Make the window visible

            // Assuming you have methods in ViewLogin to get the buttons
            viewLogin.getLoginButton().addActionListener(e -> onLoginButtonClicked());

        });
    }

    public static void ViewLoginDetails() {
        SwingUtilities.invokeLater(() -> {
            viewLoginDetails = new ViewLoginDetails(); // Create the ViewLogin window
            viewLoginDetails.setTitle("Login Window"); // Optional: Set the window title
            viewLoginDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set the default close operation
            viewLoginDetails.pack(); // Size the window to fit the preferred size and layouts of its subcomponents
            viewLoginDetails.setLocationRelativeTo(null); // Center the window on the screen
            viewLoginDetails.setVisible(true); // Make the window visible

        });
    }

    private void onLoginButtonClicked() {
        viewLogin.dispose(); // Close the ViewLogin window

        MainController.ViewLoginDetails();
    }





    public static void main(String[] args) {
        MainController controller = new MainController();
        controller.showLoginWindow(); // Show the login window

    }
}

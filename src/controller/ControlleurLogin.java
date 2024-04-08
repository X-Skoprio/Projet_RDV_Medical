package controller;

import view.*;
import controller.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlleurLogin {
    private ViewLogin view;
    private Runnable onLoginButtonClicked;

    public ControlleurLogin(ViewLogin view) {
        this.view = view;

        initListeners();
    }

    private void initListeners() {
        // Patient button action listener
        this.view.getLoginButton().addActionListener(e -> onLoginButtonClick());
    }

    private void onLoginButtonClick() {
        System.out.println("Patient button clicked");
        if (onLoginButtonClicked != null) {
            onLoginButtonClicked.run(); //
        }
    }

    public void showLoginWindow() {
        SwingUtilities.invokeLater(() -> {
            view = new ViewLogin(); // Create the ViewLogin window
            view.setTitle("Login Window"); // Optional: Set the window title
            view.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set the default close operation
            view.pack(); // Size the window to fit the preferred size and layouts of its subcomponents
            view.setLocationRelativeTo(null); // Center the window on the screen
            view.setVisible(true); // Make the window visible

            // Assuming you have methods in ViewLogin to get the buttons
            view.getLoginButton().addActionListener(e -> onLoginButtonClicked());

        });
    }

    private void onLoginButtonClicked() {
        view.dispose(); // Close the ViewLogin window

        ControlleurLoginDetails.ShowLoginDetails();
    }

}

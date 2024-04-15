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
        if (onLoginButtonClicked != null) {
            onLoginButtonClicked.run(); //
        }
    }

    public void showLoginWindow() {
        SwingUtilities.invokeLater(() -> {
            view = new ViewLogin(); // créer la fenetre
            view.setVisible(true);
            //buttons
            view.getLoginButton().addActionListener(e -> onLoginButtonClicked());
        });
    }

    private void onLoginButtonClicked() {
        view.dispose(); // Close the ViewLogin window


        ControlleurLoginDetails.ShowLoginDetails();
    }

}

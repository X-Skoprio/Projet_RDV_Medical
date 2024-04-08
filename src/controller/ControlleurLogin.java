package controller;

import view.ViewLogin;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlleurLogin {
    private ViewLogin view;
    private Runnable onPatientButtonClicked;

    public ControlleurLogin(ViewLogin view, Runnable onPatientButtonClicked) {
        this.view = view;
        this.onPatientButtonClicked = onPatientButtonClicked; // Callback for when the patient button is clicked

        initListeners();
    }

    private void initListeners() {
        // Patient button action listener
        this.view.getLoginButton().addActionListener(e -> onLoginButtonClick());
    }

    private void onLoginButtonClick() {
        System.out.println("Patient button clicked");
        if (onPatientButtonClicked != null) {
            onPatientButtonClicked.run(); // Execute the callback, if provided
        }
    }

}

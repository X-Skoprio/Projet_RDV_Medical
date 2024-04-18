package controller.Login;

import view.*;

import javax.swing.*;

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

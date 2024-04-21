package controller.Login;

import view.*;

import javax.swing.*;

/**
 * Cette classe va nous permettre de controller les boutons lors de la connexion de l'utilisateur
 * Cela va donc générer des ACTION LISTENER
 * @author MAAREK JOUD PREVOST
 */
public class ControlleurLogin {
    private ViewLogin view;
    private Runnable onLoginButtonClicked;

    /**
     * Construit un contrôleur pour la gestion de la vue de connexion.
     *
     * @param view La vue de connexion à contrôler.
     */
    public ControlleurLogin(ViewLogin view) {
        this.view = view;
        initListeners();
    }

    /**
     * Initialise les écouteurs pour les composants de la vue.
     */
    private void initListeners() {
        // Patient button action listener
        this.view.getLoginButton().addActionListener(e -> onLoginButtonClick());
    }

    /**
     * Méthode appelée lors du clic sur le bouton de connexion.
     *
     */
    private void onLoginButtonClick() {
        if (onLoginButtonClicked != null) {
            onLoginButtonClicked.run(); //
        }
    }

/**
 * affichage graphique de la fenètre login qui s'assure que l'interface est modidifé.
 */
    public void showLoginWindow() {
        SwingUtilities.invokeLater(() -> {
            view = new ViewLogin(); // créer la fenetre
            view.setVisible(true);
            //buttons
            view.getLoginButton().addActionListener(e -> onLoginButtonClicked());
        });
    }

    /**
     * Gère le clic sur le bouton de connexion en fermant la fenêtre de connexion et en affichant la fenêtre de détails
     * de connexion suivante.
     */
    private void onLoginButtonClicked() {
        view.dispose(); // Close the ViewLogin window
        ControlleurLoginDetails.ShowLoginDetails();
    }

}

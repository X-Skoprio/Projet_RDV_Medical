package controller.Login;

import controller.Patient.ControlleurPatient;
import controller.Employe.ControlleurViewEmploye;
import model.CliniqueImpl;
import view.ViewLoginDetails;

import javax.swing.*;
import java.sql.SQLException;

import model.Login;

import static model.CliniqueImpl.*;

/**
 * Contrôleur gérant la fenètre login et la suite.
 * chaque controlleur gère une fenètre différente.
 */
public class ControlleurLoginDetails {
    private static ViewLoginDetails LoginDetails;
    private Runnable onSendLoginButtonClicked;


    /**
     * Construit un contrôleur pour gérer la fenêtre de détails de connexion.
     *
     * @param LoginDetails La vue de la connexion
     * @throws SQLException Si une erreur de base de données se produit lors de la configuration des listeners.
     * @throws ClassNotFoundException Si les classes JDBC ne sont pas trouvées.
     */
    public ControlleurLoginDetails(ViewLoginDetails LoginDetails) throws SQLException, ClassNotFoundException {
        ControlleurLoginDetails.LoginDetails = LoginDetails;
        initListeners();

    }
    /**
     * Initialise les écouteurs pour les composants de la vue.
     */
    private void initListeners() {
        // Patient button action listener
        LoginDetails.getLoginButton().addActionListener(e -> {
            try {
                onSendLoginButtonClicked();
            } catch (SQLException | ClassNotFoundException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    /**
     * S'occupe du click du bonton qui envoie les infotmations à la BDD
     */
    private void onSendLoginButtonClick() {
        System.out.println("Patient button clicked");
        if (onSendLoginButtonClicked != null) {
            onSendLoginButtonClicked.run(); //
        }
    }

    /**
     * Exécute la logique de connexion en vérifiant les identifiants de l'utilisateur et en dirigeant vers
     * la fenêtre correspondante selon le type d'utilisateur.
     *
     * @throws SQLException Si une erreur de base de données se produit pendant la vérification des identifiants.
     * @throws ClassNotFoundException Si les classes JDBC nécessaires ne sont pas trouvées.
     */
    private static void onSendLoginButtonClicked() throws SQLException, ClassNotFoundException {
        connect();
         // Close the ViewLogin window
        String email = LoginDetails.getEmailField().getText();
        String password = new String(LoginDetails.getPasswordField().getPassword());
        System.out.println(email + "  " + password);


        //envoie mail et mdp à la base de donnée et evalue si correct ou no afin d'ensuite d'établir une connexion.
        checkEmailAndPassword(email,password);

        if(checkEmailInEmploye(email) && checkEmailAndPassword(email,password))
        {
            ControlleurViewEmploye.showEmployeWindow();
            Login.setEmail(email);
            LoginDetails.dispose();
        }
        else if(checkEmailInPatient(email) && checkEmailAndPassword(email,password) )
        {
            ControlleurPatient.showPatientWindow();
            Login.setEmail(email);
            LoginDetails.dispose();
        }
        System.out.println(Login.getEmail());

    }

    /**
     * Affiche la fenêtre de détails de connexion avec différentes informations.
     * Geneère une exception si la BDD SQL ne fonctionne pas
     */
    public static void ShowLoginDetails() {
        SwingUtilities.invokeLater(() -> {
            LoginDetails = new ViewLoginDetails(); // Create the ViewLogin window
            LoginDetails.setTitle("Login Window"); // Optional: Set the window title
            LoginDetails.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set the default close operation
            LoginDetails.pack(); // Size the window to fit the preferred size and layouts of its subcomponents
            LoginDetails.setLocationRelativeTo(null); // Center the window on the screen
            LoginDetails.setVisible(true); // Make the window visible

            LoginDetails.getLoginButton().addActionListener(e -> {
                try {
                    onSendLoginButtonClicked();
                } catch (SQLException | ClassNotFoundException ex) {
                    throw new RuntimeException(ex);
                }
            });
        });


    }

}

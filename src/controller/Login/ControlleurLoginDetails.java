package controller.Login;

import controller.Patient.ControlleurPatient;
import controller.Employe.ControlleurViewEmploye;
import model.CliniqueImpl;
import view.ViewLoginDetails;

import javax.swing.*;
import java.sql.SQLException;

import model.Login;

public class ControlleurLoginDetails {
    private static ViewLoginDetails LoginDetails;
    private Runnable onSendLoginButtonClicked;

    public static CliniqueImpl clinique;

    static {
        try {
            clinique = new CliniqueImpl();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


    public ControlleurLoginDetails(ViewLoginDetails LoginDetails) throws SQLException, ClassNotFoundException {
        ControlleurLoginDetails.LoginDetails = LoginDetails;
        initListeners();
    }
    private void initListeners() {
        // Patient button action listener
        LoginDetails.getLoginButton().addActionListener(e -> {
            try {
                onSendLoginButtonClicked();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
    }

    private void onSendLoginButtonClick() {
        System.out.println("Patient button clicked");
        if (onSendLoginButtonClicked != null) {
            onSendLoginButtonClicked.run(); //
        }
    }

    private static void onSendLoginButtonClicked() throws SQLException {
         // Close the ViewLogin window
        String email = LoginDetails.getEmailField().getText();
        String password = new String(LoginDetails.getPasswordField().getPassword());
        System.out.println(email + "  " + password);

        //envoie mail et mdp à la base de donnée et evalue si correct ou no afin d'ensuite d'établir une connexion.
        clinique.checkEmailAndPassword(email,password);

        if (clinique.checkEmailAndPassword(email, password))
        {
            Login.setEmail(email);
        }

        if(clinique.checkEmailInEmploye(email))
        {
            ControlleurViewEmploye.showEmployeWindow();
            LoginDetails.dispose();
        }
        else if(clinique.checkEmailInPatient(email)) //rajouter check de mdp
        {
            ControlleurPatient.showPatientWindow();
            LoginDetails.dispose();
        }
        System.out.println(Login.getEmail());
    }


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
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            });
        });


    }

}

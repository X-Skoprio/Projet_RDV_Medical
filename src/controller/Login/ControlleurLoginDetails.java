package controller.Login;

import controller.Patient.ControlleurPatient;
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
        LoginDetails.dispose(); // Close the ViewLogin window

        String email = LoginDetails.getEmailField().getText();
        String password = new String(LoginDetails.getPasswordField().getPassword());
        System.out.println(email + "  " + password);



        //envoie mail et mdp à la base de donnée et evalue si correct ou no afin d'ensuite d'établir une connexion.
        clinique.checkEmailAndPassword(email,password);

        if (clinique.checkEmailAndPassword(email, password))
        {
            Login.setEmail(email);
        }
        /* REFAORE METHODE checkEmailInPatient et checkEmailInEmploye dans implemntation clinique
        if(clinique.checkEmailInEmploye(email))
        {
            //ControlleurEmploye.ShowEmploye(); à FAIRE MAX ----------------------------------------------------------------------------------
        }
        else if(clinique.checkEmailInPatient(email))
        {
            ControlleurPatient.showPatientWindow();
        }*/
        System.out.println(Login.getEmail());

        ControlleurPatient.showPatientWindow();
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

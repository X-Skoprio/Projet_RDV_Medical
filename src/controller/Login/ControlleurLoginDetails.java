package controller.Login;

import controller.Patient.ControlleurPatient;
import controller.Employe.ControlleurViewEmploye;
import model.CliniqueImpl;
import view.ViewLoginDetails;

import javax.swing.*;
import java.sql.SQLException;

import model.Login;

import static model.CliniqueImpl.*;

public class ControlleurLoginDetails {
    private static ViewLoginDetails LoginDetails;
    private Runnable onSendLoginButtonClicked;



    public ControlleurLoginDetails(ViewLoginDetails LoginDetails) throws SQLException, ClassNotFoundException {
        ControlleurLoginDetails.LoginDetails = LoginDetails;
        initListeners();

    }
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

    private void onSendLoginButtonClick() {
        System.out.println("Patient button clicked");
        if (onSendLoginButtonClicked != null) {
            onSendLoginButtonClicked.run(); //
        }
    }

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

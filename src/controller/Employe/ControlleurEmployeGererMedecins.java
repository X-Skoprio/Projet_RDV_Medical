package controller.Employe;

import javax.swing.*;

import view.ViewEmployeGererMedecins;

import java.sql.SQLException;

import static controller.Employe.ControlleurEmployeCreationMedecins.showEmployeCreationMedecinsWindow;
import static controller.Employe.ControlleurViewEmployeConsulterPatients.showViewEmployeConsulterPatientWindow;


public class ControlleurEmployeGererMedecins {
    public static ViewEmployeGererMedecins viewEmployeGererMedecins;


    public ControlleurEmployeGererMedecins(ViewEmployeGererMedecins view) {
        ControlleurEmployeGererMedecins.viewEmployeGererMedecins = view;
        initListeners();
    }

    private static void initListeners() {

        viewEmployeGererMedecins.getCreationNouveauxMedecinsButton().addActionListener(e -> onCreationNouveauxMedecinsClicked());
        viewEmployeGererMedecins.getConsulterLesMedecinsButton().addActionListener(e -> {
            try {
                onConsulterPatientButtonClicked();
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            }
        });
    }


    private static void onCreationNouveauxMedecinsClicked()
    {
        System.out.println("Creation nouveau Medecin Clicked");
        showEmployeCreationMedecinsWindow();
    }
    private static void onConsulterPatientButtonClicked() throws SQLException {
        System.out.println("Consulter nouveau Medecin Clicked");
        showViewEmployeConsulterPatientWindow();

    }


    public static void showEmployeGererMedecinsWindow() {
        SwingUtilities.invokeLater(() -> {
            if (viewEmployeGererMedecins == null) {
                viewEmployeGererMedecins = new ViewEmployeGererMedecins(); // Create the window if it doesn't exist
            }
            viewEmployeGererMedecins.setTitle("Gerer Medecin Window"); // Set the window title
            viewEmployeGererMedecins.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Set the default close operation
            viewEmployeGererMedecins.pack(); // Size the window to fit the preferred size and layouts of its subcomponents
            viewEmployeGererMedecins.setLocationRelativeTo(null); // Center the window on the screen
            viewEmployeGererMedecins.setVisible(true); // Make the window visible

            initListeners();


        });
    }
}
